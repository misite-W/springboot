package com.css.wangzikun.springboot.Controller;

import com.css.wangzikun.springboot.Entity.Order;
import com.css.wangzikun.springboot.Service.OrderService;
//import com.mysql.cj.xdevapi.JsonArray;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 查看所有订单
     * @return  订单
     */
    @ResponseBody
    @RequestMapping(value="/findOrder")
    public JSONArray showOrder(){
            System.out.println(orderService.findOrder());
            JSONArray jsonArray = JSONArray.fromObject(orderService.findOrder());
            return jsonArray;
    }

    /**
     * 创建一个订单并判断是否存在合同，若不存在则创建合同，存在则只创建订单
     * @param order 订单信息
     * @return  创建反馈
     */
    @RequestMapping(value="/createOrder",method = RequestMethod.POST,headers = {"content-type=application/json"})
    @ResponseBody
    public String createOrder(@RequestBody Order order){
                return orderService.createOrder(order);
    }

    /**
     * 删除订单
     * @param id 订单id
     * @return 删除结果
     */
    @RequestMapping(value="/deleteOrder")
    @ResponseBody
    public String deleteOrder(@RequestParam(value="id") int id){
            return orderService.deleteOrder(id);
    }

    /**
     * 根据id更新订单内容
     * @param id
     * @param info
     * @return 更新反馈
     */
    @RequestMapping(value="/updateOrder")
    @ResponseBody
    public String updateOrder(@RequestParam(value="id") int id,@RequestParam(value="info") String info){
            return orderService.updateOrderById(info,id);
    }


}
