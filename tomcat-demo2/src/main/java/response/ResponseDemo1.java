package response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/*
重定向

 1 浏览器地址栏路径发生变化
 2 可以重定向到任意位置的资源(服务器内部、外部均可)
 3 两次请求，不能在多个资源中使用request共享数据
 */
@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1...");
//        //重定向
//        // 1 设置响应状态码 302
//        response.setStatus(302);
//        // 2 设置响应头 Location
//        response.setHeader("Location","/tomcat-demo2/resp2");



        //简化方式完成重定向
//        response.sendRedirect("/tomcat-demo2/resp2");
        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/resp2");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
