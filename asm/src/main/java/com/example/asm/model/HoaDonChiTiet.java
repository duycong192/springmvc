package com.example.asm.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Builder
@Table(name = "hdct")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_hoa_don")
    private HoaDon idHoaDon;

    @ManyToOne
    @JoinColumn(name = "id_ctsp")
    private ChiTietSanPham idCTSP;

    @Column(name = "so_luong_mua")
    private Integer soLuongMua;

    @Column(name = "gia_ban")
    private Double giaBan;

    @Column(name = "tong_tien")
    private Double tongTien;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_sua")
    private Date ngaySua;

}
