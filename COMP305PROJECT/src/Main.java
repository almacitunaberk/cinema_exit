
import java.util.*;

    class Main
    {
        static int ROW = 9;
        static int COL = 10;

        static boolean isValid(int row, int col)
        {

            return (row >= 0) && (row < ROW) &&
                    (col >= 0) && (col < COL);
        }

        static int rowNum[] = {-1, 0, 0, 1};
        static int colNum[] = {0, -1, 1, 0};


        static int BFS(int mat[][], Point src,
                       Point dest)
        {

            if (mat[src.x][src.y] != 1 ||
                    mat[dest.x][dest.y] != 1)
                return -1;

            boolean [][]visited = new boolean[ROW][COL];


            visited[src.x][src.y] = true;


            Queue<QueueNode> q = new LinkedList<>();


            QueueNode s = new QueueNode(src, 0);
            q.add(s);


            while (!q.isEmpty())
            {
                QueueNode curr = q.peek();
                Point pt = curr.pt;


                if (pt.x == dest.x && pt.y == dest.y)
                    return curr.dist;

                q.remove();

                for (int i = 0; i < 4; i++)
                {
                    int row = pt.x + rowNum[i];
                    int col = pt.y + colNum[i];

                    if (isValid(row, col) &&
                            mat[row][col] == 1 &&
                            !visited[row][col])
                    {
                        visited[row][col] = true;
                        QueueNode Adjcell = new QueueNode
                                (new Point(row, col),
                                        curr.dist + 1 );
                        q.add(Adjcell);
                    }
                }
            }

            // Return -1 if destination cannot be reached
            return -1;
        }

        // Driver Code
        public static void main(String[] args)
        {
            int mat[][] = {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                    { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                    { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                    { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                    { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                    { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                    { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                    { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};

            Point source = new Point(0, 0);
            Point dest = new Point(3, 4);

            int dist = BFS(mat, source, dest);

            if (dist != -1)
                System.out.println("Shortest Path is " + dist);
            else
                System.out.println("Shortest Path doesn't exist");
        }
    }


