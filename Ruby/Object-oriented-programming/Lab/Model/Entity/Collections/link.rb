class Link

  attr_accessor :element, :next_node, :prev_node

  def initialize(value, prev, next_element)
    @element = value
    @next_node = next_element
    @prev_node = prev
  end






end