package com.tickets.dao.catalogos.recintos.impl;

import com.tickets.api.entitys.catalogos.recintos.Mapa;
import com.tickets.api.entitys.catalogos.recintos.Zona;
import com.tickets.dao.catalogos.recintos.ZonaDao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ZonaDao")
public class ZonaDaoImpl implements ZonaDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Zona altaZona(Zona zona) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zona);
        return zona;
    }

    @Override
    public Zona actualizaZona(Zona zona) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zona);
        return zona;
    }

    @Override
    public Zona bajaZona(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Zona zona = consultaZona(id);
        session.saveOrUpdate(zona);
        
        return zona;
    }

    @Override
    public List<Zona> consultaZonasList() {
        Session session = sessionFactory.openSession();
        
        String queryStr = "select z from Zona z ";
        Query query = session.createQuery(queryStr);
        
        List<Zona> zonasList = query.list();
        return zonasList;
    }
    @Override
    public Zona consultaZona(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Zona zona = (Zona) session.get(Zona.class, id);
        return zona;
    }
}
