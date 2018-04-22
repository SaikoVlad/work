class LCDandGCM

  def LCDandGCM.lcd(a,b)
    return b == 0? a: lcd(b,a % b)
  end

  def LCDandGCM.gcm(a,b)
    return (a/lcd(a,b) * b)
  end


end