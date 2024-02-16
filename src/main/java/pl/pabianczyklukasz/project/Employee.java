package pl.pabianczyklukasz.project;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Employee {
   private GameRepository gameRepository;

   public void sellGame(Game game, Client client){
       gameRepository.removeGame(game);
       client.addGame(game);
   }
}
