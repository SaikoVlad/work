require 'nokogiri'
require 'open-uri'

class Parse

  def google_page
    url = "http://meteoinfo.by/5/?city=26850"
    html = open(url)
    doc = Nokogiri::HTML(html)
    return doc
  end

  def works

  end


end


p = Parse.new

puts p.google_page
