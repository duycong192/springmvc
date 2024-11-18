package com.example.asm.controller;

import com.example.asm.model.DanhMuc;
import com.example.asm.repository.DanhMucRepository;
import com.example.asm.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DanhMucController {
    @Autowired
    DanhMucRepository danhMucRepository;

    @GetMapping("/getall")
    public List<DanhMuc> getAll() {
        List<DanhMuc> danhMucs = danhMucRepository.findAll();
        return danhMucs;
    }

    @GetMapping("/getall/{id}")
    public DanhMuc showRow(@PathVariable("id") int id) {
        DanhMuc danhMuc = danhMucRepository.findById(id).get();
        return danhMuc;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByID(@PathVariable("id") int id) {
        danhMucRepository.deleteById(id);

    }

    @PostMapping("/add")
    public void add(@RequestBody DanhMuc danhMuc) {
        danhMuc.setNgayTao(new Date());
        danhMuc.setNgaySua(new Date());
        danhMucRepository.save(danhMuc);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody DanhMuc danhMuc, @PathVariable("id")int id) {
        danhMuc.setNgaySua(new Date());
        danhMucRepository.save(danhMuc);
    }


}
