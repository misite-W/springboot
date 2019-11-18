package com.css.wangzikun.springboot.Dao;

import com.css.wangzikun.springboot.Entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDao {
    //显示所有订单
    @Select("select * from wangzikun_order")
    public List<Order> findOrder();

    //根据合同ID显示对应订单
    @Select("select * from wangzikun_order where contract_id=#{contract_id}")
    public List<Order> showOrderByContractId(int contract_id);

    //创建订单
    @Insert("insert into wangzikun_order values(#{order_id},#{create_date},#{order_info},#{contract_id},#{party_a},#{party_b})")
    public void createOrder( Order order);

    //删除订单
    @Delete("delete from wangzikun_order where order_id=#{id}")
    public void deleteOrderById(@Param("id") int id);

    //根据合同ID删除对应订单
    @Delete("delete from wangzikun_order where contract_id=#{id}")
    public void deleteOrderByContractId(int id);

    //根据ID修改订单信息
    @Update("update wangzikun_order set order_info=#{info} where order_id=#{id}")
    public void updateOrderById(@Param("id") int id,@Param("info") String info);

    @Update("update wangzikun_order set order_info=#{order_info},party_a=#{party_a},party_b=#{party_b} where order_id=#{order_id}")
    public void updateOrder(Order order);
    //根据ID判断订单是否存在
    @Select("select count(1) from wangzikun_order where order_id=#{id}")
    public int isOrderExistById(int id);

    @Update("update wangzikun_order set order_info=#{info} where contract_id=#{contract_id} and order_id=#{orderId}")
    public void updateOrderByContract(@Param("contract_id") int contract_id,@Param("info") String info,@Param("orderId")int id);
}
