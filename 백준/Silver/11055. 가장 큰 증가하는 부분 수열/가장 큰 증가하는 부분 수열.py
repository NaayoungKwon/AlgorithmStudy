import sys

def solution(n, l):

    result = 0;
    dp_sum = [i for i in l]
    for i in range(n):
        for j in range(i):
            if l[j] < l[i]:
                dp_sum[i] =  max(dp_sum[i], dp_sum[j] + l[i])


    return max(dp_sum)

n = int(sys.stdin.readline());
myList = list(map(int,sys.stdin.readline().split())) ;
print(solution(n, myList));