import java.util.HashSet;
import java.util.Set;
class Solution {
    
    public int[] parent;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j || computers[i][j] == 0) continue;
                
                if(find(i) != find(j)){
                    union(i,j);
                }
            }
        }
        Set<Integer> count = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            // System.out.println(parent[i]);
            count.add(find(parent[i]));
        }
        return count.size();
    }
    
    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        parent[Math.max(pa, pb)] = Math.min(pa,pb);
    }
    
    public int find(int a){
        if(parent[a] != a){
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
    
     
}