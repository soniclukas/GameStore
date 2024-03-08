package pl.pabianczyklukasz.project.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import pl.pabianczyklukasz.project.repositories.GameRepository;

@AllArgsConstructor

public class Employee {
   private GameRepository gameRepository;

   public void sellGame(Game game, Client client){
       gameRepository.removeGame(game);
       client.addGame(game);
   }

   public void addGame(Game game) {
       //gameRepository.addGame(game);
   }

   public void updateGame(String oldName, String newName) {
       gameRepository.updateGame(oldName, newName);
   }

   public Game findGameByName(String name) {
       return gameRepository.findGameByName(name);
   }

   public List<Game> readAllGames(GameRepository gameRepository) {
       return gameRepository.readAllGames();
   }


}
