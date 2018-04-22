class Queue
  @indexer = 0
  @queue = []

  def add(new_element)
    @queue[@indexer] = new_element
    @indexer += 1
  end

  def to_s
    final_string = "Queue"

  end


  private
  @alphabet = "abcdefghijklmnopqrstvuwxyzABCDEFGHIKLMNOPQRSTVWXYZ".split ''
  @i = 0
  @map = @alphabet.each do |x| {
   @map[i] => x
   i+=1
  }
  end



end

class Element
  def initialize(prev_element, next_element)
    @prev_element = prev_element
    @next_element = next_element
  end
end
