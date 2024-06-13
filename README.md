***Gestión de Usuario***

Se considera un proyecto donde se gestione el registro y edición, se consideran algunas reglas a considerar, de la misma forma se describe a la brevedad los pasos que se siguieron para realizar las tareas. Las herramientas que se alisaron fue IntelliJ IDEA, DBeaver, XAMPP y DBeaver para la parte de Backend.

1\.- **Login**: 

1. Validar que el usuario existe en la tabla **usuario**.
1. Validar que la contraseña coincida con la registrada en **usuario,** este dato se guarda encriptado con SHA Base 64.
1. Mostrar una página de Bienvenida y menú con 2 opciones:
   1. Gestión de Usuarios (2).
   1. Tablero de Usuarios (3).
1. No permitir el acceso si la fecha de caducidad a vencido.

` `2.- **Gestión de Usuarios**

Generar formulario para Altas, Bajas, Modificaciones de registros de usuario.

**3.- Tablero y buscador de Usuarios.**

Generar una vista de tablero por estatus de usuario y filtros de búsqueda.

***Manos a la obra***

De primera instancia se crea la base de datos de acuerdo a las reglas mencionadas el modelo a seguir es el siguiente.

|**USUARIO**|||||
| :-: | :- | :- | :- | :- |
|**COLUMN**|**PK**|**NULL?**|**TYPE**|**DEFAULT**|
|LOGIN|YES|N|VARCHAR2 (20 Byte)| |
|PASSWORD| |N|VARCHAR2 (30 Byte)| |
|NOMBRE| |N|VARCHAR2 (50 Byte)| |
|CLIENTE| |N|FLOAT| |
|EMAIL| |Y|VARCHAR2 (50 Byte)| |
|FECHAALTA| |N|DATE|SYSDATE               |
|FECHABAJA| |Y|DATE| |
|STATUS| |N|CHAR (1 Byte)|'A'                   |
|INTENTOS| |N|FLOAT|0|
|FECHAREVOCADO| |Y|DATE| |
|FECHA\_VIGENCIA| |Y|DATE| |
|NO\_ACCESO| |Y|INTEGER| |
|APELLIDO\_PATERNO| |Y|VARCHAR2 (50 Byte)| |
|APELLIDO\_MATERNO| |Y|VARCHAR2 (50 Byte)| |
|AREA| |Y|NUMBER (4)| |
|FECHAMODIFICACION| |N|DATE|SYSDATE |

Para este ejemplo se creo la base de datos y tabla usuario con DBeaver haciendo una conexión con base de datos Mysql y se generan los siguientes atributos


Se descarga de la página “start.spring.ip” que sirve para configurar un proyecto de Spring y  se agregan algunas dependencias para nuestro proyecto.

Una vez descargado abrimos el proyecto en este caso utilizo IntelliJIDEA y creamos las carpetas junto con los archivos a trabajar

Se configura la conexión para gestionar los datos de primera instancia se crea nuestra entidad que hace referencia a nuestra tabla. Editamos el archivo “application.properties” para la conexión con el driver mysl, de la misma forma se trabaja con la herramienta Postman, en cada uno de los Endpoints,ya sea GET, POST o PUT.


