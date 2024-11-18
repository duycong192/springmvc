package com.example.asm.controller;

import com.example.asm.model.KhachHang;
import com.example.asm.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kh")
public class KhachHangController {
    @Autowired
    KhachHangRepository khachHangRepository;

    @GetMapping
    public List<KhachHang> getAllKH(){
        return khachHangRepository.findAll();
    }
}
