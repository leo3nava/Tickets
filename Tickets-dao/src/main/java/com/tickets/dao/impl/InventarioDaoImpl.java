package com.tickets.dao.impl;

import com.tickets.api.entitys.catalogos.Inventario;
import com.tickets.dao.InventarioDao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("inventarioDao")
public class InventarioDaoImpl implements InventarioDao {

    @Autowired
    SessionFactory sessionFactory;
    private boolean error;
    private String errorMsj;

    @Override
    public void separaProducto(Long productoId, String numero) {
        error = false;
        Session session = sessionFactory.getCurrentSession();
        /* if (sessionFactory.isClosed()) {
         System.out.println("Abriendo nueva sesion");
         session = sessionFactory.openSession();
         } else {
         System.out.println("Utilizando sesion");
         session = getSession();
         }*/
        // Transaction tx=session.beginTransaction();
        Query query = session.createQuery("from Inventario i where i.productoId=:productoId and i.numero=:numero");
        query.setParameter("productoId", productoId);
        query.setParameter("numero", numero);
        Inventario inventario = (Inventario) query.uniqueResult();

        if (inventario != null) {
            if (inventario.getCantidad() > 0) {
                System.out.println("Actualiza inventario " + (inventario.getCantidad() - 1));
                inventario.setCantidad((inventario.getCantidad() - 1));
                session.saveOrUpdate(inventario);
                //tx.commit();

            } else {
                error = true;
                errorMsj = "El producto no  existe en el inventario";
            }
        } else {
            error = true;
            errorMsj = "El producto no se encuentra dado de alta en el inventario";
        }
    }

    @Override
    public void desSeparaProducto(Long productoId, String numero, long cantidad) {
        error = false;
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Inventario i where i.productoId=:productoId and i.numero=:numero");
        query.setParameter("productoId", productoId);
        query.setParameter("numero", numero);
        Inventario inventario = (Inventario) query.uniqueResult();

        if (inventario != null) {
            if (inventario.getCantidad() > 0) {
                System.out.println("Actualiza inventario " + (inventario.getCantidad() + cantidad));
                inventario.setCantidad((inventario.getCantidad() + cantidad));
                session.saveOrUpdate(inventario);
                tx.commit();
                session.close();

            } else {
                error = true;
                errorMsj = "El producto no  existe en el inventario";
            }
        } else {
            error = true;
            errorMsj = "El producto no se encuentra dado de alta en el inventario";
        }
    }

    @Override
    public List<Inventario> selectInventarioByProducto(Long productoId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Inventario i where i.productoId=:productoId");
        query.setParameter("productoId", productoId);
        List<Inventario> inventarioList = query.list();

        return inventarioList;
    }

    @Override
    public boolean isError() {
        return error;
    }

    @Override
    public void actualizaInventario(Inventario inventario) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Inventario set cantidadReal = (cantidadReal + :cantidadReal)"
                + " where id = :id");
        System.out.println("aaaa " + inventario.getCantidad());
        System.out.println("aaaa " + inventario.getId());
        query.setParameter("cantidadReal", inventario.getCantidad());
        query.setParameter("id", inventario.getId());
        int result = query.executeUpdate();
    }

    @Override
    public String getErrorMsj() {
        return errorMsj;
    }
}
