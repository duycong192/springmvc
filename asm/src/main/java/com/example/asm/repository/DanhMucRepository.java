package com.example.asm.repository;

import com.example.asm.model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMuc, Integer> {
//    @Query(value = "insert into danh_muc values (?1,?2,?3,?4,?5)", nativeQuery = true)
//    DanhMuc add(DanhMuc danhMuc);


}
