package com.itheima.web.Servlet;


import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService=new BrandServiceImpl();
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 1 调用service查询
        List<Brand> brands = brandService.selectAll();
        // 2 转为JSON
        String JsonString = JSON.toJSONString(brands);
        // 3 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonString);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 1 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串
        // 2 转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        // 3 调用方法
        brandService.add(brand);
        // 4 响应成功标识
        response.getWriter().write("success");
    }


    //批量删除方法
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 1 接收id数组[1,2,3]
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串
        // 2 转为int类型数组
        int[] ids = JSON.parseObject(params, int[].class);
        // 3 调用方法
        brandService.deleteByIds(ids);
        // 4 响应成功标识
        response.getWriter().write("success");
    }

    //修改数据
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 1 接收brand对象
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串
        // 2 转为int类型数组
        Brand brand = JSON.parseObject(params,Brand.class);
        // 3 调用方法
        brandService.update(brand);
        // 4 响应成功标识
        response.getWriter().write("success");
    }

    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 1 接收 当前页码 和 每页展示条数 url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        // 2 调用service查询
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);

        // 3 转为JSON
        String JsonString = JSON.toJSONString(pageBean);
        // 4 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonString);
    }

    /**
     * 分页条件查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 1 接收 当前页码 和 每页展示条数 url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取对应条件查询的对象
        // 1 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串
        // 2 转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        // 2 调用service查询
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage,pageSize,brand);

        // 3 转为JSON
        String JsonString = JSON.toJSONString(pageBean);
        // 4 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonString);
    }

    //批量删除方法
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 1 接收id
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串
        // 2 转为int类型数组
        int id = JSON.parseObject(params, int.class);
        // 3 调用方法
        brandService.deleteById(id);
        // 4 响应成功标识
        response.getWriter().write("success");
    }
}
