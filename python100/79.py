#!/usr/local/bin/python3
"""여기서 변하기 전 원소와 변한 후 원소의 값의 차가 가장 작은 값을 출력하는 프로그램을 작성하세요.

예를 들어 2번 순회했을 때 변하기 전의 리스트와 변한 후의 리스트의 값은 아래와 같습니다.

**순회전_리스트 = [10, 20, 25, 27, 34, 35, 39]
순회후_리스트 = [35, 39, 10, 20, 25, 27, 34]
리스트의_차 = [25, 19, 15, 7, 9, 8, 5]**

39와 변한 후의 34 값의 차가 5이므로 리스트의 차 중 최솟값 입니다.
따라서 39와 34의 인덱스인 6과 39와 34를 출력하는 프로그램을 만들어주세요.

l = [10, 20, 25, 27, 34, 35, 39] #기존 입력 값
n = int(input('순회 횟수는 :'))

def rotate(inL, inN):
    newL = [""] * len(l)
    minL = [""] * len(l)
    i = 0
    a = 0
    for i in range(len(l)):
        if i+n < len(l):
            newL[i+n] = l[i]
            i += 1
        else:
            a = i+n-len(l)
            newL[a] = l[i]
            i += 1
    i=0
    for i in range(len(l)):
        if l[i] >= newL[i]:
            minL[i] = l[i] - newL[i]
            i+=1
        else:
            minL[i] = newL[i] - l[i]
            i+=1
    i=1
    mindex=0
    while i < len(minL):
        if (minL[i-1] < minL[i]) and (minL[i-1] <= minL[mindex]):
            mindex = i-1
        elif i==len(minL)-1 and (minL[i] <= minL[mindex]):
            mindex = i
        i+=1
        
    print("index: {} \nvalue: {},{}".format(mindex,l[mindex],newL[mindex]))
    

rotate(l, n)
------------
l = [10, 20, 25, 27, 34, 35, 39] #기존 입력 값
r=l.copy()
n = int(input('순회 횟수는 :'))
x=[""]*len(l)

def rotate(inL, inN):
    a=0
    while inN !=0:
        l.insert(0,inL.pop())
        inN-=1
    for i in r:
        x[a]=abs(i-l[a])
        a+=1
    a=0
    for i in x:
        if i == min(x):
            print(a)
        a+=1

rotate(l, n)
--------------
def minus(a,num):
    b=a.copy()
    minus={}
    minVal=[]
    for i in range(1,num+1):
        c=b.pop(-1)
        b.insert(0,c)

    for i in range(len(a)):
        minus[abs(a[i]-b[i])]=[i,a[i],b[i]]
        minVal.append(abs(a[i]-b[i]))
    
    res=minus[min(minVal)]
    return res

print(minus(a,num))
-------------------
"""
l = [10, 20, 25, 27, 34, 35, 39] #기존 입력 값
turn = int(input('순회 횟수는 :'))

def sol(a, t):
    b = a.copy()
    c = []
    for i in range(t):
        b.insert(0,b.pop())
    for i,j in zip(a,b):
        c.append(abs(i-j))
    index = c.index(min(c))
    print("index :",index)
    print("value :",a[index],b[index])

sol(l,turn)
