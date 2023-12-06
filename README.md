# Sistema de Monitoreo de Usuarios - API Test

Api desarrollada en Java, en su framework Springboot, usando como gestor de dependencias Gradle, implementando arquitectura 
limpia/hexagonal, quise implementar esta arquitectura ya que es ideal para darle escalabilidad y mantenibilidad a las apis 
contruidas por grandes equipos, usé Gradle ya que permite implementar microservicios de mejor manera gracias a su amplia configuracion.
Aunque pude implementar una arquitectura menos compleja por el tamaño del api, quise demostrar un poco mi conocimiento.

### Construido con

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
* ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
* ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
* ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

## Configuración del Entorno

Asegúrese de configurar las siguientes variables de entorno antes de ejecutar la aplicación:

- `URL_DB_ENV`: URL de la base de datos PostgreSQL.
- `PORT_DB_ENV`: Puerto de la base de datos.
- `NAME_DB_ENV`: Nombre de la base de datos.
- `USERNAME_DB_ENV`: Nombre de usuario de la base de datos.
- `PASSWORD_DB_ENV`: Contraseña de la base de datos.

## Roles y Accesos

- **User**: Puede ver solo sus propios datos, incluidos sus países asociados y su monitoreo de usuario (UserMonitoring).
- **Manager**: Puede ver todos los usuarios de todos los países, pero no puede acceder a UserMonitoring.
- **Admin**: Tiene acceso a todos los datos.

## Endpoints

### Ruta Base: `/api-test`

- **Obtiene la información de todos los usuarios.**

  **Acceso**: User, Manager, Admin.
- 
  **Endpoint:** `/users`

  **HTTP Method:** GET

  **Query Parameters:**

    `page`(Valor por defecto: 1): La pagina a mostrar.      
    `size`(Valor por defecto: 10): Cantidad de registros por pagina.

  **Response:**

    200 OK, Si se encuentran usuarios registrados.
     ```json
     [
        {        
          "id": "String",
          "email": "String",
          "name": "String",
          "image": "String",
          "position": "String",
          "role": {  
              "id": "String",
              "name": "String",
              "createdAt": "String"
          },
          "email_verified": "String",
          "terms_and_conditions_accepted": "String",
          "created_at": "String",
          "updated_at": "String"
        },
        {        
          "id": "String",
          "email": "String",
          "name": "String",
          "image": "String",
          "position": "String",
          "role": {  
              "id": "String",
              "name": "String",
              "createdAt": "String"
          },
          "email_verified": "String",
          "terms_and_conditions_accepted": "String",
          "created_at": "String",
          "updated_at": "String"
        }
     ]
     ```

     404 Bad Request, Usuarios no encontrados
     ```json
     {
        "error": "string"
     }
     ```

     409 Bad Request, Si en el cuerpo de la solicitud faltan campos obligatorios o contiene datos no válidos.
     ```json
     {
        "error": "string"
     }
     ```

- **Obtiene un usuario por correo electrónico.**

  **Acceso**: User, Manager, Admin.

  **Endpoint:** `/users/search`

  **HTTP Method:** GET

  **Request Body:**
   ```json
   [
      {
        "email": "test@test.com"
      }
   ]
   ```

  **Response:**

  200 OK, Si el usuario se encuentra registrado.
     ```json
     {        
       "id": "String",
       "email": "String",
       "name": "String",
       "image": "String",
       "position": "String",
       "role": {  
           "id": "String",
           "name": "String",
           "createdAt": "String"
       },
       "email_verified": "String",
       "terms_and_conditions_accepted": "String",
       "created_at": "String",
       "updated_at": "String"
     }
     ```

  404 Bad Request, Usuario no encontrado
     ```json
     {
        "error": "string"
     }
     ```

  409 Bad Request, Si en el cuerpo de la solicitud faltan campos obligatorios o contiene datos no válidos.
     ```json
     {
        "error": "string"
     }
     ```  
  
