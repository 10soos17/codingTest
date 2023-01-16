#!/usr/local/bin/python3
#다음의 딕셔너리가 주어졌을 때 한국의 면적과 가장 비슷한 국가와 그 차이
"""
natVal = list(nationWidth.items()), 딕의 (key,value) 셋트로 묶어 리스트로 만들기
natVal = list(nationWidth.values()), 딕의  vlaue만 리스트로 만들기
natKey = list(nationWidth.keys()), 딕의 키값만 리스트로 만들기
abs(), 절대값
-------------
nationWidth = {'korea': 220877,'Rusia': 17098242,'China': 9596961,'France': 543965,'Japan': 377915,'England' : 242900 }
width=list(nationWidth.values())
nation=list(nationWidth.keys())
count=0
gap=abs(nationWidth['Rusia']-nationWidth['korea'])
mini=""
for i in width:
    if nationWidth['korea'] == i:
        count+=1
        continue
    if abs(i - nationWidth['korea']) < gap:
        gap=abs(i - nationWidth['korea'])
        mini=nation[count]
    count+=1

print(mini)
-------------
nationWidth = {
    'korea': 220877, 
    'Rusia': 17098242, 
    'China': 9596961, 
    'France': 543965, 
    'Japan': 377915,
    'England' : 242900,
}

w = nationWidth['korea']
nationWidth.pop('korea')
l = list(nationWidth.items())
gap = max(nationWidth.values())
item = 0

for i in l:
    if gap > abs(i[1] - w):
        gap = abs(i[1] - w)
        item = i
print(item[0],item[1]-220877)
------------------
nationWidth = {
  'korea': 220877,
  'Rusia': 17098242,
  'China': 9596961,
  'France': 543965,
  'Japan': 377915,
  'England' : 242900 }
i = 0
nation = 'korea'
natVal = list(nationWidth.values())
natKey = list(nationWidth.keys())
for i in range(len(natVal)-2) :
   if abs(natVal[0] - natVal[i+1]) > abs(natVal[0] - natVal[i+2]):
      distance = abs(natVal[0] - natVal[i+2])
      secNation = natKey[i+2]
   else:
       distance = abs(natVal[0] - natVal[i+1])
       secNation = natKey[i+1]
print(secNation, distance)
-----------
"""
def search(data):
    ko = data['korea']
    del(data['korea'])
    len(data)
    for i in data:
        value = abs(ko-data[i])
        for j in data:
            if value !=0 and abs(ko-data[j]) < value:
                value = ko-data[j]
                key = j
    return key, value 


data = {'korea': 220877,'Rusia': 17098242,'China': 9596961,'France': 543965,'Japan': 377915,'England' : 242900 }
print(search(data))
