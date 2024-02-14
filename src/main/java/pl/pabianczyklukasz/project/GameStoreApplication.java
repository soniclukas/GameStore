package pl.pabianczyklukasz.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class GameStoreApplication {
	public static void main(String[] args) {
//		SpringApplication.run(GameStoreApplication.class, args);
		//System.out.println("Hello Store project!");
		var game1 = new Game("Grand Theft Auto", 2025, new Publisher(), TypeOfGame.ACTION);
		var game2 = new Game("The Sims", 2000, new Publisher(), TypeOfGame.SIMULATION);
		GameRepository gamesRepository = new ListBasedGameRepository();
		gamesRepository.addGame(game1);
		//gamesRepository.addGame(game2);
		System.out.println(gamesRepository.readAllGames());
		System.out.println(gamesRepository.isThisGameInRepository(game2));


	}
}
