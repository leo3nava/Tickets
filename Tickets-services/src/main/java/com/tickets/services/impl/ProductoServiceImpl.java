package com.tickets.services.impl;

import com.tickets.api.entitys.catalogos.Inventario;
import com.tickets.api.entitys.catalogos.Producto;
import com.tickets.dao.InventarioDao;
import com.tickets.dao.ProductoDao;
import com.tickets.services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    ProductoDao productoDao;
    
    @Autowired
    InventarioDao inventarioDao;
    
    @Override
    public Producto altaProducto(Producto producto) {
        return productoDao.altaProducto(producto);
    }

    @Override
    public Producto bajaProducto(Producto producto) {
        producto.setEstatus("DESACTIVADO");
        return productoDao.actualizaProducto(producto);
    }

    @Override
    public Producto actualizaProducto(Producto producto) {
        return productoDao.actualizaProducto(producto);
    }
    
    @Override
    public List<Producto> consultaProducto(){
        return productoDao.consultaProducto();
        
    }
    
    @Override
    public List<Inventario> consultarInventarioByProdcto(Long productoId){
        return inventarioDao.selectInventarioByProducto(productoId);
    }

    @Override
    public void actualizaInventario(Inventario inventario){
        inventarioDao.actualizaInventario(inventario);
    }
}
