from collections import deque
N=int(input()) #노드수
M=int(input()) #간선수
cnt=0

def BFS(start) :
    queue=deque()
    global cnt
    queue.append(start)
    visited[start]=1

    while(queue) :
        current=queue.popleft()
        for i in graph[current] :
            if(visited[i]==0) :
                queue.append(i)
                visited[i]=1
                cnt+=1

def DFS(start) :
    global cnt
    visited[start]=1
    for i in graph[start] :
        if(visited[i]==0) :
            cnt+=1
            DFS(i)




#인접리스트 구현
graph=[[] for _ in range(N+1)]

for i in range(M) :
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

visited=[0] * (N+1)

DFS(1)


print(cnt)

