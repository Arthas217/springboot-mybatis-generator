package com.bj.service.impl;

import com.bj.dao.TblUsersMapper;
import com.bj.entity.TblUsers;
import com.bj.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2022/8/17 18:21
 */
@Service
public class TransactionServiceImpl implements ITransactionService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TblUsersMapper tblUsersMapper;

//    // 测试1 ArithmeticException继承RuntimeException
//    // @Transactional默认回滚的的异常就是RuntimeException
//    // 数据库没有更新  事务生效
//    @Override
//    @Transactional
//    public int updateByAccount(TblUsers tblUsers) {
//        int i = tblUsersMapper.updateByPrimaryKey(tblUsers);
//        int a = 2 / 0;
//        if (i > 0) {
//            return 1000;
//        }
//        return -1;
//    }

    // 测试2 用try catch来捕获异常 然后在catch里面自定义抛出Exception异常
    // @Transactional并不能回滚Exception异常
    // 数据库被更新  事务不生效
//    @Override
//    @Transactional
//    public int updateByAccount(TblUsers tblUsers) throws Exception {
//        int i = tblUsersMapper.updateByPrimaryKey(tblUsers);
//        try {
//            int a = 2 / 0;
//        } catch (Exception e) {
//            throw new Exception();
//        }
//        if (i > 0) {
//            return 1000;
//        }
//        return -1;
//    }

    // 测试3 用@Transactional(rollbackFor = Exception.class)
    // 数据库未更新  事务生效
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByAccount(TblUsers tblUsers) throws Exception {
        int i = tblUsersMapper.updateByPrimaryKey(tblUsers);
        try {
            int a = 2 / 0;
        } catch (Exception e) {
            throw new Exception();
        }
        if (i > 0) {
            return 1000;
        }
        return -1;
    }



}
