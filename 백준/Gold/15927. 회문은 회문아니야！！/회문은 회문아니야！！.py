import sys

def isPalindrome(str):
    last = len(str)-1;
    for i in range((last//2) + 1):
        if str[i] != str[last-i]:
            return False;
    return True;
def solution(str):

    result = -1;
    l = len(str);
    if len((set(str))) == 1:
        return -1;
    if isPalindrome(str) == False:
        result = max(result, l);
    else:
        result = max(result, l-1);
    return result;
  
str = list(sys.stdin.readline().split('\n')[0]);
print(solution(str));