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
    public Evento altaEvento(Evento usuario) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(usuario);
        return usuario;
    }

    @Override
    public Evento actualizaEvento(Evento usuario) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(usuario);
        return usuario;
    }

    @Override
    public Evento bajaEvento(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Evento usuario = consultaEvento(id);
        session.saveOrUpdate(usuario);
        
        return usuario;
    }

    @Override
    public List<Evento> consultaEventosList() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Evento.class);
        criteria.add(Restrictions.eq("activo", 1));
        criteria.addOrder(Order.asc("nombre"));
        List<Evento> usuariosList = criteria.list();
        return usuariosList;
    }
    @Override
    public Evento consultaEvento(Long id){
        Session session = sessionFactory.getCurrentSession();
        Evento usuario = (Evento) session.get(Evento.class, id);
        return usuario;
    }
}
