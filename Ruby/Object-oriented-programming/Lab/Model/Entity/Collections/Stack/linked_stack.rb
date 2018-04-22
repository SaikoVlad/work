class LinkedStack < StackInterface

  def initialize
    @front = nil
    # @end = Link.new nil,nil,nil
    @size = 0
  end

  def size
    @size
  end

  def add(element)
    push element
  end

  def push(element)
    if @size == 0
      @front = Link.new element, nil, nil
      @end = @front
    else
      @end.next_node = Link.new element, @end, nil
      @end = @end.next_node
    end
    @size += 1
  end

  def pop
    rm = @end
    if @size == 0
      return nil
    elsif @size == 1
      @front = nil
    else
      @end = @end.prev_node
      @end.next_node = nil
    end
    @size -= 1
    return rm
  end

  def peek
    @end.element
  end


end