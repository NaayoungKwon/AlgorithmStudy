import sys
from itertools import permutations

def solution(n, arr):
    result = 1e9;
    cnt_arr = [0] * 4;
    cnt_arr[1] = arr.count(1);
    cnt_arr[2] = arr.count(2);
    cnt_arr[3] = arr.count(3);
    for comb in permutations(range(1,4),3):
        re_arr = [comb[0]] * cnt_arr[comb[0]] + [comb[1]] * cnt_arr[comb[1]] + [comb[2]] * cnt_arr[comb[2]];
        cnt = [0] * 3;
        prev = 0;
        for j in range(3):
            for i in range(prev, prev + cnt_arr[comb[j]]):
                if re_arr[i] != arr[i] and (j == 0 or (j==1 and arr[i] == comb[2]) or (j == 2 and arr[i] == comb[1])):
                    cnt[j] += 1;
            prev += cnt_arr[comb[j]];
        result = min(result, cnt[0] + max(cnt[1:]));
    return result

n = int(sys.stdin.readline());
myList = list(map(int,sys.stdin.readline().split())) ;
print(solution(n, myList));
