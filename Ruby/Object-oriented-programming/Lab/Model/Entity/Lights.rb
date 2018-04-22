require_relative "../../../Lab/Model/Entity/Abstracts/Toy"

class Lights < Toy


  def initialize(price, weight, size, life_time, usual_temp, colorful_temperature)
    super(price, weight, size)
    @life_time, @usual_temp, @colorful_temperature = life_time, usual_temp, colorful_temperature
  end

  attr_accessor :life_time, :usual_temp, :colorful_temperature

  def to_s
    Lights.name + super + "\nLife time = " + @life_time.to_s + "\nUsual temp = " + @usual_temp.to_s + "\nColorful temperature = " + @colorful_temperature.to_s
  end

end
