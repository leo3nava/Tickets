package com.tickets.dao.catalogos.impl;

import com.tickets.api.entitys.catalogos.TipoUsuario;
import com.tickets.dao.catalogos.TipoUsuarioDao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("TipoUsuarioDao")
public class TipoUsuarioDaoImpl implements TipoUsuarioDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public TipoUsuario altaTipoUsuario(TipoUsuario usuario) {
        Session session = sessionFactory.getCurrentSession();
        usuario.setActivo(1);
        session.saveOrUpdate(usuario);
        return usuario;
    }

    @Override
    public TipoUsuario actualizaTipoUsuario(TipoUsuario usuario) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(usuario);
        return usuario;
    }

    @Override
    public TipoUsuario bajaTipoUsuario(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        TipoUsuario usuario = consultaTipoUsuario(id);
        usuario.setActivo(0);
        session.saveOrUpdate(usuario);
        
        return usuario;
    }

    @Override
    public List<TipoUsuario> consultaTipoUsuariosList() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(TipoUsuario.class);
        criteria.add(Restrictions.eq("activo", 1));
        criteria.addOrder(Order.asc("nombre"));
        List<TipoUsuario> usuariosList = criteria.list();
        return usuariosList;
    }
    @Override
    public TipoUsuario consultaTipoUsuario(Integer id){
        Session session = sessionFactory.getCurrentSession();
        TipoUsuario usuario = (TipoUsuario) session.get(TipoUsuario.class, id);
        return usuario;
    }
}
