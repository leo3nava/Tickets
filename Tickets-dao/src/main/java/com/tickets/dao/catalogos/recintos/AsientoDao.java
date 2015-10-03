package com.tickets.dao.catalogos.recintos;

import com.tickets.api.entitys.catalogos.recintos.Asiento;
import java.util.List;

public interface AsientoDao {
    
    public Asiento altaAsiento(Asiento asiento);
    
    public Asiento actualizaAsiento(Asiento asiento);
    
    public Asiento bajaAsiento(Integer id);
    
    public List<Asiento> consultaAsientosList();
    
    public Asiento consultaAsiento(Integer id);
    
}
