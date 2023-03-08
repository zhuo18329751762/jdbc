package com.yangzhuo.test;

import com.yangzhuo.mapper.BrandMapper;
import com.yangzhuo.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        // 1 获取SqlSessionFactory
        // 1 加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
         //  2 获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4 执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
        // 5 释放资源
        sqlSession.close();

    }
    @Test
    public void testSelectById() throws IOException {
        //接收参数
        int id=1;
        // 1 获取SqlSessionFactory
        // 1 加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
         //  2 获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4 执行方法
        Brand brand=brandMapper.selectById(id);
        System.out.println(brand);
        // 5 释放资源
        sqlSession.close();

    }
    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status=1;
        String companyName="华为";
        String brandName="华为";
        //处理参数
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";
        //封装对象
//        Brand brand=new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        Map map=new HashMap();
        //map.put("status",status);
        //map.put("companyName",companyName);
        //map.put("brandName",brandName);
        // 1 获取SqlSessionFactory
        // 1 加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //  2 获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4 执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
        //List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Map> brands = brandMapper.selectByConditionSingle( map);
        System.out.println(brands);
        // 5 释放资源
        sqlSession.close();
    }

    //修改全部字段
    @Test
    public void testAdd() throws IOException {
        //接收参数
        int status=1;
        String companyName="菠萝手机";
        String brandName="菠萝";
        String description="手机中的战斗机";
        int ordered=100;
        //封装对象
       Brand brand=new Brand();
       brand.setStatus(status);
       brand.setCompanyName(companyName);
       brand.setBrandName(brandName);
       brand.setDescription(description);
       brand.setDescription(description);
       brand.setOrdered(ordered);
        Map map=new HashMap();
        //map.put("status",status);
        //map.put("companyName",companyName);
        //map.put("brandName",brandName);
        // 1 获取SqlSessionFactory
        // 1 加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //  2 获取SQLSession对象
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4 执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
        //List<Brand> brands = brandMapper.selectByCondition(brand);
       brandMapper.add(brand);
        System.out.println(brand);

        //提交事务
        //如果设置自动提交事务后，不用手动提交事务
        //sqlSession.commit();
        // 5 释放资源
        sqlSession.close();
    }
    @Test
    public void testAdd2() throws IOException {
        //接收参数
        int status=1;
        String companyName="菠萝手机";
        String brandName="菠萝";
        String description="手机中的战斗机";
        int ordered=100;
        //封装对象
       Brand brand=new Brand();
       brand.setStatus(status);
       brand.setCompanyName(companyName);
       brand.setBrandName(brandName);
       brand.setDescription(description);
       brand.setDescription(description);
       brand.setOrdered(ordered);
        Map map=new HashMap();
        //map.put("status",status);
        //map.put("companyName",companyName);
        //map.put("brandName",brandName);
        // 1 获取SqlSessionFactory
        // 1 加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //  2 获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4 执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
        //List<Brand> brands = brandMapper.selectByCondition(brand);
       brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);

        //提交事务
        sqlSession.commit();
        // 5 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //接收参数
        int status=1;
        String companyName="菠萝手机";
        String brandName="菠萝";
        String description="菠萝手机，手机中的战斗机";
        int ordered=300;
        int id=8;
        //封装对象
        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        //brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);
        // 1 获取SqlSessionFactory
        // 1 加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //  2 获取SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4 执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
        //List<Brand> brands = brandMapper.selectByCondition(brand);
        int update = brandMapper.update(brand);
        System.out.println(update);

        // 5 释放资源
        sqlSession.close();
    }
}
