import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgorithm {
    public int minCostToConnect(int[][] edges){
        List<int[]> edgeCost= new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            for(int j=i+1;j<edges.length-1;j++) {
                int x1 = edges[i][0];
                int x2 = edges[i][1];
                int y1 = edges[j][0];
                int y2 = edges[j][1];
                int cost = Math.abs(x1 - y1) + Math.abs(x2 - y2);
                int[] arr = {i, j, cost};
                edgeCost.add(arr);
            }
        }
        Collections.sort(edgeCost,(a,b)->Integer.compare(a[2],b[2]));
        UnionFind uf= new UnionFind(edges.length);
        int totalCost=0;
        int edgesUsed=0;
        for(int[]e:edgeCost) {
            if(edgesUsed<edges.length) {
                int x = e[0];
                int y = e[1];
                int weight = e[2];
                if (uf.union(x, y)) {
                    totalCost += weight;
                    edgesUsed++;
                }

                continue;
            }
            else
                break;
        }
        return totalCost;
    }
}
