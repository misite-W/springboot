package com.css.wangzikun.springboot.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

public class Order {
    private int order_id;
    private String create_date;
    private String order_info;
    private int contract_id;
    private String party_a;
    private String party_b;

    public Order(int order_id, String create_date, String order_info, int contract_id, String party_a, String party_b) {
        this.order_id = order_id;
        this.create_date = create_date;
        this.order_info = order_info;
        this.contract_id = contract_id;
        this.party_a = party_a;
        this.party_b = party_b;
    }

    public String getParty_a() {
        return party_a;
    }

    public void setParty_a(String party_a) {
        this.party_a = party_a;
    }

    public String getParty_b() {
        return party_b;
    }

    public void setParty_b(String party_b) {
        this.party_b = party_b;
    }

    public Order() {
    }

    public int getOrder_id() {

        return order_id;
    }

    public void setOrder_id(int order_id) {

        this.order_id = order_id;
    }

    public String getCreate_date() {

        return create_date;
    }

    public void setCreate_date(String create_date) {

        this.create_date = create_date;
    }

    public String getOrder_info() {

        return order_info;
    }

    public void setOrder_info(String order_info) {
        this.order_info = order_info;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", create_date='" + create_date + '\'' +
                ", order_info='" + order_info + '\'' +
                ", contract_id=" + contract_id +
                ", party_a='" + party_a + '\'' +
                ", party_b='" + party_b + '\'' +
                '}';
    }
}
