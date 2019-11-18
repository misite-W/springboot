package com.css.wangzikun.springboot.Entity;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class pojo {

    @Autowired
    private Contract contract;
//    private List<Order> orders;

    @Autowired
    private Order order;

    public pojo() {
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
