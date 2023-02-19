package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

/*
Druid数据库连接池演示
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        // 1 导入jar包

        // 2 定义配置文件

        // 3 加载配置文件

        // 4 获取连接池对象
        Properties prop=new Properties();
        prop.load(new FileInputStream("jdbcDemo/src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        // 5 获取数据库连接Connection
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
    }
}
