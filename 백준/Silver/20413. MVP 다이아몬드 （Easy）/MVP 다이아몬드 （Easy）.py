import sys

def solution(n,teer_list, mvp):
    teer = ['B','S','G','P','D']
    result = 0;
    prev = 0;
    for i in range(n):
        idx = teer.index(mvp[i])
        this_month = (teer_list[idx] - prev) if idx != 4 else teer_list[idx]
        result += this_month
        prev = this_month

    return result

n = int(sys.stdin.readline());
s,g,p,d= map(int,sys.stdin.readline().split());
mvp = sys.stdin.readline().split()[0];

print(solution(n, [s-1,g-1,p-1,d-1,d],mvp));