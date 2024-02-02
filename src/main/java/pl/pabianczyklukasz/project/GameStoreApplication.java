package pl.pabianczyklukasz.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class GameStoreApplication {
	public static void main(String[] args) {
//		SpringApplication.run(GameStoreApplication.class, args);
		System.out.println("Hello Store project!");
		var game1 = new Game("Grand Theft Auto", 2025, new Publisher(), TypeOfGame.ACTION);

		System.out.println(game1);
	}
}
