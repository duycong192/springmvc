package com.example.asm.repository;

import com.example.asm.dto.ViewHDCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ViewHDCTRepo extends JpaRepository<ViewHDCT,Integer> {
    @Query(value = "select hd.id, hd.id_khach_hang,hd.so_dien_thoai,ctsp.id_sp,hdct.gia_ban,hdct.so_luong_mua,hdct.tong_tien \n" +
            "\t\tfrom hoa_don hd join hdct on hd.id = hdct.id_hoa_don\n" +
            "\t\tjoin ctsp on ctsp.id = hdct.id_ctsp  where hd.id = ?1",nativeQuery = true)
    List<ViewHDCT> getHDCTbyIDHD(Integer id);
}
