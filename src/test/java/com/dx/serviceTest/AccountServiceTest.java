package com.dx.serviceTest;

import com.dx.domain.Account;
import com.dx.service.IAccountService;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * 使用junit单元测试，测试我们的配置
 */
public class AccountServiceTest {
    @Test
    public void testFindAll() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        List<Account> accounts = accountService.findAllAcount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne() {
        ApplicationContext context =  new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        Account account = accountService.findAccountById(1);
    }
    @Test
    public void testSave() {
        ApplicationContext context =  new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        Account account = new Account();
        account.setId(1);
        account.setMoney("23");
        account.setName("aaa");
        accountService.saveAccount(account);
    }
    @Test
    public void testUpdate() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = context.getBean("accountService",IAccountService.class);
        Account account = accountService.findAccountById(4);
        account.setName("3333");
        accountService.updateAccount(account);
    }
    @Test
    public void testDetele() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService accountService = (IAccountService) context.getBean("accountService");
        accountService.deleteAccount(1);
    }
    @Test
    public void testYaml(){
        Map m1, m2;
        Yaml yaml = new Yaml();
        File file = new File("config/setting.yaml");
        try {
            m1 = yaml.load(new FileInputStream(file));
            String m3 = (String) m1.get("version");
            System.out.println( m1.get("version"));
            System.out.println(m3);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
