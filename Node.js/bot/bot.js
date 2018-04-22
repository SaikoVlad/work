//bot javascript!!!
var VK = require("VK-Promise"),
  vk = new VK("6272946");

vk.init_longpoll();
vk.on("message", function (event, msg) {
  var sms = msg.body.split(" ");
  if (sms[0] == '\tt' && sms[1] == '1'){
    msg.send("MSG:\n" + sms[0] + " " + sms[1]);
  }
  if (msg.body == '/test'){
    msg.send("ok!");
  }
  if (msg.action == "chat_kick_user"){
    msg.send("Bye bye!");
  }
})
