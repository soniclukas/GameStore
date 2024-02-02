package pl.pabianczyklukasz.project;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Game {
    private String title;
    private int yearOfRelease;
    private Publisher publisher;
    private TypeOfGame typeOfGame;


}
