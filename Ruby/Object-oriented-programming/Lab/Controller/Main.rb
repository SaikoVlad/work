require_relative "../../Lab/Model/Entity/Abstracts/Toy"
require_relative "../../Lab/Model/Entity/Garland"
require_relative "../../Lab/Model/Entity/Lights"
require_relative "../../Lab/Model/Entity/StuffedToys"
require_relative "../../Lab/Model/Entity/Container/Tree"
require_relative "../../Lab/View/Output"
require_relative "../../Lab/Model/Logic/Sort"
require_relative "../../Lab/Model/Logic/Search"
require_relative "../../Lab/Model/Logic/File"
require_relative "../../Lab/Model/Entity/Collections/Stack/stack_impl"
require_relative "../../Lab/Model/Entity/Collections/Stack/linked_stack"
require_relative "../../Lab/Model/Entity/Collections/Queue/queue_impl"


class Main

  def main_method

    # stuff = StuffedToys.new(4.3,1.2,3.4,"star","male",18)
    # garland = Garland.new(1.4,2.1,4.4,12,77,"stars")
    # lights = Lights.new(3.3,5.43,65,345,663,900)
    # tree = Tree.new(a = [stuff,garland,lights])
    # puts tree

    # tree = Tree.get_instance TypeOfToy::GARLAND
    # puts tree.to_s

    stack = LinkedStack.new
    stack.push 2
    puts stack




  end



  # def write_file(file_name,tree)
  #   file = File.new file_name, 'a+'
  #   file.puts tree.to_s
  #   file.close
  # end

end





main = Main.new
main.main_method