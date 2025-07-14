N,M,K=map(int,input().split())
arr=[[0]*M for _ in range(N)]
visited=[[0]*M for _ in range(N)]
from collections import deque
result=[]
def BFS(startx,starty) :
    big=1
    visited[startx][starty]=1
    queue=deque()
    queue.append((startx,starty))
    while(queue) :
        curx,cury=queue.popleft()
        for i in [(1,0),(0,1),(-1,0),(0,-1)] :
            nx=curx+i[0]
            ny=cury+i[1]
            if(nx<0 or ny<0 or nx>=N or ny>=M): continue
            if(visited[nx][ny]!=0 or arr[nx][ny]==1): continue
            queue.append((nx,ny))
            visited[nx][ny]=visited[curx][cury]+1
            big+=1

    result.append(big)
for _ in range(K) :
    lx,ly,rx,ry=map(int,input().split())

    for y in range(ly,ry):
        for x in range(lx,rx) :
            arr[N-1-y][x]=1  #y축은 증가하는 방향이 반대니까
cnt=0


for x in range(N):
    for y in range(M) :
        if(visited[x][y]==0 and arr[x][y]!=1) :
            BFS(x,y)
            cnt+=1

print(cnt)
result.sort()
for i in result :
    print(i,end=" ")