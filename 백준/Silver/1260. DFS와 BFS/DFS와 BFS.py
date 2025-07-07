from collections import deque
def dfs(start):
    ans_dfs.append(start) #방문노드를 찍기위해추가
    visited[start]=1 #방문표
    for i in graph[start]:
        if(visited[i]==0):
            dfs(i)



def bfs(start):
    queue=deque()
    queue.append(start)
    ans_bfs.append(start)
    visited[start]=1
    while(queue):
        current=queue.popleft()
        for next in graph[current] :
            if(visited[next]==0) :
                queue.append(next)  # 방문 안한 노드 -> 큐에 삽입
                ans_bfs.append(next)
                visited[next]=1






N,M,V =map(int,input().split())

graph = [[] for _ in range(N+1)]

for i in range(M) :

    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1,N+1) :
    graph[i].sort()   #그래프 오름차순 정렬

visited=[0] * (N+1)
ans_dfs=[]
dfs(V)



visited=[0] * (N+1)
ans_bfs=[]
bfs(V)

print(*ans_dfs)
print(*ans_bfs)

#함수는 맨 마지막에 짜자

