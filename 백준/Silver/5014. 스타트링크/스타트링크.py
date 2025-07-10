import sys
input=sys.stdin.readline
from collections import deque

F, S, G, U, D=map(int,input().split())
visited=[0]*(F+1)
move=[]
if(U==0) :
    move.append(-D)
elif(D==0):
    move.append(U)
else :
    move.append(-D)
    move.append(U)

queue=deque()
queue.append(S)
check=False
while(queue) :
    cur=queue.popleft()
    if(cur==G) :
        print(visited[cur])
        check=True
        break
    for i in move :
        nx=cur+i
        if(nx<=0 or nx>=(F+1)) : continue #범위체크
        if(visited[nx]!=0) : continue
        queue.append(nx)
        visited[nx]=visited[cur]+1

if(not check) :
    print("use the stairs")





