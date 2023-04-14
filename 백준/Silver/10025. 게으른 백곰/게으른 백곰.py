import sys

def solution(n,k,cage_dict):

    l = max(cage_dict.keys())
    cage = [0] * ( l + 1)
    for key, e in cage_dict.items():
        cage[key] += e
    max_ice = sum(cage[: min(l,2*k )+1])
    his_ice = max_ice
    last_ice = 0
    for i in range(2*k +1, l+1):
        his_ice += (cage[i] - cage[last_ice])
        last_ice += 1
        max_ice = max(max_ice, his_ice)
        
    return max_ice

n,k = map(int,sys.stdin.readline().split());
myList = {}
for _ in range(n):
    a,b = map(int,sys.stdin.readline().split());
    myList[b] = a;
print(solution(n, k, myList));