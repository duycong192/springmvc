package com.example.asm.controller;

import com.example.asm.dto.SanPhamDTO;
import com.example.asm.model.DanhMuc;
import com.example.asm.model.SanPham;
import com.example.asm.repository.DanhMucRepository;
import com.example.asm.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sanpham/")
public class SanPhamController {
    @Autowired
    SanPhamRepository sanPhamRepository;
    @Autowired
    DanhMucRepository danhMucRepository;


    @GetMapping("/getall")
    public List<SanPhamDTO> getAll() {
        List<SanPham> sanPhams = sanPhamRepository.findAll();
        return sanPhams.stream()
                .map(this::convertToDTO) // Gọi phương thức chuyển đổi
                .collect(Collectors.toList());
    }

    private SanPhamDTO convertToDTO(SanPham sanPham) {
        SanPhamDTO dto = new SanPhamDTO();
        dto.setId(sanPham.getId());
        dto.setTenSanPham(sanPham.getTenSanPham());
        dto.setMaSanPham(sanPham.getMaSanPham());
        dto.setTrangThai(sanPham.getTrangThai());
        if (sanPham.getIdDanhMuc() != null) {
            DanhMuc danhMuc = sanPham.getIdDanhMuc(); // Giả sử đây là phương thức lấy đối tượng DanhMuc từ id
            dto.setIdDanhMuc(danhMuc.getId()); // Thêm thuộc tính này vào DTO
        } else {
            dto.setIdDanhMuc(null); // Hoặc giá trị mặc định nếu không có danh mục
        }

        return dto;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSP(@PathVariable("id") int id) {
        sanPhamRepository.deleteById(id);
    }

    @GetMapping("/getall/{id}")
    public SanPhamDTO getSPByID(@PathVariable("id") int id) {
        return convertToDTO(sanPhamRepository.findById(id).get());
    }

    @PostMapping("/add")
    public SanPham addSP(@RequestBody SanPhamDTO sanPhamDTO) {

        DanhMuc danhMuc = danhMucRepository.findById(sanPhamDTO.getIdDanhMuc()).get();
        SanPham sp = SanPham.builder()
                .id(sanPhamDTO.getId())
                .maSanPham(sanPhamDTO.getMaSanPham())
                .tenSanPham(sanPhamDTO.getTenSanPham())
                .trangThai(sanPhamDTO.getTrangThai())
                .idDanhMuc(danhMuc)
                .ngayTao(new Date())
                .ngaySua(new Date())
                .build();
        return sanPhamRepository.save(sp);
    }

    @PutMapping("/update/{id}")
    public SanPham updateSP(@RequestBody SanPhamDTO sanPhamDTO, @PathVariable("id") Integer id) {

        DanhMuc danhMuc = danhMucRepository.findById(sanPhamDTO.getIdDanhMuc()).get();
        SanPham sanPhamExist = sanPhamRepository.findById(sanPhamDTO.getId()).get();

        sanPhamExist.setMaSanPham(sanPhamDTO.getMaSanPham());
        sanPhamExist.setTenSanPham(sanPhamDTO.getTenSanPham());
        sanPhamExist.setTrangThai(sanPhamDTO.getTrangThai());
        sanPhamExist.setIdDanhMuc(danhMuc);
        sanPhamExist.setNgaySua(new Date());


        return sanPhamRepository.save(sanPhamExist);
    }
}
