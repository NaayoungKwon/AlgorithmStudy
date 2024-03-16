def solution(S):
    answer = 0

    #answer = dfs([],1,S)
    cnt = 1
    while True:
        if S - cnt == 0:
            return cnt
        elif S - cnt < 0:
            cnt -= 1
            return cnt
        S -= cnt
        cnt += 1
    return answer

S = input()
print(solution(int(S)))