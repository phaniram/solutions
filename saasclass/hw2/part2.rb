class CartesianProduct
  include Enumerable
  def initialize(x,y)
        @x,@y=x,y
  end
  
  def each
    if(@x.size !=0 && @y.size !=0)
      @x.each { 
        |x|  
          @y.each { 
              |y|  
              tmp=Array.new
              tmp.push(x)
              tmp.push(y)
              yield tmp
            }
      }
      end
  end
end

c = CartesianProduct.new([:a,:b], [4,5])
c.each { |elt| puts elt.inspect }

c = CartesianProduct.new([:a,:b], [])
c.each { |elt| puts elt.inspect }