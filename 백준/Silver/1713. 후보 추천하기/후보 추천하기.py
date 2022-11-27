import sys

def solution(n,m,que):

    pic = [];
    vote = [];
    for p in que:
        if p in pic:
            idx = pic.index(p);
            vote[idx] += 1;
        elif len(pic) < n:
            pic.append(p);
            vote.append(1);
        else:
            idx = vote.index(min(vote));
            pic = pic[:idx] + pic[idx+1:] + [p] ;
            vote = vote[:idx] + vote[idx+1:] + [1] ;
    pic.sort();
    return pic;
  
n = int(sys.stdin.readline());
m = int(sys.stdin.readline());
myList = list(map(int,sys.stdin.readline().split()));
print(*solution(n,m,myList));