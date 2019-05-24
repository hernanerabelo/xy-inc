# xy-inc
Aplicação para testes de GPS
# Configuração
- Editar arquivo application.properties para alterar configurações da aplicação.

##Serviços
Segue os principais serviços criados
#####Criar POI
- Para cadastrar um ponto de interesse execute:<br>
<code>POST http://localhost:8080/poi</code>
<br>
Body:
<code>
{
	"x":1,
	"y":0,
	"name": "teste"
}
</code>

#####Listar todos os POIs usando Page
- Para listar todos pontos de interesse utilizando paginação execute:<br>
<code>GET http://localhost:8080/poi</code>

#####Listar todos os POIs
- Para listar todos pontos de interesse execute:<br>
<code>GET http://localhost:8080/poi</code>


#####Listar todos os POIs por proximidade
- Para listar todos pontos de interesse por proximidade execute:<br>
<code>GET http://localhost:8080/poi/near?x=1&y=2&dist=10</code>

#####Inserir alguns valores no banco de dados
- Para inserir alguns valores no banco de dados execute:<br>
<code>GET http://localhost:8080/poi/near?x=1&y=2&dist=10</code>