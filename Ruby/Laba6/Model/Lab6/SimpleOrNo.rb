class SimpleOrNo

  def SimpleOrNo.check(n)
    i = 2
    while i <= n/i
      if n % i == 0
        return false
      end
      i += 1
    end
    return true
  end

end