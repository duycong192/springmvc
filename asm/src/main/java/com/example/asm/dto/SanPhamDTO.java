package com.example.asm.dto;

import com.example.asm.model.DanhMuc;
import jakarta.persistence.*;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class SanPhamDTO {
    private Integer id;

    private String maSanPham;


    private String tenSanPham;


    private String trangThai;


    private Integer idDanhMuc;


}
