package pl.pabianczyklukasz.project.repositories;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
        List<String> allLinesInFile = new ArrayList<>();
        List<Game> listGames = new ArrayList<>();
        try {
            allLinesInFile = Files.readAllLines(Paths.get(FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        return listGames;
    }

    @Override
    public Game findGameByName(String name) {
        try {
            List<Game> games = readAllGames();
            for (Game game : games) {
                if (game.getTitle().equals(name)) {
                    return game;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Nie znaleziono gry o podanym tytule: " + name + "!");
    }

    @Override
    public void addGame(Game gameToBeAdded) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            var game = String.format("%s,%d,%s,%s%n",
                    gameToBeAdded.getTitle(),
                    gameToBeAdded.getYearOfRelease(),
                    gameToBeAdded.getPublisher().getName(),
                    gameToBeAdded.getTypeOfGame());
            bf.write(game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeGame(Game gameToBeRemoved) {
        List<Game> games = readAllGames();
        games.remove(gameToBeRemoved);
    }

    @Override
    public Game updateGame(String oldName, String newName) {
        return null;
    }


    @Override
    public boolean doesThisGameExist(Game game) {
        List<Game> games = readAllGames();
        return games.contains(game);
    }

    @Override
    public Game findGameByPublisher(Publisher publisher) {
        List<Game> listGames = readAllGames();
        for (Game game : listGames) {
            if (game.getPublisher().equals(publisher)) {
                return game;
            }
        }
        throw new IllegalArgumentException("Nie ma gry z takim wydawcą: " + publisher.getName() + "!");
    }
}
