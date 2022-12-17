import sys

def solution(n,start,end):

    w_cnt = 0;
    b_cnt = 0;
    for i in range(n):
        if start[i] != end[i]:
            if start[i] == 'W':
                w_cnt += 1;
            elif start[i] == 'B':
                b_cnt += 1;
    return max(w_cnt, b_cnt)

answer = [];
T = int(sys.stdin.readline());
for i in range(T):
    n = int(sys.stdin.readline());
    start = sys.stdin.readline();
    end = sys.stdin.readline();
    print(solution(n,start[:-1],end[:-1]));
