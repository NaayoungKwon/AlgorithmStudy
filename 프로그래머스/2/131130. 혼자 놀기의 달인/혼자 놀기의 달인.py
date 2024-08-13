import heapq

def solution(cards):
    answer = 0
    que = []
    
    n = len(cards)
    visited = [False] * n
    
    for i in range(1, n+1):
        if visited[i-1]:
            continue
            
        g = set()
        k = i
        while True:
            g.add(cards[k-1])
            visited[k-1] = True
            k = cards[k-1]
            if visited[k-1]:
                break
        # print(g)
        heapq.heappush(que, -len(g))
    if len(que) > 1:
        return heapq.heappop(que) * heapq.heappop(que)
    else:
        return 0