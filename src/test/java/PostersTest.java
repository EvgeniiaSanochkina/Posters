import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PostersTest {

    //@BeforeEach
    String item1 = "Тутси";
    String item2 = "Назад в будущее";
    String item3 = "День сурка";
    String item4 = "Титаник";
    String item5 = "Король Лев";
    String item6 = "Прибытие";
    String item7 = "Интерстеллар";
    String item8 = "Кто я";
    String item9 = "Эта прекрасная жизнь";
    String item10 = "9 дней одного года";
    String item11 = "5 вечеров";


    @Test
    public void shouldAddMovie() {
        PostersManager repo = new PostersManager();
        repo.savePosters(item1);
        repo.savePosters(item2);
        repo.savePosters(item3);
        String[] expected = {item1, item2, item3};
        String[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAccordingDefaultLimit() {
        PostersManager repo = new PostersManager();
        repo.savePosters(item1);
        repo.savePosters(item2);
        repo.savePosters(item3);
        repo.savePosters(item4);
        repo.savePosters(item5);
        repo.savePosters(item6);
        repo.savePosters(item7);
        repo.savePosters(item8);
        repo.savePosters(item9);
        repo.savePosters(item10);
        repo.savePosters(item11);
        String[] actual = repo.getPostersListReversed();
        String[] expected = {item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAccordingSetLimit() {
        PostersManager repo = new PostersManager(7);
        repo.savePosters(item1);
        repo.savePosters(item2);
        repo.savePosters(item3);
        repo.savePosters(item4);
        repo.savePosters(item5);
        repo.savePosters(item6);
        repo.savePosters(item7);
        repo.savePosters(item8);
        repo.savePosters(item9);
        repo.savePosters(item10);
        repo.savePosters(item11);
        String[] actual = repo.getPostersListReversed();
        String[] expected = {item11, item10, item9, item8, item7, item6, item5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfLimitEqualsLength() {
        PostersManager repo = new PostersManager(3);
        repo.savePosters(item1);
        repo.savePosters(item2);
        repo.savePosters(item3);
        String[] actual = repo.getPostersListReversed();
        String[] expected = {item3, item2, item1};
        Assertions.assertArrayEquals(expected, actual);
    }
}