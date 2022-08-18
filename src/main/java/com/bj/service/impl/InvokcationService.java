package com.bj.service.impl;

import com.bj.entity.TblUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2022/8/18 11:48
 */
@Service
public class InvokcationService {
    @Autowired
    private TransactionServiceImpl transactionService;

    public int invokeInsertTestWrongModifier() throws Exception {
        TblUsers tblUsers = new TblUsers();
        tblUsers.setId(3);
        tblUsers.setAccount("w3");
        tblUsers.setDelflag("w3");
        tblUsers.setPassword("w3");
        tblUsers.setUsername("w3");
        return transactionService.insert(tblUsers);
    }

}
