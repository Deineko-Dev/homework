public class MyQueue<T> {
    private Object[] array;

    public MyQueue() {
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
            return (T)this.array[0];
        }

        return null;
    }

    public T poll() {
        if (this.array.length > 0) {
            T first = (T) this.array[0];
            Object[] nextArray = new Object[this.array.length - 1];
            System.arraycopy(this.array, 1, nextArray, 0, this.array.length - 1);
            this.array = nextArray;

            return first;
        }

        return null;
    }
}
