def solution(N, stages):
    answer = []
    clear = [0]*(N+2)
    noclear = [0]*(N+2)
    failrate = []
    
    for score in stages:
        for person in range(1,score+1):
            clear[person] += 1
        noclear[score] += 1
    #print(clear,noclear)
    for i in range(1,N+1):
        if clear[i] == 0:
            failrate.append((i,0))
        else:
            failrate.append((i,(noclear[i]/clear[i])))
    failrate.sort(key= lambda x : -x[1])
    #print(failrate)
    for i in range(N):
        answer.append(failrate[i][0])
    return answer