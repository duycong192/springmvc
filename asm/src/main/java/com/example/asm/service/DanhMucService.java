package com.example.asm.service;

import com.example.asm.model.DanhMuc;
import com.example.asm.repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DanhMucService {

    Page<DanhMuc> getData(int page);
}
