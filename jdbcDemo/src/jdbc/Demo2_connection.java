package Demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2_connection {
    /*
    JDBC API 详解：connection
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
        String sql1 = "update account set money =3000 where id=1";
        String sql2 = "update account set money =3000 where id=2";
        // 4 获取执行sql的对象
        Statement stmt = conn.createStatement();

        try {
            //开启事务
            conn.setAutoCommit(false);
            // 5 执行sql
            int count1 = stmt.executeUpdate(sql1);
            // 6 处理结果
            System.out.println(count1);

            //制造异常
            int i=3/0;

            // 5 执行sql
            int count2 = stmt.executeUpdate(sql2);
            // 6 处理结果
            System.out.println(count2);
            //提交事务
            conn.commit();
        } catch (Exception throwables) {
            //回滚事务
            conn.rollback();
            throwables.printStackTrace();
        }



        // 7 释放资源
        stmt.close();
        conn.close();
    }
}
