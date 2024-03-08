package pl.pabianczyklukasz.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
