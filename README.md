# ht1
# README.md 

# Licuadora App

## Descripción
Licuadora App es una aplicación de una licuadora virtual que permita al usuario interactuar con la interfaz de una licuadora. Los usuarios puede hacer un numero de cosas como prender y apagar la licuadora, llenarla de contenidos, ajustar la velocidad y revisar el estatus de la misma. 

## Estructura del Proyecto
```
licuadora-app
├── src
│   ├── main
│   │   └── java
│   │       ├── com
│   │       │   └── licuadora
│   │       │       ├── Main.java
│   │       │       ├── Licuadora.java
│   │       │       └── LicuadoraImpl.java
│   └── test
│       └── java
│           └── com
│               └── licuadora
│                   └── LicuadoraImplTest.java
├── pom.xml
└── README.md
```

## Requerimientos
- Java 8 o mas alto
- Maven

## Como Copiar el Proyecto
1. Clonar el repositorio:
   ```
   git clone <repository-url>
   ```
2. Navegar el directorio del proyecto:
   ```
   cd licuadora-app
   ```
3. Contruir el proyecto usando Maven
   ```
   mvn clean install
   ```

## Como Correr el Código
Para poder ejecutar el código, ingresar la siguiente línea:
   ```
   mvn exec:java -Dexec.mainClass="com.licuadora.Main"
   ```
## Tests
Para corer las pruebas uniteras, ingresar la siguiente línea:
```
mvn test
```
