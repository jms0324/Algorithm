board=[0,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,0]
#0이면 왼손 1이면 오른손
left,right=input().split()
graph=[]
graph.append(list("qwertyuiop"))
graph.append(list("asdfghjkl0"))
graph.append(list("zxcvbnm000"))
leftx=0
lefty=0
rightx=0
righty=0
for i in range(3):

    for j in range(10) :
        if(left==graph[i][j]):
            leftx=i
            lefty=j
        if(right==graph[i][j]) :
            rightx=i
            righty=j


str=input()
cnt=0
for i in str :
    if(board[ord(i)-97]==0) : #왼손움직임

        for x in range(3):
            for y in range(10):
                if(i==graph[x][y]) :
                    cnt+=abs(leftx-x)
                    cnt+=abs(lefty-y)
                    leftx=x
                    lefty=y

    else :
        for x in range(3):
            for y in range(10) :
                if(i==graph[x][y]) :
                    cnt+=abs(rightx-x)
                    cnt += abs(righty - y)
                    rightx = x
                    righty = y

print(cnt+len(str))


