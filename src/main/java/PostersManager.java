public class PostersManager {

    private int limit = 10;

    public PostersManager() {
    }

    public PostersManager(int newLimit) {
        limit = newLimit;
    }

    private PostersRepository repo;

    public PostersManager(PostersRepository repo) {
        this.repo = repo;
    }

    public void add(PosterItem item) {
        repo.save(item);
    }

    public PosterItem[] showAll() {
        return repo.findAll();
    }

    public PosterItem findById(int id) {
        return repo.findById(id);
    }

    public PosterItem[] removeById(int id) {
        return repo.removeById(id);
    }

    public PosterItem[] getPostersListReversed() {
        PosterItem[] posters = repo.findAll();

        int resultLength;
        if (posters.length > limit) {
            resultLength = limit;
        } else {
            resultLength = posters.length;
        }

        PosterItem[] reversed = new PosterItem[resultLength];
        for (int i = 0; i < resultLength; i++) {
            reversed[i] = posters[posters.length - 1 - i];
        }
        return reversed;
    }



}
