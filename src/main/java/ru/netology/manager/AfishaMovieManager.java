package ru.netology.manager;

import ru.netology.domain.AfishaMovieItem;

public class AfishaMovieManager {
  private AfishaMovieItem[] films = new AfishaMovieItem[0];
  private int numberOfFilms = 10; //число фильмов, которые нужно вывести (10 или меньше, в зависимости от количества фильмов в афише
  public void add(AfishaMovieItem post) {
    // создаём новый массив размером на единицу больше
    int length = films.length + 1;
    AfishaMovieItem[] tmp = new AfishaMovieItem[length];
    // itar + tab
    // копируем поэлементно
    // for (int i = 0; i < items.length; i++) {
    //   tmp[i] = items[i];
    // }
    System.arraycopy(films, 0, tmp, 0, films.length);
    // кладём последним наш элемент
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = post;
    films = tmp;
  }

  public AfishaMovieItem[] getLastFilms() {
    int count = films.length > numberOfFilms ? numberOfFilms : films.length;
    AfishaMovieItem[] tmp = new AfishaMovieItem[count];
    for (int i = 0; i < count; i++) {
      int index = films.length - i - 1;
      tmp[i] = films[index];
    }
    return tmp;
  }

  public AfishaMovieManager() {
  }

  public AfishaMovieManager(int numberOfFilms) {
    if (numberOfFilms < 0) {
      return;
    }
    this.numberOfFilms = numberOfFilms;
  }
}
