package com.example.asm.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@Entity
@Table(name = "ctsp")
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "id_sp")
    private SanPham idSanPham;

    @ManyToOne
    @JoinColumn (name = "id_mau_sac")
    private MauSac idMauSac;

    @ManyToOne
    @JoinColumn(name = "id_size")
    private Size idSize;

    @Column(name = "gia_ban")
    private Double giaBan;

    @Column(name = "so_luong_ton")
    private Integer soLuongTon;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_sua")
    private Date ngaySua;
    @Column(name = "img")
    private String img;



}
