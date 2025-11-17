[![Github Actions Status for JPMoliner/A3-GestaoAlunosFuncionarios](https://github.com/JPMoliner/A3-GestaoAlunosFuncionarios/workflows/Integra%C3%A7%C3%A3o%20continua%20de%20Java%20com%20Maven/badge.svg)](https://github.com/JPMoliner/A3-GestaoAlunosFuncionarios/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=JPMoliner_A3&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=JPMoliner_A3)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=JPMoliner_A3&metric=coverage)](https://sonarcloud.io/component_measures?id=JPMoliner_A3&metric=coverage)

# Sistema de Gerenciamento de Alunos e Professores Unisul

Projeto: A3-GestaoAlunosFuncionarios - Gestão de Qualidade de Software <br>
Professor: Osmar de Oliveira Braz Júnior

## Tecnologias Utilizadas

- Java 17 
- Maven
- Junit
- SonarCloud
- SQL Lite
- Jacoco

## Desenvolvedores

João Pedro Moliner de Carvalho - GitHub: [@JPMoliner](https://github.com/JPMoliner)

Guilherme Menegotto Hoeller - GitHub: [@Guilhermemhz](https://github.com/Guilhermemhz)

Gustavo Borges Leipnitz - GitHub: [@GustavoBorgesLeipnitz](https://github.com/GustavoBorgesLeipnitz)

Gabriel Zamorano Blanco - GitHub: [gabriel-zamorano](https://github.com/gabriel-zamorano)

## 🧩 Requisitos Funcionais (RF) <br>
RF01 – Cadastrar aluno:
O sistema deve permitir o cadastro de um novo aluno, informando nome, curso, fase, idade e CPF.

RF02 – Listar alunos:
O sistema deve permitir a listagem de todos os alunos cadastrados no banco de dados.

RF03 – Atualizar aluno:
O sistema deve permitir a atualização dos dados de um aluno existente.

RF04 – Excluir aluno:
O sistema deve permitir remover um aluno com base no seu identificador (ID).

RF05 – Buscar aluno por ID:
O sistema deve permitir consultar um aluno específico a partir do seu ID.

RF06 – Cadastrar funcionário:
O sistema deve permitir o cadastro de um funcionário, informando cargo, CPF, PIS, nome e idade.

RF07 – Listar funcionários:
O sistema deve permitir visualizar todos os funcionários cadastrados.

RF08 – Atualizar funcionário:
O sistema deve permitir modificar as informações de um funcionário existente.

RF09 – Excluir funcionário:
O sistema deve permitir remover um funcionário com base no seu ID.

RF10 – Buscar funcionário por ID:
O sistema deve permitir consultar um funcionário específico a partir do seu ID.

## ⚙️ Requisitos Não Funcionais (RNF) <br>
RNF01 – Persistência local:
O sistema deve utilizar um banco de dados SQLite para armazenar informações de forma local e persistente.

RNF02 – Tempo de resposta:
As operações de cadastro, consulta, atualização e exclusão devem ser processadas em menos de 2 segundos em condições normais.

RNF03 – Integridade dos dados:
As tabelas devem possuir chaves primárias únicas e validação de tipos de dados.

RNF04 – Código documentado:
Todo o código deve conter Javadoc nas classes e métodos públicos, descrevendo seu propósito e parâmetros.

RNF05 – Padrões de nomenclatura:
O código deve seguir convenções Java (camelCase, nomes de classes iniciando com letra maiúscula, etc).

RNF06 – Independência de plataforma:
O sistema deve ser compatível com qualquer sistema operacional que suporte Java (Windows, Linux, macOS).

RNF07 – Facilidade de uso:
As operações básicas devem ser acessíveis por meio de uma interface intuitiva (terminal, interface gráfica ou web, dependendo da evolução do projeto).

RNF08 – Testes automatizados:
O sistema deve possuir testes unitários para validar o funcionamento dos métodos DAO.

RNF09 – Geração de relatórios de cobertura:
O projeto deve permitir a geração de relatórios de cobertura de testes via SonarQube ou ferramentas similares.
