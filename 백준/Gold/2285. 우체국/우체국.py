import sys
import heapq

def solution(n, next_people, town):

    minValue = sum([ abs(town[i][0] - town[0][0] ) * town[i][1] for i in range(1, n) ]);
    minIdx = town[0][0];

    prev_people = town[0][1];
    next_people -= town[0][1];
    prev_value = minValue;
    for idx in range(1, n): 
        l = town[idx][0];
        total = prev_value + abs(town[idx-1][0] - l ) * ( prev_people - next_people ); 

        if minValue > total:
            minValue = total;
            minIdx = town[idx][0];

        prev_people += town[idx][1];
        next_people -= town[idx][1];
        prev_value = total;

    return minIdx;
  
n = int(sys.stdin.readline());
myList = [];
total_person = 0;

for i in range(n):
    x, a = map(int,sys.stdin.readline().split());
    myList.append([x,a]);
    total_person += a;
    # heapq.heappush(myList, (x*a, (a,x)));
myList.sort(key = lambda x : x[0]);
print(solution(n, total_person, myList));