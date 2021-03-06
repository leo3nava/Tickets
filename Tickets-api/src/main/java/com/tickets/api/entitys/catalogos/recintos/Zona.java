/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tickets.api.entitys.catalogos.recintos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author lforero
 */
@Entity
@Table(name = "ZONA", catalog = "tickets", uniqueConstraints = {
    @UniqueConstraint(columnNames = "ID")})
public class Zona implements Serializable{

    public Zona() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
            
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;    
    
    @ManyToOne()
    @JoinColumn(name = "MAPA_ID", nullable = false)
    private Mapa mapa;
    
    public Mapa getMapa() {
        return mapa;
    }

    public void setRecinto(Mapa mapa) {
        this.mapa = mapa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
