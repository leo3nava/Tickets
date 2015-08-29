package com.tickets.dao.impl;

import com.tickets.api.entitys.catalogos.Usuario;
import com.tickets.dao.UsuarioDao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Usuario altaUsuario(Usuario usuario) {
        Session session = sessionFactory.getCurrentSession();
        usuario.setActivo(1);
        session.saveOrUpdate(usuario);
        return usuario;
    }

    @Override
    public Usuario actualizaUsuario(Usuario usuario) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(usuario);
        return usuario;
    }

    @Override
    public Usuario bajaUsuario(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Usuario usuario = consultaUsuario(id);
        usuario.setActivo(0);
        session.saveOrUpdate(usuario);
        
        return usuario;
    }

    @Override
    public List<Usuario> consultaUsuariosList() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("activo", 1));
        criteria.addOrder(Order.asc("nombre"));
        List<Usuario> usuariosList = criteria.list();
        return usuariosList;
    }
    @Override
    public Usuario consultaUsuario(Long id){
        Session session = sessionFactory.getCurrentSession();
        Usuario usuario = (Usuario) session.get(Usuario.class, id);
        return usuario;
    }
}
