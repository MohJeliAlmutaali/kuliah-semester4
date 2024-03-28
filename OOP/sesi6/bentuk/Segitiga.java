package bentuk;

public abstract class Segitiga implements Bentuk {
    protected Bentuk alas;

    public Segitiga(Bentuk alas) {
        this.alas = alas;
    }
}
