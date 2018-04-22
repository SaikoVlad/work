
module Init
  def initialize(rows,columns)
    @rows = rows
    @columns = columns
  end

  def random_maker(rows,columns)
    massive = [[],[]]
    for i in 0...rows
      for j in 0...columns
        massive[i][j] = rand(100)
      end
    end
    # return massive
  end

  def printer
    massive = random_maker(@rows,@columns)
    for i in 0...rows
      for j in 0...columns
        print massive[i][j]
      end
      print "\n"
    end
  end


end