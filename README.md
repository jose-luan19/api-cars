## Importar aplicação 
Após realizar o clone do projeto para sua maquina pode importar o projeto maven em alguma IDE java, como Eclipse e Intellij. 
A as dependencias do projeto serão baixadas automaticamente seguindo o pom.xml 
</br>
<img align="center" height="300" width="200" src=https://user-images.githubusercontent.com/54694573/173243038-db1a6daf-d1a8-489e-b3ec-63dbcf166a15.png> 

## Executar aplicação com IDE
Utilizando uma das duas frameworks citadas antes, busce o arquivo **ApiCarsApplication.java** que está no pacote 
**br.com.atlantico.apicars**, nele está localizado o MAIN da aplicação. Clique no botão e busce a opcção **Run As** e escolha
 a opção **Java Application**

<img align="center" height="400" width="600" src=https://user-images.githubusercontent.com/54694573/173243308-1f9275d9-6a0d-43d8-b9c0-7963f9009f17.png>

## Build da aplicação com IDE
Para criar o .jar da aplicação utilizando o eclipse, clique com o botão direito no projeto e na opção **Run As** selecione **Maven build ...** </br>
No campo **Goals** passe o valor => _clean package_ </br>
Em seguida clique em **Apply** e depois em **Run** e isso gerará o build da aplicação na pasta **target** com o nome _api-cars-0.0.1-SNAPSHOT_

<img align="center" height="350" width="450" src=https://user-images.githubusercontent.com/54694573/173243830-da8ec50f-9854-4bbb-b05f-f2b0781e28cf.png>
</br>
<img align="center" height="500" width="400" src=https://user-images.githubusercontent.com/54694573/173243841-daa05c5c-810e-4500-b1c7-442461607f06.png>

## Build da aplicação por linha de comando
Tendo o maven instalado na sua maquina, abrir seu terminal ou prompt no diretorio raiz do projeto e executar o comando:

```bash
mvn clean package
```
E isso gerará o build da aplicação na pasta **target** com o nome _api-cars-0.0.1-SNAPSHOT_

## Execução via Docker
Após realizar o build da aplicação, abra o seu terminal ou prompt e execute o seguinte comando para gerar a imagem do projeto:

```bash
docker build -t atlantico/api-cars .
```
E em seguida para criar e executar o container execute o seguinte comando:
```bash
docker run -p 8080:8080 atlantico/api-cars
```
## Documentação da API com Swagger
Com a aplicação sendo executada na porta 8080, acesse a url:
```
http://localhost:8080/swagger-ui.html
```
Com essa interface poderá visualizar e testar os endpoints criados
