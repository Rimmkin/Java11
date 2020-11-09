package ru.netology.repository;

import ru.netology.domain.Afisha;

public class AfishaRepository {
    private Afisha[] films = new Afisha[0];

    public void save(Afisha item) {
        int length = films.length + 1;
        Afisha[] tmp = new Afisha[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        films = tmp;
    }

    public Afisha[] findAll() {return films;}

    public Afisha findById(int id) {
        for (Afisha item : films) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    public void removeById(int id) {
        int length = films.length - 1;
        Afisha[] tmp = new Afisha[length];
        int index = 0;
        for (Afisha item : films) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        films = tmp;
    }

    public void removeAll()
    {
        films = new Afisha[0];
    }
}
