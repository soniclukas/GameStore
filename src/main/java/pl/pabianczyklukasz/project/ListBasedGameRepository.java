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
        return null;
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
    public Game updateGame(Game game) {
        return game;
    }
}
