import sys

v = int(sys.stdin.readline());
map_ = [0] * (v+1);
visited = [False] * (v+1);
for _ in range(v):
    line = (list(map(int,sys.stdin.readline().split())))[:-1];
    node = line[0];
    dict = {};
    for i in range(1, len(line)-1, 2):
        [end, l ] = line[i:i+2];
        dict[end] = l
    map_[node] = dict;

def dfs(i, l, visited):

    maxL = l;
    maxIdx = i;
    for k, k_len in map_[i].items():
        if visited[k] == False:
            visited[k] = True;
            (m, m_len) = dfs(k, l + k_len, visited);
            visited[k] = False;
            if m_len > maxL:
                maxL = m_len;
                maxIdx = m;
    
    return (maxIdx, maxL);

maxResult = -1;
maxIdx = -1;
visited = [False] * (v+1);
visited[0] = visited[node] = True;
(maxIdx, maxResult) = dfs(node, 0, visited );

visited = [False] * (v+1);
visited[0] = visited[maxIdx] = True;
i = maxIdx;
(m, m_len) = dfs(i, 0, visited );
maxResult = max(maxResult, m_len);

print(maxResult);