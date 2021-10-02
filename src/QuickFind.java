public class QuickFind {
    public int numberOfVertices;
    int [] root;
    public QuickFind(int numberOfVertices){
        this.numberOfVertices=numberOfVertices;
        root=new int[numberOfVertices];
        for(int i=0;i<numberOfVertices;i++){
            root[i]=i;
        }
    }
    public int find(int x){
        return root[x];
    }
    public void union(int x,int y){
       int rootX=find(x);
       int rootY=find(y);
       if(rootX!=rootY)
       {
           for(int i=0;i<root.length;i++){
               if(rootY==root[i]){
                   root[y]=root[rootX];
               }
           }
       }
    }
    public boolean connected(int x,int y){
        return root[x]==root[y];
    }
    public static void main(String[] args) throws Exception {
        QuickFind uf = new QuickFind(10);
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
