N,M=map(int,input().split())
from collections import deque

graph=[]
visited=[[0]*M for _ in range(N)]

def BFS(x,y,visited) :
    visited[x][y]=1
    queue=deque()
    queue.append((x,y))
    while(queue) :
        a,b=queue.popleft()
        for dx,dy in ((1,0),(0,1),(-1,0),(0,-1)) :
            nx=a+dx
            ny=b+dy
            if(nx<0 or nx >= N or ny<0 or ny>=M):continue
            if(graph[nx][ny]==0 or visited[nx][ny]!=0):continue
            queue.append((nx,ny))
            visited[nx][ny]=visited[a][b]+1



for i in range(N):
    graph.append(list(map(int,input().strip())))


BFS(0,0,visited)

print(visited[N-1][M-1])


