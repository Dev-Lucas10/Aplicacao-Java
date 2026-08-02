# Códigos-fonte completos

Os códigos abaixo estão organizados por projeto e caminho de arquivo.

## 01-java-basico/README.md

```text
# 01-java-basico

Projeto Java simples para demonstrar variáveis, condicionais, repetição e método.

## Executar no Windows Server

```powershell
cd C:\programacao-avancada\01-java-basico\src
javac Main.java
java Main
```

```

## 01-java-basico/src/Main.java

```java
public class Main {
    public static void main(String[] args) {
        String nomeProduto = "Notebook";
        double preco = 3500.00;
        int estoque = 5;
        boolean disponivel = estoque > 0;

        System.out.println("=== Catálogo - Estruturas Básicas ===");
        System.out.println("Produto: " + nomeProduto);
        System.out.println("Preço original: R$ " + preco);
        System.out.println("Estoque: " + estoque);

        if (disponivel) {
            System.out.println("Status: disponível para venda");
        } else {
            System.out.println("Status: produto indisponível");
        }

        double precoFinal = aplicarDesconto(preco, 10);
        System.out.println("Preço com desconto de 10%: R$ " + precoFinal);

        System.out.println("\nSimulação de baixa no estoque:");
        for (int unidade = 1; unidade <= estoque; unidade++) {
            System.out.println("Venda simulada da unidade " + unidade);
        }
    }

    public static double aplicarDesconto(double preco, double percentual) {
        return preco - (preco * percentual / 100);
    }
}

```

## 02-classes-objetos/README.md

```text
# 02-classes-objetos

Projeto Java simples para demonstrar classe, objeto, atributos, métodos, construtor, encapsulamento e regras básicas.

## Executar no Windows Server

```powershell
cd C:\programacao-avancada\02-classes-objetos\src
javac Produto.java App.java
java App
```

```

## 02-classes-objetos/src/App.java

```java
public class App {
    public static void main(String[] args) {
        Produto produto = new Produto(1L, "Mouse sem fio", 120.00, 3);

        System.out.println("=== Catálogo - Classes e Objetos ===");
        System.out.println(produto);

        double precoPromocional = produto.calcularPrecoComDesconto(15);
        System.out.println("Preço com 15% de desconto: R$ " + precoPromocional);

        if (produto.estaDisponivel()) {
            produto.venderUmaUnidade();
            System.out.println("Venda realizada com sucesso.");
        }

        System.out.println("Estoque atualizado: " + produto.getEstoque());
    }
}

```

## 02-classes-objetos/src/Produto.java

```java
public class Produto {
    private Long id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(Long id, String nome, double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        setPreco(preco);
        setEstoque(estoque);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do produto é obrigatório.");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo.");
        }
        this.estoque = estoque;
    }

    public boolean estaDisponivel() {
        return estoque > 0;
    }

    public double calcularPrecoComDesconto(double percentual) {
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("O percentual deve estar entre 0 e 100.");
        }
        return preco - (preco * percentual / 100);
    }

    public void venderUmaUnidade() {
        if (!estaDisponivel()) {
            throw new IllegalStateException("Produto sem estoque.");
        }
        estoque--;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                '}';
    }
}

```

## 03-api-produtos-inicial/README.md

```text
# 03-api-produtos-inicial

API REST simples com Spring Boot, Controller e Service. Os dados ficam em memória.

## Executar

```powershell
cd C:\programacao-avancada\03-api-produtos-inicial
mvn spring-boot:run
```

## Testar

```powershell
Invoke-RestMethod http://localhost:8080/produtos
Invoke-RestMethod http://localhost:8080/produtos/1

$body = '{"nome":"Teclado","preco":180.00,"estoque":7}'
Invoke-RestMethod -Uri http://localhost:8080/produtos -Method POST -ContentType "application/json" -Body $body
```

```

## 03-api-produtos-inicial/pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.7</version>
        <relativePath/>
    </parent>

    <groupId>br.edu.programacaoavancada</groupId>
    <artifactId>api-produtos-inicial</artifactId>
    <version>1.0.0</version>
    <name>API Produtos Inicial</name>
    <description>Aula final prática de Programação Avançada</description>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

```

## 03-api-produtos-inicial/src/main/java/br/edu/programacaoavancada/catalogo/ApiProdutosApplication.java

```java
package br.edu.programacaoavancada.catalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiProdutosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiProdutosApplication.class, args);
    }
}

```

## 03-api-produtos-inicial/src/main/java/br/edu/programacaoavancada/catalogo/Produto.java

```java
package br.edu.programacaoavancada.catalogo;

public class Produto {
    private Long id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto() {
    }

    public Produto(Long id, String nome, double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}

```

## 03-api-produtos-inicial/src/main/java/br/edu/programacaoavancada/catalogo/ProdutoController.java

```java
package br.edu.programacaoavancada.catalogo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        Produto produtoCriado = service.cadastrar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
    }
}

```

## 03-api-produtos-inicial/src/main/java/br/edu/programacaoavancada/catalogo/ProdutoService.java

```java
package br.edu.programacaoavancada.catalogo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProdutoService {
    private final List<Produto> produtos = new ArrayList<>();
    private final AtomicLong proximoId = new AtomicLong(3);

    public ProdutoService() {
        produtos.add(new Produto(1L, "Notebook", 3500.00, 5));
        produtos.add(new Produto(2L, "Mouse sem fio", 120.00, 10));
    }

    public List<Produto> listar() {
        return produtos;
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst();
    }

    public Produto cadastrar(Produto produto) {
        produto.setId(proximoId.getAndIncrement());
        produtos.add(produto);
        return produto;
    }
}

