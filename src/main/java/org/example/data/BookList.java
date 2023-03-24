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

    public List<String> getAuthorListSortedByAlphabet() {
        ArrayList<String> authorList = new ArrayList<>();

        for (Book book : books) {
            authorList.add(book.getAuthor());
        }

        Collections.sort(authorList);

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
