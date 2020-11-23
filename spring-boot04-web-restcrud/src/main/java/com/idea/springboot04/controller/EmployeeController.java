package com.idea.springboot04.controller;

import com.idea.springboot04.dao.DepartmentDao;
import com.idea.springboot04.dao.EmployeeDao;
import com.idea.springboot04.entities.Department;
import com.idea.springboot04.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    //查询所有员工
    @GetMapping("/emps")
    public String list(Model model){
    Collection<Employee> employees=employeeDao.getAll();
    //把员工信息放在请求域中 在方法参数里放上 map 或者 Model
        model.addAttribute("emps",employees);
        // thymeleaf 会自动拼串
        return  "emps/list";
    }
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有部分 给页面
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";

    }
//springmvc 将自动请求参数和入参对象进行绑定，请求参数的名字要与javabean里面的属性的名字要一样。
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println(employee);
        employeeDao.save(employee);
        //redirect 表示重定向  “/”表示当前项目的路径
        //forward 表示要转发到一个地址
        return "redirect:/emps";
    }

    @GetMapping("/edit{id}")
    public String EditPage(@PathVariable("id") Integer id,Model model){ employeeDao.get(id);
         model.addAttribute("emp",employeeDao.get(id));

        //查出部门 给页面

        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);


         return "emps/add";
    }
}
