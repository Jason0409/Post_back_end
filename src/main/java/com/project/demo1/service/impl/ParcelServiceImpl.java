package com.project.demo1.service.impl;

import com.project.demo1.dao.ParcelDao;
import com.project.demo1.entity.Parcel;
import com.project.demo1.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParcelServiceImpl implements ParcelService {


    @Autowired
    private ParcelDao parcelDao;


    @Override
    public List<Parcel> getParcel() {
        return parcelDao.queryParcel();
    }

    @Override
    public Parcel getParcelByTrackId(String trackId) {
        return parcelDao.queryParcelByTrackId(trackId);
    }

    @Override
    public List<Parcel> getParcelByAssignerEmail(String assignerEmail) {
        return parcelDao.queryParcelByAssignerEmail(assignerEmail);
    }

    @Override
    public List<Parcel> getParcelByAgentEmail(String agentEmail) {
        return parcelDao.queryParcelByAgentEmail(agentEmail);
    }

    @Override
    public List<Parcel> getParcelByCourierEmail(String courierEmail) {
        return parcelDao.queryParcelByCourierEmail(courierEmail);
    }

    @Transactional
    @Override
    public boolean addParcel(Parcel parcel) {
        if (parcel.getParcelTrackId() != null && !"".equals(parcel.getParcelTrackId())) {
            try {
                int effectedNum = parcelDao.insertParcel(parcel);
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
    public boolean modifyParcel(Parcel parcel) {
        if (parcel.getParcelId() != null && parcel.getParcelId() > 0) {
            try {
                // 更新parcel信息
                int effectedNum = parcelDao.updateParcel(parcel);
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
    public boolean deleteParcel(int parcelId) {
        if (parcelId > 0) {
            try {
                // 删除信息
                int effectedNum = parcelDao.deleteParcel(parcelId);
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
