import heapq

def solution(k, tangerine):
    answer = 0
    tmap = {}
    theap = []
    total = len(tangerine)
    for t in tangerine:
        if t in tmap:
            tmap[t] = tmap[t] + 1
        else:
            tmap[t] = 1
            
    for t in tmap.keys():
        c = tmap[t]
        heapq.heappush(theap, c)
    
    answer = len(tmap.keys())
    while theap or total < k:
        c = heapq.heappop(theap)
        if total - c >= k:
            total -= c
            answer -= 1
    
    return answer