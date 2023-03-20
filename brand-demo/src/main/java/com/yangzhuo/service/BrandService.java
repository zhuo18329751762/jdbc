package com.yangzhuo.service;

import com.yangzhuo.mapper.BrandMapper;
import com.yangzhuo.pojo.Brand;
import com.yangzhuo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
public class BrandService {
    // 1 调用BrandMapper.selectAll()
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有
     * @return
     */
    public List<Brand> selectAll(){

        // 2 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 3 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 4 调用方法
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }
    public void add(Brand brand){
        // 2 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 3 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 4 调用方法
        mapper.add(brand);
        //增删改要提交事务    提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Brand selectById(int id){

        // 2 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 3 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 4 调用方法
       Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    /**
     * 修改
     * @param brand
     */
    public void update(Brand brand){
        // 2 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 3 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 4 调用方法
        mapper.update(brand);
        //增删改要提交事务    提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    /**
     * 通过id删除元素
     * @param id
     * @return
     */
    public void deleteById(int id){
        // 2 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 3 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 4 调用方法
        mapper.deleteById(id);
        //增删改要提交事务    提交事务
        sqlSession.commit();
        sqlSession.close();
    }

}
