import sys
import re

def solution(s):
    arr = re.split(r'[ -]', s);
    reg = r'^(c|j|n|m|t|s|l|l|d|qu|s)\'(a|e|i|o|u|h)[a-z]*'

    count = len(arr)
    for e in arr:
        if re.search(reg, e):
            count +=1  
            # print(e, True)
        
    return count


s = sys.stdin.readline();
print(solution(s));