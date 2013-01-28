/*    
 * Consultas.java
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

package com.highville.taller.hibernate.dao;

import com.highville.taller.hibernate.bean.Autor;
import com.highville.taller.hibernate.bean.Direccion;
import com.highville.taller.hibernate.bean.Libro;
import com.highville.taller.hibernate.bean.Usuario;
import com.highville.taller.hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * En éste Bean veremos una forma rápida para crear, actualizar, consultar y eliminar registros de
 * la BD usando Hibernate. Aclaro que durante el taller me confundí al mencionarles del uso de
 * los DAO's en el momento de solo acceder a la Base de Datos para ver el comportamiento de
 * Hibernate. Éstos DAO's son usados en el momento en el que yo hago uso de un Framework para una
 * aplicación directamente Web, como puede ser el caso de JSF's. Así es de que no son tan necesario
 * en éste sencillo ejemplo.
 * 
 * @author dsalinas
 */
public class Consultas {
    
    public static void guardarDatos() {
        
//        Antes de iniciarse con éste archivo recuerden ejecutar el HibernateUtil.java, descomentando primero la linea
//        CreateTables();
        
//        Éste método nos permite guardar los datos necesarios para éste sencillo ejemplo de BD,
//        como recuerdan, si la Entidad no tiene relación directa sobre alguna otra entidad, es
//        fácil guardar datos en ésta entidad, como se ve acontinuación:
        
        Direccion direccion1 = new Direccion();
        direccion1.setNumero("410");
        direccion1.setCalle("Benito Juárez 2");
        direccion1.setColonia("El arenal 2");
        direccion1.setCiudad("Huajuapan 2");
        direccion1.setCp(69521);

        Direccion direccion2 = new Direccion();
        direccion2.setNumero("200");
        direccion2.setCalle("Aldama 2");
        direccion2.setColonia("La Soledad");
        direccion2.setCiudad("Ixtlan de Juárez");
        direccion2.setCp(78501);

        Direccion direccion3 = new Direccion();
        direccion3.setNumero("48");
        direccion3.setCalle("Mexico Nuevo");
        direccion3.setColonia("Romero Rubio");
        direccion3.setCiudad("Mexico DF");
        direccion3.setCp(48951);

        Direccion direccion4 = new Direccion();
        direccion4.setNumero("520");
        direccion4.setCalle("Rosas");
        direccion4.setColonia("El Molino");
        direccion4.setCiudad("Edo de Mex");
        direccion4.setCp(45872);

        Direccion direccion5 = new Direccion();
        direccion5.setNumero("10240");
        direccion5.setCalle("Jaltianguis");
        direccion5.setColonia("Sierra Juarez");
        direccion5.setCiudad("OAxaca Oax");
        direccion5.setCp(98562);

        Direccion direccion6 = new Direccion();
        direccion6.setNumero("10240");
        direccion6.setCalle("Xiacui");
        direccion6.setColonia("Tany");
        direccion6.setCiudad("OAxaca Oax");
        direccion6.setCp(45872);


//        La complejidad en el guardado puede iniciar a complicarse gradualmente, según sean las relaciones
//        requeridas y especificadas en las relaciones, tal es el caso del siguiente modo de guardado,
//        donde se requiere en el dato de Tipo Autor, un dato de tipo Dirección, a lo que deducimos
//        que es necesario crear antes un dato de Tipo Dirección:
        
        Autor autor1 = new Autor();
        autor1.setNombre("Omar");
        autor1.setApellido("Lopez");
        autor1.setCorreo("omar@gmail.com");
        autor1.setDireccion(direccion1);

        Autor autor2 = new Autor();
        autor2.setNombre("Juan");
        autor2.setApellido("Pérez");
        autor2.setCorreo("juan.perez@gmail.com");
        autor2.setDireccion(direccion2);

        Autor autor3 = new Autor();
        autor3.setNombre("Juan");
        autor3.setApellido("Mtz");
        autor3.setCorreo("juan.mtz@gmail.com");
        autor3.setDireccion(direccion3);

        Autor autor4 = new Autor();
        autor4.setNombre("Alex");
        autor4.setApellido("Pérez");
        autor4.setCorreo("alex@gmail.com");
        autor4.setDireccion(direccion4);

        Autor autor5 = new Autor();
        autor5.setNombre("Carlos");
        autor5.setApellido("Ruiz");
        autor5.setCorreo("carlos@gmail.com");
        autor5.setDireccion(direccion5);

        Autor autor6 = new Autor();
        autor6.setNombre("Fide");
        autor6.setApellido("Mtx");
        autor6.setCorreo("fidel@gmail.com");
        autor6.setDireccion(direccion6);

        Libro libro1 = new Libro();
        libro1.setIsbn("SDF5GG584");
        libro1.setTitulo("Matematicas");
        List<Autor> autores1 = new ArrayList<Autor>();
        autores1.add(autor1);
        autores1.add(autor3);
        autores1.add(autor4);
        libro1.setAutores(autores1);

        Libro libro2 = new Libro();
        libro2.setIsbn("SDF5GG584");
        libro2.setTitulo("JSF");
        List<Autor> autores2 = new ArrayList<Autor>();
        autores2.add(autor2);
        autores2.add(autor5);
        libro2.setAutores(autores2);

        Libro libro3 = new Libro();
        libro3.setIsbn("SDFWWW584");
        libro3.setTitulo("Hibernate");
        List<Autor> autores3 = new ArrayList<Autor>();
        autores3.add(autor1);
        autores3.add(autor3);
        autores3.add(autor5);
        libro3.setAutores(autores3);

        Libro libro4 = new Libro();
        libro4.setIsbn("SDF5GG584");
        libro4.setTitulo("Curso Jonathan");
        List<Autor> autores4= new ArrayList<Autor>();
        autores4.add(autor2);
        autores4.add(autor6);
        libro4.setAutores(autores4);

        Libro libro5 = new Libro();
        libro5.setIsbn("SDF5GG584");
        libro5.setTitulo("Hibernate y PostgreSQL");
        List<Autor> autores5 = new ArrayList<Autor>();
        autores5.add(autor1);
        autores5.add(autor3);
        autores5.add(autor4);
        libro5.setAutores(autores5);
        
        Libro libro6 = new Libro();
        libro6.setIsbn("DDFNNG584");
        libro6.setTitulo("Hibernate, JSF, Struts y Spring");
        List<Autor> autores6 = new ArrayList<Autor>();
        autores6.add(autor2);
        autores6.add(autor5);
        libro6.setAutores(autores6);
        
//        Hasta aquí he creado los objetos que requiero para guardar, pero para acompletar el guardado
//        necesito obtener los datos de la sesión, para poder terminar la transacción con la clase
//        HibernateUtil.java, ésto a través de su método Commit:
        
        Session session = HibernateUtil.getSession();
        session = HibernateUtil.beginTransaction();
        
//        Añado a la sesión los datos que serán guardados al Realizar el Commit
        
        session.save(autor1);
        session.save(autor2);
        session.save(autor3);
        session.save(autor4);
        session.save(autor5);
        session.save(autor6);

        session.save(direccion1);
        session.save(direccion2);
        session.save(direccion3);
        session.save(direccion4);
        session.save(direccion5);
        session.save(direccion6);

        session.save(libro1);
        session.save(libro2);
        session.save(libro3);
        session.save(libro4);
        session.save(libro5);
        session.save(libro6);
        
//        Al ejecutar el siguiente método toda actividad cargada a la sesión actual será escrita en la BD,
//        ya que sea guardar, actualizar o eliminar, será realizado al terminar la transacción.
        
        HibernateUtil.commit();
    }
    
