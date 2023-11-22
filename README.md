# AppIMDMarket - Gerenciador de Estoque de Supermercado

Este é um aplicativo de gerenciamento de estoque de produtos de supermercado, desenvolvido como parte da avaliação da disciplina de Programação de Dispositivos Móveis I na Universidade Federal do Rio Grande do Norte.

## Descrição do Projeto

O projeto é estruturado em três principais diretórios: `controller`, `model` e `database`.

### Diretório `controller`

O diretório controller contém as classes que controlam a `Main`, `Login`, `MudarSenha` e `Menu`.

### Diretório `model`

O diretório model contém as classes que pertencem as opções da class `Menu`, como `Cadastro`, `Alterar`, `Deletar` e `Listar Produto`, como também tem a classe `ProdutoAdapter` que é uma classe auxiliar para a exibição da Listagem dos Produtos serem por ListView e utiliza o ArrayAdapter que pode ser usado para fornecer visualizações para uma AdapterView, retorna uma visualização para cada objeto em uma coleção de dados.

### Diretório `database`

O diretório database contém as classes responsáveis por interagir com o banco de dados do aplicativo.<br>
A classe `ProdutoDAO` (Data Access Object) é responsável por realizar operações de banco de dados na classe Produto. 

    salvarProduto: Este método é usado para salvar um novo produto no banco de dados.
    getLista: Este método é usado para ler um produto do banco de dados.
    atualizarProduto: Este método é usado para atualizar um produto no banco de dados, se existir.
    deletarProduto: Este método é usado para excluir um produto do banco de dados.
    getProdutoByCodigo: Este método é para identificar o código do produto e trazer os dados, seria para carregar automaticamente, mas não deu tempo.

A classe Produto representa o produto e que possui os métodos get e set, e a classe.

 O arquivo é lido ao iniciar o aplicativo para carregar os dados já salvos e é salvo ao fechar o aplicativo após qualquer manipulação de dados.

## Como Instalar e Executar o Projeto

Para instalar e executar este projeto, siga as seguintes etapas:

1. Clone o repositório para o seu computador usando o comando `git clone https://github.com/anaestevam/AppIMDMarket.git`.
2. Abra o projeto no seu ambiente de desenvolvimento, no caso o Android Studio.
3. Execute o aplicativo no seu dispositivo ou emulador.

**Versões android utilizada:**<br>
*"Lollipop", android 5.1*

## Como Usar o Projeto

O aplicativo permite a criação, listagem, detalhamento, alteração e exclusão de produtos de um supermercado. Para usar o aplicativo, siga as seguintes etapas:

1. Abra o aplicativo no seu dispositivo ou emulador.
2. Faça login usando suas credenciais "admin" "admin" ou mude a senha.
3. Selecione a funcionalidade desejada (criação, listagem, detalhamento, alteração ou exclusão de produtos) na tela de menu.
4. Siga as instruções na tela para realizar a funcionalidade desejada.
5. Após entrar no Menu e selecionar um botão para outra tela, pode-se clicar no layout IMDMarket que volta para a tela Menu.


## Autores

Ana Luisa Estevam Dantas e Debora Tayna da Silva Chacon