//package com.yangzhuo.mapper;
//
//import com.yangzhuo.Brand;
//
//import java.util.List;
//import java.util.Map;
//
//public interface BrandMapper {
//
//    //查询所有
//    public List<Brand> selectAll();
//
//    //查看详情，根据id查询
//    public Brand selectById(int id);
//
//    /*条件查询
//    参数接收
//        1:散装参数 如果方法中有多个参数，需要使用@Param(“SQL参数占位符名称”)
//        2:对象参数 对象的属性名称要和参数占位符名称一致
//        3:map集合参数
//
//        @param status
//        @param companyName
//        @param brandName
//        @return
//     */
//    //散装参数
//    //List<Brand> selectByCondition(@Param("status") int status,@Param("companyName") String companyName,@Param("brandName") String brandName);
//
//    //对象参数
//    //List<Brand> selectByCondition(Brand brand);
//
//    //Map集合参数
//    //List<Brand> selectByCondition(Map map);
//
//    //单条件
//    //@param brand
//    //@return
//    List<Map> selectByConditionSingle(Map map);
//    //添加
//    void add(Brand brand);
//    //修改
//    int update(Brand brand);
//    //根据id删除
//    void deleteById(int id);
//
//    //根据id批量删除
//    void deleteByIds(int[] ids);
//
//
//}
