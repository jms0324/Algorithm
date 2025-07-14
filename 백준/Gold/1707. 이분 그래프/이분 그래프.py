import sys
input=sys.stdin.readline
from collections import deque
T=int(input())

def BFS(start) :
    check=True

    queue=deque()
    visited[start]=-1
    queue.append(start)
    while(queue) :
        cur=queue.popleft()
        for i in graph[cur] :
            if(visited[i]!= 0 and visited[i]==visited[cur]) : #방문했는데 인접한 정점과 같을 경우 (이분그래프가 아님 )

                return False
            if(visited[i]!=0) : continue #이미 방문한경우 but 인접한 정점과 다를경우
            else :  #방문안한경우
                visited[i]=-visited[cur]
                queue.append(i)
            # if visited[i] == 0:
            #     visited[i] = -visited[cur]
            #     queue.append(i)
            # elif visited[i] == visited[cur]:
            #     return False

    return True


for _ in range(T) :
    V,E=map(int,input().split())
    graph=[[]for _ in range(V+1)]

    for i in range(E) :
        a,b=map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    queue=deque()
    check=True
    visited = [0] * (V + 1)
    for i in range(1,V+1) :
        if(visited[i]==0) :
            result=BFS(i)
            if(not result) :
                check=False
                break

    if(check) :
        print("YES")
    else :
        print("NO")




