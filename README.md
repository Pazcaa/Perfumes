# Perfumes

Proyecto Web **Java EE** siguiendo el patrón de **MVC** contra una bbdd **Mysql**
CMS para gestionar los perfumes de una tienda. 


![screenshot 1]( Screenshot1.png?raw=true)


## Técnologia

- Maven 4.0.0
- Java 8
- Java Servlet Api 3.0.1
- JSP 2.2
- JSTL 1.2
- Javax Validation Api 1.1.0.Final
- Bootstrap 4.5.0
- FontAwesome 5.13.0
- Datatables.net 1.10.21

Para ver mas detalles sobre las depencias de este proyecto mirar el [pom.xml](https://github.com/Pazcaa/Perfumes/blob/master/pom.xml)




## configuración de la bbdd

Para crear la bbdd disponemos de un script **script-perfumes.sql** en la raiz del proyecto, el cual crea el esquema **perfumes** y las tablas necesarias, ademas de insertar datos de prueba.

![screenshot 2]( Screenshotbbdd.png?raw=true)

Para realizar la conexión a la bbdd cambiar el siguiente fichero **src/main/webapp/META-INF/context.xml**


```
<?xml version="1.0" encoding="UTF-8"?>
  <Context path="/ejemplo05">
      <Resource
          type="javax.sql.DataSource"
          auth="Container"
          name="jdbc/super"
          driverClassName="com.mysql.jdbc.Driver"
          url="jdbc:mysql://localhost:3306/perfumes"
          username="debian-sys-maint"
          password="o8lAkaNtX91xMUcV"
          maxActive="100"
          maxIdle="30"
          maxWait="10000"          
      />
 </Context>
```

## Ejecutar Proyecto

Al ser un proyecto web necesitamos un servidor de aplicaciones, en nuestro caso recomendamos **Apache Tomcat 9.0**.

Podemos navegar por los diferentes enlaces de la cabecera puesto que son públicos.
Si queremos entrar a los paneles de Administración deberemos *Iniciar Sesión*.
Tenemos dos roles diferentes:

1. Administrador   **[admin,1234]** : Permisos Totales para cambiar cualquier perfume
2. Usuario Normal  **[benjamin, 1234]** : Permismos solo para sus perfumes

*Las contraseñas estan haseadas en MD5 dentro de la bbdd.*


## Estructura Clases del proyecto

Interesante consultar la documentacion [JavaDoc API](https://github.com/Pazcaa/Perfumes/tree/master/src/main/webapp/doc) la cual esta accesible una vez ejecutado el proyecto en la propia barra de navegación.

Intersante mirar los siguientes packages de java:

- **listener** Listener que se ejecuta al arrancar la APP
- **controller.backoffice** Controladores para el usuario administrador
- **controller.frontoffice** Controladores para el usuario normal
- **modelo.pojo** Pojos o Clases para crear Objetos e java
- **modelo.dao** DAO para relacionar los Pojos de Java con las tablas dela BBDD
- **seguridad** Filtros de seguridad


