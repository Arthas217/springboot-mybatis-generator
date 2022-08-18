package com.bj.controller;

import com.bj.entity.TblUsers;
import com.bj.entity.Test01;
import com.bj.service.ITransactionService;
import com.bj.service.impl.InvokcationService;
import com.bj.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * https://mp.weixin.qq.com/s/iG-iX6e5_v0Gnf8ZCIhdJA
 * https://mp.weixin.qq.com/s/b-Z9fANn2k8dceUT4Uyh4A
 * @Date 2022/8/17 18:14
 */
@RestController
@RequestMapping("/testTransaction")
public class TransactionController {

    @Autowired
    ITransactionService transactionService;

    @Autowired
    InvokcationService invokcationService;

    @Autowired
    TransactionServiceImpl transactionService1;

    @GetMapping(value = "/update")
    public void updateDelFlag() throws Exception {
        TblUsers tblUsers = new TblUsers();
        tblUsers.setId(1);
        tblUsers.setAccount("root2");
        tblUsers.setDelflag("2");
        tblUsers.setPassword("2222");
        tblUsers.setUsername("22222");
        System.out.println(transactionService.updateByAccount(tblUsers));
    }


    @GetMapping(value = "/insert")
    public void addUse() throws Exception {
        TblUsers tblUsers = new TblUsers();
        tblUsers.setId(3);
        tblUsers.setAccount("w2");
        tblUsers.setDelflag("w2");
        tblUsers.setPassword("w2");
        tblUsers.setUsername("w2");
        System.out.println(transactionService.insert(tblUsers));
    }

    @GetMapping(value = "/insert1")
    public void addUse1() throws Exception {
        System.out.println(invokcationService.invokeInsertTestWrongModifier());
    }

    @GetMapping(value = "/inner")
    public void addUse2() throws Exception {
        TblUsers tblUsers = new TblUsers();
        tblUsers.setId(3);
        tblUsers.setAccount("w2");
        tblUsers.setDelflag("w2");
        tblUsers.setPassword("w2");
        tblUsers.setUsername("w2");
        System.out.println(transactionService.insert(tblUsers));
    }

    @GetMapping(value = "/outter")
    public void addUse3() throws Exception {
        TblUsers tblUsers = new TblUsers();
        tblUsers.setId(3);
        tblUsers.setAccount("ww");
        tblUsers.setDelflag("ww");
        tblUsers.setPassword("ww");
        tblUsers.setUsername("ww");
        System.out.println(transactionService1.testInnerInvoke(tblUsers));
    }


    @GetMapping(value = "/catch/throw")
    public void addUse4() throws Exception {
        TblUsers tblUsers = new TblUsers();
        tblUsers.setId(3);
        tblUsers.setAccount("ww2");
        tblUsers.setDelflag("6");
        tblUsers.setPassword("ww2");
        tblUsers.setUsername("ww2");
        transactionService1.insertTestCatchException(tblUsers);
    }

}
