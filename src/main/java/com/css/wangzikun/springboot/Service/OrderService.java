package com.css.wangzikun.springboot.Service;

import com.css.wangzikun.springboot.Entity.Order;

import java.util.List;

public interface OrderService {

    public List<Order> findOrder();

    public String createOrder(Order order) ;

    public String deleteOrder(int id);

    //更新订单内容
    public String updateOrderById(String info , int id);

    public List<Order> showOrderByContractId(int contract_id);

    public Boolean isOrderExistById(int id);
}
