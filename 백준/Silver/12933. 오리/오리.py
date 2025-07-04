duck=input()
visited=[False]*len(duck)

if (len(duck)%5!=0) :  #울음소리의 길이체크
    print("-1")
    exit()


sound=['q','u','a','c','k']
cnt=0 #오리세는 변수
def find(start) :
    idx=0
    global cnt
    isFirst=True
    for i in range(start,len(duck)) :
        if(visited[i]!=True and duck[i]==sound[idx]) :
            visited[i]=True
            if(sound[idx]=='k') :
                if(isFirst) :
                    cnt+=1
                    isFirst = False  #k못찾으면 +=1이 걔ㅖ속된다
                idx = 0
                continue
            idx +=1







for i in range(len(duck)) :
    if(visited[i]==False and duck[i]=='q') :
        find(i)

if(cnt==0 or not all(visited)) :
    print("-1")
    exit()
print(cnt)











