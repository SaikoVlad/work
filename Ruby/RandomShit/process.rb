require 'telegram/bot'
require_relative 'data'
require_relative 'parseJoke'
token = '518210585:AAG7pCaEVih1TX_VFxA3jHvu8dk_tsrt-Yw'
Telegram::Bot::Client.run(token) do |bot|
  bot.listen do |message|
    case message.text
      when '/start'
        bot.api.sendMessage(chat_id: message.chat.id, text: "Hello, #{message.from.first_name}")
        puts "#{message.from.first_name}"
      when '/joke'
        bot.api.sendMessage(chat_id: message.chat.id, text: "Joke of a day, #{message.from.first_name}: \n#{ParseJoke.get_joke.to_s}" )
      when 'bye'
        exit 0
      when '/help'
        bot.api.sendMessage(chat_id: message.chat.id, text: "Use this:
        \n/start - greeting
        \n/help - commands info
        \n/weather - weather forecast
        \n/joke - daily joke")
      when '/weather'
        bot.api.sendMessage(chat_id: message.chat.id, text: "Your weather, #{message.from.first_name}: \n#{Data.get_weather.to_s}" )
      else
        bot.api.sendMessage(chat_id: message.chat.id, text: "You stupid, #{message.from.first_name}!" )
    end
  end
end
