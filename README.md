# Gerador de Certificados

## Documentação

Este foi um projeto desenvolvido em parceria a Rocketseat, onde foi desenvolvido em Spring Boot 3.2.2 e Java 17. O objetivo final do projeto era gerar certificados com base
no número de acertos de um estudante, mas para chegar nesse resultado ele passaria por algumas etapas. Para começar, o estudante irá informar para qual tecnologia ele ia
fazer a prova e com base na que ele passou nosso sistema ia verificar se ele já tirou o certificado antes ou não, essa verificação ia ser através do email, caso o email dele
existisse em nosso bd ele não ia poder fazer a prova. No caso em que ele consiga fazer a prova o estudante ia receber perguntas relacionadas a tecnologia escolhida e com base
nas respostas que ele escolhesse nosso sistema ia retornar a nota que ele tirou e as perguntas junto com as respostas que ele escolheu e embaixo informando se ele errou ou 
não. Além de tudo isso foi feito um ranking para que pudessemos ver os melhores colocados com base na quantidade de acertos dele.

## How To
Banco de dados utilizado será dentro de uma imagem do docker

- Necessário ter docker instalado na máquina
- Rodar os comandos abaixo
Obs: caso os comandes não rodem dentro da sua IDE, tente reiniciar o computador

**Comando para subir a imagem do docker**
```
docker-compose up -d
```

**Comando para verificar se a imagem subiu, listando ela**
```
docker ps
```

## Endpoints

`POST` /nlw/students/verifyIfHasCertification
**Request body**
```
{
  "email": "string",
  "technology": "string"
}
```
**Responses**
| Code | Message |
|------|---------|
| 200 | Ok |

`POST` /nlw/certification/answer
**Request Body**
```
{
	"email": "lucas12@gmail.com",
	"technology": "JAVA",
	"questionAnswers": [
			{
				"questionId": "c5f02721-6dc3-4fa6-b46d-6f2e8dca9c66",
				"alternativeId": "bafdf631-6edf-482a-bda9-7dce1efb1890"
			},
			{
				"questionId": "b0ec9e6b-721c-43c7-9432-4d0b6eb15b01",
				"alternativeId": "f8e6e9b3-199b-4f0d-97ce-7e5bdc080da9"
			},
			{
				"questionId": "f85e9434-1711-4e02-9f9e-7831aa5c743a",
				"alternativeId": "d3e51a56-9b97-4bb8-9827-8bcf89f4b276"
			}
	]
}
```
**Response**
| Code | Message |
|------|---------|
| 200 | Ok |
| 400 | Bad request |

`GET` /nlw/ranking/top10
**Response**
```
[
	{
		"id": "321254ad-5faa-4502-b189-3a1dd9513221",
		"technology": "JAVA",
		"grade": 3,
		"studentID": "6974c8c8-4c13-442d-94c9-f35a3a67f6ff",
		"studentEntity": {
			"id": "6974c8c8-4c13-442d-94c9-f35a3a67f6ff",
			"email": "lucas@lucas.com",
			"createdAt": "2024-02-08T14:01:46.244144"
		},
		"answersCertifications": [],
		"createdAt": "2024-02-08T15:30:21.244029"
	},
	{
		"id": "b711e8bc-ef95-4755-b1d0-3ebd19966b6c",
		"technology": "JAVA",
		"grade": 3,
		"studentID": "6974c8c8-4c13-442d-94c9-f35a3a67f6ff",
		"studentEntity": {
			"id": "6974c8c8-4c13-442d-94c9-f35a3a67f6ff",
			"email": "lucas@lucas.com",
			"createdAt": "2024-02-08T14:01:46.244144"
		},
		"answersCertifications": [],
		"createdAt": "2024-02-08T15:31:01.247026"
	}
]
```
| Code | Message |
|------|---------|
| 200 | Ok |
| 404 | Not found |

`GET` /nlw/question/{technology} -> JAVA
**Response**
```
{
		"id": "c5f02721-6dc3-4fa6-b46d-6f2e8dca9c66",
		"technology": "JAVA",
		"description": "Como criar uma classe em Java?",
		"alternatives": [
			{
				"id": "bafdf631-6edf-482a-bda9-7dce1efb1890",
				"description": "Usando a palavra-chave \"class\""
			},
			{
				"id": "98f6891b-5f14-4b8e-bb87-46456a2610d4",
				"description": "Definindo uma interface em Java"
			},
			{
				"id": "993a7d37-62a0-4040-810d-d667e3f7a891",
				"description": "Utilizando mÃ©todos estÃ¡ticos"
			},
			{
				"id": "98bf8d0f-dc1c-4db0-b09c-94246089aa02",
				"description": "Criando um construtor padrÃ£o"
			}
		]
}
```
| Code | Message |
|------|---------|
| 200 | Ok |
| 404 | Not found |
