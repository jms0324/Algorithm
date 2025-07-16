T=int(input())
cowlist=[-1]*10
cnt=0
for i in range (T) :
    cow,location=map(int,input().split())
    if(cowlist[cow-1]!=-1 and cowlist[cow-1]!=location) :
        cnt+=1
    cowlist[cow-1]=location


print(cnt)