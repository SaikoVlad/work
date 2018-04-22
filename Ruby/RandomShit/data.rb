require 'weather-api'

class Data
  def Data.understanding
    array = ["Hm, i can't understand you, friend","Hm, strange command","Please, be attentive with your commands"]
    index = rand(array.length)
    return array[index]
  end

  def Data.get_weather
    response = Weather.lookup_by_location 'Belarus, Minsk', Weather::Units::CELSIUS #(9830, Weather::Units::CELSIUS)
    return "#{response.title}\n#{response.condition.temp} degrees\n#{response.condition.text}"

  end

end
