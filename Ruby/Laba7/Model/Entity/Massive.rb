class Massive

  def initialize(rows, columns, matrix)
    @rows, @columns, @matrix = rows, columns, matrix
  end

  attr_reader :rows, :columns, :matrix

  def is_empty?
    @matrix.empty?
  end

  def to_s
    s = ""
    @matrix.each_index {|i|
      @matrix[i].each_index{|j|
        s += @matrix[i][j].to_s + "\t"
      }
      s += "\n"
    }
    return s
  end

end