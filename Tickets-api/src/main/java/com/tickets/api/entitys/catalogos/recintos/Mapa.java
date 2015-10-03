/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tickets.api.entitys.catalogos.recintos;

import com.tickets.api.entitys.catalogos.Recinto;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "MAPA", catalog = "tickets", uniqueConstraints = {
    @UniqueConstraint(columnNames = "ID")})
public class Mapa implements Serializable {

    public Mapa() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
    
    @ManyToOne()
    @JoinColumn(name = "RECINTO_ID", nullable = false)
    private Recinto recinto;

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

    public Recinto getRecinto() {
        return recinto;
    }

    public void setRecinto(Recinto recinto) {
        this.recinto = recinto;
    }
}
