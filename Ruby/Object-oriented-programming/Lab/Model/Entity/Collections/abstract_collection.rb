require_relative "cng_interface"
class AbstractCollection < CngInterface

  def add_all(array)
    array.each do |element|
      add element
    end
  end


  def add(element)
  end

  def clear
  end

  def contains(object)
  end

  def empty?
     size == 0
  end

  def size
  end

  def to_array
  end
end