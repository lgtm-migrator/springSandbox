[![CodeFactor](https://www.codefactor.io/repository/github/dvanderstoken/springsandbox/badge)](https://www.codefactor.io/repository/github/dvanderstoken/springsandbox)

[![Total alerts](https://img.shields.io/lgtm/alerts/g/DVanderstoken/springSandbox.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/DVanderstoken/springSandbox/alerts/)
[![Language grade: JavaScript](https://img.shields.io/lgtm/grade/javascript/g/DVanderstoken/springSandbox.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/DVanderstoken/springSandbox/context:javascript)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/DVanderstoken/springSandbox.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/DVanderstoken/springSandbox/context:java)

[![GitHub issues](https://img.shields.io/github/issues/DVanderstoken/springSandbox)](https://github.com/DVanderstoken/springSandbox/issues)

[![Dependabot Status](https://api.dependabot.com/badges/status?host=github&identifier=136540346)](https://dependabot.com)

# Spring / Spring Boot / Spring Cloud sandbox projects

### Big picture

![Big picture](./docs/images/DemoZuulHystrix-BigPicture.png)

### Run projects

From each maven sub-modules directory, launch with: `mvn spring-boot:run`

The `spring-cloud-netflix-eureka` sub-module uses one profile `peer1` or `peer2` : 
```
mvn spring-boot:run -Dspring-boot.run.profiles=peer{1|2}
```

Launch `ng-ms-client-frontend` app with :
```
yarn install
ng serve
```

To see Zuul fallback provider in action, stop the `spring-ms-countries` service and see what happens in your browser...
