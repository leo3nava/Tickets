/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tickets.api.entitys.catalogos;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author lforero
 */
@Entity
@Table(name = "EVENTOS_FECHAS", catalog = "ticketes", uniqueConstraints = {
    @UniqueConstraint(columnNames = "ID")})
public class EventosFechas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name = "NUMERO_EVENTO", nullable = false)
    private Integer numeroEvento;
    
    @Column(name = "FECHA_EVENTO", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEvento;
    
    @Column(name = "FECHA_EVENTO_ALTERNA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEventoAlterna;
    
    @Column(name = "FECHA_INICIO_VENTA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicioVenta;
    
    @Column(name = "FECHA_FIN_VENTA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFinVenta;
    
    @Column(name = "ACTIVO", nullable = false)
    private Integer activo;
    
    @Column(name = "TIPO_VENTAS_ID", nullable = false)
    private Integer tipoVentasId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroEvento() {
        return numeroEvento;
    }

    public void setNumeroEvento(Integer numeroEvento) {
        this.numeroEvento = numeroEvento;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public Date getFechaEventoAlterna() {
        return fechaEventoAlterna;
    }

    public void setFechaEventoAlterna(Date fechaEventoAlterna) {
        this.fechaEventoAlterna = fechaEventoAlterna;
    }

    public Date getFechaInicioVenta() {
        return fechaInicioVenta;
    }

    public void setFechaInicioVenta(Date fechaInicioVenta) {
        this.fechaInicioVenta = fechaInicioVenta;
    }

    public Date getFechaFinVenta() {
        return fechaFinVenta;
    }

    public void setFechaFinVenta(Date fechaFinVenta) {
        this.fechaFinVenta = fechaFinVenta;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public Integer getTipoVentasId() {
        return tipoVentasId;
    }

    public void setTipoVentasId(Integer tipoVentasId) {
        this.tipoVentasId = tipoVentasId;
    }
    
    
}
