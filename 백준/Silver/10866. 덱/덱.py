import sys
input=sys.stdin.readline
from collections import deque
n=int(input())
deq=deque()
for i in range(n) :
    str=input().split()
    if(str[0]=="push_back") :
        deq.append(str[1])
    elif(str[0]=="push_front") :
        deq.appendleft(str[1])
    elif(str[0]=="pop_front") :
        if deq :
            print(deq.popleft())
        else :
            print("-1")
    elif(str[0]=="pop_back") :
        if deq :
            print(deq.pop())
        else :
            print("-1")
    elif(str[0]=="size") :
        print(len(deq))
    elif(str[0]=="empty") :
        if deq :
            print("0")
        else :
            print("1")
    elif(str[0]=="front") :
        if deq :
            print(deq[0])
        else :
            print("-1")
    elif(str[0]=="back") :
        if deq :
            print(deq[-1])
        else :
            print("-1")






