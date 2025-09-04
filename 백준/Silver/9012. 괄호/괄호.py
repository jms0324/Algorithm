n=int(input())
for i in range(n) :
    stack=[]
    str=input() #문자열입력받기
    check=True
    for j in str :
        if(j=="(") :
            stack.append(j)
        else :
            if stack :
                stack.pop()
            else :
                check=False


    if not stack and check:
        print("YES")
    else :
        print("NO")