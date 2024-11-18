package com.example.asm.service.impl;

import com.example.asm.model.DanhMuc;
import com.example.asm.repository.DanhMucRepository;
import com.example.asm.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DanhMucServiceImpl implements DanhMucService {
    @Autowired
    DanhMucRepository danhMucRepository;
    @Override
    public Page<DanhMuc> getData(int page) {
        Pageable pageable = PageRequest.of(page,6);
        return danhMucRepository.findAll(pageable);
    }
}
