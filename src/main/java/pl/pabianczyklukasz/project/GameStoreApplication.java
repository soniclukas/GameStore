package pl.pabianczyklukasz.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
public class GameStoreApplication {
	public static void main(String[] args) {
//		SpringApplication.run(GameStoreApplication.class, args);
		//System.out.println("Hello Store project!");
		var game1 = new Game("Grand Theft Auto", 2025, new Publisher("Rockstar Games"), TypeOfGame.ACTION);
		var game2 = new Game("The Sims", 2000, new Publisher("Electronics Arts"), TypeOfGame.SIMULATION);
GameRepository gamesRepository = new ListBasedGameRepository();
//		gamesRepository.addGame(game1);
//		//gamesRepository.addGame(game2);
////		System.out.println(gamesRepository.readAllGames());
////		System.out.println(gamesRepository.isThisGameInRepository(game2));
//		Game game3 = gamesRepository.findGameByPublisher(new Publisher("Rockstar Games"));
//		System.out.println(game3.getTitle());
//		gamesRepository.findGameByPublisher(new Publisher("Rockstar Games"));
//
//		System.out.println("=========== sprzedaz gry ===========");
//		var emploee = new Employee(gamesRepository);
//		Client clientLukasz = new Client("Lukasz", "safd",
//				new Address(1, 2), new ArrayList<>());
//		System.out.println("Repozytorium gier przed sprzedażą: ");
//		System.out.println(gamesRepository.readAllGames());
//		System.out.println("Klient przed sprzedażą: ");
//		System.out.println(clientLukasz);
//
//		emploee.sellGame(game3, clientLukasz);
//
//		System.out.println("Repozytorium gier po sprzedaży: ");
//		System.out.println(gamesRepository.readAllGames());
//		System.out.println("Klient po sprzedaży: ");
//		System.out.println(clientLukasz);

		var employee = new Employee(gamesRepository);
		employee.addGame(game1);

		employee.findGameByName("Grand Theft Auto");

		employee.readAllGames(gamesRepository);

		Client client = new Client("Lukasz", "Pabianczyk", new Address(1,2), new ArrayList<>());
		List<Client> clients = new ArrayList<>();
		clients.add(client);

		Store store = new Store("Juhu", new Address(1,2), clients);
		store.updateClient("Lukasz", "Pabianczyk", "Nikodem", "Nowak", client);


		System.out.println(store.readAllClients());
	}
}
