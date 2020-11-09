package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.netology.domain.Afisha;
import ru.netology.repository.AfishaRepository;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {

  @Mock
  private AfishaRepository repository;

  @InjectMocks
  AfishaManager afishaManager;

  Afisha one = new Afisha(1, 1, "one", "action", true);
  Afisha two = new Afisha(2, 2, "two", "comedy", true);
  Afisha three = new Afisha(3, 3, "three", "horror", true);

  @BeforeEach
  public void setUp() {
    afishaManager.save(one);
    afishaManager.save(two);
    afishaManager.save(three);
  }

  @Test
  public void shouldRemoveIfExists() {
    int idToRemove = 1;
    Afisha[] returned = new Afisha[] {two, three};
    doReturn(returned).when(repository).findAll();
    doNothing().when(repository).removeById(idToRemove);
    afishaManager.removeById(idToRemove);
    Afisha[] expected = new Afisha[]{three, two};
    Afisha[] actual = afishaManager.getAll();
    assertArrayEquals(expected, actual);
    verify(repository).removeById(idToRemove);
  }

  @Test
  public void shouldNotRemoveIfNotExists() {
    int idToRemove = 4;
    Afisha[] returned = new Afisha[]{one, two, three};
    doReturn(returned).when(repository).findAll();
    doNothing().when(repository).removeById(idToRemove);
    afishaManager.removeById(idToRemove);
    Afisha[] expected = new Afisha[]{three, two, one};
    Afisha[] actual = afishaManager.getAll();
    assertArrayEquals(expected, actual);
    verify(repository).removeById(idToRemove);
  }
}
