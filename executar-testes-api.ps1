Write-Host "Testando GET /produtos" -ForegroundColor Cyan
Invoke-RestMethod http://localhost:8080/produtos

Write-Host "Testando GET /produtos/1" -ForegroundColor Cyan
Invoke-RestMethod http://localhost:8080/produtos/1

Write-Host "Testando POST /produtos" -ForegroundColor Cyan
$body = '{"nome":"Teclado","preco":180.00,"estoque":7}'
Invoke-RestMethod -Uri http://localhost:8080/produtos -Method POST -ContentType "application/json" -Body $body

Write-Host "Testando erro controlado em GET /produtos/99" -ForegroundColor Yellow
Invoke-RestMethod http://localhost:8080/produtos/99
