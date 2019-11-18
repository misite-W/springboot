package com.css.wangzikun.springboot.Service;

//import com.alibaba.druid.sql.ast.statement.SQLIfStatement;
import com.css.wangzikun.springboot.Dao.ContractDao;
import com.css.wangzikun.springboot.Dao.OrderDao;
import com.css.wangzikun.springboot.Entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.css.wangzikun.springboot.Entity.Order;
import java.util.List;
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDao contractDao;
    @Autowired
    private OrderDao orderDao;

    /**
     * 查询所有合同
     * @return
     */
    @Override
    public List<Contract> showContract() {
        return contractDao.showContract();
    }

    /**
     *根据ID删除合同及对应订单
     * @param id    合同id
     * @return  删除结果
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public String deleteContractById(int id) {
        if(isContractExist(id)) {
                contractDao.deleteContractById(id);
                orderDao.deleteOrderByContractId(id);
                return "合同订单删除成功！";
        }
        else    return "ID不存在!";
    }
    /**
     * 根据ID查询合同
     * @param id
     * @return
     */
    @Override
    public Contract showContractById(int id) {
        if (isContractExist(id))
                return contractDao.showContractById(id);
        else
                return new Contract();
    }

    /**
     * 根据ID判断合同是否已经存在
     * @param id
     * @return
     */
    @Override
    public Boolean isContractExist(int id) {
        if (contractDao.isContractExcist(id)!=0)
                return true;
        else
                return false;
    }

    /**
     * 创建合同并生成对应订单
     * @param contract  合同
     * @param orders    订单列表
     */
    @Override
    @Transactional
    public void createContract(Contract contract,List<Order> orders) {
        contractDao.insertContract(contract);
        for (Order order :orders){
            if(order.getContract_id()==contract.getContract_id())
                orderDao.createOrder(order);
            else
                throw new RuntimeException("订单的合同编号输入错误");
        }
    }

    /**
     * 更新合同及对应订单
     * @param contract     合同
     * @param orders    订单列表
     */
    @Override
    @Transactional
    public void updateContractAndOrder(Contract contract, List<Order> orders) {
        if(contractDao.isContractExcist(contract.getContract_id())==0){
            contractDao.insertContract(contract);
        }
        else {
            contractDao.updateContract(contract);
        }
        for (Order order :orders){
            if(order.getContract_id()!=contract.getContract_id()){
                throw new RuntimeException("订单ID与合同不对应 回滚");
            }
            else if (orderDao.isOrderExistById(order.getOrder_id())==0){
                orderDao.createOrder(order);
            }
            else {
                orderDao.updateOrder(order);
            }
        }
    }
}
