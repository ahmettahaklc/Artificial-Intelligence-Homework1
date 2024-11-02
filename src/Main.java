import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static LinkedList<int[][]> queue = new LinkedList<>();
    public static final int[][] goal_state = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};

    public static void BFS(int[][] a) {
        int column = 0;
        int line = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] == 0) {
                    line = i;
                    column = j;
                }
            }
        }

        if (line > 0) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line - 1][column];
            fringe[line - 1][column] = 0;
            queue.add(fringe);
        }

        if (line < 2) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line + 1][column];
            fringe[line + 1][column] = 0;
            queue.add(fringe);
        }

        if (column > 0) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line][column - 1];
            fringe[line][column - 1] = 0;
            queue.add(fringe);
        }

        if (column < 2) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line][column + 1];
            fringe[line][column + 1] = 0;
            queue.add(fringe);
        }
    }

    public static void DFS(int[][] a) {
        int column = 0;
        int line = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] == 0) {
                    line = i;
                    column = j;
                }
            }
        }

        if (line > 0) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line - 1][column];
            fringe[line - 1][column] = 0;
            queue.addFirst(fringe);
        }

        if (line < 2) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line + 1][column];
            fringe[line + 1][column] = 0;
            queue.addFirst(fringe);
        }

        if (column > 0) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line][column - 1];
            fringe[line][column - 1] = 0;
            queue.addFirst(fringe);
        }

        if (column < 2) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line][column + 1];
            fringe[line][column + 1] = 0;
            queue.addFirst(fringe);
        }
    }

    public static boolean CheckingState(int[][] currentState) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (goal_state[i][j] != currentState[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] initial_state = {{3, 6, 1}, {7, 0, 2}, {4, 8, 5}};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose search algorithm\n1-BFS");
        String choose = scanner.nextLine();

        if (choose.equals("1")) {

            queue.add(initial_state);
            while (!queue.isEmpty()) {
                int[][] currentState = queue.removeFirst();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(currentState[i][j]);
                    }
                    System.out.println();
                }
                System.out.println("------");

                if (CheckingState(currentState)) {
                    System.out.println("Goal State is founded");
                    break;
                }

                BFS(currentState);
                
            }
        }

    }
}