    public static void consultasHQLListas() {
        
//        Éste método nos permite consultar información de la BD mediante el lenguaje HQL
//        de Hibernate, por lo que se encontrarán con diversas líneas comentadas, y ésto
//        es precisamente por los distintos tipos de solicitud y acceso de datos a la BD.
//        Para Acceder a cierto tipo de consulta, se tiene que descomentar cada línea y
//        comentar la línea activa. Por cada módulo de acceso se indica una descripción.
        
//        Para concretar una consulta requerimos de obtener la sesión actual de hibernate,
//        ya que es donde se encuentran los datos hasta ahora actualizados.
        
        Session session = HibernateUtil.getSession();
        session = HibernateUtil.beginTransaction();
        
//        Tipos de Acceso cuando se sabe que de regreso tendremos una seria de registros,
//        o simplemente que la cantidad sea mayor a un registro:
        
//        Los datos a consultar pueden ser de cualquier tipo, siempre y cuando al momento de declarar la variable
//        de tipo lista (List<Autor>), se recuerde expecificar la clase del mismo tipo de Dato ("from Autor"):
        
//        List<Autor> autores = session.createQuery("from Autor where id>7").list();        
//        List<Autor> autores = session.createQuery("from Autor where id>1 and nombre like 'Juan'").list();
        List<Autor> autores = session.createQuery("from Autor where id>1 and nombre like 'r%'").list();
        
//        DE AQUI SE DESPLIEGAN LOS DEMAS TIPOS DE CONSULTAS QUE USTEDES SEPAN HACER, YA QUE ÉSTA PARTE
//        ES LIBRE PRA EL DESARROLLO DE CONSULTAS, POR SER HQL. SERAN RESPECTO A SUS NECESIDADES.
        
//        Ya realizada la consulta y teniendo los datos en la lista, hay que mostrarlos para quedar convencidos
//        que son los datos requeridos, se puede dar algún formato a la impresión, pero queda de ustedes:
        
        for (Autor usuario : autores){
              System.out.println(usuario.getNombre());
        }
    }
        
