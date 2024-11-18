package com.example.asm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ChiTietSanPhamDTO {
    private Integer id;

    private Integer idSanPham;

    private Integer idMau;

    private Integer idSize;

    private Double giaBan;

    private Integer soLuongTon;

    private String trangThai;

    private String img;

}
