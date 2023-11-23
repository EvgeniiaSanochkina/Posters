public class PostersRepository {
    private PosterItem[] posters = new PosterItem[0];

    public PosterItem[] findAll() {
        return posters;
    }

    public void save(PosterItem item) {
        PosterItem[] tmp = new PosterItem[posters.length + 1];
        for (int i = 0; i < posters.length; i++) {
            tmp[i] = posters[i];
        }
        tmp[tmp.length - 1] = item;
        posters = tmp;
    }

    public PosterItem findById(int id) {
        PosterItem[] tmp = new PosterItem[posters.length];
        PosterItem foundByID = null;
        for (int i = 0; i < posters.length; i++) {
            if (posters[i].getId() == id) {
                tmp[i] = posters[i];
                foundByID = tmp[i];
                break;
            }
        }
        return foundByID;
    }

    public PosterItem[] removeById(int id) {
        PosterItem[] tmp = new PosterItem[posters.length - 1];
        int index = 0;
        for (PosterItem poster : posters) {
            if (poster.getId() != id) {
                tmp[index] = poster;
                index++;
            }
        }
        posters = tmp;
        return posters;
    }

    public PosterItem[] removeAll() {
        posters = new PosterItem[0];
        return posters;
    }
}
