public class UnionFind {
    int[] root;
    int[] rank;
    public UnionFind(int n){
       root=new int[n];
       rank=new int[n];
       for(int i=0;i<n;i++){
           root[i]=i;
           rank[i]=1;
       }
    }
    public int find(int x){
        while(root[x]!=x){
            x=root[x];
        }
        return x;
    }
    public boolean union(int x,int y){
        int X=find(x);
        int Y=find(y);
        if(X==Y){
            return false;
        }
        else if(X!=Y){
            if(rank[X]>rank[Y]){
                root[Y]=x;
            }
            if(rank[X]<rank[Y]){
                root[X]=y;
            }
            else{
                root[X]=y;
                rank[y]++;
            }
        }
        return true;
    }
}
