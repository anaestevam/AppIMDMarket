# IMDMarket - Gerenciador de Estoque de Supermercado

Este é um aplicativo de gerenciamento de estoque de produtos de supermercado, desenvolvido como parte da avaliação da disciplina de Programação de Dispositivos Móveis I na Universidade Federal do Rio Grande do Norte.

## Funcionalidades e Características

O aplicativo IMDMarket permite a criação, listagem, detalhamento, alteração e exclusão de produtos de um supermercado. Ele consiste em várias telas e funcionalidades.

### Tela de Login

A primeira tela é a tela de login, onde você precisa inserir suas credenciais. As credenciais iniciais são:
- Usuário: admin
- Senha: admin

Você também terá a opção de alterar sua senha. As credenciais serão armazenadas usando a classe SharedPreferences ou em um arquivo. Consulte a imagem "A" como modelo para a implementação.

### Tela de Menu

A segunda tela é a tela de menu, que oferece quatro botões, cada um levando a uma funcionalidade específica. A imagem "B" serve como modelo para essa tela.

### Tela de Cadastro

Na terceira tela, você pode cadastrar um novo produto. Você precisará fornecer as seguintes informações:
- Código do produto (Número)
- Nome do produto (Texto Simples)
- Descrição do produto (Texto em várias linhas)
- Estoque (Número)

Todos os campos são obrigatórios. Se você não preencher algum deles, um TOAST será exibido para alertá-lo. A imagem "C" é um modelo para esta tela.

### Tela de Alteração de Produto

A quarta tela é usada para alterar as informações de um produto. O único campo obrigatório é o código do produto; os outros campos são opcionais, permitindo que você altere apenas as informações desejadas. A imagem "D" pode ser usada como referência para essa tela.

### Tela de Exclusão de Produto

Na quinta tela, você pode excluir um produto. Basta inserir o código do produto e clicar no botão de exclusão. Após a exclusão, um TOAST será exibido para indicar o sucesso ou falha da operação.

### Tela de Listagem de Produto

A sexta tela exibe uma lista de todos os produtos cadastrados. Ao clicar em um produto, você pode ver os detalhes em um Alert ou em outra tela.

### Elementos Internos do Projeto

Os dados dos produtos são armazenados em um arquivo chamado "produtos", embora você também possa usar um Banco de Dados SQLite. O arquivo é lido ao iniciar o aplicativo para carregar os dados já salvos e é salvo ao fechar o aplicativo após qualquer manipulação de dados.

Uma classe chamada "Produto" foi criada com os seguintes atributos e métodos:
- `String codigo_produto`
- `String nome_produto`
- `String descrição_produto`
- `int estoque`

Além disso, uma lista `List<Produto> listaProdutos = new ArrayList<>();` é usada para armazenar todos os produtos lidos do arquivo e manipulados durante o funcionamento do aplicativo.

### Critérios de Avaliação

O projeto será avaliado com base nos seguintes critérios:
- Leitura e escrita de EditText (1,0 ponto)
- Leitura e escrita de arquivos ou uso do SQLite (2,0 pontos)
- Utilização correta das Intents na alternância de telas (2,0 pontos)
- Criação das telas com os elementos necessários (2,0 pontos)
- Exibição dos produtos em uma ListView e seu detalhamento (2,0 pontos)
- Organização do código e do projeto (1,0 ponto)

## O Que Deve Ser Entregue?

Você deve entregar o projeto completo em um arquivo zipado. Se o arquivo for maior que o limite do Sigaa, você pode enviá-lo via GitHub (evite usar o Google Drive). Além disso, é necessário fornecer um link para um vídeo apresentando as funcionalidades e a execução do seu sistema. Se preferir, é possível apresentar o projeto pessoalmente, o que substituirá a necessidade do vídeo. Certifique-se de que sua entrega atenda a todos os requisitos da avaliação da 2ª Unidade da disciplina de Programação de Dispositivos Móveis I na Universidade Federal do Rio Grande do Norte.

## Autores

Seu nome e informações de contato.

**Universidade Federal do Rio Grande do Norte**
**Programação de Dispositivos Móveis I**
**Data da Avaliação: [Insira a data]**