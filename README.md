
Este projeto Java realiza consultas à API pública da Tabela FIPE (https://parallelum.com.br/fipe/api/v1/) para obter informações sobre veículos como **carros**, **motos** e **caminhões**. A aplicação permite ao usuário navegar pelas marcas, modelos e anos dos veículos, exibindo os dados detalhados de cada um.

## 📌 Funcionalidades

- Escolha do tipo de veículo (carro, moto ou caminhão)
- Listagem de marcas disponíveis
- Consulta de modelos por marca
- Filtro de modelos por nome
- Listagem de anos disponíveis para um modelo
- Exibição de detalhes dos veículos por ano

## 🛠️ Tecnologias e Habilidades Utilizadas

- **Java 17+**
- **Programação Orientada a Objetos (POO)**
- **Streams e Lambdas (Java 8+)**
- **Manipulação de JSON**
- **Consumo de API REST com HTTP**
- **Maven**

## 📦 Estrutura do Projeto

- `models`: Contém as classes que representam os dados da API (`Dados`, `Modelos`, `Veiculos`)
- `services`: Contém as classes responsáveis por consumir a API (`CreateURI`) e converter os dados JSON (`ConverteDados`)
- `view`: Interface de interação com o usuário via terminal (`View`)

  <img width="1772" height="613" alt="image" src="https://github.com/user-attachments/assets/76c90f8f-a96b-4ab3-8a3c-f98bf56b5084" />

