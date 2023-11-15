# API-Padaria
Projeto Teste de uma API para uma Site de Padaria

Essa API foi criada para ser consumida por um site estilo Padaria, onde o mesmo terá areas relacionadas a publicações e recebimento de curriculos,
composto por 3 classes, Usuário, Curriculo e Cargo.

ENDPOINTS da API

##Usuario ->

Cadastro de usuario: http://localhost:8080/usuario/cadastrar-usuario
Login: http://localhost:8080/usuario/login

##Cargo ->

Listar Cargos: http://localhost:8080/cargos/
Cadastrar Cargos: http://localhost:8080/cargos/cadastrar
Buscar cargo por ID: http://localhost:8080/cargos/{id}

##Curriculo ->

Listar todos os curriculos: http://localhost:8080/curriculo/
Cadastrar curriculo: http://localhost:8080/curriculo/{id}
obs: id seria o id referente a classe cargo.
