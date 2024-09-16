<h1 align="center">GabiruBank</h1>
<h3 align="center">API voltada para resolução de teste técnico da Horizon</h3>
<hr size = "185%">

# Pré-Requisitos 
  - Java 17
  - Apache Maven 
    
## Sumário

- [Visão Geral](#visão-geral)
- [Endpoints](#endpoints)

## Visão Geral

Essa API se trata de um banco cuja as funcionalidades principais são: Criar Pessoa, Criar uma conta, Realizar a Transferência e Consultar Saldo

## Regras Solicitadas
1. A pessoa pode ter no máximo duas contas, sendo elas uma conta corrente e uma conta poupança
2. Para realizar um saque a conta precisa ter saldo disponível
3. Para realizar a transferência a conta origem precisar ter saldo disponível

## Endpoints
- Pessoa <br>
  - GET http://localhost:8080/pessoa -> Lista todas as pessoas cadastradas
  - POST http://localhost:8080/pessoa -> Efetua o cadastro de uma nova pessoa
- Conta <br>
  - GET http://localhost:8080/conta -> Lista todas as contas cadastradas
  - GET http://localhost:8080/conta/{id} -> Lista apenas a conta de ID correspondente
  - GET http://localhost:8080/conta/saldo/{id} -> Lista apenas o saldo da conta de ID correspondente
  - POST http://localhost:8080/conta -> Efetua o cadastro de uma nova conta
  - POST http://localhost:8080/depositar/{id} -> Efetua um deposito para a conta de ID correspondente
  - POST http://localhost:8080/sacar/{id} -> Efetua um saque para a conta de ID correspondente
 - Transferência <br>
   - POST http://localhost:8080/{idContaOrigem}/{idContaDestino} -> Efetua a transferência da contaOrigem para contaDestino

