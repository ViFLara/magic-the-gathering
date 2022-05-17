# magic_the_gathering
CRUD spring boot

A API deve criar, atualizar, deletar e listar cartas. Além disso, deve criar e listar jogadores, assim como listas de cartas para estes.
A API terá os seguintes endpoints, os quais pode-se observar em http://localhost:8080/swagger-ui.html:

![image](https://user-images.githubusercontent.com/46038257/168906399-85429234-d2be-4ecd-b83a-492127abe87c.png)

![image](https://user-images.githubusercontent.com/46038257/168910103-5240316f-422b-42ad-abb7-d842c7c0fcb1.png)


A API faz conexão com banco H2 para testes e com MYSQL para produção criando 3 tabelas, sendo uma de relacionamento:

![image](https://user-images.githubusercontent.com/46038257/168907892-bfa84bf2-56c2-444f-83c8-e27ca4caaddc.png)

Tabela Jogador:

![image](https://user-images.githubusercontent.com/46038257/168908879-d23384ce-e05b-47b3-81a2-ac2c75d2910d.png)

Tabela Carta:

![image](https://user-images.githubusercontent.com/46038257/168908972-b7e5546e-4fec-4f81-a835-bfb7628dc43c.png)

