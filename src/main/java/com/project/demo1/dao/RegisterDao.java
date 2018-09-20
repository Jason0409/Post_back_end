package com.project.demo1.dao;

import com.project.demo1.entity.Register;

import java.util.List;

public interface RegisterDao {
    /**
     * 列出register列表
     *
     * @return registerList
     */
    List<Register> queryRegister();

    /**
     * 根据Id列出register
     *
     * @return Register
     */
    Register queryRegisterById(int registerId);

    /**
     * 插入register信息
     *
     * @param register
     * @return
     */
    int insertRegister(Register register);

    /**
     * 更新register信息
     *
     * @param register
     * @return
     */
    int updateRegister(Register register);

    /**
     * 删除register信息
     *
     * @param registerId
     * @return
     */
    int deleteRegister(int registerId);
}