- **Obtiene todos los países.**:

  **Acceso**: Manager, Admin.

  **Endpoint:** `/countries`

  **HTTP Method:** GET

  **Query Parameters:**

  `page`(Valor por defecto: 1): La pagina a mostrar.      
  `size`(Valor por defecto: 10): Cantidad de registros por pagina.

  **Response:**

  200 OK, Si se encuentran Paises registrados.
     ```json
     [
        {
          "id": "String",
          "name": "String",
          "created_at": "String",
          "updated_at": "String"
        },
        {
          "id": "String",
          "name": "String",
          "created_at": "String",
          "updated_at": "String"
        }
     ]
     ```

  404 Not Found, Paises no encontrados.
     ```json
     {
        "error": "string"
     }
     ```

  409 Bad Request, Si en el cuerpo de la solicitud faltan campos obligatorios o contiene datos no válidos.
     ```json
     {
        "error": "string"
     }
     ```  

- **Obtiene UserMonitoring de un usuario en un rango de tiempo.**

  **Acceso**: User.

  **Endpoint:** `/user-monitoring`

  **HTTP Method:** GET

  **Query Parameters:**

  `page`(Valor por defecto: 1): La pagina a mostrar.      
  `size`(Valor por defecto: 10): Cantidad de registros por pagina.

  **Request Body:**
   ```json
    [
      {
        "email": "test@test.com",
        "start_date" : "2023-02-16",
        "end_date" : "2023-04-08"
      }
    ]
   ```

  **Response:**

  200 OK, Si el usuario se encuentra registrado.
    ```json
    
    [
      {
        "id": "fbc92e83-da5d-423c-80bb-89f59cab3549",
        "usage": 1,
        "description": "print",
        "created_at": "2023-04-08T00:00:00.000+00:00",
        "user_id": "e4eabe70-ae3d-4ae7-89d9-40f041ab8f4f"
      },
      {
        "id": "ffd2ed58-e4bb-4313-afa9-2bb060db0354",
        "usage": 1,
        "description": "print",
        "created_at": "2023-03-18T00:00:00.000+00:00",
        "user_id": "e4eabe70-ae3d-4ae7-89d9-40f041ab8f4f"
      }
    ]
     ```

  404 Bad Request, Usuario no encontrado
     ```json
     {
        "error": "string"
     }
     ```

  409 Bad Request, Si en el cuerpo de la solicitud faltan campos obligatorios o contiene datos no válidos.
     ```json
     {
        "error": "string"
     }
     ```  

- **Obtiene los tres usuarios con más registros en UserMonitoring en un rango de tiempo específico.**

  **Acceso**: Admin.

  **Endpoint:** `/users/max-monitoring-records`

  **HTTP Method:** GET

  **Query Parameters:**

  `page`(Valor por defecto: 1): La pagina a mostrar.      
  `size`(Valor por defecto: 10): Cantidad de registros por pagina.

  **Request Body:**
   ```json
    [
      {
        "start_date" : "String",
        "end_date" : "String"
      }
    ]
   ```

  **Response:**

  200 OK, Si se encuentran Usuarios.
    ```json
    [
      {
        "id": "String",
        "email": "String",
        "name": "String",
        "image": "String",
        "position": "String",
        "role": {
            "id": "String",
            "name": "String",
            "createdAt": "String"
        },
        "email_verified": "String",
        "terms_and_conditions_accepted": "String",
        "created_at": "String",
        "updated_at": "String"
      },
      {
        "id": "String",
        "email": "String",
        "name": "String",
        "image": "String",
        "position": "String",
        "role": {
            "id": "String",
            "name": "String",
            "createdAt": "String"
        },
        "email_verified": "String",
        "terms_and_conditions_accepted": "String",
        "created_at": "String",
        "updated_at": "String"
      }
    ]
     ```

  404 Not Found, Si no se encuentran registros.
     ```json
     {
        "error": "string"
     }
     ```

  409 Bad Request, Si en el cuerpo de la solicitud faltan campos obligatorios o contiene datos no válidos.
     ```json
     {
        "error": "string"
     }
     ```  

