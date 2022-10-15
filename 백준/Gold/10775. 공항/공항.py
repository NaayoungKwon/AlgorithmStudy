import sys

def union(parent, root, g):
    root = parent[root];
    g = parent[g];
    parent[g] = root;

def find(parent, i):
    if parent[i] != i:
        parent[i] = find(parent,parent[i]);
    return parent[i];
    
def solution(G,P,gateList):
    
    result = 0;
    parent = [0] * (G+1);
    for i in range(1, G+1):
        parent[i] = i;
         
    for g in gateList:
        root = find(parent, g);
        if root == 0:
            break;
        result += 1;
        union(parent, root-1, root);
            
    return result;
  
G = int(sys.stdin.readline());
P = int(sys.stdin.readline());
myList = [int(sys.stdin.readline()) for i in range(P)];
print(solution(G,P,myList));