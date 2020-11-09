package ru.netology.manager;

import ru.netology.domain.Afisha;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
  private AfishaRepository repository;

  public AfishaManager(AfishaRepository repository) {this.repository = repository;}

  public void save(Afisha item) {
    repository.save(item);
  }

  public Afisha[] getAll() {
    Afisha[] films = repository.findAll();
    Afisha[] result = new Afisha[films.length];
    for (int i = 0; i < result.length; i++) {
      int index = films.length - i - 1;
      result[i] = films[index];
    }
    return result;
  }

  public void removeById(int id) {
    repository.removeById(id);
  }
}
