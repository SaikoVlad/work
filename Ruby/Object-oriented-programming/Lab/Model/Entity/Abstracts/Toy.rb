class Toy


  def initialize(price, weight, size)
    @price, @weight, @size = price, weight, price
  end

  attr_accessor :price, :weight, :size

  def to_s
    " Params:" + "\nPrice = " + price.to_s + "\nWeight = " + weight.to_s + "\nSize = " + size.to_s
  end

end