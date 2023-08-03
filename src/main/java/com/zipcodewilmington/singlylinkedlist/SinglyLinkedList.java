package com.zipcodewilmington.singlylinkedlist;

/**
 */
public class SinglyLinkedList <T extends Comparable<T>> implements LinkedListIface {

    private Node<T> head = null;

    public SinglyLinkedList() {}

    public Boolean isEmpty() {
        return head == null;
    }
    public void add(Comparable data) {
        Node<T> newnode = new Node<T>((T) data);
        if(this.head == null){
            this.head = newnode;
        }
        else{
            Node<T> temp = head;
            while(temp.hasNext()){ // walk to end
                temp = temp.getNext();
            }
            temp.setNext(newnode);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // add HEAD
        sb.append("head -> ");
        // loop thru the list and print each data
        if (head != null) {
            Node<T> temp = head;
            do { // walk to end
                sb.append("["+temp.getData()+"] -> ");
                temp = temp.getNext();
            } while((temp != null));
        }
        // add NULL
        sb.append("NULL");
        return sb.toString();
    }

    public void remove(int index) throws IndexOutOfBoundsException{
        Node<T> temp = this.head;
        if(index == 0){
            this.head = this.head.getNext();
        }
        else {
            for (int i = 0; i < index - 1; i++) {
                if (temp.hasNext()) {
                    temp = temp.getNext();
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
            temp.setNext(temp.getNext().getNext());
        }
    }

    public T get(int index) throws IndexOutOfBoundsException{
        Node<T> temp = this.head;
        for(int i = 0; i < index; i++){
            if(temp.hasNext()){
                temp = temp.getNext();
            }
            else{
                throw new IndexOutOfBoundsException();
            }
        }
        return temp.getData();
    }

    public boolean contains(Comparable data) {
        return (this.find(data) != -1);
    }

    public int find(Comparable data) {
        if (this.isEmpty()) return -1;
        int found = -1;

        Node<T> temp = head;
        do {
            found++;
            if (temp.getData().equals(data)) return found;
            temp = temp.getNext();
        } while (temp != null);

        return -1;
    }

    public int size() {
        if (this.isEmpty()) return 0;
        int n = 0;
        Node<T> temp = head;
        do {
            n++;
            temp = temp.getNext();
        } while (temp != null);
        return n;
    }

    public SinglyLinkedList<T> copy(){
        SinglyLinkedList<T> copyList = new SinglyLinkedList<T>();
        Node<T> temp = this.head;
        while(temp != null){
            copyList.add(temp.getData());
            temp = temp.getNext();
        }
        return copyList;
    }

    public void sort(){
        boolean notSorted = true;
        Node<T> temp = this.head;
        Node<T> next;
        while(notSorted){
            notSorted = false;
            while(temp.hasNext()){
                next = temp.getNext();
                //if(comparator.compare(temp.getData(), next.getData()) > 0){
                if(temp.compareTo(next) > 0){
                    swap(temp, next);
                    notSorted = true;
                }
                temp = temp.getNext();
            }
        }
    }

    public void swap(Node<T> node1, Node<T> node2){
        T tempData = node1.getData();
        node1.setData(node2.getData());
        node2.setData(tempData);
    }
}
