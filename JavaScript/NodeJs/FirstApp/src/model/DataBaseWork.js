const mysql = require('mysql');

const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '0',
    database: 'ItNews',

    port: 3306
});
connection.connect();

var selectById = function (id) {
    // var obj = {
    //     title: connection.createQuery("SELECT title FROM Articles WHERE id = " + id + ";", function (error, result) {return result;}),
    //     content: connection.createQuery("SELECT content FROM Articles WHERE id = " + id + ";")
    // };
    // return obj;
    var title = connection.createQuery("SELECT title FROM Articles WHERE id = " + id + ";", function (error, result) {return result;})
    var content = connection.createQuery("SELECT content FROM Articles WHERE id = " + id + ";")
    return content;
};

module.exports.selectById = selectById;