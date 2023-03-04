public class MyArrayList<T> {
    private Object[] array;

    public MyArrayList () {
        this.array = new Object[0];
    }

    public void add(T value) {
        int prevLength = this.array.length;
        Object[] nextArray = new Object[prevLength + 1];

        for (int i = 0; i < prevLength; i++) {
            nextArray[i] = this.array[i];
        }

        nextArray[prevLength] = value;
        this.array = nextArray;
    }

    public void remove(int index) {
        if (index >= 0 && index < this.array.length) {
            Object[] prevArray = this.array;
            this.array = new Object[prevArray.length - 1];
            int counter = 0;

            for (int i = 0; i < prevArray.length; i++) {
                if (i == index) {
                    continue;
                }

                this.array[counter] = prevArray[i];
                counter++;
            }
        }
    }

    public void clear() {
        this.array = new Object[0];
    }

    public int size() {
        return this.array.length;
    }

    public T get(int index) {
        if (index >= 0 && index < this.array.length) {
            return (T) this.array[index];
        }

        return null;
    }
}
