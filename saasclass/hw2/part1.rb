
class Numeric
  @@currencies = {'yen' => 0.013, 'euro' => 1.292, 'rupee' => 0.019 ,'dollar' => 1}
  @@from_cur_in_dollars = 1
  def method_missing(method_id)
    from_cur = method_id.to_s.gsub( /s$/, '')
    if @@currencies.has_key?(from_cur)
      @@from_cur_in_dollars=self * @@currencies[from_cur]
    end
  end
  def in(to)
    to_cur = to.to_s.gsub( /s$/, '')
    if @@currencies.has_key?(to_cur)
      to_cur_fin= (@@from_cur_in_dollars / @@currencies[to_cur])
    end
    to_cur_fin
  end
end


class String
  include Enumerable
  def palindrome?
    (a=self.downcase.gsub(/\W/,'')).eql?(a.reverse)
  end
end

module Enumerable
  def palindrome?
    if(self.is_a? Array)
      (a=self).eql?(a.reverse)
    elsif(self.is_a? Range)
      false
    elsif(self.is_a? Hash)
      true
      else li=[]
        self.each { |i| li.push(i)}
        (a=li).eql?(a.reverse)
    end
  end
end
