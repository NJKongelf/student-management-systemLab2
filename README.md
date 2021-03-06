# Student-Management-System Complex Java lab 2
## **Project creation**

- This Java EE project for the Java 19 course from ITHS was developed by Nicklas Johansson and Luis Gutierrez. We both pair-coded and collaborated to create this laboratorium.

## **Projects obstacles**

- One issue we had during the process of building the rest Endpoints was get relationships between the enties to function properly and the CascadeType. 

# Endpoints

## [Teacher](#teacher-1)
## [Subject](#subject-1)

## Student
# GET
|Method|Description|URL|
|---|---|--|
|GET|Get all students from registry|http://localhost:8080/student-management-system/api/v1/student/getall|

|Response Body Exemple|
|---|
```ruby
  {
    "email": "luis@google.com",
    "firstname": "Luis",
    "id": 1,
    "lastname": "Gutierrez",
    "phonenumber": "555-2343"
  },
  {
    "email": "erick@google.com",
    "firstname": "Erick",
    "id": 2,
    "lastname": "Gutierrez",
    "phonenumber": "555-2673"
  },
  {
    "email": "nicklas@google.com",
    "firstname": "Nicklas",
    "id": 3,
    "lastname": "Johansson",
    "phonenumber": "555-7596"
  },
  {
    "email": "lennart@google.com",
    "firstname": "Lennart",
    "id": 4,
    "lastname": "Johansson",
    "phonenumber": "555-9867"
  },
  {
    "email": "rob@google.com",
    "firstname": "Rob",
    "id": 5,
    "lastname": "Sam",
    "phonenumber": "555-3639"
  },
  {
    "email": "daniel@google.com",
    "firstname": "Daniel",
    "id": 6,
    "lastname": "Van Rankin",
    "phonenumber": "555-1086"
  }
```
|Method|Description|URL|
|---|---|--|
|GET|Get student with given ID|http://localhost:8080/student-management-system/api/v1/student/searchById/{id}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/student/searchById/2|

```ruby
  {
  "email": "erick@google.com",
  "firstname": "Erick",
  "id": 2,
  "lastname": "Gutierrez",
  "phonenumber": "555-2673"
  }
 ```
 |Method|Description|URL|
|---|---|--|
|GET|Get student with given last name|http://localhost:8080/student-management-system/api/v1/student/searchByLastName/{lastname}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/student/searchByLastName/Gutierrez|
 
```ruby
  [
  {
    "email": "luis@google.com",
    "firstname": "Luis",
    "id": 1,
    "lastname": "Gutierrez",
    "phonenumber": "555-2343"
  },
  {
    "email": "erick@google.com",
    "firstname": "Erick",
    "id": 2,
    "lastname": "Gutierrez",
    "phonenumber": "555-2673"
  }
]
 ```

# POST
|Method|Description|URL|
|---|---|--|
|POST|Create a new student record in registry|http://localhost:8080/student-management-system/api/v1/student/new|

|Request Body Example|
|---|
```ruby
{
  "email": "example@iths.se",
  "firstname": "Ronald",
  "lastname": "McDonald",
  "phonenumber": "555-2249"
}

```
|Response Body Example|
|---|
```ruby
{
  "email": "example@iths.se",
  "firstname": "Ronald",
  "id": 7,
  "lastname": "McDonald",
  "phonenumber": "555-2249"
}

```

# PUT
|Method|Description|URL|
|---|---|--|
|PUT|Update an existing student record in registry|http://localhost:8080/student-management-system/api/v1/student/update|

|Request Body Example and Response Body Example|
|---|
```ruby
{
  "email": "rob@google.com",
  "firstname": "Robbie",
  "id": 5,
  "lastname": "Sam",
  "phonenumber": "555-3639"
}

```

# DELETE
|Method|Description|URL|
|---|---|--|
|DELETE|Remove an existing student with given ID from registry|http://localhost:8080/student-management-system/api/v1/student/deleteById/{id}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/student/deleteById/3|

```ruby
Student with ID 3 removed from registry
```

# Teacher
# GET
|Method|Description|URL|
|---|---|--|
|GET|Get all teachers from registry|http://localhost:8080/student-management-system/api/v1/teacher/getall|

|Response Body Exemple|
|---|
```ruby
  [
  {
    "email": "Microsoft@google.com",
    "firstname": "Bill",
    "id": 1,
    "lastname": "Gates",
    "phonenumber": "555-1234"
  },
  {
    "email": "martin@javamaster.se",
    "firstname": "Martin",
    "id": 2,
    "lastname": "Blomberg",
    "phonenumber": "555-7698"
  }
]
```
|Method|Description|URL|
|---|---|--|
|GET|Get teacher with given ID|http://localhost:8080/student-management-system/api/v1/teacher/searchById/{id}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/teacher/searchById/1|