    public static void consultasHQLUnicos() {
        
//        Éste método nos permite consultar información de la BD mediante el lenguaje HQL
//        de Hibernate, por lo que se encontrarán con diversas líneas comentadas, y ésto
//        es precisamente por los distintos tipos de solicitud y acceso de datos a la BD.
//        Para Acceder a cierto tipo de consulta, se tiene que descomentar cada línea y
//        comentar la línea activa. Por cada módulo de acceso se indica una descripción.
        
//        Para concretar una consulta requerimos de obtener la sesión actual de hibernate,
//        ya que es donde se encuentran los datos hasta ahora actualizados.
        
        Session session = HibernateUtil.getSession();
        session = HibernateUtil.beginTransaction();
 
//        Tipos de Acceso cuando se sabe que de regreso tendremos un solo registro:
        
//        Direccion direccion = (Direccion) session.createQuery("from Direccion where id=8").uniqueResult();
        Direccion direccion = (Direccion) session.createQuery("from Direccion where id>4 and numero='520'").uniqueResult();
//        Direccion direccion = (Direccion) session.createQuery("from Direccion where calle='Rosas' and colonia='El Molino'").uniqueResult();
        
//        DE AQUI SE DESPLIEGAN LOS DEMAS TIPOS DE CONSULTAS QUE USTEDES SEPAN HACER, YA QUE ÉSTA PARTE
//        ES LIBRE PRA EL DESARROLLO DE CONSULTAS, POR SER HQL. SERAN RESPECTO A SUS NECESIDADES.
        
//        Ya realizada la consulta y teniendo los datos en la lista, hay que mostrarlos para quedar convencidos
//        que es el dato requerido, se puede dar algún formato a la impresión, pero queda de ustedes:
        
        System.out.println(direccion.getCalle());
    }
    
