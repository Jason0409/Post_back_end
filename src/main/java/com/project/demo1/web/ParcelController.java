package com.project.demo1.web;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.project.demo1.entity.Parcel;
import com.project.demo1.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class ParcelController {
    @Autowired
    private ParcelService parcelService;

    /**
     * get all the register information
     *
     * @return
     */
    @RequestMapping(value = "/listparcel", method = RequestMethod.GET)
    private Map<String, Object> listparcel() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Parcel> list = new ArrayList<Parcel>();
        // get the list of register
        list = parcelService.getParcel();
        modelMap.put("registerList", list);
        return modelMap;
    }

    /**
     * get register information be ID
     *
     * @return
     */
//    @RequestMapping(value = "/getregisterbyid", method = RequestMethod.GET)
//    private Map<String, Object> getRegisterById(Integer registerId) {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        // get register information
//        Register register = registerService.getRegisterById(registerId);
//        modelMap.put("register", register);
//        return modelMap;
//    }
//
//
//    /**
//     * get register information be Email
//     *
//     * @return
//     */
//    @RequestMapping(value = "/getregisterbyemail", method = RequestMethod.GET)
//    private Map<String, Object> getRegisterByEmail(String registerEmail) {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        // get register information
//        Register register = registerService.getRegisterByEmail(registerEmail);
//        modelMap.put("register", register);
//        return modelMap;
//    }
//
//
//    /**
//     * insert register information
//     *
//     * @param register
//     * @return
//     * @throws IOException
//     * @throws JsonMappingException
//     * @throws JsonParseException
//     */
//    @RequestMapping(value = "/addregister", method = RequestMethod.POST)
//    private Map<String, Object> addRegister(Register register)
//            throws JsonParseException, JsonMappingException, IOException {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        // insert register information
//        modelMap.put("success", registerService.addRegister(register));
//        return modelMap;
//    }
//
//    /**
//     * modify register information
//     *
//     * @param register
//     * @return
//     * @throws IOException
//     * @throws JsonMappingException
//     * @throws JsonParseException
//     */
//    @RequestMapping(value = "/modifyregister", method = RequestMethod.POST)
//    private Map<String, Object> modifyRegister(Register register)
//            throws JsonParseException, JsonMappingException, IOException {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        // modify register information
//        modelMap.put("success", registerService.modifyRegister(register));
//        return modelMap;
//    }
//
//    /**
//     * delete register information by Id
//     *
//     * @return
//     */
//
//    @RequestMapping(value = "/removeregister", method = RequestMethod.GET)
//    private Map<String, Object> removeRegister(Integer registerID) {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        // delete register information
//        modelMap.put("success", registerService.deleteRegister(registerID));
//        return modelMap;
//    }
}
