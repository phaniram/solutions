class MoviesController < ApplicationController

  def show
    id = params[:id] # retrieve movie ID from URI route
    @movie = Movie.find(id) # look up movie by unique ID
    # will render app/views/movies/show.<extension> by default
  end

  def index

    @all_ratings=Movie.select('DISTINCT rating').map(&:rating)

    if(params[:ratings])
      session[:ratings]=params[:ratings]
      session[:selected_ratings]=params[:ratings].keys
    elsif(params[:commit])
      session.delete(:ratings)
      session.delete(:selected_ratings)
    end

    if(params[:sort] && params[:sort]!="")
      session[:sort]=params[:sort]
    end
    
    p_ratings  = params.has_key?(:ratings)
    p_sort     = params.has_key?(:sort)

    @movies     =[]

    if(session.has_key?(:sort) || session.has_key?(:ratings))
      if(!p_sort && !p_ratings)
        redirect_to movies_path(:sort => session[:sort] , :ratings =>session[:ratings] )
      end
    end

    if(session[:selected_ratings])
      @movies=Movie.where(:rating => session[:selected_ratings]).order(session[:sort])
    else
      @movies = Movie.order(session[:sort])
    end

    if(session.has_key?(:sort))
      if(session[:sort]=="title")
        @title_css="hilite"
      elsif session[:sort]=="release_date"
        @release_css="hilite"
      end
    end
    
  end

  def new
    # default: render 'new' template
  end

  def create
    @movie = Movie.create!(params[:movie])
    flash[:notice] = "#{@movie.title} was successfully created."
    redirect_to movies_path
  end

  def edit
    @movie = Movie.find params[:id]
  end

  def update
    @movie = Movie.find params[:id]
    @movie.update_attributes!(params[:movie])
    flash[:notice] = "#{@movie.title} was successfully updated."
    redirect_to movie_path(@movie)
  end

  def destroy
    @movie = Movie.find(params[:id])
    @movie.destroy
    flash[:notice] = "Movie '#{@movie.title}' deleted."
    redirect_to movies_path
  end

end
