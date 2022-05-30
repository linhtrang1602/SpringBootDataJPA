package com.example.springbootdatajpa.controller;

import java.util.List;
import java.util.Random;

import com.example.springbootdatajpa.entity.Dept;
import com.example.springbootdatajpa.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {


    @Autowired
    private DeptRepository deptRepository;

    private static final String[] DNAMES = new String[] {"Tom", "Jerry", "Donald"};
    private static final String[] LOCS = new String[] {"Ha Noi", "Khanh Hoa", "Thanh Hoa"};

    @ResponseBody
    @RequestMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += "<li><a href='/testInsert'>Test Insert</a></li>";
        html += "<li><a href='/showAllDept'>Show All Dept</a></li>";
        html += "<li><a href='/showNameLikeTom'>Show All 'Tom'</a></li>";
        html += "<li><a href='/deleteAllEmployee'>Delete All Dept</a></li>";
        html += "</ul>";
        return html;
    }

    @ResponseBody
    @RequestMapping("/testInsert")
    public String testInsert() {

        Long deptNoMax = this.deptRepository.getMaxDeptNo();
        Dept dept = new Dept();
        int random = new Random().nextInt(3);
        long deptNo = deptNoMax + 1;
        String dName = DNAMES[random] + " " + deptNo;
        String loc = LOCS[random];

        dept.setDeptNo(deptNo);
        dept.setdName(dName);
        dept.setLoc(loc);
//        employee.setIdDepart(id);
        this.deptRepository.save(dept);

        return "Inserted: " + dept;
    }

    @ResponseBody
    @RequestMapping("/showAllDept")
    public String showAllDept() {
        Iterable<Dept> depts = this.deptRepository.findAll();

        String html = "";
        for (Dept dept : depts) {
            html += dept + "<br>";
        }

        return html;
    }

    @ResponseBody
    @RequestMapping("/showNameLikeTom")
    public String showNameLikeTom() {
        List<Dept> depts = this.deptRepository.findByDNameLike("Tom");

        String html = "";
        for (Dept dept : depts) {
            html += dept + "<br>";
        }

        return html;
    }

    @ResponseBody
    @RequestMapping("/deleteAllDept")
    public String deleteAllDept() {

        this.deptRepository.deleteAll();
        return "Deleted!";
    }
}