```ruby
{
  "email": "Microsoft@google.com",
  "firstname": "Bill",
  "id": 1,
  "lastname": "Gates",
  "phonenumber": "555-1234"
}
 ```
 |Method|Description|URL|
|---|---|--|
|GET|Get teacher and subjects with given first name|http://localhost:8080/student-management-system/api/v1/teacher/getTeacherAndSubject/{firstname}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/teacher/getTeacherAndSubject/Bill|
 
```ruby
[
  "Java",
  "C"
]
 ```
 |Method|Description|URL|
|---|---|--|
|GET|Get students with given subject and teachers first name |http://localhost:8080/student-management-system/api/v1/teacher/getStudentBySubjectAndTeacher/{subject}/{teacher}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/teacher/getStudentBySubjectAndTeacher/C/Bill|
 
```ruby
[
  {
    "email": "erick@google.com",
    "firstname": "Erick",
    "id": 6,
    "lastname": "Gutierrez",
    "phonenumber": "555-2673"
  },
  {
    "email": "luis@google.com",
    "firstname": "Luis",
    "id": 3,
    "lastname": "Gutierrez",
    "phonenumber": "555-2343"
  }
]
 ```

# POST
|Method|Description|URL|
|---|---|--|
|POST|Create a new teacher record in registry|http://localhost:8080/student-management-system/api/v1/teacher/new|

|Request Body Example|
|---|
```ruby
{
  "email": "example@iths.se",
  "firstname": "Ronald",
  "lastname": "McDonald",
  "phonenumber": "555-2249"
}

```
|Response Body Example|
|---|
```ruby
{
  "email": "example@iths.se",
  "firstname": "Ronald",
  "id": 10,
  "lastname": "McDonald",
  "phonenumber": "555-2249"
}

```

# PUT
|Method|Description|URL|
|---|---|--|
|PUT|Update an existing teacher record in registry|http://localhost:8080/student-management-system/api/v1/teacher/update|

|Request Body Example and Response Body Example|
|---|
```ruby
{
  "email": "rob@google.com",
  "firstname": "Robbie",
  "id": 10,
  "lastname": "Sam",
  "phonenumber": "555-3639"
}

```

# DELETE
|Method|Description|URL|
|---|---|--|
|DELETE|Remove an existing teacher with given ID from registry|http://localhost:8080/student-management-system/api/v1/teacher/deleteById/{id}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/teacher/deleteById/10|

```ruby
Teacher with ID 10 removed from registry
```
# Subject
# GET
|Method|Description|URL|
|---|---|--|
|GET|Get all subjects with teacher and all students from registry|http://localhost:8080/student-management-system/api/v1/subject/getall|

|Response Body Exemple|
|---|
```ruby
 [
  {
    "id": 8,
    "name": "Azure",
    "students": [
      {
        "email": "rob@google.com",
        "firstname": "Rob",
        "id": 7,
        "lastname": "Sam",
        "phonenumber": "555-3639"
      },
      {
        "email": "daniel@google.com",
        "firstname": "Daniel",
        "id": 9,
        "lastname": "Van Rankin",
        "phonenumber": "555-1086"
      },
      {
        "email": "erick@google.com",
        "firstname": "Erick",
        "id": 12,
        "lastname": "Gutierrez",
        "phonenumber": "555-2673"
      },
      {
        "email": "lennart@google.com",
        "firstname": "Lennart",
        "id": 11,
        "lastname": "Johansson",
        "phonenumber": "555-9867"
      }
    ],
    "teacher": {
      "email": "Microsoft@google.com",
      "firstname": "Bill",
      "id": 1,
      "lastname": "Gates",
      "phonenumber": "555-1234"
    }
  },
  {
    "id": 6,
    "name": "Java",
    "students": [
      {
        "email": "rob@google.com",
        "firstname": "Rob",
        "id": 7,
        "lastname": "Sam",
        "phonenumber": "555-3639"
      },
      {
        "email": "luis@google.com",
        "firstname": "Luis",
        "id": 3,
        "lastname": "Gutierrez",
        "phonenumber": "555-2343"
      },
      {
        "email": "nicklas@google.com",
        "firstname": "Nicklas",
        "id": 5,
        "lastname": "Johansson",
        "phonenumber": "555-7596"
      }
    ],
    "teacher": {
      "email": "martin@javamaster.se",
      "firstname": "Martin",
      "id": 2,
      "lastname": "Blomberg",
      "phonenumber": "555-7698"
    }
  },
  {
    "id": 10,
    "name": "C-Sharp",
    "students": [
      {
        "email": "daniel@google.com",
        "firstname": "Daniel",
        "id": 9,
        "lastname": "Van Rankin",
        "phonenumber": "555-1086"
      },
      {
        "email": "erick@google.com",
        "firstname": "Erick",
        "id": 12,
        "lastname": "Gutierrez",
        "phonenumber": "555-2673"
      },
      {
        "email": "lennart@google.com",
        "firstname": "Lennart",
        "id": 11,
        "lastname": "Johansson",
        "phonenumber": "555-9867"
      }
    ],
    "teacher": {
      "email": "Microsoft@google.com",
      "firstname": "Bill",
      "id": 1,
      "lastname": "Gates",
      "phonenumber": "555-1234"
    }
  },
  {
    "id": 4,
    "name": "SpringBoot",
    "students": [
      {
        "email": "luis@google.com",
        "firstname": "Luis",
        "id": 3,
        "lastname": "Gutierrez",
        "phonenumber": "555-2343"
      },
      {
        "email": "nicklas@google.com",
        "firstname": "Nicklas",
        "id": 5,
        "lastname": "Johansson",
        "phonenumber": "555-7596"
      }
    ],
    "teacher": {
      "email": "martin@javamaster.se",
      "firstname": "Martin",
      "id": 2,
      "lastname": "Blomberg",
      "phonenumber": "555-7698"
    }
  }
]
```
|Method|Description|URL|
|---|---|--|
|GET|Get subject with given ID|http://localhost:8080/student-management-system/api/v1/subject/searchById/{id}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/subject/searchById/10|

