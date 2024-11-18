package com.example.asm.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_san_pham")
    private String maSanPham;

    @Column(name = "ten_san_pham")
    private String tenSanPham;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_sua")
    private Date ngaySua;

    @ManyToOne
    @JoinColumn (name = "id_danh_muc")
    private DanhMuc idDanhMuc;

}
