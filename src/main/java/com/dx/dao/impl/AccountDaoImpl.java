package com.dx.dao.impl;

import com.dx.dao.IAccountDao;
import com.dx.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;

    public List<Account> findAllAcount() {
        try{
            return runner.query("select * from user",new BeanListHandler<Account>(Account.class));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountId) {
        try{
            return runner.query("select * from user where id = ?",new BeanHandler<Account>(Account.class),accountId);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try{
           runner.update("insert into user(name,money) values(?,?)",account.getName(),account.getMoney());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try{
            runner.update("insert into user set name=? money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountId) {
        try{
            runner.update("delete from user where id=?",accountId);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
