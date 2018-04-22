var mysql = require('mysql');
var dbResult = " ";
var connection = mysql.createConnection({
   host: 'localhost',
   user: 'root',
   password: '0',
   database: 'ItNews',
   port: 3304
});

connection.connect();

var query = connection.query("SELECT * FROM Articles ORDER BY id DESC LIMIT 2", function (error, result) {
    if (error) return;
    dbResult = JSON.stringify(result);
});

var selType = function selectByType(type) {
    var tempquery = connection.query("SELECT * FROM Articles WHERE id=7;", function (error, result) {
       if (error) return;
       dbResult = JSON.stringify(result);
       console.log(dbResult);
       return dbResult;
    });
};
var news = function getNews() {
    return dbResult;
};

module.exports.news = news;
module.exports.selType = selType;
