<h1 align="center">GabiruBank</h1>
<h3 align="center">API voltada para resolução de teste técnico da Horizon</h3>
<hr size = "185%">

# Pré-Requisitos 
  - JDK 17
  - MySQL 
    
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
  - [GET] http://localhost:8080/pessoa -> Lista todas as pessoas cadastradas
    ![pessoa-get](https://github.com/user-attachments/assets/b795f921-d41e-4833-90b8-dfaaf3e263e6)
    
  - [POST] http://localhost:8080/pessoa -> Efetua o cadastro de uma nova pessoa
    ![pessoa-post](https://github.com/user-attachments/assets/47028aff-bb5d-4ca5-9136-98a78c8cedc7)
    
- Conta <br>
  - [GET] http://localhost:8080/conta -> Lista todas as contas cadastradas
    ![conta-get](https://github.com/user-attachments/assets/ce0f6aeb-bb53-4b41-a94d-2266760df43b)

  - [GET] http://localhost:8080/conta/{id} -> Lista apenas a conta de ID correspondente
    ![image](https://github.com/user-attachments/assets/bfc29c19-ab6e-4cd7-8613-6967080bc7ba)

  - [GET] http://localhost:8080/conta/saldo/{id} -> Lista apenas o saldo da conta de ID correspondente
    ![image](https://github.com/user-attachments/assets/58e0ee61-fd0b-4b0b-aeac-9f6b293ab9ac)

  - [POST] http://localhost:8080/conta -> Efetua o cadastro de uma nova conta
    1. POUPANÇA
    ![conta-post](https://github.com/user-attachments/assets/2264f6ce-52e4-447d-aeff-773dad68ec86)

    2. CORRENTE
    ![pessoa-post2](https://github.com/user-attachments/assets/9086ee40-91b0-4975-b674-792a397a88f5)

  - [POST] http://localhost:8080/depositar/{id} -> Efetua um deposito para a conta de ID correspondente
    ![conta-depositar-post](https://github.com/user-attachments/assets/94d67f00-5677-4679-a411-c6b692f0cf5b)

  - [POST] http://localhost:8080/sacar/{id} -> Efetua um saque para a conta de ID correspondente
    ![conta-sacar-post](https://github.com/user-attachments/assets/41479166-780f-4630-851f-4a814dab1df1)

 - Transferência <br>
   - [POST] http://localhost:8080/{idContaOrigem}/{idContaDestino} -> Efetua a transferência da contaOrigem para contaDestino
     ![transferencia-post](https://github.com/user-attachments/assets/84beb0ec-98dc-4d6a-b040-1179d21f66ed)


