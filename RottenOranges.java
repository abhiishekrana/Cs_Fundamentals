import java.util.*;
class TUF{
    class Pair{
        int row;
        int col;
        int tm;
        Pair(int _row,int _col,int _tm){
            this.row = _row;
            this.col = _col;
            this.tm = _tm;
        }
    }
public static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new Pair(i , j,0));
                    vis[i][j]=2;
                }
                if(grid[i][j] != 0) {
                    count_fresh++;
                }
            }
        }
       
        if(count_fresh == 0) return 0;
        int countMin = 0, cnt = 0;
        int tm=0;
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        
        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().tm;
            tm = Math.max(tm,t);
            queue.remove();
            for(int i=0;i<4;i++){
                int nrow = r+dx[i];
                int ncol = c+dy[i];
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0&&grid[nrow][ncol]==1){
                    queue.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }


        }
        return count_fresh == cnt ? countMin : -1;
    }
    public static void main(String args[])
    {
        int arr[][]={ {2,1,1} , {1,1,0} , {0,1,1} };
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required "+rotting);
    }
}