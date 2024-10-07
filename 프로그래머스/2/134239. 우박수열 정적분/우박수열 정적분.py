def solution(k, ranges):
    answer = []
    
    graph = [k]
    dim = []
    
    n = k
    while n > 1:
        n = cal(n)
        graph.append(n)
        dim.append((abs(graph[-1] + graph[-2]))/2)
        # print(graph[-1], dim[-1])
    
    n = len(dim)
    for rg in ranges:
        x = rg[0]
        y = n + rg[1]
        r = 0
        if x > y:
            answer.append(-1)
            continue
            
        for i in range(x, y):
            r += dim[i]
        answer.append(r)
    return answer

def cal(a):
    if a % 2 == 0:
        return a // 2
    else:
        return (a * 3) +1