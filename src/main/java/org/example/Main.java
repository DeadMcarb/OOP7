package org.example;


import org.example.data.BookList;
import org.example.io.IO;
import org.example.ui.BookListUI;

import java.io.Serializable;
import java.util.*;

import static org.example.util.Constants.*;


public class Main implements Serializable {

    public static void main(String[] args) {
        new Main().run();
    }

    private void menu() {
        System.out.println("""
                -----------------------------------------|
                [0] Read file                            |
                [1] Save in file                         |
                [2] Read JSON file                       |
                [3] Save in JSON file                    |
                -----------------------------------------|
                [4] Show all list                        |
                [5] Filter by author and sorted by years |
                [6] Show author list sorted by alphabet  |
                [7] show books after year                |
                [8] Filter by publisher                  |
                -----------------------------------------|
                [9] Add new book                         |
                [10] Delete book by Id                   |
                [11] Add some books to Array             |
                -----------------------------------------|
                [12] show every publisher`s books        |
                [13] show list of publishers             |
                -----------------------------------------|
                [14] Exit                                |
                -----------------------------------------|""");

        System.out.print(">> ");
    }




    private void run() {
        BookList books = new BookList();
        IO io = new IO();

        BookListUI ui = new BookListUI(books);

        loop:
        while (true) {
            menu();
            Scanner scanner = new Scanner(System.in);
            ui.setScanner(scanner);

            int m = scanner.nextInt();
            scanner.nextLine();

            switch (m) {


                case READ_FILE -> books.setBooksList(io.readFromFile("MyBooks.dat"));
                case SAVE_IN_FILE -> io.writeToFile(books, "MyBooks.dat");

                case READ_JSON_FILE -> books.setBooksList(io.readFromJSON("MyBooks.json"));
                case SAVE_IN_JSON_FILE -> io.writeToJSON(books, "MyBooks.json");

                case SHOW_ALL_LIST -> System.out.println(books);

                case FILTER_BY_AUTHOR_AND_SORTED_BY_YEARS -> ui.showByAuthorSortedByYears();

                case SHOW_AUTHOR_LIST_SORTED_BY_ALPHABET -> ui.showAuthorListSortedByAlphabet();

                case SHOW_BOOKS_AFTER_YEAR -> ui.showBooksAfterYear();

                case FILTER_BY_PUBLISHER -> ui.showBooksByPublisher();



                case ADD_NEW_BOOK -> ui.addNewBook(books, scanner);

                case DELETE_BOOK_BY_ID -> ui.deleteById();

                case ADD_SOME_BOOKS_TO_ARRAY -> ui.createSomeBooksArray(books);



                case BOOK_LIST_FOR_EVERY_PUBLISHER -> ui.showBookListForEveryPublisher();
                case PUBLISHER_LIST -> ui.showPublisherSet();


                case EXIT -> {
                    break loop;
                }

            }
        }
    }
}


