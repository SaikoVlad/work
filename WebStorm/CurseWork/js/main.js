var action = "up";
var ctx,points,pointer;
function initcnvs(){
  ctx = document.getElementById('cnvs').getContext('2d');
  ctx.globalAlpha = 0.1;
  points = new Array(10);
}
function mDown(e){
  action = "down";
  points[0] = [e.pageX, e.pageY]
  pointer = 0;
}
function mUp(e){
  points = new Array(10);
  action = "up";
}
function mMove(e) {
  if (action == "down") {
    var nextpoint = pointer + 1;
    if (nextpoint > 9) nextpoint = 0;
    ctx.beginPath();
    ctx.moveTo(points[pointer][0],points[pointer][1]);
    ctx.lineTo(e.pageX, e.pageY);
    if (points[nextpoint]) {
      ctx.moveTo(points[nextpoint][0] + Math.round(Math.random()*10-5),points[nextpoint][1] + Math.round(Math.random()*10-5));
      ctx.lineTo(e.pageX, e.pageY);
    }
    ctx.stroke();
    pointer = nextpoint;
    points[pointer] = [e.pageX, e.pageY];
  }
}
