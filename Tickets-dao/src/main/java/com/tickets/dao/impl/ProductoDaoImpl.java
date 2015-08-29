package com.tickets.dao.impl;

import com.tickets.api.entitys.catalogos.Producto;
import com.tickets.dao.ProductoDao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("productoDao")
public class ProductoDaoImpl implements ProductoDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Producto altaProducto(Producto producto) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(producto);
        session.close();
        return producto;
    }

    @Override
    public Producto actualizaProducto(Producto producto) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(producto);
        session.close();
        return producto;
    }

    @Override
    public Producto selectProductoByCodBarras(String codigoBarras) {
       /* Session session;
        if (!sessionFactory.isClosed()) {
            System.out.println("Abriendo nueva sesion");
            session = sessionFactory.openSession();
        } else {
            System.out.println("Utilizando sesion");
            session = sessionFactory.getCurrentSession();
        }*/
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Producto p where p.codigoBarras=:codigoBarras");
        query.setParameter("codigoBarras", codigoBarras);
        Producto producto = (Producto) query.uniqueResult();
        System.out.println("codigoBarras " + codigoBarras);
        
        return producto;
    }

    @Override
    public List<Producto> consultaProducto() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Producto p");
        List<Producto> productoList = query.list();
        session.close();
        return productoList;
    }
}
