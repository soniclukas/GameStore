package pl.pabianczyklukasz.project.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pabianczyklukasz.project.domain.Game;
import pl.pabianczyklukasz.project.domain.Publisher;
import pl.pabianczyklukasz.project.domain.TypeOfGame;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListBasedGameRepositoryTest {
    @Test
    public void shouldReturnTwoGames() {
        //Given - przygotowania do testu
        var repository = new ListBasedGameRepository();
        repository.addGame(new Game("Sims", 2010, new Publisher("EA"), TypeOfGame.SIMULATION));
        repository.addGame(new Game("Fifa 12", 2011, new Publisher("EA"), TypeOfGame.SIMULATION));

        //When - to co testujemy(max 2 linijki), najpierw uzupelniac when
        List<Game> expected = repository.readAllGames();

        //Then
        assertEquals(2, expected.size());
    }

    @Test
    public void shouldReturnGameIfTitleEqualsGameTitleSearched() {
        //Given
        var repository = new ListBasedGameRepository();
        repository.addGame(new Game("Sims", 2010, new Publisher("EA"), TypeOfGame.SIMULATION));
        repository.addGame(new Game("Fifa 12", 2011, new Publisher("EA"), TypeOfGame.SIMULATION));
        //When
        var actual = repository.findGameByName("Sims");
        //Then
        assertEquals("Sims", actual.getTitle());
    }

    @Test
    public void shouldThrowExceptionIfGameTitleSearchedDoesntExist() {
        //given
        var repository = new ListBasedGameRepository();
        repository.addGame(new Game("Sims", 2010, new Publisher("EA"), TypeOfGame.SIMULATION));
        repository.addGame(new Game("Fifa 12", 2011, new Publisher("EA"), TypeOfGame.SIMULATION));
        //when
        var actual = "Gta 6";
    //then
        assertThrows(IllegalArgumentException.class,
                () -> repository.findGameByName(actual));
    }



    @Test
    public void shouldCheckIfGameExists() {
        //Given
        var repository = new ListBasedGameRepository();
        repository.addGame(new Game("Sims", 2010, new Publisher("EA"), TypeOfGame.SIMULATION));
        repository.addGame(new Game("Fifa 12", 2011, new Publisher("EA"), TypeOfGame.SIMULATION));
        //When
        boolean existenceOfTheGame = repository.doesThisGameExist(
                new Game("Fifa 12", 2011, new Publisher("EA"), TypeOfGame.SIMULATION));
        //Then
        assertTrue( existenceOfTheGame);
    }

    @Test
    public void shouldCheckIfGameDoesntExist() {
        //given
        var repository = new ListBasedGameRepository();
        repository.addGame(new Game("Sims", 2010, new Publisher("EA"), TypeOfGame.SIMULATION));
        repository.addGame(new Game("Fifa 12", 2011, new Publisher("EA"), TypeOfGame.SIMULATION));
        //when
        boolean existenceOfTheGame = repository.doesThisGameExist(
                new Game("Gta 6", 2025, new Publisher("Rockstar"), TypeOfGame.ACTION));
        //then
        assertFalse(existenceOfTheGame);
    }

}