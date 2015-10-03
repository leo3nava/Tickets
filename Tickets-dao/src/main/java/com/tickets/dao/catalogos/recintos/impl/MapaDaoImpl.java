package com.tickets.dao.catalogos.recintos.impl;

import com.tickets.api.entitys.catalogos.recintos.Mapa;
import com.tickets.dao.catalogos.recintos.MapaDao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("MapaDao")
public class MapaDaoImpl implements MapaDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Mapa altaMapa(Mapa mapa) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(mapa);
        return mapa;
    }

    @Override
    public Mapa actualizaMapa(Mapa mapa) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(mapa);
        return mapa;
    }

    @Override
    public Mapa bajaMapa(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Mapa mapa = consultaMapa(id);
        session.saveOrUpdate(mapa);
        
        return mapa;
    }

    @Override
    public List<Mapa> consultaMapasList() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Mapa.class);
        //String query = "select mapa from Mapa mapa";
        //List<Mapa> mapasList = session.createQuery(query).list();
        String queryStr = "select m from Mapa m left join m.recinto r WHERE r.id = :recintoId";
        Query query = session.createQuery(queryStr);
        query.setParameter("recintoId", 2);
        List<Mapa> mapasList = query.list();
        
        
        //criteria.add(Restrictions.eq("activo", 1));
        //criteria.addOrder(Order.asc("nombre"));
        //List<Mapa> mapasList = criteria.list();
        return mapasList;
    }
    @Override
    public Mapa consultaMapa(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Mapa mapa = (Mapa) session.get(Mapa.class, id);
        return mapa;
    }
}
