package com.example.asm.controller;

import com.example.asm.model.DanhMuc;
import com.example.asm.model.MauSac;
import com.example.asm.repository.MauSacRepository;
import com.example.asm.repository.MauSacRepository;
import com.example.asm.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mausac")
public class MauSacController {
    @Autowired
    MauSacRepository mauSacRepository;

    @GetMapping("/getall")
    public List<MauSac> getAll() {
        List<MauSac> mauSacs = mauSacRepository.findAll();
        return mauSacs;
    }

    @GetMapping("/getall/{id}")
    public MauSac showRow(@PathVariable("id") int id) {
        MauSac mauSac = mauSacRepository.findById(id).get();
        return mauSac;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByID(@PathVariable("id") int id) {
        mauSacRepository.deleteById(id);

    }

    @PostMapping("/add")
    public void add(@RequestBody MauSac mauSac) {
        mauSac.setNgayTao(new Date());
        mauSac.setNgaySua(new Date());
        mauSacRepository.save(mauSac);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody MauSac mauSac, @PathVariable("id")int id) {
        mauSac.setNgaySua(new Date());
        mauSacRepository.save(mauSac);
    }


}
