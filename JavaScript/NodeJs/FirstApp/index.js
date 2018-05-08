// first http project on node.js
var http = require('http');
var fs = require('fs');
var server = http.createServer(function(request,response) {
	if (request.url === '/index' || request.url==='/'){
        response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
        var content = fs.createReadStream(__dirname + "/views/index.html", "utf8");
        content.pipe(response);
    }else{
		response.writeHead(200,{'Content-type' : 'text/planted'})
		var content = "no resolver";
		response.write(content);
	}

});

server.listen(3001, '127.0.0.1');
console.log('port 3000 is using now');
