class Mood

  def Mood.solve(param)
    case param
      when 0
        return "Middle mood: ¯\\_(ー_ー )_/¯"
      when 1
        return "Good mood: ¯\\(⌒ω⌒)/¯"
      when 2
        return "Perfect mood: ╰(✯∀✯)╯"
      when 3
        return "Bad mood: /(￣︿￣)\\"
      else
        return "Very bad mood: \\(◣_◢)/"
    end
  end


end