- **Obtiene los principales usuarios por tipo de uso en un país específico en un rango de tiempo.**

  **Acceso**: Admin.

  **Endpoint:** `/users/description-and-country`

  **HTTP Method:** GET

  **Request Body:**
   ```json
   [
      {
        "description" : "String",
        "country_id" : "String",
        "start_date" : "String",
        "end_date" : "String"
      }
   ]
   ```

  **Response:**

  200 OK, Si se encuentran usuarios.
   ```json
   [
      {        
        "id": "String",
        "email": "String",
        "name": "String",
        "image": "String",
        "position": "String",
        "role": {  
            "id": "String",
            "name": "String",
            "createdAt": "String"
        },
        "email_verified": "String",
        "terms_and_conditions_accepted": "String",
        "created_at": "String",
        "updated_at": "String"
      },
      {        
        "id": "String",
        "email": "String",
        "name": "String",
        "image": "String",
        "position": "String",
        "role": {  
            "id": "String",
            "name": "String",
            "createdAt": "String"
        },
        "email_verified": "String",
        "terms_and_conditions_accepted": "String",
        "created_at": "String",
        "updated_at": "String"
      }
   ]
   ```

  404 Not Found, Si no se encuentran registros.
   ```json
   {
      "error": "string"
   }
   ```

  409 Bad Request, Si en el cuerpo de la solicitud faltan campos obligatorios o contiene datos no válidos.
   ```json
   {
      "error": "string"
   }
   ```
  
## Dependencias

- JPA
- Mapstruct
- Lombok
- Jakarta

## Ejecución de la Aplicación

Para ejecutar la aplicación, asegúrese de tener Java 17 instalado y siga estos pasos:

1. Clone este repositorio.
2. Configure las variables de entorno mencionadas anteriormente.
3. Cambie el puerto si lo requiere
    ```yml
   # src/main/resources/application-dev.yml
   server:
      port: <puerto-requerido>
   ```
4. Ejecute `./gradlew bootRun` para iniciar la aplicación.

La aplicación estará disponible por defecto en `http://localhost:8090/api-test`.

## Dockerfile

1. crear el archivo `env.properties` en la raiz del proyecto, en se debe agregar las siguientes variables globales con 
sus respectivos valores:
 ```properties
   # env.properties
   PORT_DB_ENV=puerto-de-la-base-de-datos
   NAME_DB_ENV=nombre-de-la-base-de-datos
   PASSWORD_DB_ENV=contraseña-de-la-base-de-datos
   URL_DB_ENV=url-de-la-base-de-datos
   USERNAME_DB_ENV=nombre-de-esuario-de-la-base-de-datos
   ```
2. Construir la imagen con el comando `docker build -t nombre-imagen:tag-imagen .` en caso de presentar problemas, intentar 
construir manualmente con gradle build y volver a ejecutar el comando.
3. Crear el contenedor con el siguiente comando para cargar las variables de entorno `docker run -p 8090:8090 --env-file env.properties nombre-imagen:tag-imagen` 
Cambiar el puerto de ser necesario.

## Despliegue 
Para desplegar en Elastic Container Service se deben realizar los siguientes pasos:

1. Realizar el paso anterior, tener la imagen creada y lista para subir a ECR o Docker Hub
2. Crear el cluster para que agrupe los recursos que utilizara el contenedor.
2. Definir las tareas para definir como se va a ejecutar el contenedor, de donde obtendra la imagen, etc.
3. Crear el servicio ECS para que realice las tareas especificadas

Para desplegar en Elastic beanstalk se deben realizar los siguientes pasos:
1. Tener la imagen docker publicada en ECR o Docker Hub.
2. Crear el archivo `Dockerrun.aws.json` de la siguiente manera:
    ```json
      {
        "AWSEBDockerrunVersion": "1",
        "Image": {
            "Name": "tu-repositorio/tu-imagen-docker",
            "Update": "true"
        },
        "Ports": [
           {
            "ContainerPort": 80
           }
        ]
      }
   ```
3. Configurar el entorno, podremos elegir con o sin base de datos, la tecnologica en la que se ejecuta la app, etc.
4. Subir el el archivo  `Dockerrun.aws.json` y la app.

## Adicional
Siempre es bueno seguir una estrategia y para este caso he seguido la estrategia de versionado GitFlow, haciendo uso de SemVer,
 si desean ver graficamente, pueden acceder al siguiente [link](https://github.com/camilo-gc/apiUserMonitoring-Prevalentware/network "GitFlow") 