package pl.pabianczyklukasz.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@Setter
public class Game {
    private String title;
    private int yearOfRelease;
    private Publisher publisher;
    private TypeOfGame typeOfGame;


}
