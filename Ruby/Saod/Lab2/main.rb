require_relative 'student'
class Main
  def Main.main
    s = Student.new "roman", "medvedev", "10701216", [9,9,9,9,9]
    puts s.to_s
  end
end

Main.main