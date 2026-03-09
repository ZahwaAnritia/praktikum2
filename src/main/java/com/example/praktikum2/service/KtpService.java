package com.example.praktikum2.service;

import com.example.praktikum2.dto.KtpDto;
import com.example.praktikum2.model.KtpEntity;
import java.util.List;

public interface KtpService {
    KtpEntity create(KtpDto dto);
    List<KtpEntity> getAll();
    KtpEntity getById(Integer id);
    KtpEntity update(Integer id, KtpDto dto);
    void delete(Integer id);
}