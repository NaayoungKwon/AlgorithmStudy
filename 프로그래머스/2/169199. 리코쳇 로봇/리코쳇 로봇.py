import heapq

def find_start(board):
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == 'R':
                return (i,j)
            
def get_edge(board, p, d):
    l = 1
    r,c = len(board), len(board[0])
    prev = p[0],p[1]
    a,b = p[0],p[1]
    
    for i in range(1, max(r,c)):
        a, b = p[0] + d[0]*i, p[1] + d[1]*i
        if a < 0 or a >= r or b < 0 or b >= c:
            return prev
        elif board[a][b] == 'D':
            return prev
        prev = (a,b)
    return prev
        
def solution(board):
    r,c = len(board), len(board[0])
    # find start point
    start = find_start(board)
    dirs = [[0,1],[1,0],[0,-1],[-1,0]]
    M = 100 * 10000 * 1000
    visited = [[M] * c for _ in range(r)]
    que = []
    
    heapq.heappush(que, (0, start))
    visited[start[0]][start[1]] = 0
    
    result = M
    
    while que:
        l, p = heapq.heappop(que)
        # l = -l
        
        for d in dirs:
            a,b = get_edge(board, p, d)
            # print(a,b)
            if a < 0 or a >= r or b < 0 or b >= c or visited[a][b] < visited[p[0]][p[1]] +1:
                continue
            if board[a][b] == 'G':
                # print(a,b,l, board[a][b])
                result = min(result, -l +1)
                visited[a][b] = visited[p[0]][p[1]] +1
                continue
            heapq.heappush(que, (l-1, (a,b)))
            visited[a][b] = visited[p[0]][p[1]] +1
            # print(a,b,p,abs(l)+1)
        
    return result if result < M else -1 