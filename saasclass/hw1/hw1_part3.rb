# author Cypronmaya

def combine_anagrams(words)
  arr=Array.new
  found=false
  words.each { |word|
    sortedword_downcase=word.downcase.split('').sort
    arr.each { |item|
      if(sortedword_downcase==(item[0].downcase.split('').sort))
          item.push(word)
        found=true
      end
    }
    if(!found)
      tmp=Array.new
      tmp.push(word)
      arr.push(tmp)
    end
    found=false
  }
  arr
end


