s=input()
cnt=0
Flag=False
Flag2=False
if(s[0]==" "):Flag=True
if(s[len(s)-1]==" "):Flag2=True



for i in s :
    if(i==" ") :
        cnt+=1
if(Flag and Flag2) :
    print(cnt-1)
elif(Flag or Flag2):
    print(cnt)
else :
    print(cnt+1)
