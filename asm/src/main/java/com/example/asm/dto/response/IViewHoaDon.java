package com.example.asm.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public interface IViewHoaDon {
    public Integer id();

    @Column(name = "id_khach_hang")
    public Integer getIDKH();

    @Column(name = "dia_chi")
    public String getDiaChi();

    @Column(name = "so_dien_thoai")
    public String getSdt();

    @Column(name = "trang_thai")
    public String getTrangThai();

    @Column(name = "tong")
    public Double getTong();
}
