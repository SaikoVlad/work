class UserInput

  def UserInput.input_mas(rows,columns)
    a=Array.new(rows).map!{Array.new(columns)}
    (0...rows).each do |i|
      a[i] = []
      (0...columns).each do |j|
        print "[#{i}, #{j}] = "
        a[i][j] = gets.chomp.to_i
      end
    end
    return a
  end

end