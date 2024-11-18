package com.example.asm.controller;

import com.example.asm.dto.ViewHoaDon;
import com.example.asm.dto.response.ResponData;
import com.example.asm.dto.response.ResponseSuccess;
import com.example.asm.model.HoaDon;
import com.example.asm.repository.HoaDonRepository;
import com.example.asm.repository.ViewHoaDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hoadon")
public class HoaDonController {
    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    ViewHoaDonRepo viewHoaDonRepo;


    @GetMapping("/getall")
    public List<ViewHoaDon> getAllHD() {
        return viewHoaDonRepo.getData();
    }

//    @GetMapping("/test")
//    public ResponData<List<ViewHoaDon>> gettest(){
//        return new ResponData<List<ViewHoaDon>>(HttpStatus.OK,"mes",List.of(hoaDonRepository.findAll()));
//    }

    @GetMapping("/test")
    public List<ViewHoaDon> getAllHDIterface() {
        return hoaDonRepository.getData();
    }
}
