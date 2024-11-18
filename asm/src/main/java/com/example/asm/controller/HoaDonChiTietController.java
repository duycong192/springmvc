package com.example.asm.controller;

import com.example.asm.model.HoaDon;
import com.example.asm.model.HoaDonChiTiet;
import com.example.asm.repository.HoaDonChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hdct")
public class HoaDonChiTietController {
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;

    @GetMapping("/getall")
    public List<HoaDonChiTiet> getAllHDCT(){
        return hoaDonChiTietRepository.findAll();
    }
}
