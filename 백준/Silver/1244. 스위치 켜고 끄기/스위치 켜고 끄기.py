N=int(input())
switch=list(map(int,input().split()))
switch.insert(0,0) #인덱스 편하게하려고

student=int(input())

for _ in range(student):
    sex,idx=map(int,input().split())
    if(sex==1) :#남자일때
        for i in range(idx,len(switch),+idx) :
            if(switch[i]==0):switch[i]=1
            else: switch[i]=0


    else : #여자일때
        if(switch[idx]==0):switch[idx]=1 #일단 주어진건 바꾸고 시작
        else: switch[idx]=0
        cnt=1
        while(idx-cnt>0 and idx+cnt<=len(switch)-1 ):
            if(switch[idx-cnt]==switch[idx+cnt]):
                if(switch[idx-cnt]==0):
                    switch[idx-cnt],switch[idx+cnt]=1,1
                    cnt+=1
                else:
                    switch[idx - cnt], switch[idx + cnt] = 0, 0
                    cnt+=1
            else :
                break
cnt=0
for i in range(1,len(switch)) :

    if(cnt==20):
        print()
        cnt=0
    print(switch[i],end=" ")
    cnt+=1
