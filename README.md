# Explorando Padrões de Projetos na Prática com Java

## Digital Innovation One: Labs
Projeto desenvolvido no curso de Spring Boot da plataforma [Digital Innovation One](https://www.dio.me/), explorando, além do framework, também os padrões de projeto **Singleton**, **Strategy** e **Facade** em Java puro que podem ser conferidos no repositório [digitalinnovationone/lab-padroes-projeto-java](https://github.com/digitalinnovationone/lab-padroes-projeto-java).

<hr>


Padrões de projeto explorados:
* *Singleton*: Padrão Criacional que permite a criação de uma única instância de uma classe e fornecer um modo para recuperá-la;
* *Strategy*: Padrão Comportamental com objetivo de simplificar a variação de algoritmos para a resolução de um mesmo problema;
* *Facade*: Padrão Estrutural que visa prover uma interface que reduza a complexidade nas integrações com subsistemas.

A relação entre Padrões de Projetos com Java e o Spring framework pode-se ser percebida em:
* Annotations *@Bean* e *@Autowired* como padrão criacional **Singleton**;
* Annotations *@Service* e *@Repository* como padrão comportamental **Strategy**;
* Annotation *@RestController* como padrão estrutural **Facade**.

<hr>

### Request Body

```JSON
{
    "firstName": "String",
    "lastName": "String",
    "cpf": "String",
    "birthDate": "AAA-MM-DD",
    "address": {
        "cep": "String"
    }
}
```