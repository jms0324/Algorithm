import sys
N=int(input())
expression=list(input()) #문장입력받기
num_list=[0]*N
for i in range(N) :
    num_list[i]=int(input())  #입력받음



stack=[] #스택선언

for i in expression :
    if("A" <= i <= "Z") : #이게 왜 필요한지 :
        stack.append(num_list[ord(i)-ord("A")])

    else :
        str2=stack.pop()
        str1=stack.pop()
        if(i=="*") :

            stack.append(str1*str2)

        elif(i=="/") :

            stack.append(str1/str2)

        elif(i=="-") :

            stack.append(str1-str2)


        elif(i=="+") :
            stack.append(str1+str2)

print("%.2f" %stack[0])


