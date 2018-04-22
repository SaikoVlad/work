class PerfectOrNo
  def PerfectOrNo.solver(n)
    sum = 0
    i = 1
    while i < n
      sum += i
      i += 1
    end
    if sum == n
      return true
    else
      return false
    end

  end
end