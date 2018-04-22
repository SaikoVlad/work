require_relative "../../../Lab/Model/Entity/Abstracts/Toy"
class Garland < Toy

  def initialize(price, weight, size, length, count_of_elements, elements)
    super(price, weight, size)
    @length, @count_of_elements, @elements = length, count_of_elements, elements
  end

  attr_accessor :length, :countOfElements, :elements

  def to_s
    Garland.name + super + "\nLength = " + @length.to_s + "\nCount of elements = " + @count_of_elements.to_s + "\nElement = " + @elements.to_s
  end

end