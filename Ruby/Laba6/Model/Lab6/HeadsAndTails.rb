class HeadsAndTails

  public
  def HeadsAndTails.solver(max)

    tails = 0

    i = 0
    while i < max
      result = Random.rand 2
      if result == 0
        tails += 1
      end
      i += 1
    end
    return "Heads: #{max - tails}\nTails: #{tails}"

  end

end