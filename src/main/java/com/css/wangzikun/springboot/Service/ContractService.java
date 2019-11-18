package com.css.wangzikun.springboot.Service;

import com.css.wangzikun.springboot.Entity.Contract;
import com.css.wangzikun.springboot.Entity.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface ContractService {
    public List<Contract> showContract();
    public String deleteContractById(int id);
    public Contract showContractById(int id);
    public Boolean isContractExist(int id);
    public void createContract(Contract contract, List<Order> orders);
    public void updateContractAndOrder(Contract contract ,List<Order> orders);
}
