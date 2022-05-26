package com.trebnikau.spring.company.rest.dao;

import com.trebnikau.spring.company.rest.entity.Detail;
import com.trebnikau.spring.company.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetailDAOImpl implements DetailDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Detail> findAllDetail() {
        Session session = sessionFactory.getCurrentSession();
        List<Detail> details = session.createQuery("from Detail").getResultList();
        return details;    }

    @Override
    public Detail findDetailById(int detailId) {
        Session session = sessionFactory.getCurrentSession();
        Detail detail = session.get(Detail.class, detailId);
        return detail;
    }

    @Override
    public void saveDetail(Detail detail) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(detail);
    }

    @Override
    public void deleteDetailById(int detailId) {
        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("delete from Detail where id = :detailId");
//        query.setParameter("detailId", detailId);
//        query.executeUpdate();
        session.delete(findDetailById(detailId));
    }
}
