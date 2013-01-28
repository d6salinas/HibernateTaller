/*    
 * Libro.java
 * This file is part of HibernateTaller
 * 
 * Copyright (C) 2012 - Diego Jonathan López Salinas
 * 
 * HibernateTaller is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * HibernateTaller is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with HibernateTaller; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package com.highville.taller.hibernate.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author dsalinas
 */
@Entity
public class Libro implements Serializable{
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;    //este nombre se registra en base al puesto al iniciar la relacion en la clase Usuario
    
    @Id
    @GeneratedValue
    private Long id;
    private String isbn;
    private String titulo;
    
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="Libro_Autor", joinColumns={@JoinColumn(name="libro_id")}, inverseJoinColumns={@JoinColumn(name="autor_id")})
    private List<Autor> autores;
    //
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the autores
     */
    public List<Autor> getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

}
