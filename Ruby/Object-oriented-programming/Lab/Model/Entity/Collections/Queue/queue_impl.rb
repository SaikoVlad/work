require_relative "../../../../../Lab/Model/Entity/Collections/Queue/queue_interface"
class QueueImpl < QueueInterface

  def initialize
    @queue = []
    @size_var = 0
    @queue_array_size = 4
  end

  def enqueue(element)
    @queue.push element
  end


  def add(element)
    enqueue element
  end

  def add_all(array)
    array.each do |x|
      enqueue x
    end
  end


  def contains(object)
    @queue.each do |x|
      if x == object
        return true
      end
    end
    return false
  end

  def dequeue
    object = @queue[0]
    temp = []
    i = 0
    while i < @queue.length - 1
      temp.push @queue[i]
    end
    @size_var -= 1
    @queue = temp
    return object
  end

  def empty?
    @queue[0] == nil
  end

  def peek
    @queue[0]
  end

  def size
    @size_var
  end

  def to_array
    @queue
  end

  def to_s
    out = "content:\n"
    @queue.each do |x|
      out += "#{x}\n"
    end
    return out
  end

end