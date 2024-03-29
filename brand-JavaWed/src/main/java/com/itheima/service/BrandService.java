package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     */
    void add(Brand brand);

    /**
     * 修改数据
     */
    void update(Brand brand);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     * @param currentPage   当前页码
     * @param pageSize      每页展示条目数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage,int pageSize);


    /**
     * 条件分页查询
     * @param currentPage   当前页码
     * @param pageSize      每页展示条目数
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);


    /**
     * 根据单个id删除
     * @param id
     */
    void deleteById(int id);
}
