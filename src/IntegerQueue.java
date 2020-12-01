/**
 * CUS-1126
 * Project 3 - Group 4
 * @author Iftikhar Tapadar, Pierce Montgomery, George Britton
 */
public interface IntegerQueue {

    public int size();

    public boolean isEmpty();

    public Integer first() throws EmptyStructureException;

    public Integer dequeue() throws EmptyStructureException;

    public void enqueue(Integer N);
}
