require_relative "../../../Lab/Model/Entity/Abstracts/Toy"

class Search

  def Search.find_by_price(tree, price)
    i = 0
    while i < tree.get_size
      if tree.get_toy(i).price == price
        return "That's our toy with this price #{price}:\n" +  tree.get_toy(i).to_s
      end
      i += 1
    end
    return "No one with this price"
  end

  def Search.find_by_weight(tree, weight)
    i = 0
    while i < tree.get_size
      if tree.get_toy(i).weight == weight
        return "That's our toy with this weight #{weight}:\n" +  tree.get_toy(i).to_s
      end
      i += 1
    end
    return "No one with this weight"
  end

  def Search.find_by_size(tree, size)
    i = 0
    while i < tree.get_size
      if tree.get_toy(i).size == size
        return "That's our toy with this size #{size}:\n" +  tree.get_toy(i).to_s
      end
      i += 1
    end
    return "No one with this size"
  end

end