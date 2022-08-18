package com.bj.service;

import com.bj.entity.TblUsers;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2022/8/17 18:16
 */
public interface ITransactionService {

    /**
     * 通过账号更新删除标识
     */
    int updateByAccount(TblUsers tblUsers) throws Exception;


    int insert(TblUsers tblUsers) throws Exception;
}
