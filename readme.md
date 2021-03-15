# Projeto

### Objetivo

Este projeto foi criado com o objetivo de realizar testes de CRUD em apis publicas, para estudo / apresentação das ferramentas e tecnicas, utilizando o
framework [RestAssured](https://rest-assured.io/) em [Java](https://github.com/rest-assured/rest-assured/wiki/Usage), utilizando maven como gerenciador de dependências.

### Autor / Autoria

* Este projeto foi criado por Guilherme Fernandes Ribeiro, com o objetivo de estudar / apresentar o RestAssured, neste
  sentido autorizo qualquer pessoa copiar parte ou por inteiro o projeto, me citando ou não.
* Aceito e gostaria muito de contruições no projeto, caso queiram fazer so me procurar.

### Dependências

* rest-assured = para utilizara o framework do RestAssured
```
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>4.3.3</version>
</dependency>
```

* json-schema-validator = para conseguir validar o schema dos responses nos testes 
```
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>json-schema-validator</artifactId>
    <version>4.3.3</version>
</dependency>
```

* lombok = anotações para facilitar a criação dos modelos de dados
```
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.18</version>
</dependency>
```

* gson = serve para realizar a serialização / deserialização dos modelos de dados para os requests
```
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.6</version>
</dependency>
```
        
### Referências

* O curso [Testando API Rest com REST-assured](https://www.udemy.com/course/testando-api-rest-com-rest-assured/) é muito
  bom, recomendo a todos, criado por Francisco Wagner Costa Aquino e disponibilizado na Udemy, declaro que estou fazendo
  essa referencia ao curso, por ser um bom curso e que foi utilizado por mim como forma de estudo, não estou ganhando nada e nem vou contestar isso no futuro.
* Para gerar schemas em json, utilizei o site [Jsonschema.net](https://jsonschema.net/home)
* [Como começar](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)
  e [Como utilizar](https://github.com/rest-assured/rest-assured/wiki/Usage) o RestAssured, segundo própria página
  de [documentação](https://rest-assured.io/).
* Api pública [ReqRes](https://reqres.in/) utilizada nos exemplos

### Arquitetura

#### Pacotes

* [builders]() onde se encontra as classes responsáveis por construir todos os RequestSpecification, utilizados nos
  testes.
* [models]() onde se encontra todas as classes que representam os modelos de dados utilizados nos endpoint.
* [jsons]() onde se encontra os schema-json que são validados nos testes.

#### Execução

* Executar o arquivo [UsersTestes.java]() projeto de teste utilizando JUnit5

### Sugestão

#### Conceito

Infelizmente não me lembro de onde li / aprendi isto que vou falar agora, mas sempre que for realizar um teste, pensar em testes ou até desenvolver aplicando TDD.
Organize as ideias, seguindo o conceito de 3a's ( Arrange, Act, Assert ).

**Arrange** -> significa seu cenário, prepare todas as dependências que o seu teste precise.

**Act** -> significa a ação que será feita / validada no teste.

**Assert** -> significa / representa os testes / validações que serão feitas, indicando sucesso ou não do seu teste.

#### Aplicado no projeto

Segui os 3 a's e me organizei desta forma para montar o projeto

**1 - Arrange - Cenario**<br/>
Montar o request

**2 - Act - Ação**<br/>
Realizar o request

**3 - Assert - Validações**<br/>
3.1 - Content-type
3.2 - StatusCode
3.3 - Esquema ( Objeto ) = Esqueleto do Endpoint
3.4 - Objetivo do Endpoint / teste **( Levantar com o time )**

#### Considerações
1 - Nomes de class, metodo e variaveis são MEGA importante, ficar atento.<br/>
2 - Utilizar objeto ou no minimo MAP ao realizar requests que possuem body.<br/>
3 - Cuidado ao colocar mais informações do que o endpoint precisa, pois seu teste é uma "documentação" do seu projeto.<br/>