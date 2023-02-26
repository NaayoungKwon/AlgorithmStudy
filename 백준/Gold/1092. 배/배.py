import sys

def solution3(n, limit, m, box):
    limit.sort(reverse=True);
    box.sort(reverse=True);

    if box[0] > limit[0]:
        return -1;
    cnt = 0;
    while box:
        for l in limit:
            for b in box:
                if b <= l:
                    box.remove(b);
                    break;
        cnt += 1;
    
    return cnt;

n = int(sys.stdin.readline());
limit = list(map(int,sys.stdin.readline().split()));
m = int(sys.stdin.readline());
box = list(map(int,sys.stdin.readline().split()));
print(solution3(n, limit, m, box));