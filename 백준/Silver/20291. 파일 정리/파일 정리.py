import sys
print=sys.stdout.write
N=int(input())
arr=[]
for i in range(N) :
    arr.append(input().split(".")[1])

dict1={}
list1=[]
for i in arr :
    if i in dict1 :
        dict1[i]+=1
    else :
        dict1[i]=1
        list1.append(i)


# list1=list(dict1.keys())
list1.sort()
for i in range(len(list1)) :
    print(str(list1[i])+" ")
    print(str(dict1[list1[i]]))
    print("\n")

