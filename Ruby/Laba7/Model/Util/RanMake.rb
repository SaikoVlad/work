class RanMake

  def RanMake.maker(rows,columns, max)
    a=Array.new(rows).map!{Array.new(columns)}
    a.each_index {|i|
      a[i].each_index{|j|
        a[i][j] = Random.rand max
        print a[i][j].to_s + "\t"
      }
      puts
    }

    return a
  end

end