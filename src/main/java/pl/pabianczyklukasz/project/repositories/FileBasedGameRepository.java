package pl.pabianczyklukasz.project.repositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import pl.pabianczyklukasz.project.domain.Game;
import pl.pabianczyklukasz.project.domain.Publisher;
import pl.pabianczyklukasz.project.domain.TypeOfGame;

public class FileBasedGameRepository implements GameRepository {
    private static final String FILE_NAME = "files/games.csv";

    @Override
    public List<Game> readAllGames() {
        List<Game> listGames = new ArrayList<>();
        try {
            List<String> allLinesInFile = Files.readAllLines(Paths.get(FILE_NAME));
            for (String line : allLinesInFile) {
                String[] gamesElements = line.split(","); //line.split(",");
                Game game = Game.builder()
                        .title(gamesElements[0])
                        .yearOfRelease(Integer.parseInt(gamesElements[1]))
                        .publisher(Publisher.builder()
                                .name(gamesElements[2])
                                .build())
                        .typeOfGame(TypeOfGame.valueOf(gamesElements[3]))
                        .build();
                listGames.add(game);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listGames;
    }

    @Override
    public Game findGameByName(String name) {
        List<Game> listGames = readAllGames();
        try {
            for (Game game : listGames) {
                if (game.getTitle().equals(name)) {
                    return game;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Nie znaleziono gry o podanym tytule!");
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
