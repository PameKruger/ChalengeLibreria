# Alura - ONE Oracle Next Education
## ChalengeLibreria
| ![Alura - ONE Oracle Next Education ](/docs/src/img/logo_alura_one.png)                                                                                                                                                                                                                                                                                                                                                                |
|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| :---:                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| Curso ONE Oracle Next Education T6, una colaboración entre Oracle y Alura, donde me dedico a resolver el desafío LiterAlura. Aquí experimentarás directamente el rol de un desarrollador backend en la vida cotidiana, creando una aplicación con conexión a una base de datos relacional. Es crucial que completes este desafío, ya que es una parte esencial del programa ONE, donde tendrás la oportunidad de aplicar conceptos ... |
| <a href="https://app.aluracursos.com/user/rossete-nl" target="_blank"><img style="margin: 10px" height="700" width="605" src="/docs/src/img/presentacion.png" alt="Imagem Presentacion"/></a>                                                                                                                                                                                                                                          |

<a href="https://spring.io/"><img height="35" src="https://img.shields.io/badge/Spring-008000?style=for-the-badge&logo=spring&logoColor=white"></a>
<a href="https://docs.oracle.com/en/java/javase/20/"><img height= "35" src= "https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"></a>
<a href="https://www.postgresql.org/"><img height="35" src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"></a>


## Índice
<a id="topo"></a>

- [Presentacion](#presentacion)
- [Funcionalidades](#funcionalidades)
- [Ejecucion](#ejecucion)
- [Conclusion](#conclucion)
- [Insignia](#insignia)
- [Licencia](#licencia)


## <a name="presentacion"> Presentacion </a>

Este proyecto es parte del curso de Java ofrecido por Alura para las cohortes de Oracle ONE. Literalura utiliza la API externa Gutendex, que proporciona información sobre el catálogo de libros de Project Gutenberg, una biblioteca en línea de libros electrónicos gratuitos. Permite a los usuarios buscar títulos del Project Gutenberg mediante la interacción con el terminal y guarda los libros y autores en una base de datos local.


## <a name="funcionalidades"> Funcionalidades </a>

La aplicación ofrece diversas funcionalidades:
- **Buscar libro por título:** *Permite al usuario buscar un libro por su título y guardarlo en la base de datos.*
- **Listar libros registrados:** *Muestra todos los libros registrados en la base de datos.*
- **Listar autores registrados:** *Muestra todos los autores registrados en la base de datos.*
- **Listar autores vivos en un año específico:** *Lista los autores que estaban vivos en un año específico y están registrados en la base de datos.*
- **Listar libros en un idioma específico:** *Muestra los libros disponibles en la base de datos en un idioma específico.*
- **Listar los 10 libros más descargados:** *Muestra los 10 libros más descargados desde Gutendex.*
- **Buscar autor:** *Permite al usuario buscar información sobre un autor. Si el autor no está en la base de datos, se realiza una búsqueda de un libro de su autoría que se insertará en la base de datos.*
- **Media de descargas por autor:** *Muestra el promedio de descargas por autor.*

<p align="right">
  <a href="#topo" style="text-decoration: none; background-color: #007bff; color: white; padding: 10px 20px; border-radius: 5px;">Volver a inicio</a>
</p>

## <a name="ejecucion"> Ejecucion </a>

Para ejecutar el proyecto localmente, sigue estos pasos:

1. Clona este repositorio en tu entorno local.
2. Asegúrate de tener instalado JDK (Java Development Kit) y Maven en tu máquina.
3. Abre una terminal en el directorio principal y ejecuta el comando:
   ```sh
   mvn clean install
   ```
4. Configura el entorno de la base de datos según las configuraciones del proyecto. (Este proyecto utiliza PostgreSQL).
5. Configura las variables de entorno correctamente:
   - `JAVA_HOME`: Ruta al directorio de tu JDK.
   - `M2_HOME`: Ruta al directorio de tu Maven.
   - Añade ambos al `PATH` incluyendo `\bin` al final.

### Configuración de POSTGRES

Define las siguientes variables de entorno:

- `DB_HOST`: Host de PostgreSQL (si se ejecuta localmente, será `localhost`)
- `DB_NAME`: Nombre de la base de datos creada.
- `DB_USER`: Tu usuario de PostgreSQL.
- `DB_PASSWORD`: Tu contraseña de PostgreSQL.

En el archivo de configuración, utiliza las variables de la siguiente manera:

```properties
spring.datasource.url=jdbc:postgresql://${DB_HOST}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

<p align="right">
  <a href="#topo" style="text-decoration: none; background-color: #007bff; color: white; padding: 10px 20px; border-radius: 5px;">Volver a inicio</a>
</p>


## <a name="conclucion"> Conclusion </a>

Este proyecto es una aplicación práctica del curso de Java de Alura para las cohortes de Oracle ONE. Hemos explorado el desarrollo de proyectos utilizando Spring Boot y Maven, aprendiendo a gestionar dependencias y manipular datos JSON. Además, revisamos conceptos fundamentales como funciones lambda, la API de Streams de Java, interfaces, genéricos y manipulación de fechas.

## <a name="insignia"></a>Insignia

- Insignia

[![Badge](docs/src/img/badge_literalura.png)](https://app.aluracursos.com/user/rossete-nl)



<p align="right">
  <a href="#topo" style="text-decoration: none; background-color: #007bff; color: white; padding: 10px 20px; border-radius: 5px;">Volver a inicio</a>
</p>

## <a name="licencia"> Licencia </a>

<a href="https://buymeacoffee.com/ryuugunatm" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png" alt="Buy Me A Coffee" style="height: 60px !important;width: 217px !important;" ></a>

Copyright © 2024 Pamela Negrete
