require 'nokogiri'
require 'open-uri'

class ParseJoke
  def ParseJoke.get_joke
    return ParseJoke.get_html "http://jokes.cc.com/"
  end

  private

  def ParseJoke.get_html (url)

    html = open url
    doc = Nokogiri::HTML html

    doc.css('.middle').map do |iterator|
      maintext = iterator.at_css('.fulltext').text
      return maintext

    end

  end

end

# ParseJoke.get_joke