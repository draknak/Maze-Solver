import java.util.Arrays;

public class Main {

    static char[][] maze1 = {
            {'#','#','#','#','#','#','#','#','#','#'},
            {'#',' ',' ',' ',' ',' ',' ','#','#','#'},
            {'#',' ','#','#',' ','#',' ',' ',' ','#'},
            {'#',' ','#','#',' ','#',' ','#',' ','#'},
            {'#',' ','#',' ',' ','#',' ','#',' ',' '},
            {'#',' ',' ',' ','#',' ',' ','#','#','#'},
            {'#',' ','#','#','#',' ','#','#',' ','#'},
            {'#',' ','#','#','#',' ',' ','#',' ','#'},
            {'#',' ',' ',' ','@','#',' ',' ',' ','#'},
            {'#','#','#','#','#','#','#','#','#','#'}};


    public static void main(String[] args) throws InterruptedException {
        /**
         * solve a maze,
         * 2d array
         * need to check all directions in this order, right, left, up, down
         * only move back a space if no other move can be made
         * # = walls, ' ' = empty, * = traversed, @ = current pos, & = backtrack
         */

        Maze maze = new Maze(maze1);
        maze.solve();
    }
}
