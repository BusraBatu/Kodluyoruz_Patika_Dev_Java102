package collectionMap;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> books = new TreeSet<>();

        Book one = new Book("Veronica Ölmek İstiyor", 150, "Paulo Coelho", "1995");
        Book two = new Book("Oblomov", 500, "Gonçarov", "1895");
        Book three = new Book("Kuyucaklı Yusuf", 200, "Sabahattin Ali", "1945");
        Book four = new Book("Kinyas ve Kayra", 495, "Hakan Günday", "2018");
        Book five = new Book("Serenad", 268, "Zülfü Livaneli", "2016");

        books.add(one);
        books.add(two);
        books.add(three);
        books.add(four);
        books.add(five);

        System.out.println("Ada göre sıralama : ");
        for (Book book : books) {

            System.out.println("Kitap Adı : " + book.getName() +
                    ",\t Sayfa Sayısı : " + book.getPage() +
                    ",\t Yazarın İsmi : " + book.getAuthor() +
                    ",\t Yayın Tarihi : " + book.getReleaseDate());
        }
        System.out.println("\n");
        //Sayfaya göre
        TreeSet<Book> books2 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPage() - o2.getPage();
            }
        });
        books2.add(one);
        books2.add(two);
        books2.add(three);
        books2.add(four);
        books2.add(five);

        System.out.println("Sayfa sayısına göre sıralama :");
        for (Book book : books2) {
            System.out.println("Kitap adı : " + book.getName() +
                    ",\t Sayfa Sayısı : " + book.getPage() +
                    ",\t Yazarın İsmi : " + book.getAuthor() +
                    ",\t Yayın Tarihi : " + book.getReleaseDate());
        }
    }
}
