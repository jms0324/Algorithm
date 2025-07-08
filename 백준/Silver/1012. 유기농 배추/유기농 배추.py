T=int(input())
from collections import deque


def BFS(x,y,visited) :
    visited[x][y]=1
    queue=deque()
    queue.append((x,y))
    while(queue) :
        x,y=queue.popleft()
        for dx,dy in ((-1,0),(0,1),(1,0),(0,-1)) :
            nx=x+dx
            ny=y+dy
            if(nx< 0 or nx >=N or ny <0 or ny>=M) : continue
            if(ans[nx][ny]==0 or visited[nx][ny]!=0): continue
            queue.append((nx,ny))
            visited[nx][ny]=1









for _ in range(T) : #테스트케이스
    M,N,K=map(int,input().split()) #M은 열,N은 행,K는 갯수
    cnt=0

    ans=[[0] * M for _ in range(N)]
    visited = [[0] * M for _ in range(N)]


    for i in range(K) :
        a,b=map(int,input().split())
        ans[b][a]=1

    for x in range(N) :
        for y in range(M) :
            if(visited[x][y]!=1 and ans[x][y]==1) :
                BFS(x,y,visited)
                cnt+=1

    print(cnt)




