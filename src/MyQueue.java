import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/**
 * CUS-1126
 * Project 3 - Group 4
 * @author Iftikhar Tapadar, Pierce Montgomery, George Britton
 */
public class MyQueue implements IntegerQueue{

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println("Generated queue:");
        //Calls on generate method which will store 50 generated methods in a queue
        queue.generate();
        //Prints the generated queue by calling on print method
        queue.print();
        System.out.println("Sorted queue:");
        //Calls on sort method which will sort integers in queue and print the result
        queue.sort();
    }

    //Queue implemented through linkedlist, and will store generated and sorted integers
    LinkedList<Integer> queue = new LinkedList<>();

    //THE FOLLOWING ARE INTERFACE METHODS FROM IntegerQueuejava class
    @Override
    //Returns size of the queue
    public int size() {
        return queue.size();
    }

    @Override
    //Returns boolean value if the queue is empty or not
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    //Looks at first value stored in queue
    public Integer first() throws EmptyStructureException {
        //Checks if it is empty first
        if(isEmpty()) {
            // error
            throw new EmptyStructureException("The queue is empty.");
        }
        return queue.peekFirst();    }

    @Override
    //Returns element from font of queue
    public Integer dequeue() throws EmptyStructureException {
        //Checks if queue is empty first
        if(isEmpty()) {
            // error
            throw new EmptyStructureException("The queue is empty.");
        }
        //Returns element in front of the queue
        return queue.pop();
    }

    @Override
    //Adds element to tail of queue
    public void enqueue(Integer N) {
        queue.add(N);
    }

    //Size variable that represents the max number of the size of the queue
    int size = 50;
    //Method to generate integer element to queue
    public void generate() {
        //Creates random object that will be used to generate random numbers in queue
        Random random = new Random(); // random generator
        //Adds an integer element to queue until 50 integers are stored
        for(int i = 1; i <= size; i++) {
            //Uses enqueue to add random integer element
            enqueue(random.nextInt(size) + 1);
        }
    }

    //Method that prints the queue
    public void print() {
        //Checks if it is empty first
        if(queue.isEmpty()) {
            System.out.println("The queue is empty.");
        }
        else {
            //Uses iterator to move through the elements in linkedlist
            Iterator<Integer> iterate = queue.iterator();
            //While there is an integer in iterator, it will print the element
            while(iterate.hasNext()) {
                //Ternary condition statement implemented to ensure each is iterated
                System.out.print(iterate.next() + (iterate.hasNext() ? "->" : ""));
            }
            //Used to move to next line after being printed
            System.out.println();
        }
    }

    //Method that sorts the generated queue
    public void sort() {
        //Checks if queue is empty first
        if(queue.isEmpty()) {
            System.out.println("The queue is empty.");
        }
        else {
            //Gets the size of the queue
            int sizeOfQueue = queue.size();
            //A temporary queue that will store integers
            List<Integer> temp = new ArrayList<>(sizeOfQueue);
            //A iterator that will be used to iterate through the queue
            Iterator<Integer> numbers = queue.iterator();
            while(numbers.hasNext()) {
                temp.add(numbers.next());
            }
            //Using collection library provided by java api
            //Using comparison logic and recursion
            Collections.sort(temp); // using default comparison logic
            //Prints the elements in sorted temp linkedlist
            for(int i = 0; i < sizeOfQueue; i++) {
                //Using condition statement to ensure al 50 elements are printed
                // the "?" acts as ternary condition statement to see if true or false
                System.out.print(temp.get(i) + (i < sizeOfQueue - 1 ? "->" : ""));
            }
            //Moves to next line and adds space
            System.out.println();
        }
    }
}
