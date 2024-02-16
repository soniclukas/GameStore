package pl.pabianczyklukasz.project;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@Setter
@Builder
@EqualsAndHashCode
public class Game {
    private String title;
    private int yearOfRelease;
    private Publisher publisher;
    private TypeOfGame typeOfGame;
}
