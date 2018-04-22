require_relative "../../../Lab/Model/Entity/Abstracts/Toy"
require_relative "../../../Lab/Model/Entity/Container/Tree"

class Sort

  def Sort.choice(tree)
    i = 0
    while i < tree.get_size - 1
      if tree.get_price(i) > tree.get_price(i + 1)
        temp = tree.get_toy(i+1)
        tree.change_toy(tree.get_toy(i),i + 1)
        j = i
        while j > 0 and temp.price < tree.get_price(j - 1)
          tree.change_toy(tree.get_toy(j-1), j)
          j -= 1
        end
        tree.change_toy(temp,j)
      end
      i += 1
    end
  end




  def Sort.bubble(tree)
    sorted = true
    i = tree.get_size
    j = 0
    while i > 0
      while j < i - 1
        if tree.get_price(j) > tree.get_price(j + 1)
          tmp = tree.get_toy(j)
          tree.change_toy(tree.get_toy(j + 1),j)
          tree.change_toy(tmp, j + 1)
          sorted = false
        end
        if sorted
          break
        end
        j += 1
      end
      i -=1
    end
  end


end

