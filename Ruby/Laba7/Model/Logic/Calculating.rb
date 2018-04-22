class Calculating

  def Calculating.min_finder(mas)
    min = mas[0][0]
    mas.each_index {|i|
      mas[i].each_index{|j|
        if mas[i][j] < min
          min = mas[i][j]
        end
      }
    }
    return min
  end

  def Calculating.max_finder(mas)
    max = mas[0][0]
    mas.each_index {|i|
      mas[i].each_index{|j|
        if mas[i][j] > max
          max = mas[i][j]
        end
      }
    }
    return max
  end

  def Calculating.verification(mas, some_value)
    count = 0
    mas.each_index {|i|
      mas[i].each_index {|j|
        if some_value == mas[i][j]
          count += 1
        end
      }
    }
    if count > 1
      return false
    else
      return true
    end
  end



  def Calculating(mas,param, rows, columns)

  end

  # public static int[][] sort(int rows, int columns, int[][] massive, int fromMin) {
  #     int temp;
  # if (fromMin > 0) {
  #     for (int i = 0; i < rows; i++) {
  #         for (int k = i + 1; k < rows; k++) {
  #             if (fromMin == 1) {
  #                 if (massive[0][i] > massive[0][k]) {
  #                     for (int j = 0; j < columns; j++) {
  #                         temp = massive[j][i];
  #                     massive[j][i] = massive[j][k];
  #                     massive[j][k] = temp;
  #                     }
  #                     }
  #                     }else{
  #                         if (massive[0][i] < massive[0][k]) {
  #                             for (int j = 0; j < columns; j++) {
  #                                 temp = massive[j][i];
  #                             massive[j][i] = massive[j][k];
  #                             massive[j][k] = temp;
  #                             }
  #                             }
  #                             }
  #                             }
  #                             }
  #                             }
  #                             return massive;
  #                             }
  #


                              end