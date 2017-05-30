# Mallcu

Simple exercise to show REST services with Java.

How to start the Mallcu application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/mallcu-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

Development notes
---

1. I was trying to make each feature in one branch and then send a pull request to merge into devel,
   but as I am the only one that is coding, I decided instead just a atomic commits into develop branch.
1. Class as name of the class can be confused, probably it should have different name.
