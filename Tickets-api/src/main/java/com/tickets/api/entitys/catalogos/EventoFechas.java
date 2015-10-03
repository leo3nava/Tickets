/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tickets.api.entitys.catalogos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Type;

/**
 *
 * @author lforero
 */
@Entity
@Table(name = "EVENTO_FECHAS", catalog = "tickets", uniqueConstraints = {
    @UniqueConstraint(columnNames = "ID")})
public class EventoFechas implements Serializable{

    public EventoFechas() {
    }

    public EventoFechas(Integer id, Integer numeroEvento, Date fechaEvento, Date fechaEventoAlterna, Date fechaInicioVenta, Date fechaFinVenta, Integer activo, Integer tipoVentasId) {
        this.id = id;
        this.numeroEvento = numeroEvento;
        this.fechaEvento = fechaEvento;
        this.fechaEventoAlterna = fechaEventoAlterna;
        this.fechaInicioVenta = fechaInicioVenta;
        this.fechaFinVenta = fechaFinVenta;
        this.activo = activo;
        this.tipoVentasId = tipoVentasId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    @Column(name = "NUMERO_EVENTO", nullable = false)
    private Integer numeroEvento;
    @Column(name = "FECHA_EVENTO")
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
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "IMAGEN_EVENTO", length = 1000000)
    private byte[] imagenEvento;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENTO_ID", nullable = false)
    private Evento evento;
    
    @Transient
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

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

    public String getFechaEvento() {
        return df.format(fechaEvento);
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getFechaEventoAlterna() {
        return df.format(fechaEventoAlterna);
    }

    public void setFechaEventoAlterna(Date fechaEventoAlterna) {
        this.fechaEventoAlterna = fechaEventoAlterna;
    }

    public String getFechaInicioVenta() {
        return df.format(fechaInicioVenta);
    }

    public void setFechaInicioVenta(Date fechaInicioVenta) {
        this.fechaInicioVenta = fechaInicioVenta;
    }

    public String getFechaFinVenta() {
        return df.format(fechaFinVenta);
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

    public byte[] getImagenEvento() {
        return imagenEvento;
    }

    public void setImagenEvento(byte[] imagenEvento) {
        this.imagenEvento = imagenEvento;
    }

    @JsonBackReference
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
