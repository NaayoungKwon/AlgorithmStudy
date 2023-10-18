import sys

def makeLink(arr):

    dic = dict()
    for a,b in arr:
        if a in dic:
            dic[a].append(b)
        else:
            dic[a] = [b]

    return dic

def verify(a,b,linkDict):

    visited = dict()
    que = [a]
    while que:
        root = que.pop(0)
        visited[root] = True
        if root not in linkDict:
            continue
        for c in linkDict[root]:
            if c == b:
                return "T";
            elif c not in visited and c in linkDict:
                que.append(c)

    return "F";

n = int(sys.stdin.readline());
myArr = []
for i in range(n):
    a, iss, b = sys.stdin.readline().split(" ");
    myArr.append([a,b.split("\n")[0]]);
link = makeLink(myArr);
m = int(sys.stdin.readline());
for i in range(m):
    a, iss, b = sys.stdin.readline().split(" ");
    print(verify(a,b.split("\n")[0],link))
