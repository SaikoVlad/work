require_relative "stack_interface"
class StackImpl < StackInterface


  # private :resize

  def initialize
    @stack = []
    @size_var = 0

  end

  def size
   @size_var
  end

  def add(element)
    @stack.push element
    # push element
  end

  def push(element)
    add element
  end

  def peek
    @stack[@size_var - 1]
  end

  def pop
    object = @stack[@size_var - 1]
    @stack[@size_var] = nil
    @size_var -= 1
    return object
  end


  def add_all(array)
    array.each do |a|
      add a
    end
  end

  def clear
    @stack = nil
  end

  def contains(object)
    @stack.each do |s|
      if s == object
        return true
      end
    end
    return false
  end

  def empty?
    @stack[0] == nil
  end

  def to_array
    @stack
  end

  def to_s
    out = "content:\n"
    @stack.each do |s|
      out += "#{s}\n"
    end
    return out
  end


end