    public static void consultaCriteriaExample() {
        
//        Se crea un objeto de tipo Autor al que se le ingresa solo un dato
        Autor autor= new Autor();
        autor.setNombre("Carlos");
//        Se le pueden añadir mas caracteristicas de datos sobre el objeto a buscar
//        autor.setId((long)5);
        
//        Se crea el Objeto de Tipo Example de Criteria
        Example example = Example.create(autor);
        example.enableLike(MatchMode.ANYWHERE);
//        example.enableLike(MatchMode.EXACT);
        
        Session session = HibernateUtil.beginTransaction();
        
//        Se crea el Objeto de tipo Criteria, pasando de parámetro la Clase a usar
        Criteria criteria = session.createCriteria(Autor.class);
//        Le agregamos el objeto que acabamos de crear de tipo Example
        criteria.add(example);
//        Se solicita realizar la Consulta por Criteria:
        Autor autorq = (Autor) criteria.uniqueResult();
//        Mostramos el resultado de la consulta
        System.out.println("res: "+autorq.getCorreo());
        HibernateUtil.commit();
        
    }
    
    public static void consultarCriteriaRestrictions() {
        Session session = HibernateUtil.beginTransaction();
        Criteria criteria = session.createCriteria(Direccion.class);
        
//        REVISARAN SOLO LINEA POR LINEA PARA INTENTAR ENTENDER EL COMPORTAMIENTO DE CADA CONSULTA
        
//        Muestra los datos de registros mayores al CP 48951
//        criteria.add(Restrictions.gt("cp", 48951));
//        Resultado: Benito Juárez 2, Aldama 2, Jaltianguis
//        Devuelve mas de un dato
        
//        Muestra los datos de registros menores al CP 48951
//        criteria.add(Restrictions.lt("cp", 48951));
//        Resultado: Rosas, Xiacui
//        Devuelve mas de un dato
        
//        Devuelve el registro que contenga alguna "x" como dato en el campo Calle, en cualquier posicion del dato 
//        criteria.add(Restrictions.like("calle", "x", MatchMode.ANYWHERE));
        
//        Devuelve el registro que contenga alguna "x" como dato en el campo Calle, como posición al Principio del dato. 
//        criteria.add(Restrictions.like("calle", "X", MatchMode.START));

//        Desvuelve los registros hallados dentro del rango:
//        criteria.add(Restrictions.between("cp", 45872, 48952));
        
//        Devuelve lo especificado en el paso previo, añaniendole aún otra restriccion, solo funciona esta linea:
//        criteria.add(Restrictions.like("calle", "z", MatchMode.ANYWHERE)).add(Restrictions.between("cp", 69521, 78501)); 
        
//        Si intento realizar algo como en la siguiente linea, no tendra resultado ya que no puedo validar dos veces
//        datos sobre un mismo campo ya evaluado, automaticamente se esta tomando como valor nulo
//        criteria.add(Restrictions.between("cp", 45872, 48951)).add(Restrictions.between("cp", 69521, 78501));

//        Devuelve los registros que contengan alguna "u" como dato en el campo ciudad, en cualquier posicion del dato.
//        criteria.add(Restrictions.like("ciudad", "u", MatchMode.ANYWHERE));
//        Devuelve el registro que contenga alguna "F" como dato en el campo Ciudad, como posición al Final del dato.
//        criteria.add(Restrictions.like("ciudad", "F", MatchMode.END));

//        Agregando como parametro un arreglo, en una busqueda de calles pero con cierto rango en CP, Ojo, Cuidado con los tipos de Dato:
//        Object []ada= {45872, 48951};
//        criteria.add(Restrictions.in("cp", ada));
        
//        Devuelve solo el dato equivalente al ingresado como parámetro:
//        criteria.add(Restrictions.eq("cp", 48951));
        
//        Devuelve los datos en que el campo Colonia no contenga valor Nulo
//        criteria.add(Restrictions.isNotNull("colonia"));
//        En éste caso muestra todos, ya que todos no son nulos, probar cambiando valores
        
//        Devuelve los datos en que el campo Colonia contenga valor Nulo
//        criteria.add(Restrictions.isNull("colonia"));
//        En éste caso no muestra nada, ya que ni un registro es nulo, probar cambiando valores.

//        Devuelve datos ordenados de forma Ascendente, una primera forma de hacerlo.
//        criteria.addOrder(Order.asc("ciudad"));
//        Devuelve datos ordenados de forma Descendente:
//        criteria.addOrder(Order.desc("ciudad"));

        List<Direccion> direcciones = criteria.list();
        for (Direccion direccion : direcciones){
              System.out.println(direccion.getCalle());
        }
        
//        Se realiza del mismo modo la evaluación, y por si se sabe que se espera un solo registro
//        no es necesrio llamar la impresion a través del for, sino solo utilizar el objeto devuelto:
//        Autor autor = (Autor) criteria.uniqueResult();
//        Direccion direccion = (Direccion) criteria.uniqueResult();
//        System.out.println(direccion.getCalle());
        
    }
    
