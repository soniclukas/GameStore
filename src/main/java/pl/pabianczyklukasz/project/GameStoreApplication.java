package pl.pabianczyklukasz.project;

import java.io.IOException;
import pl.pabianczyklukasz.project.domain.Game;
import pl.pabianczyklukasz.project.domain.Publisher;
import pl.pabianczyklukasz.project.domain.TypeOfGame;
import pl.pabianczyklukasz.project.repositories.GameRepository;
import pl.pabianczyklukasz.project.repositories.ListBasedGameRepository;

//@SpringBootApplication
public class GameStoreApplication {
	public static void main(String[] args) throws IOException {
		Game game1 = new Game("Grand Theft Auto 6", 2025, new Publisher("Rockstar Games"), TypeOfGame.ACTION);
		var game2 = new Game("Sims", 2020, new Publisher("EA"), TypeOfGame.SIMULATION);
		GameRepository gameRepository = new ListBasedGameRepository();
		gameRepository.addGame(game1);
		gameRepository.addGame(game2);
		gameRepository.readAllGames();
	}
}
