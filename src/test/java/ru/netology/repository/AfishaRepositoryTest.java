package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Afisha;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfishaRepositoryTest {

    @Test
    public void save() {
        AfishaRepository afishaRepository = new AfishaRepository();
        Afisha one = new Afisha(1, 1, "one", "action", true);
        Afisha two = new Afisha(2, 2, "two", "comedy", true);
        Afisha three = new Afisha(3, 3, "three", "horror", true);
        afishaRepository.save(one);
        afishaRepository.save(two);
        afishaRepository.save(three);
        Afisha[] actual = afishaRepository.findAll();
        Afisha[] expected = new Afisha[]{one, two, three};
        assertArrayEquals(expected, actual);
    }


    @Test
    public void findAll() {
        AfishaRepository afishaRepository = new AfishaRepository();
        Afisha one = new Afisha(1, 1, "one", "action", true);
        Afisha two = new Afisha(2, 2, "two", "comedy", true);
        Afisha three = new Afisha(3, 3, "three", "horror", true);
        afishaRepository.save(one);
        afishaRepository.save(two);
        afishaRepository.save(three);
        afishaRepository.findAll();
        Afisha[] actual = afishaRepository.findAll();
        Afisha[] expected = new Afisha[]{one, two, three};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findById() {
        AfishaRepository afishaRepository = new AfishaRepository();
        int idToFind = 2;
        Afisha one = new Afisha(1, 1, "one", "action", true);
        Afisha two = new Afisha(2, 2, "two", "comedy", true);
        Afisha three = new Afisha(3, 3, "three", "horror", true);
        afishaRepository.save(one);
        afishaRepository.save(two);
        afishaRepository.save(three);
        Afisha actual = afishaRepository.findById(idToFind);
        Afisha expected = two;
        assertEquals(expected, actual);
    }

    @Test
    public void findByIdNoExist() {
        AfishaRepository afishaRepository = new AfishaRepository();
        int idToFind = 5;
        Afisha one = new Afisha(1, 1, "one", "action", true);
        Afisha two = new Afisha(2, 2, "two", "comedy", true);
        Afisha three = new Afisha(3, 3, "three", "horror", true);
        afishaRepository.save(one);
        afishaRepository.save(two);
        afishaRepository.save(three);
        Afisha actual = afishaRepository.findById(idToFind);
        Afisha expected = null;
        assertEquals(expected, actual);
    }

    @Test
    void removeById() {
        AfishaRepository afishaRepository = new AfishaRepository();
        int idToRemove = 3;
        Afisha one = new Afisha(1, 1, "one", "action", true);
        Afisha two = new Afisha(2, 2, "two", "comedy", true);
        Afisha three = new Afisha(3, 3, "three", "horror", true);
        afishaRepository.save(one);
        afishaRepository.save(two);
        afishaRepository.save(three);
        afishaRepository.removeById(idToRemove);
        Afisha[] actual = afishaRepository.findAll();
        Afisha[] expected = new Afisha[]{one, two};
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {
        AfishaRepository afishaRepository = new AfishaRepository();
        Afisha one = new Afisha(1, 1, "one", "action", true);
        Afisha two = new Afisha(2, 2, "two", "comedy", true);
        Afisha three = new Afisha(3, 3, "three", "horror", true);
        afishaRepository.save(one);
        afishaRepository.save(two);
        afishaRepository.save(three);
        afishaRepository.removeAll();
        Afisha[] actual = afishaRepository.findAll();
        Afisha[] expected = {};
        assertArrayEquals(expected, actual);
    }
}
