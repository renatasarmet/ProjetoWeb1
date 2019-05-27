# Trabalhos disciplina Desenvolvimento de Software para Web

# OBS: O trabalho 1 está na branch master e o trabalho 2 está na branch Trabalho2
### O Roteiro do trabalho 2 está no READ.ME da branch Trabalho2

## Roteiro Trabalho 1

## SGBD utilizado, nome do banco, usuário e senha de acesso

- SGDB: JavaDB
- Nome do banco: ProjetoWeb1
- Usuário: root
- Senha: root


## Como criar as tabelas? Existe algum script de criação da tabelas? Onde está localizado?

- Existe, está em: https://docs.google.com/document/d/18aB_roBFz8uZ7kTJ1TI4kuT_czbbRIm8no0PLq8rSxE/edit?usp=sharing


## É necessário popular as tabelas? Existe algum programa/classe para popular as tabelas? Onde está localizado?

- É necessário popular a tabela User com o usuário ADMIN, pois depois disso será possível realizar qualquer cadastro e alteração no próprio sistema.
- Para realizar isso, basta Executar o script CriaUsuarios
- Localizado em: ProjetoWeb1/ProjetoWeb1/src/java/br/ufscar/dc/dsw/login


## Login/senha para acesso ao sistema?

- Ao rodar o script CriaUsuarios, você terá o User de administrador, que poderá fazer qualquer alteração posteriormente, inclusive criar novos usuários do tipo SITE DE VENDAS e do tipo TEATRO.
- Login do administrador: admin@admin
- Senha do administrador: admin


## Alguma informação adicional?

- Se der algum problema, por favor certifique-se de que as bibliotecas estão corretamente colocadas no projeto. Estamos utilizando o Driver do Java DB, o JSTL e todas aquelas mesmas que você utilizou de spring e commons-logging no seu exemplo de LoginJSP. Essas relacionadas ao login estão na pasta /lib do nosso projeto.


## -------------------------------------


# Descrição do Trabalho

## Sistema para criação de promoções em sites de venda de ingressos

- O sistema deve possuir um cadastro de sites de venda de ingressos, com os seguintes dados: e-mail, senha, endereço/URL, nome e telefone.
- O sistema deve possuir um cadastro de salas de teatro, com os seguintes dados: e-mail, senha, CNPJ, nome e cidade.
- O sistema deve possuir um cadastro de promoções, com os seguintes dados: endereço/URL do site de venda de ingressos, CNPJ do teatro, nome da peça, preço e dia/horário.

## O sistema deve atender aos seguintes requisitos:

- R1: Operações CRUD[1] de sites de venda de ingressos (requer login de
administrador)
- R2: Operações CRUD de teatros (requer login de administrador
- R3: Listagem de todos os teatros em uma única página (não requer login)
- R4: Listagem de todos os teatros por cidade (não requer login)
- R5: Criação de uma promoção de um teatro (requer login do teatro: via e-
mail + senha). Depois de fazer login, o teatro pode cadastrar uma promoção. Para isso, deve escolher o site de venda de ingressos (digitando seu endereço/URL ou escolhendo a partir de uma lista), o nome da peça, o preço, e o dia/horário da sessão, e deve ser gravada a promoção na base de dados.
- R6: Listagem de todas as promoções de um teatro (não requer login).
- R7: Listagem de todas as promoções de um site de venda de ingressos
(requer login do site: via e-mail + senha).
- R8: O sistema não deve permitir o cadastro de promoções de um mesmo
teatro ou de um mesmo site de venda de ingressos em um mesmo
dia/horário.
- R9: O sistema deve ser internacionalizado em pelo menos dois idiomas:
português + outro de sua escolha.

O sistema deve tratar todos os erros possíveis (cadastros duplicados, problemas técnicos, etc) mostrando uma página de erros amigável ao usuário e registrando o erro no console.


### Arquitetura: 
Modelo-Visão-Controlador 
### Tecnologias: 
JSP, Servlet & JDBC (Lado Servidor)
Javascript & CSS (Lado Cliente) 

[1] CRUD: Create, Read, Update & Delete
