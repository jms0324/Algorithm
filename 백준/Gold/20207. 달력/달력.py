time = int(input())
ans=[0] * 366
col=0
row=0
res=0

for k in range(time) :
    start,end=map(int,input().split())
    for i in range(start,end+1) :
        ans[i]+=1

for i in range(366) :

    if(ans[i]==0) :
        res+=row*col
        col=0
        row=0


    elif(ans[i] != 0) :
        col=max(col,ans[i])
        row +=1

print(res+row*col) #0을 안만나는경우도 잇음 365일째 까지 일정지속되면 기존 res로는 카운트가 안되니 추가해줘야함











