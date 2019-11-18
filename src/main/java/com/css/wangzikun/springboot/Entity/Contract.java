package com.css.wangzikun.springboot.Entity;

import org.hibernate.exception.DataException;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

public class Contract {
   private int contract_id;
   private String party_a;
   private String party_b;
   private String create_date;
   private String contract_info;

    public Contract() {
    }

    public Contract(int contract_id, String party_a, String party_b, String create_date, String contract_info) {
        this.contract_id = contract_id;
        this.party_a = party_a;
        this.party_b = party_b;
        this.create_date = create_date;
        this.contract_info = contract_info;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
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

    @Override
    public String toString() {
        return "Contract{" +
                "contract_id=" + contract_id +
                ", party_a='" + party_a + '\'' +
                ", party_b='" + party_b + '\'' +
                ", create_date=" + create_date +
                ", contract_info='" + contract_info + '\'' +
                '}';
    }

    public void setParty_b(String party_b) {
        this.party_b = party_b;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getContract_info() {
        return contract_info;
    }

    public void setContract_info(String contract_info) {
        this.contract_info = contract_info;
    }
}
