import java.util.Arrays;

public class MyStack<T> {
    private Object[] array;

    public MyStack() {
        this.array = new Object[0];
    }

    public void add(T value) {
        int prevLength = this.array.length;
        Object[] nextArray = new Object[prevLength + 1];
        System.arraycopy(this.array, 0, nextArray, 0, this.array.length);
        nextArray[prevLength] = value;
        this.array = nextArray;
    }

    public void clear() {
        this.array = new Object[0];
    }

    public int size() {
        return this.array.length;
    }

    public T peek() {
        if (this.array.length > 0) {
            return (T)this.array[this.array.length - 1];
        }

        return null;
    }

    public T pop() {
        if (this.array.length > 0) {
            T first = (T) this.array[this.array.length - 1];
            Object[] nextArray = new Object[this.array.length - 1];
            System.arraycopy(this.array, 0, nextArray, 0, this.array.length - 1);
            this.array = nextArray;

            return first;
        }

        return null;
    }
}
