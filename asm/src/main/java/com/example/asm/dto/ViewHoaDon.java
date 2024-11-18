package com.example.asm.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class ViewHoaDon {
    @Id
    private Integer id;

    @Column(name = "id_khach_hang")
    private Integer idKH;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "so_dien_thoai")
    private String sdt;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "tong")
    private Double tong;

}
