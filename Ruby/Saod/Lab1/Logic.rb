class Logic

  def Logic.calculate(mas_of_digits)
    @mas_of_digits = []
    @mas_of_digits = mas_of_digits
    return Logic.calc_number @mas_of_digits
  end


  private

  def Logic.calc_number(mas_of_digits)
    below, above, zero = 0,0,0
    mas_of_digits.each do |digit|
      if digit > 0
        above += 1
      elsif digit < 0
        below += 1
      else
        zero += 1
      end
    end
    s = "count: #{mas_of_digits.size}\n"
    s += "zero: #{zero}\nabove zero: #{above}\nbelow zero: #{below}"
    s += Logic.calc_percent mas_of_count = [zero,below,above], mas_of_digits.size
    return s
  end

  def Logic.calc_percent(mas_of_count, mas_of_digits)
    out_string = "\nZero elements: #{(mas_of_count[0].to_f / mas_of_digits) * 100}%"
    out_string += "\nBelow zero elements: #{(mas_of_count[1].to_f / mas_of_digits) * 100}%"
    out_string += "\nAbove zero elements: #{(mas_of_count[2].to_f/mas_of_digits) * 100}%"
  end

end
