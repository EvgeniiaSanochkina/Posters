import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostersTest {

    PostersRepository repo = Mockito.mock(PostersRepository.class);
    PostersManager manager = new PostersManager(repo);


    PosterItem item1 = new PosterItem(1, "Тутси");
    PosterItem item2 = new PosterItem(2, "Назад в будущее");
    PosterItem item3 = new PosterItem(3, "День сурка");
    PosterItem item4 = new PosterItem(4, "Титаник");
    PosterItem item5 = new PosterItem(5, "Король Лев");
    PosterItem item6 = new PosterItem(6, "Прибытие");
    PosterItem item7 = new PosterItem(7, "Интерстеллар");
    PosterItem item8 = new PosterItem(8, "Кто я");
    PosterItem item9 = new PosterItem(9, "Эта прекрасная жизнь");
    PosterItem item10 = new PosterItem(10, "9 дней одного года");
    PosterItem item11 = new PosterItem(11, "5 вечеров");

    @Test
    public void shouldFindById() {
        PostersRepository repo = new PostersRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        PosterItem actual = repo.findById(2);
        PosterItem expected = item2;
        assertEquals(actual, expected);
    }

    @Test
    public void shouldFindAll() {
        PostersRepository repo = new PostersRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        PosterItem[] actual = repo.findAll();
        PosterItem[] expected = {item1, item2, item3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        PostersRepository repo = new PostersRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        PosterItem[] actual = repo.removeById(3);
        PosterItem[] expected = {item1, item2, item4, item5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        PostersRepository repo = new PostersRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        PosterItem[] actual = repo.removeAll();
        PosterItem[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReverse() {
        PosterItem[] items = {item7, item8, item9};
        doReturn(items).when(repo).findAll();
        PosterItem[] actual = manager.getPostersListReversed();
        PosterItem[] expected = {item9, item8, item7};
        Assertions.assertArrayEquals(expected, actual);
    }

    /*@Test НЕ СРАБОТАЛО
    public void shouldFindByIdUsingMockito() {
        PosterItem[] items = {item5, item6, item9, item10, item11};
        doReturn(items).when(repo).findAll();
        PosterItem actual = manager.findById(9);
        PosterItem expected = item9;
        assertEquals(actual, expected);
    }*/

    @Test
    public void shouldFindByIdByManager() {
        PostersRepository repo = new PostersRepository();
        PostersManager manager = new PostersManager(repo);
        manager.add(item5);
        manager.add(item6);
        manager.add(item9);
        manager.add(item10);
        manager.add(item11);
        PosterItem actual = manager.findById(9);
        PosterItem expected = item9;
        assertEquals(actual, expected);
    }



}