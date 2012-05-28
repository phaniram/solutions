# author Cypronmaya

class WrongNumberOfPlayersError < StandardError ; end
class NoSuchStrategyError < StandardError ; end
def rps_game_winner(game)
  raise WrongNumberOfPlayersError unless game.length == 2
  raise NoSuchStrategyError unless ["r","p","s"].include?(str1=game[0][1].downcase) && ["r","p","s"].include?(str2=game[1][1].downcase)
  if(str1==str2 || ["rs","sp","pr"].include?(str1+str2))
    game[0]
  else
    game[1]
  end
end

def rps_tournament_winner (game)
 if !game[0][0].is_a?(String)
        return rps_tournament_winner([rps_tournament_winner(game[0]), rps_tournament_winner(game[1])])
    else
        return rps_game_winner game
    end
end
