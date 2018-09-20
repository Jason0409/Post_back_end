package com.project.demo1.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.project.demo1.entity.Register;
import com.project.demo1.service.RegisterService;

@RestController
@RequestMapping("/superadmin")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    /**
     * 获取所有的register信息
     *
     * @return
     */
    @RequestMapping(value = "/listregister", method = RequestMethod.GET)
    private Map<String, Object> listregister() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Register> list = new ArrayList<Register>();
        // 获取区域列表
        list = registerService.getRegister();
        modelMap.put("registerList", list);
        return modelMap;
    }

    /**
     * 通过区域Id获取register信息
     *
     * @return
     */
    @RequestMapping(value = "/getregisterbyid", method = RequestMethod.GET)
    private Map<String, Object> getRegisterById(Integer registerId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取区域信息
        Register register = registerService.getRegisterById(registerId);
        modelMap.put("register", register);
        return modelMap;
    }

    /**
     * 添加register信息
     *
     * @param register
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/addregister", method = RequestMethod.POST)
    private Map<String, Object> addRegister(@RequestBody Register register)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 添加区域信息
        modelMap.put("success", registerService.addRegister(register));
        return modelMap;
    }

    /**
     * 修改register信息
     *
     * @param register
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/modifyregister", method = RequestMethod.POST)
    private Map<String, Object> modifyRegister(@RequestBody Register register)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", registerService.modifyRegister(register));
        return modelMap;
    }

    @RequestMapping(value = "/removeregister", method = RequestMethod.GET)
    private Map<String, Object> removeRegister(Integer registerID) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", registerService.deleteRegister(registerID));
        return modelMap;
    }

}