package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //-----------------------------------------请求行

        //String getMethod();获取请求方式：GET
        String method = req.getMethod();
        System.out.println(method);//GET
        //String getContextPath();获取虚拟目录(项目访问路径):/request-demo
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        //StringBuffer getRequestURL():获取URL(统一资源定位符):http://localhost:8080/request-demo/req1
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL.toString());
        //String getRequestURL();获取URL(统一资源标识符);/request-demo/req1
        String url = req.getRequestURI();
        System.out.println(url.toString());
        //String getQueryString();获取请求参数(GET方式);username-zhangsan
        String queryString = req.getQueryString();
        System.out.println(queryString);

        //---------------------------------------请求头

        //获取请求头:user-agent:浏览器版本信息
        String header = req.getHeader("user-agent");
        System.out.println(header);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取post 请求体:请求参数
        // 1 获取字符输入流
        BufferedReader br=req.getReader();
        // 2 获取数据
        String line = br.readLine();
        System.out.println(line);
    }
}
