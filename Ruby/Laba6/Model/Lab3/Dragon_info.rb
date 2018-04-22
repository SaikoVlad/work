class DragonInfo

  def DragonInfo.heads_and_eyes(age)
    if age < 1
      return "Incorrect age!"
    elsif age < 201 and age > 0
      return "Heads: #{age * 3}\nEyes: #{age * 6}"
    elsif age < 301 and age > 200
      return "Heads: #{age * 3 + (age - 200) * 2}\nEyes: #{200*6 + (age - 2000) * 4}"
    else
      return "Heads: #{200 * 3 + 100 * 2 + (age - 300)}\nEyes: #{200 * 6 + 100 * 4 + (age - 300) * 2}"
    end


  end

end