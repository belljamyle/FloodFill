public class CircularQueue {

    private int top = -1;
    private int base = 0;
    private Pair[] data;
    private int size;

    CircularQueue(int size) {
        this.size = size;
        this.data = new Pair[size];
    }
    public void add(Pair dado) {
        if (!isFull()) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    data[i] = dado;
                    top = i;
                    break;
                }
            }
        } else {
            System.out.println("Fila cheia!");
        }
    }
    public Pair remove() {
        Pair ans;
        if (!isEmpty()) {
            ans = data[base];
            data[base] = null;
            base = move(base);
            return ans;
        } else {
            System.out.println("Fila vazia!");
            return null;
        }
    }
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
    }
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            if (data[i] == null) {
                return false;
            }
        }
        return true;
    }
    public boolean isEmpty() {
        for (int i = 0; i < size; i++) {
            if (data[i] != null) {
                return false;
            }
        }
        return true;
    }
    private int move(int position) {
        if (position + 1 == data.length) {
            return 0;
        } else {
            return position + 1;
        }
    }
    void print() {
        for (int i = 0; i < size; i++) {
            if(data[i] == null) {
                System.out.println(data[i]);
            } else {
                Pair pair = data[i];
                System.out.print("(" + pair.row + ", " + pair.column);
                System.out.println();
            }
        }
        System.out.println("=====");
    }
}
