package pl.pabianczyklukasz.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
public class GameStoreApplication {
	public static void main(String[] args) throws IOException {
		Game game1 = new Game("Grand Theft Auto 6", 2025, new Publisher("Rockstar Games"), TypeOfGame.ACTION);
		GameRepository gameRepository = new ListBasedGameRepository();
		gameRepository.addGame(game1);
		System.out.println(gameRepository.readAllGames());
	}
}
