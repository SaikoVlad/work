class SumAndCount

  def SumAndCount.get(n)
    sum = 0
    count = 0
    while n != 0
      sum += n % 10
      n /= 10
      count += 1
    end
    return "Sum: #{sum}\nCount: #{count}"
  end

end