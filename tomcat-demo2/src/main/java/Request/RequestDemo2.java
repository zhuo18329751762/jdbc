package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get请求逻辑
        //System.out.println("get...");
        // 1 获取所有参数的Map集合
        Map<String, String[]> Map = req.getParameterMap();
        for (String key : Map.keySet()) {
            //输出Key
            System.out.print(key+":");
            //输出value
            String[] values = Map.get(key);
            for (String value : values) {
                System.out.print(value+" ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
        // 2 根据Key获取参数值，数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        System.out.println("--------------------------------");
        // 3 根据key获取单个参数值
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Post请求逻辑
        System.out.println("Post...");
        this.doGet(req,resp);
    }
}
