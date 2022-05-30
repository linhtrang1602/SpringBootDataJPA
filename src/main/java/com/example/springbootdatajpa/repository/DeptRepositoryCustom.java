package com.example.springbootdatajpa.repository;

import com.example.springbootdatajpa.entity.Dept;

public interface DeptRepositoryCustom {

    public Long getMaxDeptNo();

    public Long updateDept(Long deptNo, String dName, String loc);
}