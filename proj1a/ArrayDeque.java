public class ArrayDeque<T> {

    // array to save data
    private T[] array;

    //size of te array
    private int size;

    //front index
    private int;

    //last index
    private int last;

    //contructor for ArrayDeque
    public ArrayDeque(){
        array = (T[]) new Object[8];
        size = 0;
        length = 8;
        front = 4;
        last = 4;
    }

    // decide if the deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    //return the size of the deque
    public int size( {
        return size;
    }

    // return the index -1
    private int plusOne(int index, int module) {
        index %= module;
        if(index == module-1) {
            return 0;
        }
        return index + 1;
    }

    private int minusOne(int index) {

        if(index == 0) {
            return length - 1;
        }
        return index - 1;
    }



    private void grow() {
        T[] newArray = (T[]) new Object()[length*2];
        int ptr1 = front;
        int ptr2 = length;
        while (ptr1!= last) {
            newArray[ptr2] = array[ptr1];
            ptr1 = plusOne(ptr1,length);
            ptr2 = plusOne(ptr2,length*2);
        }
        front = length;
        last = ptr2;
        array = newArray;
        length *= 2;
        }

    private void shrink() {
        T[] newArray = (T[]) new Object()[length/2];
        int ptr1 = front;
        int ptr2 = length/4;
        while (ptr1!= last) {
            newArray[ptr2] = array[ptr1];
            ptr1 = plusOne(ptr1,length);
            ptr2 = plusOne(ptr2,length/2);
        }
        front = length/4;
        last = ptr2;
        array = newArray;
        length /= 2;
    }

    public void addFirst(T item) {
        if(size == length -1) {
            grow();
        }
        front = minusOne(front);
        array[front] = item;
        size++;
    }

    public T removeFirst() {
        if(length >= 16 && length / size >= 4) {
            shrink();
        }
        if(size == 0) {
            return null;
        }

        T ret = array[front];
        front = plusOne(front,length);
        size--;
        return ret;
    }

    public T removeLast() {
        if(length >= 16 && length / size >= 4) {
            shrink();
        }
        if(size == 0) {
            return null;
        }


        last = minuOne(last);
        size--;
        return array[last];
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }

        int ptr = front;
        for(int i = 0; i < index; i++) {
            ptr = plusOne(ptr,length);
        }
        return array[ptr];
    }

    public void printDeque() {
        int ptr = front;
        while(ptr != last) {
            System.out.print(array[ptr] + " ");
            ptr = plusOne(ptr,length);
        }
    }

}
