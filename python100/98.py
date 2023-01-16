#!/usr/local/bin/python3
"""
패션의 선도주자 청길이는 패션의 발전을 위해 패션쇼를 방문해 유니크한 아이템을 조사하기로 하였습니다.
청길이는 입장하는 사람들의 패션에서 처음 보는 아이템 만을 기록합니다. 이때 청길이의 기록에서 아래 규칙에 맞게 배열로 출력해주세요.

    1. 청길이는 각 옷의 종류를 정수로 기록해 놓습니다.
         ex)입력은  "1번: 3,1 2번: 4 3번: 2,1,3 4번: 2,1,3,4" 형태의 문자열 입니다.
    2. 기록은 청길이가 번호 순서로 유니크한 옷의 번호를 적습니다.
    3. 유니크한 옷은 기록된 순서로 추출되고 출력됩니다.
         ex)출력은 [3,1,4,2] 입니다.
import re

def solution(i):
	#먼저 번호로 자릅니다.
	idx = re.split("[0-9]번: ",i)
	#잘라낸 문자열에 맨 앞이 "", 공백문자열이들어간 배열을 없애줍니다 
	idx = idx[1:]
	for i in range(len(idx)):
			#띄어쓰기를 없애주고 , 단위로 잘라줘요
	    idx[i] = idx[i].replace(" ","").split(",")
	    for j in range(len(idx[i])):
	        idx[i][j] = int(idx[i][j])
	answer = []
	for i in idx:
	    for j in i:
	        if j in answer:
	            pass
	        else:
	            answer.append(j)
	return answer

i = "1번: 3,1 2번: 4 3번: 2,1,3 4번: 2,1,3,4"
solution(i)
---------
import re

def solution(s):
    answer = []
    l = re.split('[0-9]번: ', s)[1:]
    for i in range(len(l)):
        l[i] = list(map(int, l[i].replace(' ', '').split(',')))
    for i in l:
        for j in i:
            if j in answer:
                pass
            else:
                answer.append(j)
    return answer

i = '1번: 3,1 2번: 4 3번: 2,1,3 4번: 2,1,3,4'
solution(i)
------------
"""
def solution(text):
    order = list(text.split(" "))
    reorder=[]
    
    a=0
    for i in order:
        if a%2 == 1:
           order[a] = list(i.split(","))
           a+=1
        else:
            a+=1
    a=0
    for i in order:
       if a%2 == 1:       
          for j in order[a]:
              if reorder.count(j) == 0:
                  reorder.append(j)
          a+=1
       else:
           a+=1

    print(reorder)
text="1번: 3,1 2번: 4 3번: 2,1,3 4번: 2,1,3,4"    
solution(text)


def unique(item):
    record = list(item.split(" "))
    one=[]
    res=[]
    for i in range(1,len(record),2):
        one.append(record[i].split(","))
    for i in one:
        for j in i:
            if j not in res:
                res.append(j)
    return res
        
item="1번: 3,1 2번: 4 3번: 2,1,3 4번: 2,1,3,4"
print(unique(item))
