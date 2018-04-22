require '../Model/Util/RanMake'
require '../Model/Util/UserInput'
require '../Model/Entity/Massive'
require '../Model/Logic/Calculating'

class MainClass

  def MainClass.main

    puts "Input rows"
    rows = gets.to_i
    puts "Input columns"
    columns = gets.to_i
    mas = RanMake.maker rows, columns,100
    puts "\n\n"


    massif = Massive.new rows, columns, mas
    # puts Calculating.min_finder massif.matrix
    # puts Calculating.max_finder massif.matrix
    # puts Calculating.verification(massif.matrix, Calculating.max_finder(mas))

    # puts massif.rows


  end

end

MainClass.main