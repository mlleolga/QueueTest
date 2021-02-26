package com.queuetest;

public class ObjectQueue<T> {
    private ObjectBox head = null;
    private ObjectBox tail = null;
    private int size = 0;

    public void push(T obj) {
        ObjectBox objectBox = new ObjectBox();
        objectBox.setObject(obj);
        if (head == null) {
            head = objectBox;
        } else {
            tail.setNext(objectBox);
        }
        tail = objectBox;
        size++;
    }

    public T pull() {
        if (size == 0) return null;
        T obj = (T) head.getObject();
        head = head.getNext();
        if (head== null) tail = null;
        size--;
        return obj;
    }

    public T get (int index){
        if (size == 0 || index >=size || index < 0) return null;
        ObjectBox current = head;
        int pos = 0;
        while (pos < index){
            current = current.getNext();
            pos++;
        }
        T obj = (T) current.getObject();
        return obj;
    }

    public int size() {
        return size;
    }

    private class ObjectBox<T> {
        private Object object;
        private ObjectBox next;

        public T getObject() {
            return (T) object;
        }

        public void setObject(T object) {
            this.object = object;
        }

        public ObjectBox getNext() {
            return next;
        }

        public void setNext(ObjectBox next) {
            this.next = next;
        }
    }

}
