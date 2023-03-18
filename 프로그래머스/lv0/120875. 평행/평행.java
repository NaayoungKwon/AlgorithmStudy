import java.util.ArrayList;
import java.util.List;

class Solution {
    int answer = 0;
    public int solution(int[][] dots) {
        // boolean[] visited = new boolean[dots.length];
        // comb(dots, visited, 0, dots.length, 2);
        for(int i = 1 ; i < 4 ; i++){
            double l1 = line(dots[0], dots[i]);
            List<Integer> l = new ArrayList<>();
            l.add(0);
            l.add(1);
            l.add(2);
            l.add(3);
            l.remove(i);
            l.remove(0);
            double l2 = line(dots[l.get(0)], dots[l.get(1)]);
            // if((double)((dots[0][1]-dots[i][1])/(dots[0][0]-dots[i][0])) == (double)((dots[l.get(0)][1]-dots[l.get(1)][1])/(dots[l.get(0)][0]-dots[l.get(1)][0]))){
                // answer = 1;
            // }
            if(l1 == l2){
                answer = 1;
            }
        }
        return answer;
    }
    
    public double line(int[] a, int[] b){
        return (double)((double)(b[1] - a[1]) / (double)(b[0] - a[0]));
    }
    
    public void comb(int[][] arr, boolean[] visited, int start, int n, int r){
        if(r == 0 ){
            ArrayList<Integer> arr_visited = new ArrayList<>();
            ArrayList<Integer> arr_nonvisited = new ArrayList<>();
            for(int i = 0 ; i < 4 ; i++){
                if(visited[i] == true){
                    arr_visited.add(i);
                } else {
                    arr_nonvisited.add(i);
                }
            }
            // System.out.println(arr_visited);
            double line1 = line(arr[arr_visited.get(0)], arr[arr_visited.get(1)]);
            double line2 = line(arr[arr_nonvisited.get(0)], arr[arr_nonvisited.get(1)]);
            if(line1 == line2){
                answer = 1;
            }
            return ;
        }
        
        for(int i = start; i < n ; i++){
            visited[i] = true;
            comb(arr, visited, i+1, n,r-1);
            visited[i] = false;
        }
    }
}