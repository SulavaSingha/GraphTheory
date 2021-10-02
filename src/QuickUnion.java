/*
we will be saving the root of root untill it is itself in the find method rather than searching it during union
 */
public class QuickUnion {
    public int numberOfVertices;
    int [] root;
    public QuickUnion(int numberOfVertices){
        this.numberOfVertices=numberOfVertices;
        root=new int[numberOfVertices];
        for(int i=0;i<numberOfVertices;i++){
            root[i]=i;
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
            root[y]=rootX;
        }
        }
    public static void main(String[] args) throws Exception {
        QuickUnion uf = new QuickUnion(10);
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
