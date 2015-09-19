/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tickets.api.entitys.catalogos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author lforero
 */
@Entity
@Table(name = "EVENTO", catalog = "tickets", uniqueConstraints = {
    @UniqueConstraint(columnNames = "ID")})
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
    
    @Column(name = "TITULAR_ID", nullable = false)
    private Integer titularId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Recinto recinto;
    
    @Column(name = "CATEGORIA_ID", nullable = false)
    private Integer categoriaId;
    
    @Column(name = "COMENTARIO_1", nullable = false)
    private String comentario1;
    
    @Column(name = "COMENTARIO_2", nullable = false)
    private String comentario2;
    
    @Column(name = "NOMBRE_ALTERNO", nullable = false)
    private String nombreAlterno;
    
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTitularId() {
        return titularId;
    }

    public void setTitularId(Integer titularId) {
        this.titularId = titularId;
    }

    public Recinto getRecinto() {
        return recinto;
    }

    public void setRecinto(Recinto recinto) {
        this.recinto = recinto;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getComentario1() {
        return comentario1;
    }

    public void setComentario1(String comentario1) {
        this.comentario1 = comentario1;
    }

    public String getComentario2() {
        return comentario2;
    }

    public void setComentario2(String comentario2) {
        this.comentario2 = comentario2;
    }

    public String getNombreAlterno() {
        return nombreAlterno;
    }

    public void setNombreAlterno(String nombreAlterno) {
        this.nombreAlterno = nombreAlterno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
