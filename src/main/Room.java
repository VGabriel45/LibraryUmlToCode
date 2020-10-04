package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Room {
    private String color;
    private List<Book> books;

    public Room(String color, List<Book> books) {
        this.color = color;
        this.books = books;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int countBookByCategory(Category category){
        int result = 0;
        for (Book book : books){
            if (book.getCategory().equals(category)){
                result++;
            }
        }
        return result;
    }

    public String findMostPopularAuthor(){
        HashMap<String,Integer> bookAuthor = new HashMap<>();
        int result = 0;
        for (Book book : books){
            if (bookAuthor.containsKey(book.getAuthor())){
                bookAuthor.put(book.getAuthor(), bookAuthor.get(book.getAuthor()) + 1);
            } else {
                bookAuthor.put(book.getAuthor(),0);
            }
        }

        // find max value
        for (Integer x : bookAuthor.values()){
            if (x > result){
                result = x;
            }
        }

        // get the author
        for (String author : bookAuthor.keySet()){
            if (bookAuthor.get(author) == result){
                return author;
            }
        }

        return null;
    }
}
