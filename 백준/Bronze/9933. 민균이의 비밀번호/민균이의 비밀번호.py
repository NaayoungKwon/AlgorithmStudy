import sys

def 회문인가(str, str2):
    print(str, str2);
    for i in range(len(str)):
        if str[i] != str2[i]:
            return False;
    return True;

def solution(arr):
    for i in range(3,14):
        if i % 2 == 0:
            continue;

        for j in range(len(arr[i])):
            if arr[i][j] == arr[i][j][::-1]:
                print(i, arr[i][j][i//2]);
                return ;
            for k in range(j+1,len(arr[i])):
                if arr[i][j] == arr[i][k][::-1]:
                    print(i, arr[i][j][i//2]);
                    return ;
    return True;
  
n = int(sys.stdin.readline());
myList = [[] for _ in range(15)];
for _ in range(n):
    s = sys.stdin.readline().split('\n')[0];
    s_l = len(s);
    myList[s_l].append(s);
solution( myList);