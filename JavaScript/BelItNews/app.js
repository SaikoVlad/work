import TelegramBot from 'node-telegram-bot-api'
import config from 'config'
var data = require('./dataCheck');
import {selectByType, news} from "./dbutil";

const TOKEN = config.get('token');
const bot = new TelegramBot(TOKEN, {polling: true});

bot.onText(/\/alive/, (msg, [source,match]) =>{
   const {chat: {id}} = msg;
   bot.sendMesage(id, "I am alive");
});

bot.onText(/\/help (.+)/, (msg, [source,match]) =>{
    const {chat: {id}} = msg;
    bot.sendMessage(id,match)
});

bot.onText(/\/newslist/, (msg)=>{
   const {chat: {id}} = msg;
   bot.sendMessage(id,news().toString());
});

bot.onText(/\/news/, (msg, [source, match])=>{
    const {chat: {id}} = msg;
    bot.sendMessage(id, selectByType(match.toString()).toString());
});