    public static void otraFormaDeObtenerDatos() {
//        Esto para obtener los datos de la sesion, de Hibernate
        
        Session session = HibernateUtil.beginTransaction();
        
//        Get, en el momento en que es llamado, realiza la consulta
        
//        Load, en el momento en que se ocupa uno de sus valores, es cuando realiza la consulta, solo funciona dentro de l en transaction y cuando se recibe un solo valor
//        Load solo funciona para cuando se recibe un solo valor
        
//        Condiciones para el uso de Load
//        1 que este en su transaccion, la primera ves que se ocupe, las siguientes veces puede ser en cualquier lado
//        2 que siempre exista su id
        
        System.out.println("Previo a consultar");
//        System.out.println("Revisando datos para GET");
//        Autor autor = (Autor)session.get(Autor.class, (long)11); // Lanzando con Get
        System.out.println("Revisando datos para LOAD");
        Autor autor = (Autor)session.load(Autor.class, (long)11); // Lanzando con Load
        System.out.println("Despues de consultar");
        System.out.println(autor.getNombre());
        System.out.println(autor.getApellido());
        System.out.println(autor.getDireccion().getNumero());
        System.out.println(autor.getDireccion().getCalle());
        System.out.println(autor.getDireccion().getColonia());
        System.out.println(autor.getDireccion().getCiudad());
//        session.getTransaction().commit();
        System.out.println(autor);
    }
    
    public static void agregarDirecciones() {
        
        Session session = HibernateUtil.beginTransaction();
        
        Direccion direc1 = new Direccion();
        direc1.setCalle("Olivos");
        direc1.setCiudad("Oaxaca");
        direc1.setColonia("Hoteles");
        direc1.setCp(77777);
        direc1.setNumero("134");
        
        Direccion direc2 = new Direccion();
        direc2.setCalle("Cuarteles");
        direc2.setCiudad("Oaxaca");
        direc2.setColonia("Hoteles");
        direc2.setCp(77777);
        direc2.setNumero("135");
        
        Direccion direc3 = new Direccion();
        direc3.setCalle("Sierra Azul");
        direc3.setCiudad("Oaxaca");
        direc3.setColonia("Hoteles");
        direc3.setCp(77777);
        direc3.setNumero("136");
        
        Direccion direc4 = new Direccion();
        direc4.setCalle("Del Sol");
        direc4.setCiudad("Oaxaca");
        direc4.setColonia("Hoteles");
        direc4.setCp(77777);
        direc4.setNumero("137");
        
        Direccion direc5 = new Direccion();
        direc5.setCalle("El Mirhab");
        direc5.setCiudad("Oaxaca");
        direc5.setColonia("Hoteles");
        direc5.setCp(77777);
        direc5.setNumero("138");
        
        session.save(direc1);
        session.save(direc2);
        session.save(direc3);
        session.save(direc4);
        session.save(direc5);
        
        HibernateUtil.commit();
    }
    
