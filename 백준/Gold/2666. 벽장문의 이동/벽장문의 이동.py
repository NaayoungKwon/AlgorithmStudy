import sys

def find_door(i, door):
    if i < door[0]:
        return 0
    elif i > door[1]:
        return 2
    else:
        return 1

def get_node(move, idx , door, s):
    i = move[idx]
    position = find_door(i, door)
    q = []
    if position == 0:
        q.append((idx+1, [i, door[1]], s + abs(door[0] - i)))
    elif position == 1:
        q.append((idx+1, [i, door[1]], s + abs(door[0] - i)))
        q.append((idx+1, [door[0], i], s + abs(door[1] - i)))
    else:
        q.append((idx+1, [door[0], i], s + abs(door[1] - i)))
    return q

def solution(n, door, k, move):

    result = 20 * 20 * 20;
    
    que = get_node(move, 0 , door, 0)

    while que:
        idx, new_door, sum_l = que.pop()
        if idx == k:
            result = min(result, sum_l)
            continue
        
        nodes = get_node(move, idx, new_door, sum_l)
        que.extend(nodes)


    return result

n = int(sys.stdin.readline());
a, b = map(int,sys.stdin.readline().split());
k = int(sys.stdin.readline());
move = []
for _ in range(k):
    move.append(int(sys.stdin.readline()))
print(solution(n, [a,b], k,move));