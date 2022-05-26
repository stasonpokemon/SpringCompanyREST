package com.trebnikau.spring.company.rest.dao;

import com.trebnikau.spring.company.rest.entity.Detail;

import java.util.List;

public interface DetailDAO {

    List<Detail> findAllDetail();
    Detail findDetailById(int detailId);
    void saveDetail(Detail detail);
    void deleteDetailById(int detailId);
}
