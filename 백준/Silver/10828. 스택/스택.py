import sys
input=sys.stdin.readline


n=int(input())
stack=[]
for i in range(n) :
    str=input().split()

    if(str[0]=="push") :
        stack.append(str[1])
    elif(str[0]=="pop") :
        if stack :
            print(stack.pop())
        else :
            print("-1")


    elif(str[0]=="size") :
        print(len(stack))
    elif(str[0]=="empty") :
        if stack :
            print("0")
        else :
            print("1")
    elif(str[0]=="top") :
        if stack :
            print(stack[-1])
        else :

            print("-1")


