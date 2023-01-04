import sys

def find_char(s, idx, ch):

    return idx;

def solution(s):

    idx = 0;
    seq = ["A","F","C"];
    range_arr = ["B", "D", "E"];
    if s[0] in range_arr:
        idx = 1;
    elif s[0] not in (range_arr + seq):
        return False;

    for c in seq:
        prev_idx = idx;
        while s[idx] == c:
            idx += 1;
        
        if prev_idx == idx:
            return False;
    
    if idx == len(s) -1 or (idx == len(s)-2 and s[idx] in (seq+range_arr)):
        return True;

    return False;

n = int(sys.stdin.readline());
myList = [sys.stdin.readline() for _ in range(n)];
for s in myList:
    print("Infected!" if solution(s) else "Good");