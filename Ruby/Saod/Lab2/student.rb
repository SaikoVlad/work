class Student

  def initialize(name, surname,group, progress)
    @name, @surname, @group, @progress = name, surname, group, progress
  end

  def to_s
    "Name: #{@name}\nSurname: #{@surname}\nGroup: #{@group}\nProgress: #{@progress.to_s}"
  end

end