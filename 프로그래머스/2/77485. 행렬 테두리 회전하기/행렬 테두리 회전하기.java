class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        // 행렬을 초기화 합니다.
        int[][] matrix = new int[rows+1][columns+1];
        int cnt = 1;
        for(int i = 1 ; i <= rows ; i++){
            for(int j = 1 ; j <= columns ; j++){
                matrix[i][j] = cnt;
                cnt += 1;
            }
        }

        // 쿼리를 하나씩 확인합니다
        cnt = 0;
        for(int[] query: queries){
            // 하나의 쿼리에서 시계방향으로 회전합니다. 이때 최솟값도 저장합니다.
            int x1 = query[0], y1 = query[1], x2 = query[2], y2 = query[3];
            
            int minValue = Integer.MAX_VALUE;
            int last = matrix[x1][y1];
            // x1 (y1 ~ y2)로 이동
            for(int i = y1; i < y2; i++){
                int cur = matrix[x1][i+1];
                minValue = Math.min(minValue,cur);
                matrix[x1][i+1] = last;
                last = cur;
            }

            // y2 (x1 ~ x2)로 이동
            for(int i = x1; i < x2 ; i++){
                int cur = matrix[i+1][y2];
                minValue = Math.min(minValue, cur);
                matrix[i+1][y2] = last;
                last = cur;
            }

            // x2 (y2 ~ y1)으로 이동
            for(int i = y2; i > y1; i--){
                int cur = matrix[x2][i-1];
                minValue = Math.min(minValue, cur);
                matrix[x2][i-1] = last;
                last = cur;
            }

            // y1 (x2 ~ x1)으로 이동
            for(int i = x2; i > x1 ; i--){
                int cur = matrix[i-1][y1];
                minValue = Math.min(minValue, cur);
                matrix[i-1][y1] = last;
                last = cur;
            }

            answer[cnt] = minValue;
            cnt += 1;
        }
        

        return answer;
    }
}