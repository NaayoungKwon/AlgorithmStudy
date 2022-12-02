import sys

def solution(n, Alist):

    Alist.sort();
    result = 0;
    for k in range(n):
        prevSum = sum(Alist[:k]);
        minSum = Alist[k] * k - prevSum;
        for i in range(1, len(Alist)-k):
            minSum = min(minSum,  Alist[i+k] * k - (prevSum + Alist[i+k-1] - Alist[i-1]));
            prevSum += (Alist[i+k-1] - Alist[i-1]);
        # print(minSum)
        result += minSum;
    return result

  
T = int(sys.stdin.readline());
result = [];
for i in range(T):
    myList = list(map(int,sys.stdin.readline().split()));
    result.append(solution(myList[0], myList[1:]));

for i in result:
    print(i)