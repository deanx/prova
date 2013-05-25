var mongo = require("mongodb");

var Server = mongo.Server;

var Db = mongo.Db;

var server = new Server("localhost", 27017, {auto_reconnect:true});

var bson = mongo.BSONPure;

db = new Db("provawallmart", server, {safe:true});

exports.findAll = function(req, res) {
	db.collection("produtos", function(err, collection) {
		collection.find().toArray(function (err, items) {
			res.send(items);
		});
		
	});
};

exports.findById = function(req, res) {
	var id = req.params.id;
	db.collection("produtos", function(err, collection) {
		collection.findOne({'id':id}, function (err, item) {
			res.send(item);
		});
	});
};

exports.addProduto = function(req, res) {
	
	var produto = req.body;
	
	db.collection("produtos", function(err, collection) {
		collection.insert(produto, {safe:true}, function(err, result) {
			res.send(result[0]);
		});
	});
};


exports.alteraProduto = function(req, res) {
	var produto = req.body;
	var id = req.params.id;
	
	console.log(produto);
	
	db.collection("produtos", function(err, collection) {
		collection.update({"id":id}, produto, {safe:true}, function(err, result) {
			res.send(produto);
		});
	});
};

exports.apagaProduto = function(req, res) {
	var id = req.params.id;
	
	db.collection("produtos", function(err, collection) {
		collection.remove({"id":id}, {safe:true}, function(err, result) {
			res.send(req.body);
		});
	});
};