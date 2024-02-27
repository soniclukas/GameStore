package pl.pabianczyklukasz.project;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor

public class Employee {
   private GameRepository gameRepository;

   public void sellGame(Game game, Client client){
       gameRepository.removeGame(game);
       client.addGame(game);
   }

   public void addGame(Game game) {
       gameRepository.addGame(game);
   }

   public void updateGame(String oldName, String newName, Game game) {
       gameRepository.updateGame(oldName, newName, game);
   }

   public Game findGameByName(String name) {
       return gameRepository.findGameByName(name);
   }

   public List<Game> readAllGames(GameRepository gameRepository) {
       return gameRepository.readAllGames();
   }


}
