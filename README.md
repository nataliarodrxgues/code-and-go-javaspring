<h1 align="center"> Code and Go! Viagens </h1> 

<h1 align="center">
      <img alt="logoNova" title="LOGOCODEANDGO" src="https://github.com/nataliarodrxgues/code-and-go-viagens/blob/main/IMG/logo_rodape.png" width="300vw"/>
</h1>

## 💻 Sobre o projeto
Code and Go! Viagens é um projeto que simula uma agencia de viagens desenvolvido durante o Bootcamp **Recode Pro 2023** para formação de desenvolvedores de softwares fullstack oferecido pela [Recode](https://recodepro.org.br).  <br>



## 🛠 Tecnologias

### **Backend** 
-  **Spring Tool**
-  **MySQL**
  

### **Banco de dados** 
Abaixo é possível visualizar a tabela do código SQL usado na aplicação:
<br><br>
CREATE DATABASE IF NOT EXISTS codeandgoapi;
USE codeandgoapi;

-- Tabela 'clientes'
CREATE TABLE IF NOT EXISTS clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
) ENGINE=InnoDB;      

-- Tabela 'destinos'
CREATE TABLE IF NOT EXISTS destinos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    local VARCHAR(255) NOT NULL,
    dataIda DATE NOT NULL,
    dataVolta DATE NOT NULL,
    clientes_fk INT,
    FOREIGN KEY (clientes_fk) REFERENCES clientes(id)
) ENGINE=InnoDB;

## 👩🏼‍💻 Autora 
Natalia Rodrigues- [@nataliarodrxgues](https://www.github.com/nataliarodrxgues)
<br>
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/nataliarodrxgues)

## Licenças

Este projeto está sob as licenças:
<br>
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)
