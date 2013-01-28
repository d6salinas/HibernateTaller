/*    
 * Usuario.java
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author dsalinas
 */
@Entity
@Table(name="usuarios_biblioteca")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue //para crear el id autogenerado
    @Column(name="id_usuario")
    private Long id;

    @Column(nullable=false, length=50)
    private String nombre;
    @Column(length=20)
    private String contraseña;
    @Column(name="email", unique=true, length=50)
    private String correo;
    private Boolean aceptado;
    @Temporal(value = javax.persistence.TemporalType.DATE)
    @Column(name = "fecha_inscripcion")
    private Calendar fechaInscripcion;
    @Temporal(value = javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha_prestamo")
    private Date fechaPrestamo;
    private Integer edad;
    @OneToMany(mappedBy = "usuario", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Libro> libros;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the contraseña
     */
    
    //@Column(length=20) //tambien aqui son los unicos lubgares 2
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String toString()
    {
        return +id+" - "+nombre;
    }

    /**
     * @return the aceptado
     */
    public Boolean getAceptado() {
        return aceptado;
    }

    /**
     * @param aceptado the aceptado to set
     */
    public void setAceptado(Boolean aceptado) {
        this.aceptado = aceptado;
    }
    
    /**
     * @return the fechaInscripcion
     */
    public Calendar getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     * @param fechaInscripcion the fechaInscripcion to set
     */
    public void setFechaInscripcion(Calendar fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    /**
     * @return the fechaPrestamo
     */
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * @param fechaPrestamo the fechaPrestamo to set
     */
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * @return the edad
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @return the libros
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * @param libros the libros to set
     */
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

}
