public class QuickRank {
    public int numberOfVertices;
    int [] root;
    int[] rank;
    public QuickRank(int numberOfVertices){
        this.numberOfVertices=numberOfVertices;
        root=new int[numberOfVertices];
        rank=new int[numberOfVertices];
        for(int i=0;i<numberOfVertices;i++){
            root[i]=i;
            rank[i]=1;
        }
    }
    public int find(int x){
        if(root[x]==x)
            return x;
        return find(root[x]);
    }
    public boolean connected(int x,int y){
        return root[x]==root[y];
    }
    public void union(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX!=rootY)
        {
            if(rank[rootX]>rank[rootY]){
                root[rootY]=rootX;
            }
            else if(rank[rootY]>rank[rootX]){
               root[rootX]=rootY;
            }
            else{
                root[rootY]=rootX;
                rank[rootX]+=1;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        QuickRank uf = new QuickRank(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
