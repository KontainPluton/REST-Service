# Create docker image with DockerFile

- You need to build `java-restserver.war`. Go in java-restserver folder.

```
mvn clean
mvn install
```

Then go into `java-restserver/target/java-restserver/META-INF` folder.

If there is no `context.xml` in this folder, add it from the folder: `java-restserver/src/main/resources/META-INF/` (from the repository root folder). Then rebuild the project (`mvn install`).

---

- In `java-restserver/target` you will find a java-reserver.war.

- Move this file into docker folder.

```
    docker build -f .\Dockerfile . -t bookme
```
