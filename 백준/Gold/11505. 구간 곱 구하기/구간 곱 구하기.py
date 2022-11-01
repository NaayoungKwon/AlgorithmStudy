import sys

MAX_VALUE = 1000000007;
n, m, k = map(int,sys.stdin.readline().split());
# h = math.ceil(math.sqrt(n));

nList = [0] + [ int(sys.stdin.readline()) for i in range(n)];
# tree = [0] * (sum([int(math.pow(2,i)) for i in range(h+1)])+1); # + nList[:];
tree = [0] * 3*n;
leaf = [0] *(n+1);

def makeSegmentTree(tree, idx, left, right):
    mid = (left+right)//2;
    if left == right:
        tree[idx] = nList[left];
        leaf[left] = idx;
        return tree[idx];
    
    leftValue = makeSegmentTree(tree, 2*idx, left, mid);
    rightValue = makeSegmentTree(tree, (2*idx)+1, mid+1, right);
    tree[idx] = (leftValue * rightValue) % MAX_VALUE;
    return tree[idx];

def updateSegmentTree(tree, idx):
    left = tree[2*idx];
    right = tree[(2*idx)+1];
    tree[idx] = (left * right) % MAX_VALUE;
    if idx > 1:
        updateSegmentTree(tree, int(idx/2));

def searchSegmentTree(tree, idx, left, right, t_left, t_right):
    
    if left > t_right or right < t_left:
        return 1;
    if left <= t_left and t_right <= right:
        return tree[idx];

    t_mid = (t_left+t_right)//2;
    return (searchSegmentTree(tree, 2*idx, left, right, t_left, t_mid) * searchSegmentTree(tree, 2*idx +1, left, right, t_mid+1, t_right)) % MAX_VALUE;

makeSegmentTree(tree, 1, 1, n);
result = [];
for _ in range(m+k):
    a, b, c = map(int,sys.stdin.readline().split());
    if a == 1:
        tree[leaf[b]] = c;
        updateSegmentTree(tree, leaf[b]//2);
    elif a == 2:
        result.append(searchSegmentTree(tree, 1, b, c, 1, n));

for value in result:
    print(value);

