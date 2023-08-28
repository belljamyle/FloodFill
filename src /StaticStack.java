public class StaticStack {

    private int top = -1;
    private Pair[] data;
    private int size;

    StaticStack (int size) {
        this.size = size;
        this.data = new Pair[size];
        for(int i = 0; i < size; i++) {
            data[i] = null;
        }
    }
    public void push(Pair dado) {
        if (!isFull()) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    data[i] = dado;
                    top = i;
                    break;
                }
            }
        } else {
            System.out.println("Pilha cheia!");
        }
    }
    public Pair pop() {
        Pair ans;
        if(!isEmpty()) {
            ans = data[top];
            data[top] = null;
            top -= 1;
            return ans;
        } else {
            System.out.println("Pilha vazia!");
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
