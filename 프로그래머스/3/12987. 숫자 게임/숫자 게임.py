import bisect
def solution(A, B):
    answer = 0
    A.sort()
    B.sort()
    s = 0
    for a in A:
        flag = False
        for i in range(s, len(B)):
            if a < B[i]:
                s = i+1
                answer += 1
                flag = True
                break
        if flag == False:
            return answer

    return answer