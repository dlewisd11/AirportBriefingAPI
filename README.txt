Daniel Lewis
Airport Briefing API


Build and run the application using the following command from within the project directory (JDK 17 required):

    ./mvnw spring-boot:run

Alternatively, run the pre-packaged application in java jar file form using the following command from within the
target folder within the project directory (Java 17 required):

    java -jar airportbriefing-0.0.1-SNAPSHOT.jar

Once the application is running, send requests as follows to obtain airport briefings. The "identifiers" parameter
is used to specify one or more comma-separated airport identifiers:

    http://localhost:8080/AirportBriefing?identifiers=KAUS

To obtain airport briefings for multiple airport identifiers:

    http://localhost:8080/AirportBriefing?identifiers=KAUS,KIAH
