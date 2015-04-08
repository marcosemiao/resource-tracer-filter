# Resource Tracer Filter

## Fonctionnalités générales
Cet outil est un filtre Web permettant de tracer sur la sortie standard toutes les ressources utilisées.
- Compatible à partir de la version Java 5.
- Facile d'utilisation, il suffit de rajouter la dépendance dans votre application.
- A partir de Servlet 3, il n'est plus nécessaire de rajouter le filtre dans le descripteur de déploiement (web.xml)
- Disponible sur le repository central de Maven.

## Utilisation rapide

Il y a 2 étapes au maximum à effectuer pour l'utiliser :
- Ajouter la dépendance dans votre webapp:

````xml
<dependency>
	<groupId>com.github.marcosemiao</groupId>
	<artifactId>resource-tracer-filter</artifactId>
	<version>1.0.0</version>
</dependency>
````

- Si votre descripteur de déploiement (web.xml) n'utilise pas les [metadata de Servlet 3](https://blogs.oracle.com/swchan/entry/servlet_3_0_web_fragment), ajoutez le filtre web dans votre descripteur de déploiement (web.xml) :

````xml
	<filter>
		<filter-name>resourceTracer</filter-name>
		<filter-class>fr.ms.resource.tracer.TracerFilter</filter-class>
	</filter>

	<filter-mapping>
		<filter-name>resourceTracer</filter-name>
		<url-pattern>*</url-pattern>
		<dispatcher>INCLUDE</dispatcher>
		<dispatcher>FORWARD</dispatcher>
		<dispatcher>REQUEST</dispatcher>
		<dispatcher>ERROR</dispatcher>
	</filter-mapping>
````