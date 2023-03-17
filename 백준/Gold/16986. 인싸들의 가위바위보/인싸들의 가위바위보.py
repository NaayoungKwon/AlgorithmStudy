import sys
from itertools import permutations

def find_abc(idx, step, jiu_order, hee,hoo):
    if idx == 1:
        return hee[step[idx]]-1;
    elif idx == 2:
        return hoo[step[idx]]-1;
    else:
        return jiu_order[step[idx]];

def solution(n,k,rule,hee,hoo):

    for jiu_order in permutations(range(n),n):
        jiu = 0;
        win_cnt = [0] * 3;
        last_win = 0; # jiu
        fight = 1; # hee
        step = [0] * 3;
        # print(jiu_order)
        while step[0] < n and step[1] < 20 and step[2] < 20:
            i = find_abc(last_win, step, jiu_order, hee,hoo); 
            j = find_abc(fight, step, jiu_order, hee,hoo); 
            step[fight] += 1;
            step[last_win] += 1;
            result = rule[i][j];
            # print(last_win, fight, i,j, result, win_cnt);
            if (result == 1 and last_win < fight) or result == 0:
                win_cnt[fight] += 1;
                temp_next_win = fight;
                fight = 3 - fight - last_win;
                last_win = temp_next_win;
            elif (result == 1 and last_win > fight) or result == 2:
                win_cnt[last_win] += 1;
                fight = 3 - fight - last_win;
                
            # print(last_win,fight)
            if win_cnt[last_win] == k:
                if last_win == 0:
                    return 1;
                break;
    return 0;

n, k = map(int, sys.stdin.readline().split());
myList = [list(map(int,sys.stdin.readline().split())) for _ in range(n)];
hee = list(map(int,sys.stdin.readline().split()));
hoo = list(map(int,sys.stdin.readline().split()));
print(solution(n,k,myList,hee,hoo));