h,w=map(int,input().split())

list1=list(map(int,input().split()))

ans=0

for i in range(1,w-1) :
    leftmax=max(list1[:i])
    rightmax=max(list1[i:])
    cur=min(leftmax,rightmax)
    if(list1[i]<cur):
        ans+=cur-list1[i]

print(ans)