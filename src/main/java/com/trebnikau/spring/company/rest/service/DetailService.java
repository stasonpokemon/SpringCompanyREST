package com.trebnikau.spring.company.rest.service;

import com.trebnikau.spring.company.rest.entity.Detail;

import java.util.List;

public interface DetailService {

    List<Detail> findAllDetail();
    Detail findDetailById(int detailId);
    void saveDetail(Detail detail);
    void deleteDetailById(int detailId);
}
