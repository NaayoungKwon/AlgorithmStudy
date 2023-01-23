import sys

def solution(n, cur, exp):

    prev = 0;
    tab = [exp[i] - cur[i] for i in range(n)];
    result = 0;
    for i in range(1,n):
        if tab[i-1] * tab[i] < 0:
            result += abs(tab[i-1]);
        elif abs(tab[i-1]) > abs(tab[i]):
            result += abs(tab[i-1] - tab[i]);
    result += abs(tab[n-1])
    return result;
    # dp_prev = [(0,0)] * n;
    # dp_me = [(0,0)] * n;
    # dp_me[0] = (tab[0], abs(tab[0]));
    # dp_prev[0] = (tab[0], abs(tab[0]));

    # for i in range(1,n):
    #     dp_me[i] = (tab[i], min(dp_me[i-1][1], dp_prev[i-1][1]) + abs(tab[i]));
    #     a = dp_me[i-1][1] + abs(tab[i] - dp_me[i-1][0]);
    #     b = dp_prev[i-1][1] + abs(tab[i] - dp_prev[i-1][0]);
    #     if a < b:
    #         dp_prev[i] = (dp_me[i-1][0], a);
    #     else:
    #         dp_prev[i] = (dp_prev[i-1][0], b);
    # print(dp_me)
    # print(dp_prev)
    # return min(dp_me[n-1][1], dp_prev[n-1][1]);  

n = int(sys.stdin.readline());
cur = list(map(int,sys.stdin.readline().split()));
exp = list(map(int,sys.stdin.readline().split()));
print(solution(n, cur, exp));