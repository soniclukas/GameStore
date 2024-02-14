package pl.pabianczyklukasz.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class GameStoreApplication {
	public static void main(String[] args) {
//		SpringApplication.run(GameStoreApplication.class, args);
		//System.out.println("Hello Store project!");
		var game1 = new Game("Grand Theft Auto", 2025, new Publisher("Rockstar Gamess"), TypeOfGame.ACTION);
		var game2 = new Game("The Sims", 2000, new Publisher("Electronics Arts"), TypeOfGame.SIMULATION);
		GameRepository gamesRepository = new ListBasedGameRepository();
		gamesRepository.addGame(game1);
		//gamesRepository.addGame(game2);
//		System.out.println(gamesRepository.readAllGames());
//		System.out.println(gamesRepository.isThisGameInRepository(game2));
		Game game3 = gamesRepository.findGameByPublisher(new Publisher("Rockstar Games"));
		System.out.println(game3.getTitle());
		gamesRepository.findGameByPublisher(new Publisher("Rockstar Games"));
	}
}
