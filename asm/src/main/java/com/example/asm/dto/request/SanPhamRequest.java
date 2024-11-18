package com.example.asm.dto.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class SanPhamRequest {
    @Id
    private Integer id;
    private String maSanPham;
    private String tenSanPham;
    private String trangThai;
    private String idDanhMuc;
}
