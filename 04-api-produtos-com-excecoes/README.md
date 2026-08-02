# 04-api-produtos-com-excecoes

API REST com tratamento global de exceções usando `@RestControllerAdvice` e `@ExceptionHandler`.

## Executar

```powershell
cd C:\programacao-avancada\04-api-produtos-com-excecoes
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
