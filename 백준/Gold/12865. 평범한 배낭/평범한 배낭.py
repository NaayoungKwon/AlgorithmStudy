def solution(n,k,lines):
    answer = 0
    lines.sort(key= lambda x : (x[0],x[1]))
    dp = [0]*(k+1)
    for (w, v) in lines:
        if w > k:
            continue
        for j in range(k,w,-1):
            new = dp[j-w] + v
            if dp[j-w] != 0:
                dp[j] = max(dp[j], new)
                #chk[j+w] = True
        dp[w] = max(dp[w], v)
       

    return max(dp)



# print(solution(3,["happy","new","year"]))
# print(solution(4,["aba","abab","abcabc","a"]))
n, k = input().split(' ')
l = []
for i in range(int(n)):
    w, v =input().split(' ')
    l.append((int(w),int(v)))
print(solution(int(n),int(k),l))