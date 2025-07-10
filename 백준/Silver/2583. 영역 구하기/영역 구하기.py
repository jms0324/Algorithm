import sys
input=sys.stdin.readline
print=sys.stdout.write
from collections import deque
N,M,K=map(int,input().split())

ans=[]

def BFS(x,y,visited) :
    global ans
    cnt=0
    queue=deque()
    queue.append((x,y))
    visited[x][y]=1
    while(queue) :
        curx,cury=queue.popleft()
        cnt+=1 #뺄때 카운트
        for i in [(0,1),(1,0),(-1,0),(0,-1)] :
            nx=curx+i[0]
            ny=cury+i[1]
            if(nx<0 or ny<0 or nx>=N or ny>=M):continue#범위
            if(visited[nx][ny]==1 or arr[nx][ny]==1):continue #직사각형 만나거나 이미 방문했을떼ㅐ
            visited[nx][ny]=1 #방문처리
            queue.append((nx,ny))
    ans.append(cnt)




arr = [[0] * M for _ in range(N)]
for i in range(K):
    lx, ly, rx, ry = map(int, input().split())

    for y in range(ly, ry):         # 세로 좌표 (y축 → 행 인덱스)
        for x in range(lx, rx):     # 가로 좌표 (x축 → 열 인덱스)
            arr[N - 1 - y][x] = 1   # y좌표를 위로 뒤집어서 행 번호로 바꿈







visited=[[0]*M for _ in range(N)]
ccnt=0

for i in range (N) :
    for j in range(M) :
        if(arr[i][j]!=1 and visited[i][j]!=1) :
            BFS(i,j,visited)
            ccnt+=1

print(str(ccnt)+"\n")
ans.sort()
for i in ans :
    print(str(i)+" ")




