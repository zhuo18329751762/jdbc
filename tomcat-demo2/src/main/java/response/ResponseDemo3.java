package response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字符数据：设置字符数据的响应体
 */
@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 1 获取字符输出流
        PrintWriter writer = response.getWriter();
        //content-type
//        response.setHeader("content-type","text/html");
        writer.write("你好");
        writer.write("<h1>aaa</h1>");
        //流不需要关闭 随着响应结束，response对象销毁，由服务器关闭
        //中文乱码问题:原因通过Response获取的字符输出流默认编码:ISO-8859-1
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
