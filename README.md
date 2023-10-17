## To-Do List

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Render](https://img.shields.io/badge/Render-%46E3B7.svg?style=for-the-badge&logo=render&logoColor=white)

Projeto realizado no evento de Java da [Rocketseat](https://www.rocketseat.com.br/).

### Tecnologias utilizadas

* [Java](https://www.java.com/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Render](https://render.com)

### Descrição

Projeto de uma API para listar tarefas a serem realizadas. Nesse projeto podemos cadastrar um novo usuário na aplicação para ele poder cadastrar suas próprias tarefas. A senha é criptografada usando a biblioteca BCrypt. Para cadastrar uma nova tarefa, é necessário, além do corpo da requisição, enviar o username e a senha do usuário por meio de um Basic Auth. Dessa forma, quando o usuário quiser realizar alguma modificação, ele poderá faze-la em sua própria tarefa. O arquivo Dockerfile é utilizado para fazer o deploy no Render.

## Exemplos

### [POST] /api/users

Para cadastrar um novo usuário, use a seguinte URL:

```code
http://localhost:8080/api/users
```
No corpo da requisição, envie os seguintes dados:

```json
{
    "name": "John Doe",
    "username": "johndoe",
    "password": "12345",
}
```

### [POST] /api/tasks

Para cadastrar uma nova tarefa, use a seguinte URL:

```code
http://localhost:8080/api/tasks
```

No Basic Auth, insira um username e senha já cadastrados

|                     |     username      |               password             | 
|:-------------------:|:-------------:|:--------------------------------------:|
|    Basic Auth    |    johndoe    |        12345         |

No corpo da requisição, envie os seguintes dados:

```json
{
    "title": "Bake a chocolate cake",
    "description": "Bake a delicious chocolate cake",
    "startAt": "2023-10-17T12:30:00",
    "endAt": "2023-10-17T13:30:00",
    "priority": "MEDIUM",
}
```

### [GET] /api/tasks

Para buscar tarefas de um usuário, use a seguinte URL:

```code
http://localhost:8080/api/tasks
```

No Basic Auth, insira um username e senha já cadastrados

|                     |     username      |               password             | 
|:-------------------:|:-------------:|:--------------------------------------:|
|    Basic Auth    |    johndoe    |        12345         |

### [PUT] /api/tasks

Para alterar uma tarefa, use a seguinte URL:

```code
http://localhost:8080/api/tasks/{task_id}
```

No Basic Auth, insira um username e senha do usuário dono da tarefa

|                     |     username      |               password             | 
|:-------------------:|:-------------:|:--------------------------------------:|
|    Basic Auth    |    johndoe    |        12345         |

No corpo da requisição, envie os dados que precisam ser alterados:

```json
{
    "title": "Bake a carrot cake",
    "description": "Bake a delicious carrot cake",
    "priority": "HIGH",
}
```
