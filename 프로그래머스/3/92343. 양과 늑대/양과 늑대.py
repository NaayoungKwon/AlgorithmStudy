def solution(info, edges):
    answer = []
    n = len(info)
    visited = [False] * n
    
    def dfs(me, xinlong):
        if me > xinlong:
            answer.append(me)
        else:
            return
        
        for s, e in edges:
            if visited[s] and not visited[e]:
                visited[e] = True
                if info[e] == 0:
                    dfs(me+1, xinlong)
                else:
                    dfs(me, xinlong+1)
                visited[e] = False
    
    visited[0] = True
    dfs(1, 0)
    
    return max(answer)