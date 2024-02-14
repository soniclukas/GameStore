package pl.pabianczyklukasz.project;

import java.util.ArrayList;
import java.util.List;

public class ListBasedGameRepository implements GameRepository{
    private List<Game> games = new ArrayList<>();

    @Override
    public List<Game> readAllGames() {
        return games;
    }

    @Override
    public Game findGameByName(String name) {
        for(Game game : games) {
            if(game.getTitle().equals(name)) {
                return game;
            }
        }
        throw new IllegalArgumentException("Nie ma gry o takiej nazwie " + name);
    }

    @Override
    public void addGame(Game gameToBeAdded) {
        games.add(gameToBeAdded);
    }

    @Override
    public void removeGame(Game gameToBeRemoved) {
    games.remove(gameToBeRemoved);
    }

    @Override
    public Game updateGame(String oldName, String newName, Game game) {
       if (findGameByName(oldName) != null && !game.getTitle().equals(newName)){
            game.setTitle(newName);
       } else {
           throw new IllegalArgumentException("Już istnieje taka nazwa gry!");
       }
       return game;
    }

    @Override
    public boolean isThisGameInRepository(Game game) {
        if(games.contains(game)) {
            return true;
        }
        throw new IllegalArgumentException("Nie ma takiej gry w repozytorium!");
    }
}
