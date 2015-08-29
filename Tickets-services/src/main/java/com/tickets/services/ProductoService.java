package com.tickets.services;

import com.tickets.api.entitys.catalogos.Inventario;
import com.tickets.api.entitys.catalogos.Producto;
import java.util.List;

public interface ProductoService {
    
    public Producto altaProducto(Producto producto);
    
    public Producto bajaProducto(Producto producto);
    
    public Producto actualizaProducto(Producto producto);
    
    public List<Producto> consultaProducto();
    
    public List<Inventario> consultarInventarioByProdcto(Long productoId);
    
    public void actualizaInventario(Inventario inventario);
    
}
