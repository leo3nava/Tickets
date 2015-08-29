package com.tickets.dao;

import com.tickets.api.entitys.catalogos.Producto;
import java.util.List;

public interface ProductoDao {
    
    public Producto altaProducto(Producto producto);
    
    public Producto actualizaProducto(Producto producto);
    
    public Producto selectProductoByCodBarras(String codigoBarras);
    
    public List<Producto> consultaProducto();
    
}
