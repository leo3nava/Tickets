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
@Table(name="PRODUCTO", catalog="tickets", uniqueConstraints={
    @UniqueConstraint(columnNames = "ID")})
public class Producto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID", unique=true, nullable=false)
    private Long id;
    
    @Column(name="CODIGO_BARRAS", unique=true, nullable=false)
    private String codigoBarras;
    
    @Column(name="DESCRIPCION", nullable=false)
    private String descripcion;
    
    @Column(name="DESCRIPCION_CORTA")
    private String descripcionCorta;
    
    @Column(name="EXISTENCIA_MINIMA")
    private Long existenciaMinima;
    
    @Column(name="PRECIO_VENTA")
    private BigDecimal precioVenta;
    
    @Column(name="ESTATUS")
    private String estatus;
    
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

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public Long getExistenciaMinima() {
        return existenciaMinima;
    }

    public void setExistenciaMinima(Long existenciaMinima) {
        this.existenciaMinima = existenciaMinima;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
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
