package data;

public class Music {
    protected String path;

    public Music(String path) {
        this.path = path;
    }

    public String getPath() { return path; }

    @Override
    public boolean equals(Object obj) {
        try {
            Music music2 = (Music)obj;
            return music2.path.equals(this.path);
        }
        catch (Exception e) {
            return false;
        }
    }
}
