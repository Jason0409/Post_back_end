package com.project.demo1.dao;

import com.project.demo1.entity.Parcel;
import com.project.demo1.entity.Register;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParcelDaoTest {

    @Autowired
    private ParcelDao parcelDao;


    @Test
    @Ignore
    public void queryParcel() {
        List<Parcel> parcelList = parcelDao.queryParcel();
        assertEquals(2, parcelList.size());
    }

    @Test
    @Ignore
    public void queryParcelByTrackId() {
        Parcel parcel = parcelDao.queryParcelByTrackId("YM34D");
        assertEquals("ewaf213", parcel.getParcelVcode());
    }

    @Test
    @Ignore
    public void queryParcelByAssignerEmail() {
        Parcel parcel = parcelDao.queryParcelByAssignerEmail("user_1231@anu.edu.au");
        assertEquals("ewaf213", parcel.getParcelVcode());
    }

    @Test
    @Ignore
    public void insertParcel() {
        Parcel parcel = new Parcel();
        parcel.setParcelTrackId("YHM89U");
        parcel.setAssignerEmail("u6166394@anu.edu.au");
        parcel.setAgentEmail("u6166395@anu.edu.au");
        parcel.setCourierEmail("u6166396@anu.edu.au");
        parcel.setReceiverName("Marry");
        parcel.setReceiverPhone("0451098378");
        parcel.setDestination("ACT");
        parcel.setParcelTime("2 hours");
        parcel.setParcelStatus("Done");
        parcel.setParcelVcode("wafq123");

        //将该对象实例添加入库
        int effectedNum = parcelDao.insertParcel(parcel);
        //检测影响行数
        assertEquals(1, effectedNum);
        //校验总数是否+1
        List<Parcel> parcelList = parcelDao.queryParcel();
        assertEquals(3, parcelList.size());
    }

    @Test
    @Ignore
    public void updateParcel() {
        List<Parcel> parcelList = parcelDao.queryParcel();
        for (Parcel parcel : parcelList) {
            if ("Jason".equals(parcel.getReceiverName())) {
                // 对比之前的phone值
                assertEquals("453428996", parcel.getReceiverPhone());
                parcel.setReceiverPhone("451066603");
                int effectedNum = parcelDao.updateParcel(parcel);
                assertEquals(1, effectedNum);
            }
        }
    }

    @Test
    @Ignore
    public void deleteParcel() {
        List<Parcel> parcelList = parcelDao.queryParcel();
        for (Parcel parcel : parcelList) {
            if ("Marry".equals(parcel.getReceiverName())) {
                int effectedNum = parcelDao.deleteParcel(parcel.getParcelId());
                assertEquals(1, effectedNum);
            }
        }
        // 重新获取一次列表，看看总数是否少1
        parcelList = parcelDao.queryParcel();
        assertEquals(2, parcelList.size());
    }
}