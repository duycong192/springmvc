package com.example.asm.repository;

import com.example.asm.dto.ViewHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ViewHoaDonRepo extends JpaRepository<ViewHoaDon,Integer>{
    @Query(value = "select hd.id, hd.id_khach_hang,hd.dia_chi,hd.so_dien_thoai,hd.trang_thai ,sum(hdct.tong_tien)as 'tong' from hoa_don hd join hdct  on hd.id = hdct.id_hoa_don group by hd.id, hd.id_khach_hang,hd.dia_chi,hd.so_dien_thoai,hd.trang_thai ,hdct.tong_tien",nativeQuery = true)
    List<ViewHoaDon> getData();
}
