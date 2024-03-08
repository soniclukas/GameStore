package pl.pabianczyklukasz.project.repositories;

import java.util.ArrayList;
import java.util.List;
import pl.pabianczyklukasz.project.domain.Game;
import pl.pabianczyklukasz.project.domain.Publisher;

public class ListBasedGameRepository implements GameRepository {
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
    public Game updateGame(String oldName, String newName) {
        Game gameByName = findGameByName(oldName);
        if (gameByName != null && !gameByName.getTitle().equals(newName)){
            gameByName.setTitle(newName);
       } else {
           throw new IllegalArgumentException("Już istnieje taka nazwa gry!");
       }
       return gameByName;
    }

    @Override
    public boolean doesThisGameExist(Game game) {
        return games.contains(game);
        //metoda contains uzywa kontraktu hashcode i equals.
        //to znaczy, ze klasa tzn. typ tego obiektu powinien nadpisywać hashcode i equals.

    }

    @Override
    public Game findGameByPublisher(Publisher publisher) throws IllegalArgumentException{
        for (Game game : games) {
            if (game.getPublisher().equals(publisher)) {
                return game;
            }
        }
//        return null; bo nie powinnismy zwracac nigdy nulla, bo może rzucic nullPointerException
     //   return null;
     throw new IllegalArgumentException("Nie ma gier z takim wydawcą: " + publisher.getName());
        //jesli metoda zwraca nulla, a my uzyjemy tej metody, wyciagniemy jej wynik do zmiennej neie wiedzac ze ona zwraca nulla
        //to wtedy gdy na tej zmiennewj wywolamy jakas metode to poleci nPE
        //return Game.builder().build();
    }
}
