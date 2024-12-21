def solution(mats, park):
    answer = 0
    
    # park 첫 자리 부터 돌아가면서 여기서 부터 최대 몇 까지 가능한지 확인
    # mats를 돌아가면서 answer보다 작으면 continue, 크면 수행하는데 못깔면 break
    n, m = len(park), len(park[0])
    for i in range(n):
        for j in range(m):
            for l in mats:
                if l < answer or i+l > n or j+l > m:
                    continue
                    
                s = set()
                for k in range(l):
                    # print(park[i+k][j:j+l])
                    s.update(park[i+k][j:j+l])
                # print(i,j,l,s)
                
                if len(s) == 1 and s == set(['-1']):
                    answer = max(answer, l)
                    # print(i,j,l,s)

    return answer if answer > 0 else -1