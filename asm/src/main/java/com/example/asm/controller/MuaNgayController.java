package com.example.asm.controller;

import com.example.asm.dto.MuaNgayDTO;
import com.example.asm.model.ChiTietSanPham;
import com.example.asm.model.HoaDon;
import com.example.asm.model.HoaDonChiTiet;
import com.example.asm.model.KhachHang;
import com.example.asm.repository.ChiTietSanPhamRepository;
import com.example.asm.repository.HoaDonChiTietRepository;
import com.example.asm.repository.HoaDonRepository;
import com.example.asm.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/muangay")
public class MuaNgayController {
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;
    @Autowired
    KhachHangRepository khachHangRepository;
    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;

    @PostMapping
    public HoaDon muaNgay(@RequestBody MuaNgayDTO muaNgayDTO) {
        System.out.println("đây là requets" +
                "" + muaNgayDTO.toString());

//        xử lý thêm kh trước

        KhachHang khachHang = new KhachHang();
        khachHang.setHoTenKH(muaNgayDTO.getTenKH());
        khachHang.setDiaChiKH(muaNgayDTO.getDiaChi());
        khachHang.setSdt(muaNgayDTO.getSdt());
        khachHang.setTrangThai("1");
        khachHang.setNgayTao(new Date());
        khachHang.setNgaySua(new Date());

        KhachHang khachHangNew = khachHangRepository.save(khachHang);

//        xủ lý thêm hóa đơn

        HoaDon hoaDon = new HoaDon();
        hoaDon.setIdKH(khachHangNew);
        hoaDon.setDiaChi(muaNgayDTO.getDiaChi());
        hoaDon.setSdt(muaNgayDTO.getSdt());
        hoaDon.setTrangThai("1");
        hoaDon.setNgayTao(new Date());
        hoaDon.setNgaySua(new Date());

        HoaDon hoaDonNew = hoaDonRepository.save(hoaDon);

//        thêm hđct
        ChiTietSanPham chiTietSanPhamDangMua = chiTietSanPhamRepository.findById(muaNgayDTO.getIdSP()).get();
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        hoaDonChiTiet.setIdHoaDon(hoaDonNew);
        hoaDonChiTiet.setIdCTSP(chiTietSanPhamDangMua);
        hoaDonChiTiet.setSoLuongMua(muaNgayDTO.getSoLuong());
        hoaDonChiTiet.setGiaBan(chiTietSanPhamDangMua.getGiaBan());
        hoaDonChiTiet.setTongTien(muaNgayDTO.getSoLuong() * chiTietSanPhamDangMua.getGiaBan());
        hoaDonChiTiet.setTrangThai("1");
        hoaDonChiTiet.setNgayTao(new Date());
        hoaDonChiTiet.setNgaySua(new Date());

        hoaDonChiTietRepository.save(hoaDonChiTiet);
        return hoaDonNew;
    }
}
