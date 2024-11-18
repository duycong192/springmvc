package com.example.asm.controller;

import com.example.asm.model.Size;
import com.example.asm.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/size")
public class SizeController {
    @Autowired
    SizeRepository sizeRepository;

    @GetMapping("/getall")
    public List<Size> getAll() {
        List<Size> sizes = sizeRepository.findAll();
        return sizes;
    }

    @GetMapping("/getall/{id}")
    public Size showRow(@PathVariable("id") int id) {
        Size size = sizeRepository.findById(id).get();
        return size;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByID(@PathVariable("id") int id) {
        sizeRepository.deleteById(id);

    }

    @PostMapping("/add")
    public void add(@RequestBody Size size) {
        size.setNgayTao(new Date());
        size.setNgaySua(new Date());
        sizeRepository.save(size);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Size size, @PathVariable("id")int id) {
        size.setNgaySua(new Date());
        sizeRepository.save(size);
    }

}
