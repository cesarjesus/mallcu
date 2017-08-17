# Mallcu

Simple exercise to show REST services with Java.

How to start the Mallcu application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/mallcu-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

API Implemented
---
### Student
* GET `/api/v1/students` -> get a list of all students.
* GET `/api/v1/students/:id` -> get a student with specified id.
* GET `/api/v1/students/:id/class` -> get all classes for the student.
* POST `/api/v1/students` -> create a new student
```json
{
	"id": 1,
	"firstName": "Jhon",
	"lastName": "Snow"
}
```
* POST `/api/v1/students/:id/class/:code` -> add a student into the class.
* DELETE `/api/v1/students/:id` -> remove a student.
* DELETE `/api/v1/students/:id/class/:code` -> remove a student from a class.
* PUT `/api/v1/students/:id` -> update a student.

### Class
* GET `/api/v1/class` -> get a list of all class.
* GET `/api/v1/class/:code` -> get a class with specified code.
* GET `/api/v1/class/:id/students` -> get all students for the class.
* POST `/api/v1/class` -> create a new class
```json
{
	"code": "JKD-54",
	"title" : "Introduction",
	"description" : "This is an introduction to something"
}
```
* POST `/api/v1/class/:code/students/:id` -> add a student into the class.
* DELETE `/api/v1/class/:code` -> remove a class.
* DELETE `/api/v1/class/:code/students/:id` -> remove a student from a class.
* PUT `/api/v1/class/:code` -> update a class.

Development notes
---

1. Framework used for implementation, Dropwizard 1.1.1 and all infrastructure.
1. Framework used for unit testing, JUnit 4.x
1. I was trying to make each feature in one branch and then send a pull request to merge into devel,
   but as I am the only one that is coding, I decided instead just a atomic commits into develop branch.
1. Class as name of the class can be confused, probably it should have different name.
1. The id field should be generated on Student class.
1. Most of the HTTP responses are handled.
1. A singleton probably is not the best way to start services, it should be
   initialized by the context, or injected by requirement.
1. I don't like much pass all object when updating with PUT.
1. The reference to other objects probably should be links and not just ids or codes.
1. If the students has a list of class in POST or PUT it will result on 400 error
   there is no deserializer implemented yet. Same for class and list of students.
1. I tried to add unit tests and integration tests using dropwizard-testing framework,
   but don't want to spend much time in research.
1. It was funny to learn Dropwizard for REST API development, according documentation
   Dropwizard has many other features that are not being used in this exercise.