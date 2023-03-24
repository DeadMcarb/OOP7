package org.example.io;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.data.Book;
import org.example.data.BookList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IO implements InOut{
    public List<Book> readFromFile(String filePath) {
        List<Book> books = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            books = (List<Book>) ois.readObject();
            System.out.println("File read success!");
            return books;
        } catch (IOException e) {
            System.out.println("File Read ERROR!");
        } catch (ClassNotFoundException e) {
            System.out.println("File Not Found!");
        }
        return books;
    }

    public void writeToFile(BookList books, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(books.getBooks());
            System.out.println("File write success!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    public List<Book> readFromJSON(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Book> books = new ArrayList<>();

        try {
            books = objectMapper.readValue(new File(filePath), new TypeReference<List<Book>>(){});
            System.out.println("File read success!");
            return books;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    /////////// НАДО ТРАЙ С РЕСУРСАМИ?
    public void writeToJSON(BookList books, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filePath), books.getBooks());
            System.out.println("File write success!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
