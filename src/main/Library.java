package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    List<Room> rooms = new ArrayList<Room>();

    public Library(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> findRedRooms(){
        return rooms.stream().filter(room -> room.getColor().equals("Red")).collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> booksByThisAuthor = new ArrayList<>();
        for (Room room : rooms){
            for (Book book : room.getBooks()){
                if (book.getAuthor().equals(author)){
                    booksByThisAuthor.add(book);
                }
            }
        }
        return booksByThisAuthor;
    }
}
