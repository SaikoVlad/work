class File
  def File.write_file(file_name,tree)
    file = File.new file_name, 'a+'
    file.puts tree.to_s
    file.close
  end

  def File.read_file(file_name)
    f = File.new file_name
    out = ""
    while (line = f.gets)
      out += line
    end
    f.close
    return out
  end

  def File.write_in_html(tree)
    first_half = "<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n" + "    <title>Title</title>\n" + "</head>\n" + "<body>\n";
    middle = tree.to_s
    second_half = "\n" + "</body>\n" + "</html>"
    all = first_half + middle + second_half
    write_file"Example.html", all
  end

end
