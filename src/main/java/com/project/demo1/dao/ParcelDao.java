package com.project.demo1.dao;

import com.project.demo1.entity.Parcel;

import java.util.List;

public interface ParcelDao {
    /**
     * 列出Parcel列表
     *
     * @return parcelList
     */
    List<Parcel> queryParcel();

    /**
     * 根据trackId列出parcel
     *
     * @return Parcel
     */
    Parcel queryParcelByTrackId(String trackId);

    /**
     * 根据Email列出Parcel
     *
     * @return Parcel
     */
    List<Parcel> queryParcelByAssignerEmail(String assignerEmail);

    /**
     * 插入parcel信息
     *
     * @param parcel
     * @return int
     */
    int insertParcel(Parcel parcel);

    /**
     * 更新parcel信息
     *
     * @param parcel
     * @return int
     */
    int updateParcel(Parcel parcel);

    /**
     * 删除parcel信息
     *
     * @param parcelId
     * @return int
     */
    int deleteParcel(int parcelId);
}
