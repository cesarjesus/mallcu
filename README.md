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
1. The id field should be generated on Student class.
1. There are a lot of missing controls to response correctly the right HTTP response codes.
1. A singleton probably is not the best way to start services, it should be
   initialized by the context, or injected by requirement.
1. I don't like much pass all object when updating with PUT.
1. The reference to other objects probably should be links and not just ids or codes.
1. Missing control of unique class code and unique student id.
1. If the students has a list of class in POST or PUT it will result on 400 error
   there is no deserializer implemented yet. Same for class and list of students.