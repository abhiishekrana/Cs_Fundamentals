import java.util.ArrayList;

class Rep{
    public static void main(String[] args){
        
       int n = 5;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
        }
        int[][] edges = {
            {0, 1},
            {0, 4},
            {1, 2},
            {1, 3},
            {1, 4},
            {3, 4}
        };

        int m = edges.length;
        for(int i=0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            al.get(u).add(v);
            al.get(v).add(u);
        }


        for (int i = 0; i < n; i++) {
            System.out.print("Vertex " + i + ":");
            for (int j : al.get(i)) {
                System.out.print(" " + j);
            }
            System.out.println();
        }
    }
}