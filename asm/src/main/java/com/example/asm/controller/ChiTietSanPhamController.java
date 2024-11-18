package com.example.asm.controller;

import com.example.asm.dto.ChiTietSanPhamDTO;
import com.example.asm.model.ChiTietSanPham;
import com.example.asm.model.MauSac;
import com.example.asm.model.SanPham;
import com.example.asm.model.Size;
import com.example.asm.repository.ChiTietSanPhamRepository;
import com.example.asm.repository.MauSacRepository;
import com.example.asm.repository.SanPhamRepository;
import com.example.asm.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ctsp/")
public class ChiTietSanPhamController {
    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;
    @Autowired
    SanPhamRepository sanPhamRepository;
    @Autowired
    MauSacRepository mauSacRepository;
    @Autowired
    SizeRepository sizeRepository;

    private ChiTietSanPhamDTO convertCTSPToCTSPDTO(ChiTietSanPham ctsp) {
        ChiTietSanPhamDTO chiTietSanPhamDTO = new ChiTietSanPhamDTO();
        SanPham sanPham = ctsp.getIdSanPham();
        MauSac mauSac = ctsp.getIdMauSac();
        Size size = ctsp.getIdSize();

        chiTietSanPhamDTO.setId(ctsp.getId());
        chiTietSanPhamDTO.setIdSanPham(sanPham.getId());
        chiTietSanPhamDTO.setIdMau(mauSac.getId());
        chiTietSanPhamDTO.setIdSize(size.getId());
        chiTietSanPhamDTO.setGiaBan(ctsp.getGiaBan());
        chiTietSanPhamDTO.setSoLuongTon(ctsp.getSoLuongTon());
        chiTietSanPhamDTO.setTrangThai(ctsp.getTrangThai());
        chiTietSanPhamDTO.setImg(ctsp.getImg());

        return chiTietSanPhamDTO;
    }

    @GetMapping("/getall")
    public List<ChiTietSanPhamDTO> getALLCTSP() {
        List<ChiTietSanPham> sanPhams = chiTietSanPhamRepository.findAll();
        return sanPhams.stream()
                .map(this::convertCTSPToCTSPDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/getall/{id}")
    public ChiTietSanPhamDTO getCTSP(@PathVariable("id") Integer id) {

        return convertCTSPToCTSPDTO(chiTietSanPhamRepository.findById(id).get());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCTSP(@PathVariable("id") Integer id) {
        chiTietSanPhamRepository.deleteById(id);

    }

    @PostMapping("/add")
    public ChiTietSanPham addCTSP(@RequestBody ChiTietSanPhamDTO dto) {
        SanPham sanPham = sanPhamRepository.findById(dto.getIdSanPham()).get();
        MauSac mauSac = mauSacRepository.findById(dto.getIdMau()).get();
        Size size = sizeRepository.findById(dto.getIdSize()).get();

        ChiTietSanPham chiTietSanPham = ChiTietSanPham.builder()
                .idSanPham(sanPham)
                .idMauSac(mauSac)
                .idSize(size)
                .giaBan(dto.getGiaBan())
                .soLuongTon(dto.getSoLuongTon())
                .trangThai(dto.getTrangThai())
                .ngayTao(new Date())
                .ngaySua(new Date())
                .img(dto.getImg()).build();
        return chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @PutMapping("/update/{id}")
    public ChiTietSanPham update(@RequestBody ChiTietSanPhamDTO dto, @PathVariable("id") Integer id) {
        SanPham sanPham = sanPhamRepository.findById(dto.getIdSanPham()).get();
        MauSac mauSac = mauSacRepository.findById(dto.getIdMau()).get();
        Size size = sizeRepository.findById(dto.getIdSize()).get();

        ChiTietSanPham chiTietSanPhamExist = chiTietSanPhamRepository.findById(dto.getId()).get();

        chiTietSanPhamExist.setIdSanPham(sanPham);
        chiTietSanPhamExist.setIdMauSac(mauSac);
        chiTietSanPhamExist.setIdSize(size);
        chiTietSanPhamExist.setGiaBan(dto.getGiaBan());
        chiTietSanPhamExist.setSoLuongTon(dto.getSoLuongTon());
        chiTietSanPhamExist.setTrangThai(dto.getTrangThai());
        chiTietSanPhamExist.setImg(dto.getImg());
        chiTietSanPhamExist.setNgaySua(new Date());

        return chiTietSanPhamRepository.save(chiTietSanPhamExist);
    }

}
