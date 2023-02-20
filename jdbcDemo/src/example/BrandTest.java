package example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/*
品牌数据的测试类
 */
public class BrandTest {
    public static void main(String[] args) throws Exception {
        //testSelectAll();
        //brandAdd();
        //upDate();
        delete();
    }


  //查询所有
  /*
  1:SQL:select * from tb_brand;
  2:参数:不需要
  3:结果:List<Brand>
   */
public static void testSelectAll() throws ClassNotFoundException, SQLException {
    // 1 注册驱动
    Class.forName("com.mysql.jdbc.Driver");
    // 2 获取连接
    String url="jdbc:mysql://127.0.0.1:3306/db1?userSSL=false";
    String username="root";
    String password="1234";
    Connection conn= DriverManager.getConnection(url,username,password);
    // 3 定义sql
    String sql="select * from tb_brand";
    // 4 获取执行statement对象
    Statement stmt = conn.createStatement();
    // 5 执行sql
    ResultSet rs = stmt.executeQuery(sql);
    //处理结果
    ArrayList<Brand> list=new ArrayList<>();
    while (rs.next()){
        Brand brand=new Brand(rs.getInt("id"),rs.getString("brand_name"),rs.getString("company_name"),rs.getInt("ordered"),rs.getString("description"),rs.getInt("status"));
        list.add(brand);
    }
    rs.close();
    stmt.close();
    conn.close();
    System.out.println(list);
}
//添加信息
  /*
  1:SQL:insert into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?)
  2:参数:需要，Brand的除id外的所有数据
  3:结果:boolean
   */
    public static void brandAdd() throws Exception {
        //接收页面提交的参数
        String brandName="香飘飘";
        String companyName="香飘飘奶茶有限公司";
        int ordered=1;
        String description="绕地球一圈";
        int status= 1;
        // 1 获取Connection
        // 3 加载配置文件
        Properties prop=new Properties();
        prop.load(new FileInputStream("jdbcDemo/src/druid.properties"));
        // 4 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        // 5 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        // 3 定义sql
        String sql="insert into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?)";
        // 4 获取执行pstmt对象
         PreparedStatement pstmt= conn.prepareStatement(sql);
         // 5 设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        // 5 执行sql
        int count = pstmt.executeUpdate();//影响的行数
        // 6 处理结果
        System.out.println(count>0);
        pstmt.close();
        conn.close();
    }
    //修改信息
  /*
  1:SQL:

  update tb_brand
    set brand_name=?,
     company_name=?,
     ordered=?,
     description=?,
     status=?,
  where id=?

  2:参数:需要，Brand的除id外的所有数据
  3:结果:boolean
   */
    public static void upDate() throws Exception{
        //接收页面提交的参数
        String brandName="香飘飘";
        String companyName="香飘飘奶茶有限公司";
        int ordered=1000;
        String description="绕地球三圈";
        int status= 1;
        int id=4;
        // 1 获取Connection
        // 3 加载配置文件
        Properties prop=new Properties();
        prop.load(new FileInputStream("jdbcDemo/src/druid.properties"));
        // 4 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        // 5 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        // 3 定义sql
        String sql="  update tb_brand\n" +
                "    set brand_name = ?,\n" +
                "     company_name = ?,\n" +
                "     ordered = ?,\n" +
                "     description = ?,\n" +
                "     status = ?\n" +
                "  where id = ?";
        // 4 获取执行pstmt对象
        PreparedStatement pstmt= conn.prepareStatement(sql);
        // 5 设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);
        // 5 执行sql
        int count = pstmt.executeUpdate();//影响的行数
        // 6 处理结果
        System.out.println(count>0);
        pstmt.close();
        conn.close();
    }
    //删除信息
  /*
  1:SQL:delete  from tb_brand where id=?
  2:参数:需要，Brand的id
  3:结果:boolean
   */
    public static void delete() throws Exception{
        //接收页面提交的参数
        int id=4;
        // 1 获取Connection
        // 3 加载配置文件
        Properties prop=new Properties();
        prop.load(new FileInputStream("jdbcDemo/src/druid.properties"));
        // 4 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        // 5 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        // 3 定义sql
        String sql="delete  from tb_brand where id=?";
        // 4 获取执行pstmt对象
        PreparedStatement pstmt= conn.prepareStatement(sql);
        // 5 设置参数
        pstmt.setInt(1,id);
        // 5 执行sql
        int count = pstmt.executeUpdate();//影响的行数
        // 6 处理结果
        System.out.println(count>0);
        pstmt.close();
        conn.close();
    }
}
