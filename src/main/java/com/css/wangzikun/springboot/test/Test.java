package com.css.wangzikun.springboot.test;

import org.springframework.beans.factory.annotation.Autowired;
import com.css.wangzikun.springboot.Dao.OrderDao;
import com.css.wangzikun.springboot.Service.ContractService;

public class Test {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ContractService contractService;
    @org.junit.Test
    public void demo1(){
        int a = 3;
        int b = 1;
        try {
            //try监控区域，此区域发生的异常都会被catch捕获
            if(b==0) throw new Exception();
            System.out.println(a/b);
        }
         catch (Exception e) {
             System.out.println("程序出现异常，除数B不能为0");
        }
        System.out.println("程序结束");
    }
    @org.junit.Test
    public void demo2(){


            int a = 1;
            contractService.deleteContractById(a);


    }
}
