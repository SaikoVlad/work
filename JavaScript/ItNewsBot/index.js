import TelegramBot from 'node-telegram-bot-api'
import config from 'config'
var data = require('./dataCheck');
// import {selectByType, news} from "./dataCheck";
const TOKEN = config.get('token');
const bot = new TelegramBot(TOKEN, {polling: true});




bot.onText(/\/alive/, (msg) =>{
   const {chat: {id}} = msg;
   bot.sendMessage(id, "I am alive");
});

bot.onText(/\/help (.+)/, (msg, [source,match]) =>{
    const {chat: {id}} = msg;
    bot.sendMessage(id,match)
});

bot.onText(/\/newslist/, (msg)=>{
   const {chat: {id}} = msg;
   bot.sendMessage(id,data.news().toString());
});

bot.onText(/\/news/, (msg, [source, match])=>{
    const {chat: {id}} = msg;
    bot.sendMessage(id, data.selType(match.toString()).toString());
});
