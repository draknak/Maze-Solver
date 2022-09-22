import java.util.Arrays;

public class Maze {

    private int x;
    private int y;
    private char[][] maze;

    public Maze(char[][] maze) throws InterruptedException {
        int[] startPos = findStart(maze);

        this.maze = maze;
        x = startPos[0];
        y = startPos[1];
    }

    public void solve() throws InterruptedException {
        while (canMove(x, y) || !(atEdge(x, y)))
        {
            if (canMove(x, y)) {
                move(x, y);
            } else {
                System.out.println("The maze cannot be solved");
                break;
            }
            printMaze();
        }
    }

    private void move(int x, int y)
    {
        if(maze[x+1][y] == ' ') {
            maze[x][y] = '*';
            maze[x+1][y] = '@';
            this.x=x+1;
        } else if (maze[x-1][y] == ' ') {
            maze[x][y] = '*';
            maze[x-1][y] = '@';
            this.x=x-1;
        } else if (maze[x][y+1] == ' ') {
            maze[x][y] = '*';
            maze[x][y+1] = '@';
            this.y=y+1;
        } else if (maze[x][y-1] == ' ') {
            maze[x][y] = '*';
            maze[x][y-1] = '@';
            this.y=y-1;
        } else {
            backTrack(x, y);
        }
    }

    private void backTrack(int x, int y)
    {
        if(maze[x+1][y] == '*') {
            maze[x][y] = '&';
            maze[x+1][y] = '@';
            this.x=x+1;
        } else if (maze[x-1][y] == '*') {
            maze[x][y] = '&';
            maze[x-1][y] = '@';
            this.x=x-1;
        } else if (maze[x][y+1] == '*') {
            maze[x][y] = '&';
            maze[x][y+1] = '@';
            this.y=y+1;
        } else if (maze[x][y-1] == '*') {
            maze[x][y] = '&';
            maze[x][y-1] = '@';
            this.y=y-1;
        }
    }

    private Boolean atEdge(int x, int y)
    {
        if(x == 0 || x == 9 || y == 0 || y == 9) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    private Boolean canMove(int x, int y)
    {
        if(atEdge(x, y))
        {
            System.out.println("The maze has been solved");
            return Boolean.FALSE;
        }

        if(maze[x+1][y] == ' ' || maze[x+1][y] == '*' ||
                maze[x-1][y] == ' ' || maze[x-1][y] == '*' ||
                maze[x][y+1] == ' ' || maze[x][y+1] == '*' ||
                maze[x][y-1] == ' ' || maze[x][y-1] == '*') {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    private int[] findStart(char[][] maze)
    {
        int[] coordinates = new int[2];
        coordinates[0] = 0;
        coordinates[1] = 0;

        for(int i = 0; i < maze.length; i ++) {
            for(int j = 0; j < maze[i].length; j ++)
            {
                if (maze[i][j] == '@')
                {
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
            }
        }
        return coordinates;
    }

    private void printMaze() throws InterruptedException {
        //Thread.sleep(500); // just so you can see the maze going through each iteration
        System.out.println(Arrays.deepToString(maze).replace("], ", "]\n"));
    }

}
