package com.itcanteen.example.transactiondemo.service;

import com.itcanteen.example.transactiondemo.exception.CustomException;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/10/17 16:55
 */
public interface ISpringTransaction {


    /**
     * 主动捕获异常，导致事务不能回滚
     */
    void test1();


    /**
     * 不是Unchecked异常，导致事务不能回滚
     */
    void test2() throws CustomException;


    /**
     * unchecked异常，事务可以回滚
     */
    void test3();


    /**
     * 指定了rollbackFor ,事务可以回滚
     */
    void test4() throws CustomException;


    void test5();
}
