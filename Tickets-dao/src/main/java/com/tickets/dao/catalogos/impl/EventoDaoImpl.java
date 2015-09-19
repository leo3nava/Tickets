package com.tickets.dao.catalogos.impl;

import com.tickets.api.entitys.catalogos.Evento;
import com.tickets.dao.catalogos.EventoDao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("EventoDao")
public class EventoDaoImpl implements EventoDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Evento altaEvento(Evento evento) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(evento);
        return evento;
    }

    @Override
    public Evento actualizaEvento(Evento evento) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(evento);
        return evento;
    }

    @Override
    public Evento bajaEvento(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Evento evento = consultaEvento(id);
        session.saveOrUpdate(evento);
        
        return evento;
    }

    @Override
    public List<Evento> consultaEventosList() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Evento.class);
        //criteria.add(Restrictions.eq("activo", 1));
        criteria.addOrder(Order.asc("nombre"));
        List<Evento> eventosList = criteria.list();
        return eventosList;
    }
    @Override
    public Evento consultaEvento(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Evento evento = (Evento) session.get(Evento.class, id);
        return evento;
    }
}
