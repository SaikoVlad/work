const express  = require("express");
const data = require('./src/model/DataBaseWork');
const app = express();

app.set('view engine', 'ejs');

app.get('/', function (request, response) {
   response.send('Home page');
});

app.get("/news/:id", function (request, response) {
    var object = data.selectById(request.params.id);
    response.render('news', {article: object});
});

app.listen(3001);