    public static void actualizar() {
        Session session = HibernateUtil.beginTransaction();
        
        System.out.println("Muestro Dato Actual");
        Direccion direccion = (Direccion)session.load(Direccion.class, (long)25); // Lanzando con Load
        
        System.out.println("Despues de consultar");
        System.out.println(direccion.getNumero());
        System.out.println(direccion.getCalle());
        System.out.println(direccion.getColonia());
        System.out.println(direccion.getCiudad());
        System.out.println(direccion.getCp());
        
        System.out.println("Actualizando Datos");
        direccion.setNumero("201");
        direccion.setCalle("Ciudad Azteca");
        direccion.setColonia("Zapotecos");
        direccion.setCiudad("Tepoztlán");
        direccion.setCp(88888);
        
        System.out.println("Muestro Dato Nuevo");
        System.out.println(direccion.getNumero());
        System.out.println(direccion.getCalle());
        System.out.println(direccion.getColonia());
        System.out.println(direccion.getCiudad());
        System.out.println(direccion.getCp());
        
//        Para actualizar usando solo el método Update, tengo que indicar el ID del objeto a modificar,
//        Pero para hacerlo de forma directa bajo la comparacion del contenido de un objeto pasado como parametro
//        basta con llamar al Método SaveOrUpdate, es quien se encarga de realizar toda comparación y actualizar
//        el campo que deseamos actualizar.
        
        session.saveOrUpdate(direccion);
        HibernateUtil.commit();
        
        System.out.println("He guardado los datos");
        
        session = HibernateUtil.beginTransaction();
        System.out.println("Muestro los Datos despues de Modificados de la BD:");
        direccion = (Direccion)session.load(Direccion.class, (long)24); // Lanzando con Load
        System.out.println("Despues de consultar");
        System.out.println(direccion.getNumero());
        System.out.println(direccion.getCalle());
        System.out.println(direccion.getColonia());
        System.out.println(direccion.getCiudad());
        System.out.println(direccion.getCp());
    }
    
    public static void eliminar() {
        Session session = HibernateUtil.beginTransaction();
        
        System.out.println("Muestro Dato Actual");
        Direccion direccion = (Direccion)session.get(Direccion.class, (long)28); // Lanzando con Get
        
//        Éste es solo un modo par aobtener un dato, puede ser por algun otro tipo de consulta.
        
        System.out.println("Despues de consultar");
        System.out.println(direccion.getNumero());
        System.out.println(direccion.getCalle());
        System.out.println(direccion.getColonia());
        System.out.println(direccion.getCiudad());
        System.out.println(direccion.getCp());
        
        
        System.out.println("A eliminar Objeto de la BD:");
        session.delete(direccion);
        
        HibernateUtil.commit();
        
        System.out.println("El dato ha sido eliminado...");
    }
    
    public static void main(String[] args) {
//        Con éste método se guardan los datos iniciales para desarrollar el ejercicio:
//        guardarDatos(); // Ejecutar solo una Vez
        
//        Con éste método podemos realizar consultas con HQL manejando listas
//        consultasHQLListas();
        
//        Con éste método podemos realizar consultas HQL de datos únicos
//        consultasHQLUnicos();
        
//        Éste método permite realizar consultas usando el modo Example de Criteria
//        consultaCriteriaExample();
        
//        Éste método permite realizar consultas añadiendo restricciones a la Consulta de Tipo Criteria:
//        consultarCriteriaRestrictions();
        
//        Un modo mas de como obtener los datos 
//        otraFormaDeObtenerDatos();
        
//        Para actualizar primero ejecutar el Siguiente Metodo
//        agregarDirecciones();
//        Los ID's de direcciones que tengo son 24 al 28
        
//        posteriormente podras ver el ejercicio basandote en los ids generados por tu gestor (24-28, en mi caso):
//        actualizar();
        
//        despues podras ver el modo para eliminar un registro de la BD
//        eliminar();
        
//        Este código puede ser optimizado usando DAO's específicos para cada Entidad, así como 
//        con la ya integracion a un proyecto de desarrollo. Revisen a detalle cada parte del código
//        Si hay algo que comentar, fácil escríbanme un correo. Diego Salinas.        
        
    }
    
}
