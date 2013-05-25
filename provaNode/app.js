var http = require('http');
var express = require('express');

repo = require("./repo/mongo");

var app = express();

app.configure(
		function() {
			app.use(express.bodyParser());
			app.use(express.basicAuth("teste", "prova"));
		}
);




app.get("/produtos", repo.findAll);

app.get("/produtos/:id",repo.findById);

app.post("/produtos", repo.addProduto);

app.put("/produtos/:id", repo.alteraProduto);

app.delete("/produtos/:id", repo.apagaProduto);


http.createServer(app).listen(1337, function() {
	console.log("subindooo");
});
