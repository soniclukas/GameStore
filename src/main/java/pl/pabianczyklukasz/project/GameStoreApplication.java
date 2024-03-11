package pl.pabianczyklukasz.project;

import java.io.IOException;
import pl.pabianczyklukasz.project.domain.Game;
import pl.pabianczyklukasz.project.domain.Publisher;
import pl.pabianczyklukasz.project.domain.TypeOfGame;
import pl.pabianczyklukasz.project.repositories.FileBasedGameRepository;
import pl.pabianczyklukasz.project.repositories.GameRepository;

//@SpringBootApplication
public class GameStoreApplication {
	public static void main(String[] args) throws Exception {
		Game game1 = new Game("Grand Theft Auto 6", 2025, new Publisher("Rockstar Games"), TypeOfGame.ACTION);
		var game2 = new Game("Sims", 2020, new Publisher("EA"), TypeOfGame.SIMULATION);
		GameRepository gameRepository = new FileBasedGameRepository();
		gameRepository.addGame(game1);
		gameRepository.addGame(game2);
		//System.out.println(gameRepository.readAllGames());

		System.out.println(gameRepository.findGameByName("Grand Thteft Auto 6"));
	}
}
