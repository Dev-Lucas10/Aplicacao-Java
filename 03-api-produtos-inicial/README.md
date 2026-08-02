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
