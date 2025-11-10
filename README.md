[![Github Actions Status for
JPMoliner/A3(https://github.com/JPMoliner/A3/workflows/Integra%C3%A7%C3%A3o%20continua%20de%20Java%20com%20Maven/badge.svg(https://github.com/JPMoliner/A3/actions)
[![Quality Gate
Status](https://sonarcloud.io/api/project_badges/measureproject=JPMoliner_A3&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=JPMoliner_A3)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=JPMoliner_A3&metric=coverage)](https://sonarcloud.io/component_measures?id=JPMoliner_A3&metric=coverage)

# A3 Qualidade de software.
Utiliza 3 ambientes:
- dev - Desenvolvimento
- hmg - Homologação
- prd - Produção
<br>
Pipeline
- dev - Compilação <br>
- hmg - Compilação, Testes, Análise Código, Cobertura Código <br>
- prd - Empacotamento <br>
<br>
- Utiliza o Apache Maven para a automatização da construção.<br>
- A pasta test contêm os testes unitários do projeto utilizando JUnit. <br>
- A cobertura do código é realizada através do JaCoCo.<br>
