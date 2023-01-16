#!/usr/local/bin/python3
"""
일정한 규칙을 가지고있는 숫자를 나열하는 놀이를 하는 중입니다.
이전 숫자에서 각 숫자의 갯수를 나타내어 숫자로 만들고 다시 그 숫자를 같은 규칙으로 만들며 나열 합니다.
이 놀이는 1부터 시작합니다.
다음수는 1이 1개 이기때문에 '11'이 되고
 '11'에서 1이 2개이기때문에 그 다음은 '12'가 됩니다.
1. 1  → (1)
2. 11 → (1이 1개)
3. 12 → (1이 2개)
4. 1121 → (1이 1개 2가 1개)
5. 1321 → (1이 3개 2가 1개)
6. 122131 → (1이 2개 2가 1개 3이 1개)
7. 132231 → (1이 3개 2가 2개 3이 1개)
위와 같이 진행되는 규칙을 통해 진행횟수 N을 입력받으면 해당되는 수를 출력하세요
def numPlay(num):
    m="1"
    temp=""
    c=0
    nList=[]
    new=[]
    
    for i in range(num):
        for l in m:
            nList.append(l)
            c+=1
            nList.sort()
        c=0
        m=""
        for j in nList:
            if j != temp:
                c=nList.count(j)
                m+=j
                m+=str(c)
                c=0
                temp=j
        new.append(m)
        nList=[]
        temp=""
num=10
print(numPlay(num))
-----------------------
"""
def solution(n):
    answer='1'
    if n == 1:
        return answer
    for i in range(1,n):
        answer = rule(answer)
    return answer
def rule(n):
    num_l = max([int(i) for i in n])
    d = [str(i)+str(str(n).count(str(i))) for i in range(1,num_l+1)]
    return ''.join(d)

num=int("number?")
solution(num)
