require_relative "../../../../Lab/Model/Entity/Abstracts/Toy"

class Tree


  def Tree.get_instance(type_of_toy)
    if type_of_toy == TypeOfToy::GARLAND
      return Garland.new 1,1,1,1,1,1
    elsif type_of_toy == TypeOfToy::STUFFEDTOY
      return StuffedToys.new 1,1,1,1,1,1
    elsif type_of_toy == TypeOfToy::LIGHTS
      return Lights.new 1,1,1,1,1,1
    else
      puts "exception!"
    end
  end

  def initialize(mas)
    @toys = []
    @toys = mas
  end

  def get_size
    @toys.length
  end

  def get_toy_mas
    @toys
  end

  def get_toy(index)
    @toys[index]
  end

  def add(new_element)
    @toys.push(new_element)
  end

  def set_toy(new_element,index)
    @toys.insert(index,new_element)
  end

  def change_toy(new_element, index)
    @toys[index] = new_element
  end

  def get_price(index)
    @toys[index].price
  end

  def to_s
    outer = "\n"
    i = 0
    while i < @toys.length
      outer += @toys[i].to_s + "\n\n"
      i += 1
    end
    return outer
  end

end

class TypeOfToy
  GARLAND=1
  STUFFEDTOY=2
  LIGHTS=3
end
