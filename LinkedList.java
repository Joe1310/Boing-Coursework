import java.util.NoSuchElementException;

public class LinkedList<T> {

    private Link<T> head;
    private Link<T> tail;
    private int count;


    public boolean isEmpty() {
        return this.head == null;
    }

    LinkedList() {
        this.head = null;
        this.count = 0;
    }

    public Object elementAt(int index) {
        Link curItem = head;
        for (int i = 0; i < index; i++) {
            curItem = curItem.getNext();
        }
        return curItem.getElement();
    }


    public void insertAt(int index, T e) {
        try {
            if(index > this.count){
                throw new NoSuchElementException();
            }
            if (this.isEmpty()) {
                this.head = new Link<>(e, null);
                this.tail = this.head;
            } else {
                Link<T> prev = this.head;

                for (int i = 0; i < index - 1; i++) {
                    prev = prev.getNext();
                }
                Link<T> temp = prev.getNext();
                Link<T> newNode = new Link<>(e, temp);
                prev.setNext(newNode);
                this.count++;

            }
        }catch(NoSuchElementException ex){
            System.out.println(ex+". Please enter a valid index.");
            System.exit(0);
        }
        while (this.tail.getNext() != null) {
            this.tail = this.tail.getNext();
        }
    }
}


