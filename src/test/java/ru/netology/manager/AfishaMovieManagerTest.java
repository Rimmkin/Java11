package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaMovieItem;



import static org.junit.jupiter.api.Assertions.*;

class AfishaMovieManagerTest {

  @Test
  public void getLastTenFilmsLess() {
    AfishaMovieManager posterManager = new AfishaMovieManager(2);
    AfishaMovieItem first = new AfishaMovieItem(1, 1, "first", "comedy", true);
    AfishaMovieItem second = new AfishaMovieItem(2, 2, "second", "action", false);
    posterManager.add(first);
    posterManager.add(second);
    AfishaMovieItem[] actual = posterManager.getLastFilms();
    AfishaMovieItem[] expected = new AfishaMovieItem[]{second, first};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void getLastTenFilmsEqual() {
    AfishaMovieManager posterManager = new AfishaMovieManager();
    AfishaMovieItem one = new AfishaMovieItem(1, 1, "one", "comedy", true);
    AfishaMovieItem two = new AfishaMovieItem(2, 2, "two", "action", true);
    AfishaMovieItem three = new AfishaMovieItem(3, 3, "three", "horror", true);
    AfishaMovieItem four = new AfishaMovieItem(4, 4, "four", "action", false);
    AfishaMovieItem five = new AfishaMovieItem(5, 5, "five", "comedy", true);
    AfishaMovieItem six = new AfishaMovieItem(6, 6, "six", "comedy", false);
    AfishaMovieItem seven = new AfishaMovieItem(7, 7, "seven", "horror", true);
    AfishaMovieItem eight = new AfishaMovieItem(8, 8, "eight", "comedy", false);
    AfishaMovieItem nine = new AfishaMovieItem(9, 9, "nine", "horror", true);
    AfishaMovieItem ten = new AfishaMovieItem(10, 10, "ten", "action", false);
    posterManager.add(one);
    posterManager.add(two);
    posterManager.add(three);
    posterManager.add(four);
    posterManager.add(five);
    posterManager.add(six);
    posterManager.add(seven);
    posterManager.add(eight);
    posterManager.add(nine);
    posterManager.add(ten);
    AfishaMovieItem[] actual = posterManager.getLastFilms();
    AfishaMovieItem[] expexcted = new AfishaMovieItem[]{ten, nine, eight, seven, six, five, four, three, two, one};
    assertArrayEquals(expexcted, actual);
  }

  @Test
  public void getLastTenFilmsMore() {
    AfishaMovieManager posterManager = new AfishaMovieManager(10);
    AfishaMovieItem one = new AfishaMovieItem(1, 1, "one", "comedy", true);
    AfishaMovieItem two = new AfishaMovieItem(2, 2, "two", "action", true);
    AfishaMovieItem three = new AfishaMovieItem(3, 3, "three", "horror", true);
    AfishaMovieItem four = new AfishaMovieItem(4, 4, "four", "action", false);
    AfishaMovieItem five = new AfishaMovieItem(5, 5, "five", "comedy", true);
    AfishaMovieItem six = new AfishaMovieItem(6, 6, "six", "comedy", false);
    AfishaMovieItem seven = new AfishaMovieItem(7, 7, "seven", "horror", true);
    AfishaMovieItem eight = new AfishaMovieItem(8, 8, "eight", "comedy", false);
    AfishaMovieItem nine = new AfishaMovieItem(9, 9, "nine", "horror", true);
    AfishaMovieItem ten = new AfishaMovieItem(10, 10, "ten", "action", false);
    AfishaMovieItem eleven = new AfishaMovieItem(11, 11, "eleven", "horror", true);
    posterManager.add(one);
    posterManager.add(two);
    posterManager.add(three);
    posterManager.add(four);
    posterManager.add(five);
    posterManager.add(six);
    posterManager.add(seven);
    posterManager.add(eight);
    posterManager.add(nine);
    posterManager.add(ten);
    posterManager.add(eleven);
    AfishaMovieItem[] actual = posterManager.getLastFilms();
    AfishaMovieItem[] expected = new AfishaMovieItem[] {eleven, ten, nine, eight, seven, six, five, four, three, two};
    assertArrayEquals(expected, actual);
  }
}