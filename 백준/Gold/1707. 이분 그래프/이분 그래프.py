import sys
input=sys.stdin.readline
T=int(input())
from collections import deque



def BFS(start,visited) :
    queue= deque()
    queue.append(start)
    visited[start]=1
    while(queue) :

        cur=queue.popleft()

        for i in list1[cur] :
            if(visited[i]==0) : #아직 방문안한곳이라면
                visited[i]=-1*visited[cur]
                queue.append(i)

            elif(visited[cur]==visited[i]) : #이미 방문햇엇음
                    return False
    return True



for _ in range(T) :
    V,E=map(int,input().split())
    visited=[0]*(V+1) #방문체크
    list1=[[] for _ in range(V+1)]
    for i in range(E) :
        a,b=map(int,input().split())
        list1[a].append(b)
        list1[b].append(a)  #연결그래프 구현

    result=True

    #다른 색깔로 칠해가면서 만약 같은색이 인접해잇으면 fals
    for i in range(1, V+1) :
        if(visited[i]==0) :
            result=BFS(i,visited)
            if(not result) :
                break


    if(result): print("YES")
    else:print("NO")






