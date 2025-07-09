T=int(input())
from collections import deque
dirx=[2,2,1,1,-1,-1,-2,-2]
diry=[1,-1,2,-2,2,-2,-1,1]  #나이트 이동 움직임


def BFS(x,y,visited) :
    global wantx
    global wanty
    queue = deque()
    queue.append((x, y))
    visited[x][y]=1
    while(queue) :
        curx,cury=queue.popleft()
        for i in range(8) :
            nx=curx+dirx[i]
            ny=cury+diry[i]
            if(nx==wantx and ny == wanty) :
                return visited[curx][cury]
            if(nx<0 or nx>=N or ny<0 or ny>=N) :continue
            if(visited[nx][ny]!=0) : continue
            queue.append((nx,ny))
            visited[nx][ny]=visited[curx][cury]+1






for _ in range(T) :
    N=int(input())
    startx,starty=map(int,input().split())
    wantx, wanty = map(int, input().split())

    graph=[[0] * N for _ in range(N)] #탐색할 그래프
    visited = [[0] * N for _ in range(N)]

    if(startx == wantx and starty==wanty) :
        print(0)
        continue

    print(BFS(startx,starty,visited))








