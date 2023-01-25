import sys

def 선호친구위치(friends, seat):
    result = [];
    for friend in friends:
        if seat[friend] != (0,0):
            result.append(seat[friend]);
    return result;

def 인접한칸의수(i,j,like,map_):
    cnt = 0;
    empty = 0;
    for x, y in [[1,0], [0,1],[-1,0],[0,-1]]:
        new_i = i + x;
        new_j = j + y;
        if new_i > 0 and new_i <= n and new_j > 0 and new_j <= n:
            if (new_i, new_j) in like:
                cnt += 1;
            elif map_[new_i][new_j] == False:
                empty += 1;
    return (cnt, empty);

def solution(people, hope, seq):

    result = 0;
    seat = [(0,0)] * (people+1);
    map_ = [[False] * (n+1) for _ in range(n+1)];

    for student in seq:
        like = 선호친구위치(hope[student], seat);
        max_num = -1;
        max_seat = (0,0);
        max_empty = 0;
        for j in range(1,n+1):
            for i in range(1,n+1):
                if map_[i][j] == False:
                    num, empty = 인접한칸의수(i,j,like, map_);
                    # print(student, num,empty)
                    if max_num < num or (max_num == num and max_empty < empty):
                        max_num = num;
                        max_seat = (i,j);
                        max_empty = empty;

        seat[student] = max_seat;
        map_[max_seat[0]][max_seat[1]] = True;
    
    score = [0,1,10,100,1000];
    # print(seat);
    for student in seq:
        i, j = seat[student];
        like = 선호친구위치(hope[student], seat);
        num, empty = 인접한칸의수(i,j,like, map_);
        # print(student, num)
        result += score[num];
    return result;

n = int(sys.stdin.readline());
myList = [[] for _ in range(n*n +1)];
seq = [];
for _ in range(n*n):
    arr = list(map(int,sys.stdin.readline().split()));
    myList[arr[0]] = arr[1:];
    seq.append(arr[0]);
print(solution(n*n, myList,seq));