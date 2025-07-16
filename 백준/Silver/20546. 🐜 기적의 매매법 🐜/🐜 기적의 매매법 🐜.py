cash=int(input())
stock=list(map(int,input().split()))

Bcash=cash #준현
Tcash=cash #성민
Bstock=0 #준현 주식수
Tstock=0 #성민 주식수
#준현
for i in stock :
    if(i<=Bcash) :
        Bstock+=Bcash//i
        Bcash%=i
Bcash+=stock[13]*Bstock


for i in range(3,len(stock)) :
    if(stock[i-3]>stock[i-2] and stock[i-2]>stock[i-1]) : #전량매수
        if(Tcash>=stock[i]) : #매수조건 만족해도 살돈이 있는지 체크

            Tstock+=Tcash//stock[i]
            #Tcash-=Tstock*stock[i] #주식을 이미 늘린상태에서 곱해서 빼버리면 안된다
            Tcash%=stock[i]

    elif(stock[i-2]<stock[i-1] and stock[i-3]<stock[i-2]): #전량매도

        if(Tstock>=1):


            Tcash += Tstock * stock[i]

            Tstock=0


Tcash+=stock[13]*Tstock


if(Bcash>Tcash) :
    print("BNP")
elif(Bcash<Tcash) :
    print("TIMING")
else :
    print("SAMESAME")
