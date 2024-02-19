package pl.pabianczyklukasz.project;

import lombok.AllArgsConstructor;

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

   public void findGameByName(String name) {
       System.out.println(gameRepository.findGameByName(name));
   }

   public void readAllGames(GameRepository gameRepository) {
       System.out.println(gameRepository.readAllGames());
   }


}
