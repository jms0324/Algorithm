
from collections import deque
check=False
import sys
input=sys.stdin.readline

T=int(input())
def FireBFS(queue,visited) :
    # 불에 시작위치는 이미 큐에 들어간 상태고, visited도 처리완료
    while(queue) :
        curx,cury=queue.popleft()
        for i in [(-1,0),(1,0),(0,1),(0,-1)] :
            nx=curx+i[0]
            ny=cury+i[1]
            if(nx<0 or nx >= N or ny<0 or ny >= M) : continue
            if(arr[nx][ny]=='#' or visited[nx][ny]!=-1) : continue # 범위 체크 및 벽,. 방문 체크
            queue.append((nx,ny))
            visited[nx][ny]=visited[curx][cury]+1   #불의 경로 기록 완료

def PeopleBFS(queue,visited):
    global check

    startx,starty=queue[0] #빼진않음
    visited[startx][starty]=0 #상근이의 시작위치 이미 불이 건들었으므로 초기화 반드시 필요

    while(queue) :
        startx,starty=queue.popleft()
        for i in [(-1, 0), (1, 0), (0, 1), (0, -1)]:
            nx=startx+i[0]
            ny=starty+i[1]
            if(nx<0 or nx >= N or ny<0 or ny >= M) :
                #범위를 넘어 탈출성공했을 떄
                print(visited[startx][starty]+1)
                check=True
                return
            if(arr[nx][ny]=='#' or arr[nx][ny]=='*') : continue #벽은 넘긴다
            if(visited[nx][ny]!=-1 and visited[nx][ny]<=visited[startx][starty]+1): continue #불이 더 빨랐을경우
            visited[nx][ny]=visited[startx][starty]+1
            queue.append((nx,ny))








for _ in range (T) :
    M,N=map(int,input().split())
    arr=[]
    for i in range(N) :
        arr.append(list(input().strip()))
    visited=[[-1] * M for _ in range(N)]

    FireQueue=deque()
    PeopleQueue=deque()
    for i in range(N) :
        for j in range(M) :
            if(arr[i][j]=='*') :
                FireQueue.append((i,j)) #불의 시작위치 넣기(여러개)
                visited[i][j]=0
            elif(arr[i][j]=='@') :
                PeopleQueue.append((i,j)) #상근이의 시작위치 넣기
                #visited처리 조심
    FireBFS(FireQueue,visited)
    PeopleBFS(PeopleQueue,visited)
    if(check==False) :
        print("IMPOSSIBLE")
    check=False

