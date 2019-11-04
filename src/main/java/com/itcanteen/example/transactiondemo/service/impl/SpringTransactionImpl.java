package com.itcanteen.example.transactiondemo.service.impl;

import com.itcanteen.example.transactiondemo.dao.ExtraAdDao;
import com.itcanteen.example.transactiondemo.entity.ExtraAd;
import com.itcanteen.example.transactiondemo.exception.CustomException;
import com.itcanteen.example.transactiondemo.service.ISpringTransaction;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/10/17 16:55
 */

@Service
public class SpringTransactionImpl implements ISpringTransaction {


    @Autowired
    ExtraAdDao extraAdDao;


    /**
     * 捕获异常，导致事务不能回滚
     */
    @Override
    @Transactional
    public void test1() {
        try{
            extraAdDao.save(new ExtraAd("1701B"));
            throw  new RuntimeException();
        }catch(Exception e){
            e.printStackTrace();
            //手动标识回滚
          //  TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();侵入
        }

    }

    /**
     * 捕获异常并转移异常，导致事务不能回滚
     * @throws CustomException
     */
    @Override
    @Transactional
    public void test2() throws CustomException {
        try{
            extraAdDao.save(new ExtraAd("1701C"));
            throw new RuntimeException();
        }catch (Exception e){
            throw new CustomException(e.getMessage());
        }

    }

    /**
     * RuntimeException异常，事务可以回滚
     */
    @Override
    @Transactional
    public void test3() {
        extraAdDao.save(new ExtraAd("1701D"));
        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackFor = {CustomException.class})
    public void test4() throws CustomException {
        try{
            extraAdDao.save(new ExtraAd("1701E"));
            throw new RuntimeException();
        }catch (Exception e){
            throw  new CustomException(e.getMessage());
        }

    }


    @Transactional
    public void save(){
        extraAdDao.save(new ExtraAd("1701A"));
        throw new RuntimeException(

        );
    }

    /**
     * 在同一个类中，一个没有被事务标识的方法，器调用一个呗事务标记的方法，则事务会失效
     */
    @Transactional
    public void test5(){
        this.save();
    }
}
