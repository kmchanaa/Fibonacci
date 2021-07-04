# Fibonacci

How to start the Fibonacci application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/fibonacci-0.0.1-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080/fibonacci`
1. You can see the fibonacci sequence and sorted sequence by sending a http get request with "elements" as key and value between 1 to 100 e.g.
`http://localhost:8080/fibonacci?elements=10`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

#Dockerfile

How to build the app's container image
---

In the project directory, run the command:

```
docker build -t fibonacci .
```

This command used the Dockerfile to build a new container image of this application.

How to start an app container

Start the container using the below command:

```
docker run -p 8080:8080 fibonacci
```

Now, open your web browser to `http://localhost:8080/fibonacci`. You should see the application is running.