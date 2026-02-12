# ⛽ Sistema de Posto de Combustível

Projeto em Java que simula o gerenciamento de um posto de combustível, utilizando **JDBC** para conexão com banco de dados **MySQL** e o padrão **DAO (Data Access Object)** para acesso aos dados.

---

## 📌 Funcionalidades

- Cadastro de combustíveis  
- Cadastro de tanques  
- Cadastro de bombas  
- Registro de abastecimentos  
- Consulta de dados no banco  
- Atualização de informações operacionais  
  (ex: litros do tanque, status da bomba)

---

## 🛠️ Tecnologias Utilizadas

- Java  
- JDBC  
- MySQL  
- IntelliJ IDEA  
- Git / GitHub  

---

## 🗂️ Estrutura do Projeto

src/

├── model/

├── dao/

└── Conexao.java

---

## ⚙️ Banco de Dados

O projeto utiliza MySQL com as seguintes tabelas:

- combustivel  
- tanque  
- bomba  
- abastecimento  

A tabela **abastecimento** registra automaticamente a data e hora do abastecimento através de:
 data_hora DATETIME DEFAULT CURRENT_TIMESTAMP

---

## 🚀 Como Executar

1. Clone o repositório:

 -  git clone <https://github.com/daviHmoraes/ProjetoPosto>

3. Crie o banco de dados MySQL e as tabelas.

4. Configure a classe `Conexao.java` com:
- URL do banco  
- Usuário  
- Senha  

4. Execute o projeto pelo IntelliJ.

---

## 📖 Observações

- O projeto segue o padrão DAO  
- PreparedStatement é usado para evitar SQL Injection  
- Enums são armazenados no banco como String  
- Abastecimentos são tratados como registros históricos (sem update/delete)

---

## ✍️ Autor

Davi Heinzen
