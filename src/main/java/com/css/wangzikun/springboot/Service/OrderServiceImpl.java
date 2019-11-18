package com.css.wangzikun.springboot.Service;

import com.css.wangzikun.springboot.Dao.ContractDao;
import com.css.wangzikun.springboot.Entity.Order;
import com.css.wangzikun.springboot.Dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
//@Transactional(propagation = Propagation.REQUIRED ,readOnly = false)
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ContractDao contractDao;
    @Autowired
    private  ContractService contractService;
    //查询所有订单
    @Override
    public List<Order> findOrder() {
        return orderDao.findOrder();
    }

    //创建订单并生成合同
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public String createOrder(Order order)  {
        //判断订单是否存在 如存在则不创建
        if(!isOrderExistById(order.getOrder_id())) {
            //检测合同是否存在，若不存在则根据订单创建合同
            if (!contractService.isContractExist(order.getContract_id())) {
                contractDao.createContract(order.getContract_id()
                        , order.getParty_a()
                        , order.getParty_b()
                        , order.getCreate_date()
                        , "");
            }
            orderDao.createOrder(order);
            return "订单创建成功";
        }
            return "订单ID已经存在，不能创建订单和合同！";
    }
    //根据id删除订单
    @Override
    public String deleteOrder(int id) {
            if(isOrderExistById(id)) {
                orderDao.deleteOrderById(id);
                return "订单删除成功!";
            }
            else
            return "ID不存在";
    }

    //根据ID更新订单电内容
    @Override
    public String updateOrderById(String info, int id) {
            if(isOrderExistById(id)) {
                orderDao.updateOrderById(id, info);
                return "订单修改成功";
            }
            else {
                return "ID不存在";
            }
    }

    //根据合同ID找到订单
    @Override
    public List<Order> showOrderByContractId(int contract_id) {
            return orderDao.showOrderByContractId(contract_id);
    }

    //判断订单是否存在
    @Override
    public Boolean isOrderExistById(int id) {
            if (orderDao.isOrderExistById(id)!=0)
                return true;
            else
                return false;
    }
}
