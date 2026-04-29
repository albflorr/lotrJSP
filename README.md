# LOTR App - Lord of the Rings Character Creator

Una aplicación web Java para crear y gestionar personajes de El Señor de los Anillos, construida con arquitectura en capas y patrones de diseño.

## Características

- Creación de personajes con diferentes razas (Hobbit, Elfo)
- Aplicación automática de bonos por raza usando patrones de diseño
- Persistencia en base de datos MySQL
- Interfaz web con JSP, JSTL y CSS temático
- Configuración mediante archivos `.env`

## Tecnologías Utilizadas

- **Java 8**
- **Maven** - Gestión de dependencias
- **Java EE 7** (Servlet API)
- **JSP / JSTL 1.2** - Vista
- **MySQL Connector 8.0.33** - Base de datos
- **Dotenv Java 3.0.0** - Manejo de variables de entorno
- **Apache Tomcat 8.5** - Servidor de aplicaciones
- **NetBeans** - IDE

## Arquitectura

El proyecto sigue una arquitectura en capas con principios **SOLID**:

```
src/main/java/com/mycompany/lotrapp/
├── dominio/                    # Capa de dominio (Entidades y lógica de negocio)
│   ├── Personaje.java         # Entidad principal
│   ├── Atributos.java         # Atributos del personaje (fuerza, agilidad, sigilo, valor)
│   ├── RazaStrategy.java      # Interfaz Strategy
│   ├── HobbitStrategy.java    # Estrategia para Hobbits
│   └── ElfoStrategy.java      # Estrategia para Elfos
├── aplicacion/                # Capa de aplicación (Casos de uso)
│   ├── PersonajeService.java  # Servicio de aplicación
│   └── IPersonajeRepository.java # Puerto de salida (interfaz)
└── infraestructura/           # Capa de infraestructura
    ├── ui/
    │   └── PersonajeServlet.java # Controlador Servlet
    └── persistence/
        ├── DatabaseConnection.java    # Conexión a MySQL
        ├── MySQLPersonajeRepository.java # Adaptador de persistencia
        └── CharacterFactory.java     # Factory para estrategias
```

## Patrones de Diseño Implementados

1. **Strategy Pattern**: `RazaStrategy` permite aplicar diferentes bonos según la raza
2. **Factory Pattern**: `CharacterFactory` centraliza la creación de estrategias
3. **Repository Pattern**: `IPersonajeRepository` abstrae la persistencia (DIP)
4. **Dependency Injection**: `PersonajeService` recibe su dependencia por constructor

## Configuración

### 1. Base de Datos MySQL

Crear la base de datos y tabla:

```sql
CREATE DATABASE IF NOT EXISTS lotr_db;
USE lotr_db;

CREATE TABLE IF NOT EXISTS personajes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    raza VARCHAR(50) NOT NULL,
    habilidad_especial VARCHAR(100),
    fuerza INT,
    agilidad INT,
    sigilo INT,
    valor INT
);
```

### 2. Configurar variables de entorno

Crear archivo `.env` en la raíz del proyecto:

```env
DB_URL=jdbc:mysql://localhost:3306/lotr_db?useSSL=false&serverTimezone=UTC
DB_USER=root
DB_PASS=tu_password_mysql
```

**⚠️ IMPORTANTE**: No subas el archivo `.env` a GitHub. Ya está incluido en `.gitignore`.

## Cómo Ejecutar

### Requisitos previos
- JDK 8 o superior
- Maven 3.x
- MySQL Server en ejecución
- Apache Tomcat 8.5

### Pasos

1. Clonar el repositorio:
```bash
git clone https://github.com/tuusuario/lotrapp.git
cd lotrapp
```

2. Crear el archivo `.env` con tus credenciales de MySQL

3. Compilar el proyecto:
```bash
mvn clean package
```

4. Desplegar en Tomcat:
   - Copiar `target/lotrapp.war` a la carpeta `webapps` de Tomcat
   - O desplegar directamente desde NetBeans

5. Acceder a la aplicación:
```
http://localhost:8080/lotrapp/
```

## Uso

1. Ingresa el nombre del personaje (mínimo 3 caracteres)
2. Selecciona la raza (Hobbit o Elfo)
3. Haz clic en "Generar Personaje"
4. El personaje se guardará en la base de datos con sus bonos aplicados
5. La lista se actualizará automáticamente

### Bonos por Raza

- **Hobbit**: +15 Sigilo, +10 Valor (Habilidad: Resistencia a la Sombra)
- **Elfo**: +25 Sigilo, +15 Agilidad (Habilidad: Agilidad aumentada)

## Estructura del Proyecto

```
lotrapp/
├── src/
│   ├── main/
│   │   ├── java/com/mycompany/lotrapp/
│   │   │   ├── dominio/
│   │   │   ├── aplicacion/
│   │   │   └── infraestructura/
│   │   ├── resources/
│   │   │   └── .env (debe crearse localmente)
│   │   └── webapp/
│   │       ├── css/style.css
│   │       ├── js/script.js
│   │       ├── WEB-INF/web.xml
│   │       └── index.jsp
│   └── test/
├── pom.xml
├── .env (no se sube a Git)
└── README.md
```

## Licencia

Este proyecto es de uso educativo.

## Autor

Desarrollado como práctica de arquitectura de software y patrones de diseño en Java EE.
