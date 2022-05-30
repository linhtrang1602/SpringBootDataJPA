package com.example.springbootdatajpa.repository;

import java.util.List;

import com.example.springbootdatajpa.entity.Dept;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeptRepository extends CrudRepository<Dept, Long> {

    Dept findByDeptNo(Long deptNo);

    List<Dept> findByDNameLike(String dName);

    List<Dept> findByLocContaining(String loc);

    @Query("SELECT COALESCE(MAX(d.deptno), 0) FROM dept d")
    Long getMaxDeptNo();
}