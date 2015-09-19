package com.tickets.dao.catalogos.impl;

import com.tickets.api.entitys.catalogos.Evento;
import com.tickets.api.entitys.catalogos.EventoFechas;
import com.tickets.dao.catalogos.EventoFechasDao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("EventoFechasDao")
public class EventoFechasDaoImpl implements EventoFechasDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public EventoFechas altaEventoFechas(EventoFechas eventoFechas) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(eventoFechas);
        return eventoFechas;
    }

    @Override
    public EventoFechas actualizaEventoFechas(EventoFechas eventoFechas) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(eventoFechas);
        return eventoFechas;
    }

    @Override
    public EventoFechas bajaEventoFechas(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        EventoFechas eventoFechas = consultaEventoFechas(id);
        session.saveOrUpdate(eventoFechas);
        
        return eventoFechas;
    }

    @Override
    public List<EventoFechas> consultaEventoFechasList() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(EventoFechas.class);
        //criteria.add(Restrictions.eq("activo", 1));
        //criteria.addOrder(Order.asc("nombre"));
        List<EventoFechas> eventoFechasList = criteria.list();
        return eventoFechasList;
    }
    @Override
    public EventoFechas consultaEventoFechas(Integer id){
        Session session = sessionFactory.getCurrentSession();
        EventoFechas eventoFechas = (EventoFechas) session.get(EventoFechas.class, id);
        return eventoFechas;
    }
}
