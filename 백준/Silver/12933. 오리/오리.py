s=input()
arr=["q","u","a","c","k"]
visited=[False]*len(s)
cnt=0

def Find(start):
    global cnt
    idx=0
    isFirst=True
    for i in range(start,len(s)) :
        if(visited[i]!=True and arr[idx]==s[i]):
            visited[i]=True
            if(s[i]=="k"):
                if(isFirst):
                    cnt+=1
                    isFirst=False
                idx = 0
                continue
            idx+=1







if(len(s)%5!=0):
    print("-1")
    exit()
if(s[0]!="q") :
    print("-1")
    exit()



for i in range(len(s)) :
    if(visited[i]!=True and s[i]=='q'):
        Find(i)

if(cnt==0 or not all(visited)):
    print("-1")
    exit()

print(cnt)