```ruby
{
  "id": 10,
  "name": "C-Sharp",
  "students": [
    {
      "email": "erick@google.com",
      "firstname": "Erick",
      "id": 12,
      "lastname": "Gutierrez",
      "phonenumber": "555-2673"
    },
    {
      "email": "lennart@google.com",
      "firstname": "Lennart",
      "id": 11,
      "lastname": "Johansson",
      "phonenumber": "555-9867"
    },
    {
      "email": "daniel@google.com",
      "firstname": "Daniel",
      "id": 9,
      "lastname": "Van Rankin",
      "phonenumber": "555-1086"
    }
  ],
  "teacher": {
    "email": "Microsoft@google.com",
    "firstname": "Bill",
    "id": 1,
    "lastname": "Gates",
    "phonenumber": "555-1234"
  }
}
 ```
 |Method|Description|URL|
|---|---|--|
|GET|Get students with given subject name|http://localhost:8080/student-management-system/api/v1/subject/getStudentsBySubjectName/{name}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/subject/getStudentsBySubjectName/Java|
 
```ruby
[
  {
    "email": "nicklas@google.com",
    "firstname": "Nicklas",
    "id": 5,
    "lastname": "Johansson",
    "phonenumber": "555-7596"
  },
  {
    "email": "luis@google.com",
    "firstname": "Luis",
    "id": 3,
    "lastname": "Gutierrez",
    "phonenumber": "555-2343"
  },
  {
    "email": "rob@google.com",
    "firstname": "Rob",
    "id": 7,
    "lastname": "Sam",
    "phonenumber": "555-3639"
  }
]
 ```

# POST
|Method|Description|URL|
|---|---|--|
|POST|Create a new subject record in registry|http://localhost:8080/student-management-system/api/v1/subject/new|

|Request Body Example|
|---|
```ruby
{
  "name": "#F"
}

```
|Response Body Example|
|---|
```ruby
{
  "id": 13,
  "name": "#F",
  "students": []
}

```

# PUT
|Method|Description|URL|
|---|---|--|
|PUT|Update an existing subject record in registry|http://localhost:8080/student-management-system/api/v1/subject/update|

|Request Body Example and Response Body Example|
|---|
```ruby
{
  "id": 13,
  "name": "#F",
	"students":[
		      {
        "email": "erick@google.com",
        "firstname": "Erick",
        "id": 6,
        "lastname": "Gutierrez",
        "phonenumber": "555-2673"
      }
	],
  "teacher": {
    "email": "Microsoft@google.com",
    "firstname": "Bill",
    "id": 1,
    "lastname": "Gates",
    "phonenumber": "555-1234"
  }
}

```

# DELETE
|Method|Description|URL|
|---|---|--|
|DELETE|Remove an existing teacher with given ID from registry|http://localhost:8080/student-management-system/api/v1/subject/deleteById/{id}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/subject/deleteById/13|

```ruby
Subject with ID 13 removed from registry
```
