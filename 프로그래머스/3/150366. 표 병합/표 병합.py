
def solution(commands):
    answer = []
    map_ = [[''] * 51 for _ in range(51)]
    parent = []
    for i in range(51):
        t = []
        for j in range(51):
            t.append((i,j))
        parent.append(t)
    
    for command in commands:
        cs = command.split(" ")
        if cs[0] == "UPDATE" and len(cs) == 4:
            r, c, v = int(cs[1]), int(cs[2]), cs[3]
            pa, pc = find(parent, r,c)
            map_[pa][pc] = v

        elif cs[0] == "UPDATE" and len(cs) == 3:
            v1, v2 = cs[1], cs[2]
            for i in range(51):
                for j in range(51):
                    pi, pj = find(parent,i,j)
                    if map_[pi][pj] == v1:
                        map_[pi][pj] = v2

        elif cs[0] == "MERGE":
            r1, c1, r2, c2 = int(cs[1]), int(cs[2]), int(cs[3]), int(cs[4])
            if r1 == r2 and c1 == c2:
                continue
            pr1, pc1 = find(parent, r1, c1)
            pr2, pc2 = find(parent, r2, c2)
            if pr1 < pr2 or (pr1 == pr2 and pc1 < pc2):
                parent[pr2][pc2] = (pr1, pc1)
                t = ''
                if map_[pr1][pc1] != '' and map_[pr2][pc2] != '':
                    t = map_[pr1][pc1]
                elif map_[pr1][pc1] != '' and map_[pr2][pc2] == '':
                    t = map_[pr1][pc1]
                elif map_[pr1][pc1] == '' and map_[pr2][pc2] != '':
                    t = map_[pr2][pc2]
                map_[pr2][pc2] = ''
                map_[pr1][pc1] = t
            elif (pr1 == pr2 and pc1 > pc2) or (pr1 > pr2):
                parent[pr1][pc1] = (pr2, pc2)
                t = ''
                if map_[pr1][pc1] != '' and map_[pr2][pc2] != '':
                    t = map_[pr1][pc1]
                elif map_[pr1][pc1] != '' and map_[pr2][pc2] == '':
                    t = map_[pr1][pc1]
                elif map_[pr1][pc1] == '' and map_[pr2][pc2] != '':
                    t = map_[pr2][pc2]
                map_[pr2][pc2] = t
                map_[pr1][pc1] = ''

        elif cs[0] == "UNMERGE":
            r, c = int(cs[1]), int(cs[2])
            pr, pc = find(parent, r, c)
            nv = map_[pr][pc]
            map_[pr][pc] = ''
            nl = []
            for i in range(51):
                for j in range(51):
                    if find(parent, i,j) == (pr, pc):
                        nl.append((i,j))
            for i, j in nl:
                parent[i][j] = (i,j)
                map_[i][j] = ''
            map_[r][c] = nv
        elif cs[0] == "PRINT":
            r, c = int(cs[1]), int(cs[2])
            pr, pc = find(parent, r, c)
            answer.append((map_[pr][pc] if map_[pr][pc] != '' else "EMPTY"))
    return answer

def find(parent, r,c):
    if parent[r][c] != (r,c):
        parent[r][c] = find(parent, parent[r][c][0], parent[r][c][1])
    return parent[r][c]