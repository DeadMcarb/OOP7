package org.example.data;

import java.util.*;

public class BookList {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }
    public List<Book> getBooks() {
        return books;
    }

    public void setBooksList(List<Book> arr){
        books = arr;
    }


    //3. Реалізувати операції пошуку елементів у колекції, вилучення знайденого об’єкта

    //4. Зверніть увагу на додаткові пункти завдання та уточнення тих, що
    //виконувались у попередніх лабораторних роботах.

    //Колекції: списки, множини, відображення. Порівняння об’єктів




    //f) для кожного видавництва визначити список книг, виданих ним
    public HashMap<String, List<Book>> getBookListForEveryPublisher () {
        HashMap<String, List<Book>> BookListForEveryPublisher = new HashMap<>();

        for (Book book : books) {
            String publisher = book.getPublisher();

            if (BookListForEveryPublisher.containsKey(publisher)) {
                BookListForEveryPublisher.get(publisher).add(book);
            } else {
                List<Book> arr = new ArrayList<>();
                arr.add(book);
                BookListForEveryPublisher.put(publisher, arr);
            }
        }

//        books.forEach(e -> BookListForEveryPublisher.put());

        return BookListForEveryPublisher;
    }


    //e) список видавництв, книги яких зареєстровані в системі без повторів
    public HashSet<String> getPublisherSet () {
        HashSet<String> publisherSet = new HashSet<>();

//        for (Book book : books) {
//            publisherSet.add(book.getAuthor());
//        }
//
        books.forEach(e -> publisherSet.add(e.getPublisher()));

        return publisherSet;

    }



//    public List<String> getAuthorListSortedByAlphabet() {
//        ArrayList<String> authorList = new ArrayList<>();
//
//        for (Book book : books) {
//            authorList.add(book.getAuthor());
//        }
//
//        Collections.sort(authorList);
//
//        return authorList;
//    }


    //d. список авторів в алфавітному порядку     ПЕРЕДЕЛАТЬ без повторений
    public TreeSet<String> getAuthorListSortedByAlphabet() {
        TreeSet<String> publisherSet = new TreeSet<>();

        books.forEach(e -> publisherSet.add(e.getAuthor()));

        return publisherSet;

    }



    public List<Book> getByAuthorSortedByYears(String author) {
        ArrayList<Book> authorList = new ArrayList<>();

        for (Book book : books) {
            if (book != null) {
                if (book.getAuthor().equals(author)) {
                    authorList.add(book);
                }}
        }

        authorList.sort(Comparator.comparingInt(Book::getYear));

        return authorList;
    }

    public List<Book> getBooksAfterYear(int year) {
        ArrayList<Book> newArray = new ArrayList<>();

        for (Book book : books) {
            if (book.getYear() > year) {
                newArray.add(book);
            }
        }

        return newArray;
    }


    public List<Book> getBooksByPublisher(String publisher) {
        ArrayList<Book> newArray = new ArrayList<>();

        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                newArray.add(book);
            }
        }

        return newArray;
    }



    public void deleteById(int id){
        books.removeIf(e -> (e.getId() == id));
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }
}
