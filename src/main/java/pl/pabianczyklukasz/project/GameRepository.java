package pl.pabianczyklukasz.project;

import java.util.List;

public interface GameRepository {
    public List<Game> readAllGames();
    public Game findGameByName(String name);
    public void addGame(Game gameToBeAdded);
    public void removeGame(Game gameToBeRemoved);
    public Game updateGame(String oldName, String newName, Game game);
    public boolean isThisGameInRepository(Game game);
}
