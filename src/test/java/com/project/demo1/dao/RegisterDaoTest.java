package com.project.demo1.dao;

import com.project.demo1.entity.Register;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterDaoTest {

    @Autowired
    private RegisterDao registerDao;

    @Test
    @Ignore
    public void queryRegister() {
        List<Register> registerList = registerDao.queryRegister();
        assertEquals(2, registerList.size());
    }

    @Test
    @Ignore
    public void queryRegisterById() {
        Register register = registerDao.queryRegisterById(2);
        assertEquals("Jason", register.getRegisterName());
    }


    @Test
    @Ignore
    public void queryRegisterByEmail() {
        Register register = registerDao.queryRegisterByEmail("u6212332@anu.edu.au");
        assertEquals("Jason", register.getRegisterName());
    }



    @Test
    @Ignore
    public void insertRegister() {
        Register register = new Register();
        register.setRegisterAddress("anu");
        register.setRegisterEmail("u6166394@anu.edu.au");
        register.setRegisterName("Jack");
        register.setRegisterPassword("Jack123");
        register.setRegisterPhone("123142131");
        register.setRegisterRole("admin");
        //将该对象实例添加入库
        int effectedNum = registerDao.insertRegister(register);
        //检测影响行数
        assertEquals(1, effectedNum);
        //校验总数是否+1
        List<Register> areaList = registerDao.queryRegister();
        assertEquals(3, areaList.size());
    }

    @Test
    @Ignore
    public void updateRegister() {
        List<Register> registerList = registerDao.queryRegister();
        for (Register register : registerList) {
            if ("Jason".equals(register.getRegisterName())) {
                // 对比之前的phone值
                assertEquals("451066604", register.getRegisterPhone());
                register.setRegisterPhone("451066603");
                int effectedNum = registerDao.updateRegister(register);
                assertEquals(1, effectedNum);
            }
        }
    }

    @Test
    @Ignore
    public void deleteRegister() {
        List<Register> registerList = registerDao.queryRegister();
        for (Register register : registerList) {
            if ("Jack".equals(register.getRegisterName())) {
                int effectedNum = registerDao.deleteRegister(register.getRegisterId());
                assertEquals(1, effectedNum);
            }
        }
        // 重新获取一次列表，看看总数是否少1
        registerList = registerDao.queryRegister();
        assertEquals(2, registerList.size());
    }
}