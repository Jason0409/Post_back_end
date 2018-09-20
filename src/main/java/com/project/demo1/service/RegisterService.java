package com.project.demo1.service;

import com.project.demo1.entity.Register;

import java.util.List;

public interface RegisterService {

    /**
     * 列出register列表
     *
     * @return registerList
     */
    List<Register> getRegister();

    /**
     * 根据Id列出register
     *
     * @return Register
     */
    Register getRegisterById(int registerId);

    /**
     * 插入register信息
     *
     * @param register
     * @return
     */
    boolean addRegister(Register register);

    /**
     * 更新register信息
     *
     * @param register
     * @return
     */
    boolean modifyRegister(Register register);

    /**
     * 删除register信息
     *
     * @param registerId
     * @return
     */
    boolean deleteRegister(int registerId);
}
