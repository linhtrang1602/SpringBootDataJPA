package com.example.springbootdatajpa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "DEPT")
public class Dept {

    @Id
    private Long deptNo;

    @Column(name="DNAME", length=14, nullable=true)
    private String dName;

    @Column(name="LOC", length=13, nullable=true)
    private String loc;

    public Long getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Long deptNo) {
        this.deptNo = deptNo;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return this.getDeptNo() + ", " + this.getdName();
    }
}