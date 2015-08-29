package com.tickets.dao;

import com.tickets.api.entitys.catalogos.Inventario;
import java.util.List;

public interface InventarioDao {
    
    public void separaProducto(Long productoId, String numero);
    
    public void desSeparaProducto(Long productoId, String numero, long cantidad);
    
    public boolean isError();
    
    public String getErrorMsj();
    
    public List<Inventario> selectInventarioByProducto(Long productoId);
    
    public void actualizaInventario(Inventario inventario);
    
}
