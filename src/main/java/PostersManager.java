public class PostersManager {
    private String[] posters = new String[0]; // инициализируем пустой массив
    private int limit = 10;

    public PostersManager() {
    }

    public PostersManager(int newLimit) {
        limit = newLimit;
    }

    public void savePosters(String item) { //в качестве арг принимает новый постер
        String[] tmp = new String[posters.length + 1];
        for (int i = 0; i < posters.length; i++) {
            tmp[i] = posters[i];
        }
        tmp[tmp.length - 1] = item;
        posters = tmp;
    }

    public String[] getItems() {
        return posters;
    }

    public String[] getPostersListReversed() {
        int resultLength;
        if (posters.length > limit) {
            resultLength = limit;
        } else {
            resultLength = posters.length;
        }
        String[] reversed = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            reversed[i] = posters[posters.length - 1 - i];
        }
        return reversed;
    }
}
