class VowelOrConsonant
  def VowelOrConsonant.solver(letter)
    if letter.length > 1
      return "incorrect letter"
    end
    mas_of_vowel = ['a','e','y','u','i','o']
    for i in mas_of_vowel
      if i == letter
        return "It's vowel"
      end
    end
    return "It's consonant"
  end
end