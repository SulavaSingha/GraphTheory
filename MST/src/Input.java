public class Input {
    public static void main(String[] args){
        int[][] edges = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        KruskalAlgorithm ka = new KruskalAlgorithm();
        int minCost= ka.minCostToConnect(edges);
        System.out.println(minCost);
    }
}
