def solution(n,m,Alist,Clist):
    answer = 10000000*100
    #t_size = sum(Alist)
    app = [(Alist[i],Clist[i]) for i in range(n)]
    app.sort(key = lambda x: (x[1],x[0]))
    dp = [0]*(10000+1)
    #searchlist = []
    
    for (i_size, i_cost) in app:
        
        for j in range(10000,i_cost-1,-1):
            #if dp[j - i_cost] != -1:
            dp[j] = max(dp[j], i_size + dp[j - i_cost])
            #print(j, dp[j],'j')
        
        # print(i_cost, dp[i_cost],'i')
        # dp[i_cost] = max(i_size, dp[i_cost])
        # print(i_cost, dp[i_cost],'i')
    
    
    
    for i in range(10002):
        if dp[i] >= m:
            return i



n, m = input().split(' ')
Alist = list(map(int, input().split(' ')))
Clist = list(map(int, input().split(' ')))
print(solution(int(n), int(m), Alist, Clist))
    