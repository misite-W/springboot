package com.css.wangzikun.springboot.Controller;
import com.css.wangzikun.springboot.Entity.Contract;
import com.css.wangzikun.springboot.Entity.Order;
import com.css.wangzikun.springboot.Service.ContractService;
import com.css.wangzikun.springboot.Service.OrderService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private OrderService orderService;

    /**
     * 查看所有合同
     * @return
     */
    @RequestMapping(value="/showContract")
    @ResponseBody
    public JSONArray showContract(){
            System.out.println(contractService.showContract());
            JSONArray jsonArray =JSONArray.fromObject(contractService.showContract());
            return jsonArray;
    }

    /**
     * 根据ID查询合同并列出对应所有订单
     * @param id    合同id
     * @return map
     */
    @RequestMapping("/showContractAndOrderById")
    @ResponseBody
    public Map<Contract,List<Order>> showContractAndOrderById(int id){
            Contract contract = contractService.showContractById(id);
            List<Order> orders = orderService.showOrderByContractId(id);
            Map<Contract,List<Order>> map = new HashMap<>();
            map.put(contract,orders);
            System.out.println(orders);
            return map;
    }

    /**
     * 根据id删除合同并删除对应所有订单
     * @param id
     * @return
     */
    @RequestMapping(value="/deleteContract")
    @ResponseBody
    public String deleteContract(@RequestParam(value="id") int id){
        return contractService.deleteContractById(id);
    }

    /**
     * 创建合同并创建订单列表
     * @param orders        订单列表
     * @param contract_id   合同ID
     * @param party_a       甲方
     * @param party_b       乙方
     * @param create_date   创建日期
     * @param contract_info 合同内容
     */
    @RequestMapping("/createContract")
    @ResponseBody
    public void createContract(@RequestBody()List<Order> orders,
                               @RequestParam(value="contract_id") int contract_id,
                               @RequestParam (value="party_a")String party_a,
                               @RequestParam (value = "party_b")String party_b,
                               @RequestParam (value="create_date")String create_date,
                               @RequestParam (value="contract_info")String contract_info){
        Contract contract = new Contract(contract_id,party_a,party_b,create_date,contract_info);
        contractService.createContract(contract,orders);
    }

    /**
     * 传入需要修改的合同和订单列表，可修改合同及对应任意数量订单的数据
     * @param orders        订单列表
     * @param contract_id   合同ID
     * @param party_a       甲方
     * @param party_b       乙方
     * @param create_date   创建日期
     * @param contract_info 合同内容
     */
    @RequestMapping(value="/updateContractAndOrder")
    @ResponseBody
    public void updateContractAndOrder(@RequestBody()List<Order> orders,
                                       @RequestParam(value="contract_id") int contract_id,
                                       @RequestParam (value="party_a")String party_a,
                                       @RequestParam (value = "party_b")String party_b,
                                       @RequestParam (value="create_date")String create_date,
                                       @RequestParam (value="contract_info")String contract_info){
        Contract contract = new Contract(contract_id,party_a,party_b,create_date,contract_info);
        contractService.updateContractAndOrder(contract,orders);
    }
}
