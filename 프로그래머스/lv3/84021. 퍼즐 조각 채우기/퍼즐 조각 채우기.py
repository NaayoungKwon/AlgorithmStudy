from collections import defaultdict

def make_puz(pan,si,sj,ei,ej,ci,cj,size,target):

    n = len(pan)
    m = len(pan[0])
    plus = 0

    for x,y in [[1,0],[0,1], [-1,0],[0,-1]]:
        i = ci + x
        j = cj + y
        if 0 <= i < n and 0 <= j < m and pan[i][j] == target:
            pan[i][j] = 2
            a,b,c,d,e = make_puz(pan,min(si,i),min(sj,j),max(ei,i),max(ej,j),i,j, 1,target)
            plus += a
            ei = max(ei, b,d)
            ej = max(ej , c,e)
            si = min(si, b,d)
            sj = min(sj , c,e)

    return (size+plus, si,sj,ei, ej);

def check_puz(game_board,game_puz, table, puz):
    n = game_puz[2] - game_puz[0] + 1
    m = game_puz[3] - game_puz[1] + 1
    a = puz[2] - puz[0] + 1
    b = puz[3] - puz[1] + 1
    # print(n,m,a,b)


    flag = [True] * 4
    for x in range(n):
        if True not in flag:
            break

        for y in range(m):
            g = game_board[game_puz[0] + x][game_puz[1] + y]
            if n == a and m == b:
                t1 = table[puz[0] + x][puz[1] + y]
                if not ((g == 2 and t1 == 2) or (g != 2 and t1 != 2)) :
                    flag[0] = False

                t2 = table[puz[2] - x][puz[3] - y]
                # print(game_puz[0] + x,game_puz[1] + y, puz[2] - x,puz[3] - y)
                if not ((g == 2 and t2 == 2) or (g == 1 and t2 == 0)) :
                    flag[1] = False
                # print(game_puz[0] + x,game_puz[1] + y ,g,t1,t2)
            else:
                flag[0] = False
                flag[1] = False

            if n == b and m == a:
                t3 = table[puz[2] - y][puz[1] + x]
                if not ((g == 2 and t3 == 2) or (g == 1 and t3 == 0)) :
                    # print(game_puz[0] + x,game_puz[1] + y, puz[3] - y,puz[0] + x,3333)
                    flag[2] = False

                t4 = table[puz[0] + y][puz[3] - x]
                if not ((g == 2 and t4 == 2) or (g == 1 and t4 == 0)) :
                    # print(game_puz[0] + x,game_puz[1] + y, puz[1] + y,puz[2] - x,4444)
                    flag[3] = False
            else:
                flag[2] = False
                flag[3] = False
    # print(flag, game_puz, puz)
    if True in flag:
        return True

    return False

def solution(game_board, table):
    answer = 0
    # 1. dictionary에 key = 크기, value는 모양 배열얼 넣는 table 요소들을 넣는다
    # 2. 보드를 하나씩 순회하다가 0을 만나면 dfs로 모양을 만든다. 
    # 3. 만든 모양의 크기의 key를 가진 배열들을 비교해본다

    dic = defaultdict(list)
    for i in range(len(table)):
        for j in range(len(table[0])):
            if table[i][j] == 1:
                table[i][j] = 2
                size, si,sj,ei, ej = make_puz(table, i,j,i,j,i,j,1,1)
                dic[size].append((si,sj,ei,ej))

    for i in range(len(game_board)):
        for j in range(len(game_board[0])):
            if game_board[i][j] == 0:
                game_board[i][j] = 2
                size,si,sj,ei,ej = make_puz(game_board, i ,j,i,j,i,j,1,0)
                for puz in dic[size]:
                    if check_puz(game_board,(si,sj,ei,ej), table, puz):
                        answer += size
                        dic[size].remove(puz)
                        break
    return answer