class Reverse

  def Reverse.do(digit)
    res = 0
    while true
      if digit > 0
        res = digit % 10 + res * 10
        digit /= 10
      else
        break
      end
    end
    return res
  end

end