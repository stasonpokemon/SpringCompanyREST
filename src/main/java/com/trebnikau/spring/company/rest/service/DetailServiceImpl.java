package com.trebnikau.spring.company.rest.service;

import com.trebnikau.spring.company.rest.dao.DetailDAO;
import com.trebnikau.spring.company.rest.entity.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailDAO detailDAO;

    @Override
    @Transactional
    public List<Detail> findAllDetail() {
        List<Detail> details = detailDAO.findAllDetail();
        return details;
    }

    @Override
    @Transactional
    public Detail findDetailById(int detailId) {
        Detail detail = detailDAO.findDetailById(detailId);
        return detail;
    }

    @Override
    @Transactional
    public void saveDetail(Detail detail) {
        detailDAO.saveDetail(detail);
    }

    @Override
    @Transactional
    public void deleteDetailById(int detailId) {
        detailDAO.deleteDetailById(detailId);
    }
}
