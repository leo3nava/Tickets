package com.tickets.dao.catalogos.recintos.impl;

import com.tickets.api.entitys.catalogos.recintos.Asiento;
import com.tickets.dao.catalogos.recintos.AsientoDao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("AsientoDao")
public class AsientoDaoImpl implements AsientoDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Asiento altaAsiento(Asiento asiento) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(asiento);
        return asiento;
    }

    @Override
    public Asiento actualizaAsiento(Asiento asiento) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(asiento);
        return asiento;
    }

    @Override
    public Asiento bajaAsiento(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Asiento asiento = consultaAsiento(id);
        session.saveOrUpdate(asiento);
        
        return asiento;
    }

    @Override
    public List<Asiento> consultaAsientosList() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Asiento.class);
        //criteria.add(Restrictions.eq("activo", 1));
        criteria.addOrder(Order.asc("nombre"));
        List<Asiento> asientosList = criteria.list();
        return asientosList;
    }
    @Override
    public Asiento consultaAsiento(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Asiento asiento = (Asiento) session.get(Asiento.class, id);
        return asiento;
    }
}
