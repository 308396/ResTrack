# ResTrack – Research Management System

## 1. Project Overview

ResTrack is a Research Management System developed using Java and Spring Boot. It provides REST API endpoints to retrieve and manage research project information stored in a PostgreSQL database.

The system manages research project details, including research titles, grant types, researchers, research status, start dates, expected completion dates, and end dates.

## 2. Project Objectives

1. To develop a REST API for managing research project information.
2. To connect the application to a PostgreSQL database for storing and retrieving research data.
3. To containerize the application using Docker and publish the Docker image on Docker Hub.

## 3. Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Docker
- Docker Hub
- Postman
- Git and GitHub
- IntelliJ IDEA

## 4. Project Structure

```text
ResTrack/
├── src/
│   ├── main/
│   │   ├── java/com/group7/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   ├── ResearchData.java
│   │   │   └── ResTrackApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── sql/
│   ├── research_create.sql
│   └── research_data.sql
├── Dockerfile
├── pom.xml
├── .gitignore
└── README.md
```

## 5. Database

ResTrack uses PostgreSQL as its relational database management system.

The `sql` directory contains the following scripts:

- `research_create.sql` – creates the database tables.
- `research_data.sql` – inserts sample data and includes example SELECT, UPDATE, and DELETE operations.

For a fresh database, execute the table-creation script before the sample-data script. Ensure that the scripts are run against the intended database.

The application database connection is configured in `src/main/resources/application.properties`. The database URL can be overridden using the `DB_URL` environment variable.

Database credentials should be kept private.

## 6. Running the Application Locally

### Prerequisites

- Java Development Kit (JDK)
- Maven
- PostgreSQL
- IntelliJ IDEA or another Java IDE

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/308396/ResTrack.git
   cd ResTrack
   ```

2. Configure the PostgreSQL database and connection settings.

3. Build the application using Maven:

   ```bash
   mvn clean package -Dmaven.test.skip=true
   ```

4. Run the generated JAR file:

   ```bash
   java -jar target/*.jar
   ```

5. Test the REST API using Postman.

The default application port is `8080`.

## 7. REST API Testing with Postman

The application provides REST API endpoints for research projects and related entities.

### Retrieve Research Projects

- **HTTP Method:** GET
- **Endpoint:** `http://localhost:8080/api/research-projects`

A successful request returns JSON data containing research project records.

### Postman Screenshots

Add actual screenshots of successful API requests and responses below.

**GET Research Projects**

Insert GET request screenshot here.

**POST Research Project**

Insert POST request screenshot here.

**UPDATE Research Project**

Insert UPDATE request screenshot here.

**DELETE Research Project**

Insert DELETE request screenshot here.

## 8. Docker Containerization

The application is packaged into a Docker image using the `Dockerfile` in the project root.

### Build the Docker Image

```bash
docker build -t restrack:1.0 .
```

### Run the Docker Container

The following command maps host port `8081` to port `8080` inside the container.

```bash
docker run -d \
  --name restrack-container \
  -p 8081:8080 \
  -e DB_URL=jdbc:postgresql://host.docker.internal:5432/postgres \
  restrack:1.0
```

This configuration assumes PostgreSQL is running on the host machine and is accessible to Docker.

### Verify the Container

```bash
docker ps
```

View application logs:

```bash
docker logs restrack-container
```

Test the API using:

`http://localhost:8081/api/research-projects`

A compatible PostgreSQL database must be accessible for the API to retrieve database records.

## 9. Docker Hub

The ResTrack Docker image has been published to Docker Hub.

- **Docker Hub repository:** https://hub.docker.com/r/afifwahdi/restrack
- **Image tag:** `1.0`

Pull the image using:

```bash
docker pull afifwahdi/restrack:1.0
```

## 10. GitHub Repository

The project source code, Dockerfile, and SQL scripts are available at:

https://github.com/308396/ResTrack

## 11. Video Presentation

**YouTube presentation link:** Insert your YouTube video link here.

The presentation must be in English, contain no background music, and be no longer than 15 minutes.

Suggested presentation contents:

1. Introduction and project objectives.
2. Database structure and SQL scripts.
3. Explanation of the application architecture.
4. Demonstration of REST API operations using Postman.
5. Docker image creation and container execution.
6. Docker Hub and GitHub repositories.

## 12. References

Docker, Inc. (n.d.). *Docker documentation*. https://docs.docker.com/

Docker, Inc. (n.d.). *Dockerfile reference*. https://docs.docker.com/reference/dockerfile/

GitHub. (n.d.). *GitHub documentation*. https://docs.github.com/

Hibernate. (n.d.). *Hibernate ORM documentation*. https://hibernate.org/orm/documentation/

Oracle. (n.d.). *Java documentation*. https://docs.oracle.com/en/java/

Postman. (n.d.). *Postman documentation*. https://learning.postman.com/docs/

PostgreSQL Global Development Group. (n.d.). *PostgreSQL documentation*. https://www.postgresql.org/docs/

The Apache Software Foundation. (n.d.). *Maven documentation*. https://maven.apache.org/guides/

Eclipse Foundation. (n.d.). *Jakarta Persistence*. https://jakarta.ee/specifications/persistence/

The Spring Team. (n.d.). *Spring Boot reference documentation*. https://docs.spring.io/spring-boot/

The Spring Team. (n.d.). *Building a RESTful web service*. https://spring.io/guides/gs/rest-service/

Fielding, R., Nottingham, M., & Reschke, J. (2022). *HTTP semantics* (RFC 9110). RFC Editor. https://www.rfc-editor.org/rfc/rfc9110
