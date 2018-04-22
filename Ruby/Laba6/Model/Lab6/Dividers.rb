class Dividers
  def Dividers.finder(value)
    count = 0
    i = 1
    while i <= value
      if value%i == 0
        count += 1
      end
      i += 1
    end
    return count

  end
end