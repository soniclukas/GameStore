package pl.pabianczyklukasz.project.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class Client {
    private String name;
    private String surname;
    private Address address;
    private List<Game> games;

    public void addGame(Game game) {
        games.add(game);
    }
}