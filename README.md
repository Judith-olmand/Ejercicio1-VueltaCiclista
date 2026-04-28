Consulta de Ciclistas por País (JDBC PreparedStatement)
Programa en Java que permite realizar búsquedas dinámicas en una base de datos Oracle, filtrando la información de los ciclistas según el país de origen de su equipo.

🚀 Funcionalidades
Búsqueda Parametrizada: Solicita al usuario el nombre de un país y recupera todos los ciclistas asociados a equipos de esa región.

Seguridad en Consultas: Implementa PreparedStatement para proteger la aplicación contra ataques de Inyección SQL.

Vinculación de Tablas: Realiza un JOIN entre las tablas CICLISTA y EQUIPO para mostrar información completa en una sola vista.

Gestión Eficiente de Recursos: Utiliza el bloque try-with-resources para asegurar que la conexión y la sentencia se cierren automáticamente, incluso en caso de error.

🛠️ Estructura técnica
El proyecto se centra en la interacción segura entre Java y el motor de base de datos:

ps.setString(1, pais): Técnica de asignación de parámetros que escapa automáticamente los caracteres especiales introducidos por el usuario.

Operador LIKE: Permite realizar búsquedas flexibles en la base de datos (por ejemplo, permitiendo el uso de comodines).

Mapeo de Resultados: Transforma las filas del ResultSet en variables locales de Java para su impresión formateada por consola.
