```
    _____  __    __          _______
   /     |/  |  /  |        /       \
   $$$$$ |$$ |  $$ |        $$$$$$$  |  ______    _______  __    __  _____  ____    ______
      $$ |$$  \/$$/  ______ $$ |__$$ | /      \  /       |/  |  /  |/     \/    \  /      \
 __   $$ | $$  $$<  /      |$$    $$< /$$$$$$  |/$$$$$$$/ $$ |  $$ |$$$$$$ $$$$  |/$$$$$$  |
/  |  $$ |  $$$$  \ $$$$$$/ $$$$$$$  |$$    $$ |$$      \ $$ |  $$ |$$ | $$ | $$ |$$    $$ |
$$ \__$$ | $$ /$$  |        $$ |  $$ |$$$$$$$$/  $$$$$$  |$$ \__$$ |$$ | $$ | $$ |$$$$$$$$/
$$    $$/ $$ |  $$ |        $$ |  $$ |$$       |/     $$/ $$    $$/ $$ | $$ | $$ |$$       |
 $$$$$$/  $$/   $$/         $$/   $$/  $$$$$$$/ $$$$$$$/   $$$$$$/  $$/  $$/  $$/  $$$$$$$/


```

# James Xie Resume Microservice

This microservice is responsible for fetching Resume data from backend database.

### Building the project

Use ```mvn clean install``` to build the project, which will create a jar ready to deploy.

### Running the project

- ```mvn spring-boot:run -Drun.profiles=dev,local```
- ```java -jar -Dspring.profiles.active=dev target/[artifact_name].jar```
- ```target/[artifact_name].jar --spring.profiles.active=dev```

The application can be accessed locally at;
```
http://localhost:8300
```

### Documentation

- We are using Swagger to automatically generate documentation on our APIs. You can find them here;
```
http://localhost:8300/index.html
```

### Spring profiles

- You can run various profiles with the following commands
```
target/[artifact_name].jar --spring.profiles.active=test,dev
OR
mvn spring-boot:run -Dspring.profiles.active=test,dev
OR
mvn spring-boot:run -Dspring.config.location=file:xxx/yyy/zzz/application-custom.properties
```
