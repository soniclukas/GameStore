package pl.pabianczyklukasz.project.repositories;

import java.io.IOException;
import pl.pabianczyklukasz.project.domain.Game;
import pl.pabianczyklukasz.project.domain.Publisher;

public interface GameRepository {
    public void readAllGames();
    public Game findGameByName(String name);
    public void addGame(Game gameToBeAdded) throws IOException;
    public void removeGame(Game gameToBeRemoved);
    public Game updateGame(String oldName, String newName);
    public boolean doesThisGameExist(Game game);
    public Game findGameByPublisher(Publisher publisher);
}
