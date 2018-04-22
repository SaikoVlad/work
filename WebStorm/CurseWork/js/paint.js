//Инициализируем переменные
var palette=document.getElementById("palette");
var canvas = document.getElementById("canvas");
var context = canvas.getContext("2d");
//Точки текущего положения курсора и предыдущего
//для рисования линия от и до
var currentPoint={x:0, y:0},
    previousPoint={x:0, y:0}
//флаг, указывающий зажата-ли кнопка мыши
var isMousePressed = false;
//цвет по-умолчанию
var color = "#FFFF00";

//вешаем обработчики на кнопки
$("#clear").click(clear);
$("#save").click(save);

//переменные для рисования
context.lineCap="round";
context.lineWidth = 8;

//генерируем палитру
//в итоге 5^3 цветов = 125
for(var r=0, max=4; r<=max; r++){
    for(var g=0; g<=max; g++){
        for(var b=0; b<=max; b++){
            palette.innerHTML+="<div class='button' onclick='setColor(this)' style='background:rgb("+
                    Math.round(r*255/max)+", "+
                    Math.round(g*255/max)+", "+
                    Math.round(b*255/max)+")'></div>";
        }
        palette.innerHTML+="<br>";
    }

}
//функция рисования линии
function draw() {
    //рисует только если зажата кнопка
    if (isMousePressed) {
        context.beginPath();
        context.strokeStyle = color;
        context.moveTo(previousPoint.x, previousPoint.y);
        context.lineTo(currentPoint.x, currentPoint.y);
        context.stroke();
        context.closePath();
    }
    //обновить переменную предыдущего положения курсора
    previousPoint={x:currentPoint.x, y:currentPoint.y};
}
//срабатывает при клике на цвет в палитре
function setColor(objColor){
    color=objColor.style.backgroundColor;
}
canvas.onmousedown=function(){
    console.log(e);
    setCoords(event.offsetX,event.offsetY)
    draw();
    isMousePressed = true;
}
document.body.onmouseup=function(){
    isMousePressed = false;
}
canvas.onmousemove=function(){
    setCoords(event.offsetX,event.offsetY)
    if(isMousePressed)
        draw();
}
function save(){
    window.open(canvas.toDataURL('image/png'), 'new_window');
}
function clear(){
    context.clearRect(0,0,canvas.width, canvas.height);
}
function setCoords(x,y){
    currentPoint={x:x, y:y};
}
