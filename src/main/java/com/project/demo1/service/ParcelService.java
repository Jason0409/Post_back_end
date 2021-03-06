package com.project.demo1.service;

import com.project.demo1.entity.Parcel;

import java.util.List;

public interface ParcelService {
    /**
     * 列出Parcel列表
     *
     * @return parcelList
     */
    List<Parcel> getParcel();

    /**
     * 根据trackId列出parcel
     *
     * @return Parcel
     */
    Parcel getParcelByTrackId(String trackId);

    /**
     * 根据assignerEmail列出Parcel
     *
     * @return Parcel
     */
    List<Parcel> getParcelByAssignerEmail(String assignerEmail);

    /**
     * 根据agentEmail列出Parcel
     *
     * @return Parcel
     */
    List<Parcel> getParcelByAgentEmail(String agentEmail);

    /**
     * 根据courierEmail列出Parcel
     *
     * @return Parcel
     */
    List<Parcel> getParcelByCourierEmail(String courierEmail);

    /**
     * 插入parcel信息
     *
     * @param parcel
     * @return int
     */
    boolean addParcel(Parcel parcel);

    /**
     * 更新parcel信息
     *
     * @param parcel
     * @return int
     */
    boolean modifyParcel(Parcel parcel);

    /**
     * 删除parcel信息
     *
     * @param parcelId
     * @return
     */
    boolean deleteParcel(int parcelId);
}
