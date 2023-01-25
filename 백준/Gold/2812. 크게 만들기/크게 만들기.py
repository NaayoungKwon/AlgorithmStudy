import sys

def solution2(n, k, arr):
    st = [];
    cnt = k;
    for c in arr:
        while st and cnt > 0 and st[-1] < c:
            m = st.pop();
            cnt -= 1;
        st.append(c);

    result = '';
    for c in range(n-k):
        result += str(st[c]);
    return result;
n,k = map(int,sys.stdin.readline().split());
a = list(map(int, sys.stdin.readline().strip()));
print(solution2(n, k, a));