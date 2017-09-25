# Bac à sable pour la mise en oeuvre de Spring / Spring Boot / Spring Cloud

### Big picture

![Big picture](./docs/images/DemoZuulHystrix-BigPicture.png)

### Démarrer les projets

Se placer dans chaque répertoire de chaque module et lancer la commande `mvn spring-boot:run`

Pour le module `spring-cloud-netflix-eureka`, ajouter à la ligne de commande le profil de lancement désiré : 
```
mvn spring-boot:run -Drun.profiles=peer{1|2}
```
