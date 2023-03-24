package org.example.ui;

import org.example.data.Book;
import org.example.data.BookList;

import java.util.List;
import java.util.Scanner;

public class BookListUI {
    private BookList books;
    private Scanner scanner;

////    ТУТ НИЧЕГО НЕ ПОМЕНЯЛОСЬ
    public void addNewBook(BookList books, Scanner scanner) {
        System.out.print("Enter id >> ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name >> ");
        String name = scanner.nextLine();

        System.out.print("Enter author >> ");
        String author = scanner.nextLine();

        System.out.print("Enter price >> ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter year >> ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter publisher >> ");
        String publisher = scanner.nextLine();

        System.out.print("Enter number of pages >> ");
        int numberOfPages = scanner.nextInt();
        scanner.nextLine();

        books.addBook(new Book(id, name, author, price, year, publisher, numberOfPages));
    }





    public void createSomeBooksArray(BookList books) {
        books.addBook(new Book(1, "Никогда, никогда", "Колин Гувер", 300, 2015, "Любовні романи", 800));
        books.addBook(new Book(2, "Скарби Валькірії: Правда і вигадка", "Сергій Алексєєв", 150, 2003, "Сучасна російська література", 1000));
        books.addBook(new Book(3, "Підручник Українська мова 5 клас", "Авраменко", 456, 2022, "УкрЛіб", 200));
        books.addBook(new Book(4, "Поцілунок вампіра. Книга 5. Клуб безсмертних" , "Колин Гувер", 78, 2010, "Любовні романи", 678));
        books.addBook(new Book(5, "Подорожі Тафа", "Джордж Мартін", 89, 1986, "Сучасна зарубіжна література", 567));
        books.addBook(new Book(6, "П'ятнадцятирічний капітан", "Жуль Верн", 111, 1878, "Зарубіжна література", 567));
        books.addBook(new Book(7, "Навколо світу за вісімдесят днів", "Жуль Верн", 132, 1872, "Зарубіжна література", 511));
        books.addBook(new Book(8, "20000 льє під водою", "Жуль Верн", 132, 1870, "Зарубіжна література", 511));
    }


    public void deleteById() {
        System.out.print("Enter id to delete >> ");
        int id = scanner.nextInt();
        books.deleteById(id);
    }



    private void printList(List<Book> arr) {
        for (Book book : arr) {
            System.out.println(book.toString());
        }
    }

    public void showBooksByPublisher() {
        System.out.print("Enter name of publisher >> ");
        String publisher = scanner.nextLine();

        printList(books.getBooksByPublisher(publisher));

    }

    public void showBooksAfterYear() {
        System.out.print("Enter a year >> ");
        int year = scanner.nextInt();
        scanner.nextLine();

        printList(books.getBooksAfterYear(year));
    }

    public void showByAuthorSortedByYears() {
        System.out.println("Enter name of author >> ");
        String author = scanner.nextLine();

        printList(books.getByAuthorSortedByYears(author));
    }



    public void showAuthorListSortedByAlphabet() {

        List<String> arr = books.getAuthorListSortedByAlphabet();

        for (String element : arr) {
            System.out.println(element);
        }
    }



    public BookListUI() {}
    public BookListUI(BookList books) {
        this.books = books;
    }

    public BookList getBooks() {
        return books;
    }

    public void setBooks(BookList books) {
        this.books = books;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
