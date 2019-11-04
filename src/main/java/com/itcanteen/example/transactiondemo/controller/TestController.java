package com.itcanteen.example.transactiondemo.controller;

import com.itcanteen.example.transactiondemo.exception.CustomException;
import com.itcanteen.example.transactiondemo.service.ISpringTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/10/17 16:59
 */

@RestController
public class TestController {


    @Autowired
    ISpringTransaction iSpringTransaction;




    @RequestMapping("/test1")
    public void test1(){
        iSpringTransaction.test1();
    }

    @RequestMapping("/test2")
    public void test2() throws CustomException {


        iSpringTransaction.test2();
    }

    @RequestMapping("/test3")
    public void test3()  {
        iSpringTransaction.test3();
    }

    @RequestMapping("/test4")
    public void test4() throws CustomException {
        iSpringTransaction.test4();
    }

    @RequestMapping("/test5")
    public void test5() throws CustomException {
        iSpringTransaction.test5();
    }


}
