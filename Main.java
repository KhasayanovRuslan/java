
public class Main {
    public static int random(int a, int b) {
        int r;
        do {
            r = (int) Math.random();
        } while(r < a || r > b);

        return r;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Tree tree = new Tree();

            for (int j = 0; j < 64; j++) {
                tree.insert(new Cat(random(-100, 100)));
            }

            tree.displayTree();
        }
    }
}
