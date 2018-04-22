var mysql = require('mysql');
var dbResult = " ";
var connection = mysql.createConnection({
   host: 'localhost',
   user: 'root',
   password: '0',
   database: 'ItNews',
   port: 3306
});

connection.connect();
var query = connection.query("SELECT * FROM Articles ORDER BY id DESC LIMIT 2", function (error, result) {
    if (error) return;
    dbResult = JSON.stringify(result);
});

export function selectByType(type) {
    var tempquery = connection.query("SELECT content WHERE type=other FROM Articles;", function (error, result) {
       if (error) return;
       dbResult = JSON.stringify(result);
       return dbResult;
    });
}
export var news = function getNews() {
    return dbResult;
};

module.exports = news;
module.exports = selectByType;
