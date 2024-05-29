import sys
import heapq

def solution(n, men, women):

    result = 0;
    men.sort()
    women.sort(reverse=True)
    m, w = 0, 0

    while m < n and w < n:
        if men[m] < 0 and women[w] > 0:
            if -men[m] > women[w]:
                result += 1
                m += 1
                w += 1
            else:
                w += 1
        elif men[m] > 0 and women[w] < 0:
            if men[m] < -women[w]:
                result += 1
                m += 1
                w += 1
            else:
                w += 1
        elif men[m] < 0 and women[w] < 0:
            m += 1
        else:
            w += 1


    return result

n = int(sys.stdin.readline());
men = list(map(int,sys.stdin.readline().split())) ;
women = list(map(int,sys.stdin.readline().split())) ;
print(solution(n, men, women));