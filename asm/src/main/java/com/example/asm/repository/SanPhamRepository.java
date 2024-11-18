package com.example.asm.repository;

import com.example.asm.model.SanPham;
import com.example.asm.dto.SanPhamDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPham,Integer> {

}
