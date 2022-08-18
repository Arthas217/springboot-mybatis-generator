package com.bj.controller;

import com.bj.entity.TblUsers;
import com.bj.entity.Test01;
import com.bj.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author 会游泳的蚂蚁
 * @Description: https://mp.weixin.qq.com/s/iG-iX6e5_v0Gnf8ZCIhdJA
 * @Date 2022/8/17 18:14
 */
@RestController
@RequestMapping("/testTransaction")
public class TransactionController {

    @Autowired
    ITransactionService transactionService;

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
}
