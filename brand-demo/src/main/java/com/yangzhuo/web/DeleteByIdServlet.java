package com.yangzhuo.web;

import com.yangzhuo.pojo.Brand;
import com.yangzhuo.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteByIdServlet")
public class DeleteByIdServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 接收id
        String id = request.getParameter("id");
        // 2 调用service删除
        service.deleteById(Integer.parseInt(id));
        // 3 转发到brand.jsp
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
