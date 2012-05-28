# author Cypronmaya

def palindrome?(string)
  (a=string.downcase.gsub(/\W/,'')).eql?(a.reverse)
end


def count_words(string)
  out=Hash.new
  string.downcase.scan(/[a-z]+/).each {
    |e|
    if(out.has_key?(e))
      out[e]=out[e]+1
    else
      out[e] = 1
    end
  }
  out
end