package pl.pabianczyklukasz.project.repositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import pl.pabianczyklukasz.project.domain.Game;
import pl.pabianczyklukasz.project.domain.Publisher;

public class FileBasedGameRepository implements GameRepository {
  private static final String FILE_NAME = "files/games.csv";

  @Override
  public List<Game> readAllGames() {
    try {
      List<String> file = Files.readAllLines(Paths.get(FILE_NAME));
      file.forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public Game findGameByName(String name) {
    return null;
  }

  @Override
  public void addGame(Game gameToBeAdded) throws IOException {
//    String file = FILE_NAME;
//    try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
//      for(Game game : games) {
//        writer.write(String.valueOf(game));
//        writer.newLine();
//      }
//      System.out.println("Obiekt został zapisany do pliku " + file);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
  }

  @Override
  public void removeGame(Game gameToBeRemoved) {

  }

  @Override
  public Game updateGame(String oldName, String newName) {
    return null;
  }

  @Override
  public boolean doesThisGameExist(Game game) {
    return false;
  }

  @Override
  public Game findGameByPublisher(Publisher publisher) {
    return null;
  }
}
