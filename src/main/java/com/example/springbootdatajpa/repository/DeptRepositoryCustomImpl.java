package com.example.springbootdatajpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.example.springbootdatajpa.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptRepositoryCustomImpl implements DeptRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public Long getMaxDeptNo() {
        try {
            String sql = "SELECT COALESCE(max(d.deptNo), 0) FROM Dept d";
            Query query = entityManager.createQuery(sql);
            return (Long) query.getSingleResult();
        } catch (NoResultException e) {
            return 0L;
        }
    }

    @Override
    public Long updateDept(Long deptNo, String dName, String loc) {
        Dept d = entityManager.find(Dept.class, deptNo);
        if (d == null) {
            return 0L;
        }
        d.setdName(dName);
        d.setLoc(loc);
//        d.setIdDepart(idDepart);
        entityManager.flush();
        return 1L;
    }

//    @Override
//    public Long getMaxDeptNo() {
//        return null;
//    }
//
//    @Override
//    public Long updateDept(Long deptNo, String dName, String loc) {
//        return null;
//    }
}
