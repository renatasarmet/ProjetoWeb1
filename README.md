# Trabalho 2 disciplina Desenvolvimento de Software para Web

# Roteiro Trabalho 2

## SGBD utilizado, nome do banco, usuário e senha de acesso

- SGDB: JavaDB
- Nome do banco: ProjetoWeb1
- Usuário: root
- Senha: root


## É necessário popular as tabelas? Existe algum programa/classe para popular as tabelas? Onde está localizado?

- É necessário popular a tabela User com o usuário ADMIN, pois depois disso será possível realizar qualquer cadastro e alteração no próprio sistema.
- Para realizar isso, basta Executar o script CriaTudo
- Localizado em: ProjetoWeb1/ProjetoWeb1/src/java/br/ufscar/dc/dsw/dao


## Login/senha para acesso ao sistema?

- Ao rodar o script CriaTudo, você terá o User de administrador, que poderá fazer qualquer alteração posteriormente, inclusive criar novos usuários do tipo SITE DE VENDAS e do tipo TEATRO.
- Login do administrador: admin@admin
- Senha do administrador: admin


## -------------------------------------


# Descrição do Trabalho

## Sistema para criação de promoções em sites de venda de ingressos

- O sistema deve possuir um cadastro de sites de venda de ingressos, com os seguintes dados: e-mail, senha, endereço/URL, nome e telefone.
- O sistema deve possuir um cadastro de salas de teatro, com os seguintes dados: e-mail, senha, CNPJ, nome e cidade.
- O sistema deve possuir um cadastro de promoções, com os seguintes dados: site de venda de ingressos, teatro, nome da peça, preço e dia/horário.

## O sistema deve atender aos seguintes requisitos:

- R1: Operações CRUD[1] de sites de venda de ingressos (requer login de
administrador).
- R2: Operações CRUD de teatros (requer login de administrador).
- R3: Listagem de todos os teatros em uma única página (não requer login)
- R4: Listagem de todos os teatros por cidade (não requer login). Para tal,
deve-se digitar o nome da cidade ou escolher a cidade a partir de uma
lista.
- R5: Criação de uma promoção de um teatro (requer login do teatro: via e-
mail + senha). Depois de fazer login, o teatro pode cadastrar uma promoção. Para isso, deve escolher o site de venda de ingressos (a partir de uma lista), o nome da peça, o preço, e o dia/horário da sessão, e deve ser gravada a promoção na base de dados.
- R6: Listagem de todas as promoções de um teatro (não requer login). Para tal, deve-se digitar o CNPJ do teatro ou escolher o teatro a partir de uma lista.
- R7: Listagem de todas as promoções de um site de venda de ingressos (requer login do site: via e-mail + senha). Depois de fazer login, o site pode visualizar todas as suas promoções gravadas.
- R8: O sistema não deve permitir o cadastro de promoções de um mesmo teatro ou de um mesmo site de venda de ingressos em um mesmo dia/horário.
- R9: O sistema deve ser internacionalizado em pelo menos dois idiomas: português + outro de sua escolha.

O sistema deve tratar todos os erros possíveis (cadastros duplicados, problemas técnicos, etc) mostrando uma página de erros amigável ao usuário e registrando o erro no console. Além disso, o sistema deve proporcionar máscaras (telefone, CNPJ, e-mail, data, etc) para entrada dos dados.



### Arquitetura: 
Modelo-Visão-Controlador 
### Tecnologias: 
JSF/PrimeFaces & JPA (Lado Servidor)
Javascript & CSS (Lado Cliente)

[1] CRUD: Create, Read, Update & Delete
