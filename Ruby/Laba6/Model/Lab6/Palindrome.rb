class Palindrome



  def Palindrome.get_palindrome(pal)
    nextt = 0
    pal2 = pal
    while pal2 != 0
      nextt = (nextt * 10) + (pal2 % 10)
      pal2 /= 10
    end
    if pal == nextt
      return true
    else
      return false
    end
  end


end