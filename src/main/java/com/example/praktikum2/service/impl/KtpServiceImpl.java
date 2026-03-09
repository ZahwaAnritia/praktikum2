package com.example.praktikum2.service.impl;

import com.example.praktikum2.dto.KtpDto;
import com.example.praktikum2.mapper.KtpMapper;
import com.example.praktikum2.model.KtpEntity;
import com.example.praktikum2.repository.KtpRepository;
import com.example.praktikum2.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository repository;

    @Autowired
    private KtpMapper mapper;

    @Override
    public KtpEntity create(KtpDto dto) {
        if (repository.findByNomorKtp(dto.getNomorKtp()).isPresent()) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    public List<KtpEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public KtpEntity getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
    }

    @Override
    public KtpEntity update(Integer id, KtpDto dto) {
        KtpEntity ktp = getById(id);
        KtpEntity updatedData = mapper.toEntity(dto);

        ktp.setNamaLengkap(updatedData.getNamaLengkap());
        ktp.setAlamat(updatedData.getAlamat());
        ktp.setTanggalLahir(updatedData.getTanggalLahir());
        ktp.setJenisKelamin(updatedData.getJenisKelamin());

        return repository.save(ktp);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}