public class StackFloodFill {

    public static int[] rows = {0, -1, 0, 1};
    public static int[] cols = {-1, 0, 1, 0};

    public static void floodFill(int[][] image, int x, int y, int newColor) {
        StaticStack staticStack = new StaticStack(45);

        staticStack.push(new Pair(x,y));


        while(!staticStack.isEmpty()) {
            Pair pair = staticStack.pop();
            int newX = pair.row;
            int newY = pair.column;

            image [newX][newY] = newColor;
            print(image);


            for (int i = 0; i < rows.length; i++) {
                if(isValid(image, newX + rows[i], newY + cols[i], newColor)) {
                    staticStack.push(new Pair(newX + rows[i], newY + cols[i]));
                }
            }
        }
    }

    public static boolean isValid(int[][] image, int x, int y, int newColor) {
        int rows = image.length;
        int columns = image[0].length;
        if(x > rows || x < 0 || y > columns || y < 0 || image[x][y] != 1) {
            return false;
        } else {
            return true;
        }
    }

    public static void print(int[][] image) {
        for (int i = 0; i < 10; i++) {
            System.out.print("[");
            for(int r = 0; r < 10; r++) {
                System.out.print(" " + image[i][r] + ",");
            }
            System.out.println("]");
        }
        System.out.println("======");
    }

}
