# Usar una imagen base de Tomcat
FROM tomcat:10.1-jdk21

# Establecer el directorio de trabajo
WORKDIR /usr/local/tomcat

# Copiar el archivo WAR generado por tu proyecto al directorio de despliegue de Tomcat
COPY target/oclaritybizV1.war webapps/oclaritybiz.war

# Exponer el puerto que utiliza Tomcat
EXPOSE 8080

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]