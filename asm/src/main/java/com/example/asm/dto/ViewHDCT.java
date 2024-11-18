package com.example.asm.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ViewHDCT {
    @Id
    private Integer id;
    @Column(name = "id_khach_hang")
    private Integer idKH;
    @Column(name = "so_dien_thoai")
    private String sdt;
    @Column(name = "id_sp")
    private Integer idCTSP;
    @Column(name = "gia_ban")
    private Double giaBan;
    @Column(name = "so_luong_mua")
    private Integer soLuong;
    @Column(name = "tong_tien")
    private Double tongTien;
}
