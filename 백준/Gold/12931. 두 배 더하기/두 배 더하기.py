import sys

def solution2(n, wanted):
    result = 0
    while max(wanted) > 0:
        flag = True;
        for i in range(n):
            if wanted[i] % 2 == 1:
                wanted[i] -= 1;
                result += 1;
                flag = False;
            elif wanted[i] == 0:
                continue;
        if flag:
            for i in range(n):
                wanted[i] = wanted[i] // 2;
            result += 1;
    return result;
n = int(sys.stdin.readline());
myList = list(map(int,sys.stdin.readline().split()));
print(solution2(n, myList));