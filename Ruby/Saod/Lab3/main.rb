require_relative 'Queue'
class Main
  def self.main
    queue = Queue.new
    queue.add 2
    queue.add 3
    queue.add 5
    puts queue
  end
end

Main.main
