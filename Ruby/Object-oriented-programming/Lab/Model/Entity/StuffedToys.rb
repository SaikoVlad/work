require_relative "../../../Lab/Model/Entity/Abstracts/Toy"

class StuffedToys < Toy


  def initialize(price, weight, size, person, gender, age_limit)
    super(price, weight, size)
    @person, @gender, @age_limit = person, gender, age_limit
  end

  attr_accessor :person, :gender, :age_limit

  def to_s
    StuffedToys.name + super + "\nPerson = " + @person.to_s + "\nGender = " + @gender.to_s + "\nAge limit = " + @age_limit.to_s
  end

end