package com.example.praktikum2.controller;

import com.example.praktikum2.dto.KtpDto;
import com.example.praktikum2.model.KtpEntity;
import com.example.praktikum2.service.KtpService;
import com.example.praktikum2.util.WebResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ktp")
@CrossOrigin(origins = "*")
public class KtpController {

    @Autowired
    private KtpService service;

    @PostMapping
    public ResponseEntity<WebResponse<KtpEntity>> create(@Valid @RequestBody KtpDto dto) {
        try {
            KtpEntity result = service.create(dto);
            return ResponseEntity.ok(new WebResponse<>("success", "Berhasil disimpan", result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new WebResponse<>("error", e.getMessage(), null));
        }
    }

    @GetMapping
    public List<KtpEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public KtpEntity getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WebResponse<KtpEntity>> update(@PathVariable Integer id, @Valid @RequestBody KtpDto dto) {
        try {
            KtpEntity result = service.update(id, dto);
            return ResponseEntity.ok(new WebResponse<>("success", "Berhasil diupdate", result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new WebResponse<>("error", e.getMessage(), null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WebResponse<String>> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok(new WebResponse<>("success", "Berhasil dihapus", null));
    }
}