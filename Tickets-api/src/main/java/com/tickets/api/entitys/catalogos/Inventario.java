package com.tickets.api.entitys.catalogos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="INVENTARIO", catalog="tickets", uniqueConstraints={
    @UniqueConstraint(columnNames = "ID")})
public class Inventario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID", unique=true, nullable=false)
    private Long id;
    
    @Column(name="PRODUCTO_ID", unique=true, nullable=false)
    private Long productoId;
    
    @Column(name="CANTIDAD", nullable=false)
    private Long cantidad;
    
    @Column(name="CANTIDAD_REAL")
    private long cantidadReal;
    
    @Column(name="NUMERO")
    private String numero;
    
    //Poner el ID del usuario
    @Column(name="CREADO_POR")
    private Long creadoPor;
    
    @Column(name="FECHA_CREACION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreacion;
    
    @Column(name="MODIFICADO_POR")
    private Long modificadoPor;
    
    @Column(name="FECHA_MODIFICACION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaModificacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public long getCantidadReal() {
        return cantidadReal;
    }

    public void setCantidadReal(long cantidadReal) {
        this.cantidadReal = cantidadReal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Long creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(Long modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

}
