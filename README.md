Sistema de administración de Insumos Médicos - Ecommerce Admin
Este proyecto es una aplicación web diseñada para la gestión administrativa de un catálogo de insumos médicos. Permite controlar productos, categorizarlos y mantener el inventario.

•	Características Principales
 -Visualización de catálogo completo.
 -Creación, edición y eliminación de insumos.
 -Clasificación dinámica de productos para una mejor organización.

•	Tecnologías Utilizadas
-Java EE
-PostgreSQL.
-Apache Tomcat v10.1.
-Eclipse IDE for Enterprise Java and Web Developers.

•	Estructura del Proyecto
-src/main/java: Contiene la lógica de negocio (Modelos/DAO).
-src/main/webapp: Contiene las vistas (JSP), estilos y scripts.
-database: Contiene el script ecommerce_admin.sql con la creación de tablas y datos de prueba.

•	Instrucciones de Ejecución
-Ejecuta el script ecommerce_admin.sql en el gestor de base de datos PostgreSQL para las tablas de categorías, clientes, productos, existencias y pedidos.
-Configurar los datos de conexión a tu base de datos en la clase Conexion.java (URL, usuario y contraseña).
-Exporta el proyecto desde Eclipse como archivo .war.
-Despliega el archivo generado en la carpeta webapps de tu servidor Apache Tomcat.
-Reinicia el servidor y accede a la ruta principal: http://localhost:8080/ecommerce_admin_productos/listarProductos.
Enlace repositorio: https://github.com/franciscaortiz-dotcom/ecommerce_admin.git
