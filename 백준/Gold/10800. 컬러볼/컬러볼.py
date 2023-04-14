
import heapq
import sys
def solution(n, ball):

    answer = [0]*(n)
    color_sum = dict()
    prev_size = 0
    prev_num = 0
    prev_color = 0
    prev_color_num = 0
    total_sum = 0
    #print(ball)
    for i in range(n):
        s, c, idx = heapq.heappop(ball)
        
        #이때까지 전체에서 내가 속한 색깔만 뺀다.
        my_sum = total_sum
        if c in color_sum.keys():
            my_sum -= color_sum[c]
        
        # 앞이 나랑 같으면 그만큼은 빼야해
        if prev_size == s:
            if prev_color == c:
                my_sum -= (s*(prev_num-prev_color_num))
                prev_color_num += 1
            else:
                my_sum -= (s*prev_num)
                prev_color = c
                prev_color_num = 1
            prev_num += 1
            
        else:
            prev_size = s
            prev_num = 1
            prev_color = c
            prev_color_num = 1
                        
        if c in color_sum.keys():    
            color_sum[c] = color_sum[c] + s
        else:
            color_sum[c] = s
        
        answer[idx] = my_sum
        total_sum += s
        #print(idx, my_sum,answer,color_sum)
    
    for score in answer:
        print(score)
    # return answer
    
    
n = int(sys.stdin.readline())
ball = []
for i in range(n):
    c, s = map(int, sys.stdin.readline().split())
    heapq.heappush(ball,(s,c,i))
    #ball.append((s,i,c))
#ball.sort(key = lambda x : (x[2], x[1]))
solution(n,ball)
