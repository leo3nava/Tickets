package com.tickets.dao.catalogos.impl;

import com.tickets.api.entitys.catalogos.Recinto;
import com.tickets.dao.catalogos.RecintoDao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("recintoDao")
public class RecintoDaoImpl implements RecintoDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Recinto altaRecinto(Recinto recinto) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(recinto);
        return recinto;
    }

    @Override
    public Recinto actualizaRecinto(Recinto recinto) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(recinto);
        return recinto;
    }

    @Override
    public Recinto bajaRecinto(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Recinto recinto = consultaRecinto(id);
        session.saveOrUpdate(recinto);
        
        return recinto;
    }

    @Override
    public List<Recinto> consultaRecintoList() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Recinto.class);
        //criteria.add(Restrictions.eq("activo", 1));
        //criteria.addOrder(Order.asc("nombre"));
        List<Recinto> RecintoList = criteria.list();
        return RecintoList;
    }
    @Override
    public Recinto consultaRecinto(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Recinto recinto = (Recinto) session.get(Recinto.class, id);
        return recinto;
    }
}
