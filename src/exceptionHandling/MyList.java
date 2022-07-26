package exceptionHandling;

public class MyList<T> {
    private T[] arr;

    MyList() {
        this.arr = (T[]) new Object[10];
    }

    MyList(int cap) {
        this.arr = (T[]) new Object[cap];
    }

    public int size() {
        int x = 0;
        for (T each : arr) {
            if (each != null) {
                x++;
            }
        }
        return x;
    }

    public int getCapacity() {
        return this.arr.length;
    }

    public void add(T x) {
        if (this.size() == this.getCapacity()) {
            T[] newArr = (T[]) new Object[this.getCapacity() * 2];
            for (int i = 0; i < this.arr.length; i++) {
                newArr[i] = this.arr[i];
            }
            this.arr = newArr;
        }
        this.arr[this.size()] = x;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size()) {
            return null;
        }

        return this.arr[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= this.size()) {
            return null;
        }
        T removedElement = this.arr[index];

        for (int i = index; i < this.size() - 1; i++) {
            this.arr[i] = this.arr[i + 1];
        }
        this.arr[this.size() - 1] = null;
        return removedElement;
    }


    public T set(int index, T data) {
        if (index < 0 || index >= this.size()) {
            return null;
        }
        T oldData = this.arr[index];
        this.arr[index] = data;
        return oldData;

    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            if (arr[i] != null) {
                sb.append(arr[i].toString() + " ");
            }
        }

        return sb.toString();

    }


    public int indexOf(T data) {
        for (int i = 0; i < this.size(); i++) {
            if (data.equals(this.arr[i])) {
                return i;
            }
        }
        return -1;
    }


    public int lastIndexOf(T data) {
        for (int i = this.size(); i > 0; i--) {
            if (data.equals(this.arr[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }


    public T[] toArray() {
        T[] newArr = (T[]) new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            newArr[i] = this.arr[i];
        }

        return newArr;
    }

    public void clear() {
        for (int i = 0; i < this.size(); i++) {
            this.arr[i] = null;
        }
    }


    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || finish < 0 || start >= this.size() || finish >= this.size() || finish < start) {
            return null;
        }
        MyList<T> newList = new MyList<>();
        for (int i = start; i < finish; i++) {
            newList.add(this.arr[i]);
        }
        return newList;
    }


    public boolean contains(T data) {
        for (int i = 0; i < this.size(); i++) {
            if (this.arr[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

}
