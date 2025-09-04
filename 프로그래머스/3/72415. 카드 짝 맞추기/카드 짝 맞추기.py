import collections

def solution(board, r, c):
    answer = 10000000

    number_set = set()
    pos = collections.defaultdict(list)
    n = len(board)
    m = len(board[0])
    for i in range(n):
        for j in range(m):
            if board[i][j] > 0:
                number_set.add(board[i][j])
                pos[board[i][j]].append([i,j])

    stack = []
    stack.append((board, (r,c), 0, set()))
    while len(stack) > 0:
        node = stack.pop()
        if len(node[3]) == len(number_set):
            answer = min(answer, node[2])
        for s in number_set:
            if s in node[3]:
                continue
            n_borad = [node[0][q][:] for q in range(len(board))]
            n_borad[pos[s][0][0]][pos[s][0][1]] = 0
            n_borad[pos[s][1][0]][pos[s][1][1]] = 0
            ns = set(list(node[3]))
            ns.add(s)
            m1 = cal_dist(node[0], node[1], pos[s][0], pos[s][1])
            if m1 < answer:
                stack.append((n_borad, pos[s][1], node[2] + m1 + 2, ns))
            m2 = cal_dist(node[0], node[1], pos[s][1], pos[s][0])
            if m2 < answer:
                stack.append((n_borad, pos[s][0], node[2] + m2 + 2, ns))
    
    return answer

def cal_dist(board, cur, n1, n2):
    return cal_sub(board, cur, n1) + cal_sub(board, n1, n2)

def cal_sub(board, start, end):
    n = len(board)
    m = len(board[0])
    visited = [[False] * m for _ in range(n)]

    min_l = 10000 * 1000
    dirs = [[1, 0], [0, -1], [-1, 0], [0,1]]

    queue = collections.deque()
    queue.append((start ,0))
    visited[start[0]][start[1]] = True
    while len(queue) > 0:
        cur, l = queue.popleft()
        if cur[0] == end[0] and cur[1] == end[1]:
            # print(start, end, l)
            # min_l = min(min_l , l)
            # continue
            return l

        for d in dirs:
            nx = cur[0] + d[0]
            ny = cur[1] + d[1]
            if nx < 0 or nx >= n or ny < 0 or ny >= m or visited[nx][ny]:
                continue
            visited[nx][ny] = True
            queue.append(([nx, ny], l+1))
        
        for d in dirs:
            nlx = cur[0]
            nly = cur[1]
            while True:
                nlx += d[0]
                nly += d[1]
                if nlx < 0 or nlx >= 4 or nly < 0 or nly >= 4:
                    nlx -= d[0]
                    nly -= d[1]
                    break

                # print(nlx, nly)
                if board[nlx][nly] != 0:
                    break
            # print(nlx, nly)
            if not (nlx < 0 or nlx >= 4 or nly < 0 or nly >= 4) and visited[nlx][nly] == False:
                visited[nlx][nly] = True
                queue.append(([nlx, nly], l+1))

    # print(start, end, min_l)
    return min_l
