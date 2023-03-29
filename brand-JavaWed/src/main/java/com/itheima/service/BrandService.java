package com.itheima.service;

import com.itheima.pojo.Brand;

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
}
