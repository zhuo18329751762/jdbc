package Request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/*
中文乱码问题解决
 */
@WebServlet("/req3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 解决乱码：Post,getReader
        request.setCharacterEncoding("UTF-8");//设置字符输入流编码
        // 2 获取username
        String username = request.getParameter("username");
        System.out.println("解决乱码前: "+username);
        // 3 GET 获取参数方法 getQueryString
        //乱码原因：tomcat进行URL编码，默认字符集是ISO-8859-1
//        // 3.1 先对乱码数据进行编码，转化为字节数组
//        byte[] bytes = username.getBytes("ISO-8859-1");
//        // 3.2 字节数组解码
//        username= new String(bytes, "utf-8");
        //简写形式
        //此方法Post与Get均可解决
        username=new String(username.getBytes(StandardCharsets.ISO_8859_1),"utf-8");
        System.out.println("解决乱码后: "+username);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
