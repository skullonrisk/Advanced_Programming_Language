//*************************************************************************
// Title : A java programme to demonstrate Interface Segregation Principle.
// Author : Md Nazmul Huda Labib, CSE, Khulna University.
//*************************************************************************

import java.util.ArrayList;
import java.util.List;

// Interface representing the ability to read
interface Readable {
    void read();
}

// Interface representing the ability to write
interface Writable {
    void write();
}

// Interface representing the ability to listen
interface Listenable {
    void listen();
}

// Class representing a Book that can be read
class Book implements Readable {
    @Override
    public void read() {
        System.out.println("Reading a book.");
    }
}

// Class representing a Pen that can be used for writing
class Pen implements Writable {
    @Override
    public void write() {
        System.out.println("Using a pen for writing.");
    }
}

// Demo class demonstrating the usage of objects and the Interface Segregation Principle
public class Interface_Segregation_Principle {
    public static void main(String[] args) {
        // Create a list of objects
        List<Object> objects = new ArrayList<>();
        objects.add(new Book());
        objects.add(new Pen());

        // Perform actions on each object
        for (Object obj : objects) {
            if (obj instanceof Readable) {
                ((Readable) obj).read();
            }
            if (obj instanceof Writable) {
                ((Writable) obj).write();
            }
            if (obj instanceof Listenable) {
                ((Listenable) obj).listen();
            }
            System.out.println();
        }
    }
}

/**
 * In the above programme, there are three interfaces for specific tasks like
 * reading, writing, and listening instead of a fat interface containing all
 * three tasks. As a result, the Book class can implement the specific Readable
 * interface, and the Pen class can implement the specific Writable interface.
 */
