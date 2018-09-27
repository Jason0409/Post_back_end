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
    @RequestMapping(value = "/getparcelbytrackid", method = RequestMethod.GET)
    private Map<String, Object> getParcelByTrackId(String trackId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // get register information
        Parcel parcel = parcelService.getParcelByTrackId(trackId);
        modelMap.put("parcel", parcel);
        return modelMap;
    }


    /**
     * get register information be Email
     *
     * @return
     */
    @RequestMapping(value = "/getparcelbyassigneremail", method = RequestMethod.GET)
    private Map<String, Object> getParcelByAssignerEmail(String assignerEmail) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // get register information
        Parcel parcel = parcelService.getParcelByAssignerEmail(assignerEmail);
        modelMap.put("parcel", parcel);
        return modelMap;
    }


    /**
     * insert register information
     *
     * @param parcel
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/addparcel", method = RequestMethod.POST)
    private Map<String, Object> addParcel(Parcel parcel)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // insert register information
        modelMap.put("success", parcelService.addParcel(parcel));
        return modelMap;
    }

    /**
     * modify register information
     *
     * @param parcel
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/modifyparcel", method = RequestMethod.POST)
    private Map<String, Object> modifyParcel(Parcel parcel)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // modify register information
        modelMap.put("success", parcelService.modifyParcel(parcel));
        return modelMap;
    }

    /**
     * delete register information by Id
     *
     * @return
     */

    @RequestMapping(value = "/removeparcel", method = RequestMethod.GET)
    private Map<String, Object> removeParcel(Integer parcelId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // delete register information
        modelMap.put("success", parcelService.deleteParcel(parcelId));
        return modelMap;
    }
}
