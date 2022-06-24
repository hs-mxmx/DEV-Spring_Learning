#### Get Departments
GET - http://localhost:8082/departments/{id}
GET - http://localhost:8082/departments

#### Add Department
PUT - http://localhost:8081/departments
```json
    {
    "departmentName": "Development",
    "departmentAddress": "Spain",
    "departmentCode": "Dev"
    }
```
#### Modify Department
PUT - http://localhost:8081/departments/{id}
```json
    {
    "departmentName":"DevSecOps",
    "departmentAddress":"Spain",
    "departmentCode":"DSO"
    }
```
#### Delete Department
DELETE - http://localhost:8081/departments/{id}
