package jdbc;

import java.sql.*;
import java.util.ArrayList;

public class Demo4_ResultSetTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
        查询account账户表数据，封装为Account对象中，并且储存到ArrayList集合中
         */
        // 1 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2 获取连接
        String url="jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String username="root";
        String password="1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3 定义sql
        String sql="select * from account";
        // 4 获取statement对象
        Statement stmt = conn.createStatement();
        // 5 执行sql
        ResultSet rs=stmt.executeQuery(sql);

        ArrayList<Account> list=new ArrayList<>();
        while (rs.next()){
            Account account=new Account(rs.getInt("id"),rs.getString("name"),rs.getDouble("money"));
            list.add(account);
        }
        System.out.println(list);
        //关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
