package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo4_ResultSet {
    /*
    JDBC API 详解：resultSet
     */
    public static void main(String[] args) throws Exception {
        //执行DML语句
        testDML();
    }
    public static void testDML() throws Exception{
        // 1 注册驱动
        Class.forName("com.mysql.jdbc.Driver");//可以不用写
        // 2 获取连接
        //如果连接的是本机mysql服务器，兵器mysql服务默认端口是3306，则url可以简写为：jdbc:mysql://数据库名称
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3 定义sql
        String sql="select * from account";
        // 4 获取statement对象
        Statement stmt = conn.createStatement();
        // 5 执行sql
        ResultSet rs = stmt.executeQuery(sql);
        // 6 处理结果,遍历rs中的所有数据
        //判断当前行是否有数据
//        while (rs.next()){
//            int id = rs.getInt(1);
//            String name = rs.getString(2);
//            double money = rs.getDouble(3);
//            System.out.println(id);
//            System.out.println(name);
//            System.out.println(money);
//            System.out.println("==========================");
//        }
        while (rs.next()){
           int id = rs.getInt("id");
           String name = rs.getString("name");
           double money = rs.getDouble("money");
           System.out.println(id);
           System.out.println(name);
           System.out.println(money);
           System.out.println("==========================");
       }
        // 7 释放资源
        rs.close();
        stmt.close();
        conn.close();


    }
}
