def solution(t, p):
    answer = 0
    l = len(p)
    for i in range(len(t) - l+1):
        nt = t[i:i + l]
        # print(nt)
        if int(nt) <= int(p):
            answer += 1
    return answer