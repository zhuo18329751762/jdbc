package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo1 {
    /*
    JDBC的快速入门
     */
    public static void main(String[] args) throws Exception {
        // 1 注册驱动
        Class.forName("com.mysql.jdbc.Driver");//可以不用写
        // 2 获取连接
        //如果连接的是本机mysql服务器，兵器mysql服务默认端口是3306，则url可以简写为：jdbc:mysql://数据库名称
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3 定义sql
        String sql = "update account set money =3000 where id=1";
        // 4 获取执行sql的对象
        Statement stmt = conn.createStatement();
        // 5 执行sql
        int count = stmt.executeUpdate(sql);
        // 6 处理结果
        System.out.println(count);
        // 7 释放资源
        stmt.close();
        conn.close();
    }
}

