
import sys
input = sys.stdin.readline
n=int(input())
from collections import deque
queue=deque()
for i in range(n) :
    str=input().split() #배열로 변환
    if(str[0]=="push") :
        queue.append(str[1])
    elif(str[0]=="pop") :
        if queue :
            print(queue.popleft())
        else :
            print(-1)


    elif(str[0]=="size"):
        print(len(queue))
    elif(str[0]=="empty") :
        if queue :
            print(0)
        else :
            print(1)
    elif(str[0]=="front") :
        if not queue :
            print(-1)
        else :
            print(queue[0])
    elif(str[0]=="back") :
        if not queue :
            print(-1)
        else :
            print(queue[-1])






