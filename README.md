# Challenge 01 Realizado.

En el sgte Github se encuentra el challenge 01 realizado, para la parte del servidor API REST (Proyecto Maven) se encuentra dentro del carpeta
"ch01" y para la parte del FrontEnd (AngularJS) se encuentra en la carpeta "FrontEnd".

## Requerimientos mínimos a cumplir

* En el back-end:
    * Se utiliza Apache Tomcat 8.5.4.
	* Se utiliza la base de datos PostgreSQL (se añade la base de datos "chBD" guardado de forma Custom).
	* Se utiliza el ORM Hibernate 5.0.9.
	* Se trabaja mediante el patrón de arquitectura de SW, Model-View-Controller(MVC).
	* Se crea el modelo "User", en el cual se aplicara los metodos CRUD en el controlador bajo el estándar REST.
* En el front-end:
	* Se utiliza el framework de diseño Bootstrap y el framework del FrontEnd AngularJS para el manejo del servidor API REST.
* Se añade un documento "Documentación POSTMAN Challenge 01" para detallar los endpoints del servidor.
* Levantar el servidor Back-End:
    * Importar el proyecto desde el archivo pom.xml.
    * Cambiar las credenciales de la base de datos.
    * En la pestaña "Maven Projects", hacer click en "Plugins", luego en "spring-boot", y finalmente hacer click en "spring-boot:run".
* Levantar el servidor Front-End:
    * En el terminal, se debe instalar las dependecias del archivo "bower.json" mediante "bower install" (tener preinstalo bower mediante npm (npm install -g bower).
    * En el terminal, se pone el comando "grunt server" (En caso de que no funcione aplicar el codigo " npm install -g grunt-cli bower yo generator-karma generator-angular" y volver a probar).

## Interfaz Web

Para la interfaz, se trabaja con AngularJS y Bootstrap, y se hacen las sgtes consideraciones:

* En la carpeta /app/scripts/controllers, en los archivos "userCtrl.js" y "helpers.js" es necesario que se cambie la ruta del servidor con la ip del computador o servidor fisico donde se levante (cambiar la ip en cada consulta del http).

* Cualquier otro problema, favor avisar a felipe.mancilla@alumnos.usm.cl o revisar los errores en la consola del Google Chrome.


