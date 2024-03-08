package pl.pabianczyklukasz.project;

import java.io.IOException;
import java.util.List;

public interface GameRepository {
    public void readAllGames();
    public Game findGameByName(String name);
    public void addGame(Game gameToBeAdded) throws IOException;
    public void removeGame(Game gameToBeRemoved);
    public Game updateGame(String oldName, String newName);
    public boolean doesThisGameExist(Game game);
    public Game findGameByPublisher(Publisher publisher);
}
