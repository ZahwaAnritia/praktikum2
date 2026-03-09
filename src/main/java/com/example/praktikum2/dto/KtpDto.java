package com.example.praktikum2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KtpDto {

    private Integer id; // Kosong saat simpan baru, terisi saat ambil data/edit

    @NotBlank(message = "Nomor KTP tidak boleh kosong")
    @Size(min = 16, max = 16, message = "Nomor KTP harus 16 digit")
    private String nomorKtp;

    @NotBlank(message = "Nama lengkap harus diisi")
    private String namaLengkap;

    private String alamat;

    @NotBlank(message = "Tanggal lahir harus diisi")
    private String tanggalLahir; // String agar mudah diterima dari input HTML type="date"

    @NotBlank(message = "Jenis kelamin harus dipilih")
    private String jenisKelamin;
}