/*    
 * HibernateUtil.java
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

package com.highville.taller.hibernate.util;

import com.highville.taller.hibernate.bean.Autor;
import com.highville.taller.hibernate.bean.Direccion;
import com.highville.taller.hibernate.bean.Libro;
import com.highville.taller.hibernate.bean.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Diego Jonathan López Salinas
 */

public class HibernateUtil {

    private static SessionFactory factory = null;

    public static Session getSession()
    {
        if(factory==null)
        {
            factory = getInitializedConfiguration().buildSessionFactory();
        }
        return factory.getCurrentSession();
    }

    public static void closeSession()
    {
        getSession().close();
    }

    private static void createTables()
    {
        new SchemaExport(getInitializedConfiguration()).create(true, true);
    }

    public static Configuration getInitializedConfiguration()
    {
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(Autor.class);
        config.addAnnotatedClass(Direccion.class);
        config.addAnnotatedClass(Libro.class);
        config.addAnnotatedClass(Usuario.class);
        config.configure();
        return config;
    }

    public static Session beginTransaction()
    {
        Session session = getSession();
        getSession().beginTransaction();
        return session;
    }

    public static void commit()
    {
        getSession().getTransaction().commit();
    }

    public static void main(String[] args) {
//         createTables();   //comentar o descomentar segun se requiera
        // BD creado con éxito...
    }
}
