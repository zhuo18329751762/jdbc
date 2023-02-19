package jdbc;

import java.sql.*;

public class Demo6_PreparedStatement {
    /*
    用户登录
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 2 获取连接
        //如果连接的是本机mysql服务器，兵器mysql服务默认端口是3306，则url可以简写为：jdbc:mysql://数据库名称
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        //接收用户输入 用户名和密码
        //'or'1'='1
        String name="张三";
        String pwd="'or'1'='1";

        //定义sql
        String sql="select * from account where name= ? and money=? ";
        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置？值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);
        ResultSet rs = pstmt.executeQuery();
        // 判断登录是否成功
        if(rs.next()){
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }
        // 7 释放资源
//        stmt.close();
//        conn.close();
    }
}
