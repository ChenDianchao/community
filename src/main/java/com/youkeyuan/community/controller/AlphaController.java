package com.youkeyuan.community.controller;

import com.youkeyuan.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;



    @RequestMapping("/hello")
    @ResponseBody
    public String syaHello(){
        return "Hello World!";
    }

    @RequestMapping("/testSpring")
    @ResponseBody
    public String testS(){
        return alphaService.testAlphaDao();
    }

    @RequestMapping("/testHttp")
    public void testHttp(HttpServletRequest request, HttpServletResponse response){

        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(" name:" + name + "     value: " + value);
        }
        System.out.println(request.getParameter("code"));

        //返回响应数据
        response.setContentType("text/html;charset = utf-8");
        try{
            PrintWriter writer = response.getWriter();
            writer.write("<h1>NWS论坛</h1>");
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    //GET请求，默认请求为GET

    // /students?current=1&limit=20
    //查询所有学生，当前最多显示多少数据
    @RequestMapping(path = "/testGetStudent", method = RequestMethod.GET)
    @ResponseBody
    public String testGetStudents(
            //匹配浏览器传入的数据，允许不传数据。不传数据时变量为默认值
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit){
        System.out.println();
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    //student/123
    //查询学号为123的学生
    @RequestMapping(path = "/testGetStudentForId/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String testGetStudentForId(
            //设置传入的路径变量
            @PathVariable("id") int id){
        System.out.println(id);
        return "a student for id";
    }

    //POST请求
    //此请求对应student.html中，在html文件中的路径对应下列路径，传的参数自动对应函数变量
    @RequestMapping(path = "/testPostStudent", method = RequestMethod.POST)
    @ResponseBody//不加该注解默认返回ＨＴＭＬ
    public String testSaveStudent(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "Success";
    }

    //响应HTML数据
    @RequestMapping(path = "/testGetTeacher", method = RequestMethod.GET)
    //ModelAndView此数据类型
    public ModelAndView testGetTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","CDC");
        mav.addObject("age","10000");
        //在template模板文件夹中查找view.html文件，自动匹配该模板
        mav.setViewName("/demo/view");
        return mav;
    }

    @RequestMapping(path = "/getSchool", method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","YKY");
        model.addAttribute("age","99");
        return "/demo/view";
    }

    //相应JSON数据（异步请求）  类似于注册时显示昵称已注册（页面不刷新，部分数据出现变化）
    //Java对象 -> JSON字符串 ->  JSP对象
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String, Object> emp =new HashMap<>();
        emp.put("name","CDC");
        emp.put("age",10000);
        emp.put("salary",1000000000000.00);
        return emp;
    }

}
