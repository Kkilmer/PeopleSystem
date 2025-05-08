# 👥 PeopleSystem

**PeopleSystem** é um projeto Java desenvolvido com o objetivo de revisar e aplicar os principais conceitos da **Programação Orientada a Objetos (POO)**. O sistema simula uma estrutura de pessoas (clientes e funcionários) e suas composições com objetos como endereço, telefone, cargo e profissão.

O projeto é voltado à prática de **encapsulamento, abstração e composição**, evitando o uso excessivo de herança e favorecendo um código mais modular e de fácil manutenção.

---

## 🗂️ Estrutura de Pacotes de 1, as outras usei a mesma base ou semelhante.

kevin/
└── house/
└── atv1/
├── composicao/
│ ├── Cargo.java
│ ├── Endereco.java
│ ├── Profissao.java
│ └── Telefone.java
│
├── main/
│ └── Main.java
│
└── pessoas/
├── Cliente.java
└── Funcionario.java


---

## 🧱 Organização e Conceitos

### 📁 `composicao/`

Contém as **classes de apoio** utilizadas na composição dos objetos principais (`Cliente` e `Funcionario`):

- `Endereco.java`: Representa o endereço da pessoa (rua, número, bairro, cidade, UF).
- `Telefone.java`: Representa um telefone com DDD e número.
- `Cargo.java`: Representa o cargo de um funcionário.
- `Profissao.java`: Representa a profissão de um cliente.

Essas classes são utilizadas como **atributos compostos** nas classes `Cliente` e `Funcionario`, demonstrando o princípio da **composição**.

---

### 📁 `pessoas/`

Contém as **entidades principais** do sistema, que herdam ou reutilizam comportamentos comuns de uma superclasse `Pessoa` (se presente):

- `Cliente.java`: Representa uma pessoa cliente, contendo nome, CPF, profissão, endereço e telefone.
- `Funcionario.java`: Representa um funcionário, contendo nome, CPF, cargo, endereço e telefone.

---

### 📁 `main/`

Contém a classe `Main.java`, ponto de entrada do sistema, responsável por instanciar objetos e demonstrar a interação entre eles.

---

## 💡 Exemplo de Composição 

`java
Endereco endereco = new Endereco("Rua Central", 100, "Centro", "Recife", "PE");
Telefone telefone = new Telefone(81, "99999-1234");
Profissao profissao = new Profissao("Engenheiro Civil");`

`Cliente cliente = new Cliente("João da Silva", "123.456.789-00", endereco, telefone, profissao);`

`| Conceito       | Aplicação                                                                    |
| -------------- | ---------------------------------------------------------------------------- |
| Encapsulamento | Todos os atributos são `private` e acessados via `getters/setters`.          |
| Abstração      | As classes modelam entidades do mundo real com seus próprios comportamentos. |
| Composição     | Classes complexas formadas por objetos de outras classes.                    |
| Reutilização   | Componentes como `Endereco` e `Telefone` podem ser usados em várias classes. |`

---

## 🛠️ Requisitos

- Java 17 ou superior
- IDE recomendada: IntelliJ, Eclipse ou VS Code com suporte Java

---
