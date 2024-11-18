package com.example.asm.controller;

import com.example.asm.dto.ViewHDCT;
import com.example.asm.repository.ViewHDCTRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("viewhdct")
public class ViewHDCTControlle {
    @Autowired
    ViewHDCTRepo viewHDCTRepo;

    @GetMapping("/get/{id}")
    public List<ViewHDCT> getAll(@PathVariable("id") Integer id) {
        return viewHDCTRepo.getHDCTbyIDHD(id);
    }

}
