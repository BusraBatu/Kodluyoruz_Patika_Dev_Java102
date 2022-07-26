package collectionMap;

import java.util.Comparator;

public class Book implements Comparable<Book> {
    private String name;
    private int page;
    private String author;
    private String releaseDate;

    @Override
    public int compareTo(Book book) {

        return getName().compareTo(book.getName());
    }

    public Book(String name, int page, String author, String releaseDate) {
        this.name = name;
        this.page = page;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


}
