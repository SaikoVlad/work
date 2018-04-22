require 'telegram/bot'
require_relative 'data'
token = '518210585:AAG7pCaEVih1TX_VFxA3jHvu8dk_tsrt-Yw'
Telegram::Bot::Client.run(token) do |bot|
  bot.listen do |message|
    case message.text
    when '/start'
      bot.api.sendMessage(chat_id: message.chat.id, text: "Hello, #{message.from.first_name}")
      puts "#{message.from.first_name}"
    when '/help'
      bot.api.sendMessage(chat_id: message.chat.id, text: "Use this:
        \n/start - greeting
        \n/help - commands info
        \n/weather - weather forecast
        \n/joke - daily joke")
    when '/stopkill'
      exit 0
    # when '/joke'
    #   bot.api.sendMessage(chat_id: message.chat.id, text: "Joke of a day, #{message.from.second_name}: \n#{ParseJoke.get_joke.to_s}" )
    when '/weather'
      bot.api.sendMessage(chat_id: message.chat.id, text: "Your weather, #{message.from.first_name}: \n#{Data.get_weather.to_s}" )
    else
      bot.api.sendMessage(chat_id: message.chat.id, text: Data.understanding.to_s)
    end
  end
end