```

## 03-api-produtos-inicial/src/main/resources/application.properties

```text
spring.application.name=api-produtos-inicial
server.port=8080

```

## 04-api-produtos-com-excecoes/README.md

```text
# 04-api-produtos-com-excecoes

API REST com tratamento global de exceções usando `@RestControllerAdvice` e `@ExceptionHandler`.

## Executar

```powershell
cd C:\aulas\programacao-avancada-final\04-api-produtos-com-excecoes
mvn spring-boot:run
```

## Testar

```powershell
Invoke-RestMethod http://localhost:8080/produtos
Invoke-RestMethod http://localhost:8080/produtos/1
Invoke-RestMethod http://localhost:8080/produtos/99

$body = '{"nome":"Monitor","preco":950.00,"estoque":4}'
Invoke-RestMethod -Uri http://localhost:8080/produtos -Method POST -ContentType "application/json" -Body $body
```

```

## 04-api-produtos-com-excecoes/pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.7</version>
        <relativePath/>
    </parent>

    <groupId>br.edu.programacaoavancada</groupId>
    <artifactId>api-produtos-com-excecoes</artifactId>
    <version>1.0.0</version>
    <name>API Produtos com Excecoes</name>
    <description>Aula final prática de Programação Avançada</description>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

```

## 04-api-produtos-com-excecoes/src/main/java/br/edu/programacaoavancada/catalogo/ApiProdutosApplication.java

```java
package br.edu.programacaoavancada.catalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiProdutosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiProdutosApplication.class, args);
    }
}

```

## 04-api-produtos-com-excecoes/src/main/java/br/edu/programacaoavancada/catalogo/ErroResposta.java

```java
package br.edu.programacaoavancada.catalogo;

import java.time.LocalDateTime;

public class ErroResposta {
    private LocalDateTime dataHora;
    private int status;
    private String erro;
    private String mensagem;
    private String caminho;

    public ErroResposta() {
    }

    public ErroResposta(LocalDateTime dataHora, int status, String erro, String mensagem, String caminho) {
        this.dataHora = dataHora;
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
        this.caminho = caminho;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
}

```

## 04-api-produtos-com-excecoes/src/main/java/br/edu/programacaoavancada/catalogo/Produto.java

```java
package br.edu.programacaoavancada.catalogo;

public class Produto {
    private Long id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto() {
    }

    public Produto(Long id, String nome, double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}

```

## 04-api-produtos-com-excecoes/src/main/java/br/edu/programacaoavancada/catalogo/ProdutoController.java

```java
package br.edu.programacaoavancada.catalogo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        Produto produtoCriado = service.cadastrar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
    }
}

```

## 04-api-produtos-com-excecoes/src/main/java/br/edu/programacaoavancada/catalogo/ProdutoNaoEncontradoException.java

```java
package br.edu.programacaoavancada.catalogo;

public class ProdutoNaoEncontradoException extends RuntimeException {
    public ProdutoNaoEncontradoException(Long id) {
        super("Produto não encontrado com id: " + id);
    }
}

```

## 04-api-produtos-com-excecoes/src/main/java/br/edu/programacaoavancada/catalogo/ProdutoService.java

```java
package br.edu.programacaoavancada.catalogo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProdutoService {
    private final List<Produto> produtos = new ArrayList<>();
    private final AtomicLong proximoId = new AtomicLong(3);

    public ProdutoService() {
        produtos.add(new Produto(1L, "Notebook", 3500.00, 5));
        produtos.add(new Produto(2L, "Mouse sem fio", 120.00, 10));
    }

    public List<Produto> listar() {
        return produtos;
    }

    public Produto buscarPorId(Long id) {
        return produtos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProdutoNaoEncontradoException(id));
    }

    public Produto cadastrar(Produto produto) {
        produto.setId(proximoId.getAndIncrement());
        produtos.add(produto);
        return produto;
    }
}

```

## 04-api-produtos-com-excecoes/src/main/java/br/edu/programacaoavancada/catalogo/TratadorGlobalDeErros.java

```java
package br.edu.programacaoavancada.catalogo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TratadorGlobalDeErros {

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<ErroResposta> tratarProdutoNaoEncontrado(
            ProdutoNaoEncontradoException exception,
            HttpServletRequest request) {

        ErroResposta erro = new ErroResposta(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}

```

## 04-api-produtos-com-excecoes/src/main/resources/application.properties

```text
spring.application.name=api-produtos-com-excecoes
server.port=8080

```

## executar-testes-api.ps1

```powershell
Write-Host "Testando GET /produtos" -ForegroundColor Cyan
Invoke-RestMethod http://localhost:8080/produtos

Write-Host "Testando GET /produtos/1" -ForegroundColor Cyan
Invoke-RestMethod http://localhost:8080/produtos/1

Write-Host "Testando POST /produtos" -ForegroundColor Cyan
$body = '{"nome":"Teclado","preco":180.00,"estoque":7}'
Invoke-RestMethod -Uri http://localhost:8080/produtos -Method POST -ContentType "application/json" -Body $body

Write-Host "Testando erro controlado em GET /produtos/99" -ForegroundColor Yellow
Invoke-RestMethod http://localhost:8080/produtos/99

```
