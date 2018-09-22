package com.project.demo1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo1.dao.RegisterDao;
import com.project.demo1.entity.Register;
import com.project.demo1.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterDao registerDao;

    @Override
    public List<Register> getRegister() {
        // 返回所有的register信息..
        return registerDao.queryRegister();
    }

    @Override
    public Register getRegisterById(int registerId) {
        return registerDao.queryRegisterById(registerId);
    }

    @Override
    public Register getRegisterByEmail(String registerEmail) {
        return registerDao.queryRegisterByEmail(registerEmail);
    }

    @Transactional
    @Override
    public boolean addRegister(Register register) {
        if (register.getRegisterEmail() != null && !"".equals(register.getRegisterEmail())) {
            try {
                int effectedNum = registerDao.insertRegister(register);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("error!");
                }
            } catch (Exception e) {
                throw new RuntimeException("error:" + e.toString());
            }
        } else {
            throw new RuntimeException("can not be null！");
        }
    }

    @Transactional
    @Override
    public boolean modifyRegister(Register register) {

        if (register.getRegisterId() != null && register.getRegisterId() > 0) {
            try {
                // 更新register信息
                int effectedNum = registerDao.updateRegister(register);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("error!");
                }
            } catch (Exception e) {
                throw new RuntimeException("error:" + e.toString());
            }
        } else {
            throw new RuntimeException("can not be null！");
        }
    }

    @Transactional
    @Override
    public boolean deleteRegister(int registerId) {
        if (registerId > 0) {
            try {
                // 删除区域信息
                int effectedNum = registerDao.deleteRegister(registerId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("error!");
                }
            } catch (Exception e) {
                throw new RuntimeException("error:" + e.toString());
            }
        } else {
            throw new RuntimeException("can not be null！");
        }
    }
}