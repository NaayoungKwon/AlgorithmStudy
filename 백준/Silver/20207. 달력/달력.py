import sys

END_DAY = 365;
n = int(sys.stdin.readline());
cal = [0] * (END_DAY + 10);
result = 0;
for _ in range(n):
    s, e = map(int,sys.stdin.readline().split());
    for i in range(s, e+1):
            cal[i] += 1;

max_cnt = 0;
start = -1;
for i in range(END_DAY+2):
    if cal[i] == 0:
        result += (( i - start) * max_cnt);
        start = -1;
        max_cnt = 0;
    else:
        if start == -1:
            start = i;
        max_cnt = max(max_cnt, cal[i]);
print(result);