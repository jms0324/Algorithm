N,K=map(int,input().split())
from collections import deque

move=["back","forward","mul"]

V=[0]*200001


def BFS(start,end) :
    queue=deque()
    queue.append(start)
    V[start]=0
    while(queue) :

        cur=queue.popleft()
        if(cur==end) :
            return V[cur]

        for i in move :
            if(i=="back") :
                nx=cur-1
            elif(i=="forward") :
                nx=cur+1
            else :
                nx=cur*2

            if(nx<0 or nx>=200001): continue
            if(V[nx]!=0): continue
            queue.append(nx)
            V[nx]=V[cur]+1

print(BFS(N,K))