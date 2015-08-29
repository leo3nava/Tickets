/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tickets.api.entitys.catalogos;


/**
 *
 * @author lnava
 */
public class RequestWrapper {
    
    private Producto producto;
    private String accion;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
