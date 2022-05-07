import java.util.PriorityQueue;
import java.util.Queue;

public class PrimAlgo {
    Queue<Edge> pq;
    boolean[] visited;
    int size;
    public PrimAlgo(int size){
        this.size=size;
        pq= new PriorityQueue<>((x,y)->x.weight-y.weight);
        visited = new boolean[size];
    }
    public int minCost(int[][] points){
        int minCost=0;
        int[] cordinateX=points[0];
        for(int j=1;j<size;j++){
            int[] cordinateY=points[j];
            int x1=cordinateX[0];
            int x2=cordinateX[1];
            int y1=cordinateY[0];
            int y2=cordinateY[1];
            int cost=Math.abs(x1-y1)+Math.abs(x2-y2);
            Edge edge = new Edge(0,j,cost);
            pq.offer(edge);
        }
        visited[0]=true;
        int count=this.size;
        while(pq.size()>0 && count>0){
          Edge edge=pq.poll();
          int start =edge.start;
          int end= edge.end;
          int cost=edge.weight;
          if(!visited[end]){
              minCost+=cost;
              visited[end]=true;
              int[] cordinateX2=points[end];
              for(int j=0;j<size;j++){
                  if(!visited[j]){
                    int[] cordinateY2=points[j];
                    int distance= Math.abs(cordinateX2[0]-cordinateY2[0])+Math.abs(cordinateX2[1]-cordinateY2[1]);
                    pq.offer(new Edge(end,j,distance));
                    count--;
                  }
              }
          }
        }
        return minCost;
    }
}
