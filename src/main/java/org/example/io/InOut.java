package org.example.io;


import org.example.data.Book;
import org.example.data.BookList;

import java.util.List;

public interface InOut {
    public List<Book> readFromFile(String filePath);
    public void writeToFile(BookList books, String filePath);

    public List<Book> readFromJSON(String filePath);
    public void writeToJSON(BookList books, String filePath);
}
