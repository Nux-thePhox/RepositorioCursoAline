#Crear una imagen de la aplicacion Spring.

#1ra fase Define la imagen base que se usara
#maven:eclipse-temurin:17 es la imagen oficial de docker
#nos permite referenciar esta fase(fase de definision de img base) como builder,
#para mas tarde copiar archivos de ella
FROM maven:3.8-eclipse-temurin-17 AS builder
#Establece el directorio actual de trabajo dentro del contenedor.
#Todos los comandos siguientes (ej: COPY y RUN) se ejecutarán relativos a /app en este caso
WORKDIR /app
#Copia los archivos del host (la computadora donde se ejecutara el docker build) al sistema de archivos
#del contenedor.
#. . indica "copia todo lo que esta en el directorio actual del host (primer .) al directorio
# de trabajo actual del contenedor, que es /app (el segundo .)
COPY . .
#Ejecuta un comando en una nueva capa sobre la imagen actual
#mvn clean package, es el comando estandar de maven para compilar el codigo, pasa las pruebas,
#y empaqueta el resultado (un archivo jar o war) en la carpeta target/ del proyecto
#-DskipTests una bandera que le dice a maven que omita la ejecución de las pruebas unitarias
#dentro del package.
RUN mvn clean package -DskipTests

#Segunda fase, crea el la imagen final que se usará para ejecutar la aplicación.
#Define la imagen base para la fase final
#openjdk:17-slim es la imagen oficial de java openjdk 17 muy ligera, contiene solo lo necesario.
FROM eclipse-temurin:17-jre
#Establece el directorio de trabajo en /app para esta nueva imagen final
WORKDIR /app
#copia los archivos desde la fase anterior, la que lamamos builder.
#/app/target/Celular-0.0.1-SNAPSHOT.jar es la ruta del archivo jar compilado que se creo en la fase 1
#app.jar es el nombre que le damos al archivo en el directorio /app de la imagen final
COPY --from=builder /app/target/Celular-0.0.1-SNAPSHOT.jar app.jar
#Es para el puerto en el que estara corriendo nuestra app.
#Informa a docker que el contenedor escuchará en el puerto 8001 en tiempo de ejecución.
EXPOSE 8001
#ENTRYPOINT Define el comando que se ejecutará cuando el contenedor inicie.
#Es el punto de entrada de la aplicación.
#["java", "-jar", "app.jar"] inicia la maquina virtual de java y ejecuta el archivo app.jar
#que acabamos de copiar.
ENTRYPOINT ["java", "-jar", "app.jar"]