N=int(input())
sentence=input()
numlist=[]
for i in range(N) :
    numlist.append(int(input()))



stack=[]
for x in sentence :

    if("A"<=x<="Z") :
        stack.append(numlist[ord(x)-ord("A")])


    else :
        res2=stack.pop()
        res1=stack.pop()
        result = 0
        if(x=="*") :
            result+=res1*res2



        elif(x=="+") :

            result+=res1+res2

        elif(x=="/") :

            result+=res1/res2

        elif(x=="-") :

            result+=res1-res2

        stack.append(result)

print("%.2f" %stack[0])


