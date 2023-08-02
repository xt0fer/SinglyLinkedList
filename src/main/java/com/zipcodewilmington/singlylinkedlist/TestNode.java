package com.zipcodewilmington.singlylinkedlist;
public class TestNode<E> {
    //<E extends Comparable<E>> implements Comparable<TestNode<E>>{

    private E data;
    private TestNode<E> next;

    public TestNode(E data, TestNode<E> next) {
        this.data = data;
        this.next = next;
    }

    public TestNode(E data) {
        this.data = data;
        this.next = null;
    }

    public boolean hasNext(){
        return (this.next == null) ? false : true;
        // if(this.next == null){
        //     return false;
        // }
        // else{
        //     return true;
        // }
    }

    public TestNode<E> getNext() {
        return this.next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setNext(TestNode<E> next) {
        this.next = next;
    }

    //public int compareTo(TestNode<E> node2) {
    //    return (this.data.compareTo((E) node2.getData()));
    //}


}
