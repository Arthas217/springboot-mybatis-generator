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


    //Transactional失效场景1
    // Transactional注解标注方法修饰符为非public时,事务没开启,在方法抛出异常时，操作不会进行回滚。

    // Transactional失效场景2
    // 方法修饰符为public时,control层调用 || 在同一个包内，InvokcationService调用进行访问。
    // 事务未开启,在方法抛出异常时，操作不会进行回滚。
    // 修复添加下(rollbackFor = Exception.class)
//    @Override
//    @Transactional
//    public int insert(TblUsers tblUsers) throws Exception {
//        int re = tblUsersMapper.insert(tblUsers);
//        if (re > 0) {
//            throw new Exception("need intercept");
//        }
//        TblUsers tblUsers1 = new TblUsers();
//        return tblUsersMapper.insert(tblUsers1);
//    }

    //Transactional失效场景3
    // 在类内部调用调用类内部@Transactional标注的方法。
    // 调用一个方法在类内部调用内部被@Transactional标注的事务方法，运行结果是事务不会正常开启，不会回滚
    @Override
    public int insert(TblUsers tblUsers) throws Exception {
        return testInnerInvoke(tblUsers);
    }

    //control层在外部调用事务testInnerInvoke方法能够保证开启事务，会回滚
    @Transactional(rollbackFor = Exception.class)
    public int testInnerInvoke(TblUsers tblUsers) throws Exception {
        int re = tblUsersMapper.insert(tblUsers);
        if (re > 0) {
            throw new Exception("need intercept");
        }
        TblUsers tblUsers1 = new TblUsers();
        return tblUsersMapper.insert(tblUsers1);
    }


    //Transactional失效场景4
    //事务方法内部捕捉了异常，没有抛出新的异常，导致事务操作不会进行回滚。
    @Transactional
    public void insertTestCatchException(TblUsers tblUsers) {
        try {
            int re = tblUsersMapper.insert(tblUsers);
            if (re > 0) {
                //运行期间抛异常
                throw new RuntimeException("need intercept");
            }
            tblUsersMapper.insert(new TblUsers());
        }catch (Exception e){
            System.out.println(" catch exception");
        }
    }

}
