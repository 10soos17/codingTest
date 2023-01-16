#!/usr/local/bin/python3
#a = [1,2,3,4], b = [a,b,c,d]/[[1,a],[b,2],[3,c],[d,4]] a,b리스트가 번갈아 출력
"""
fir = [1,2,3,4]
sec = ["a","b","c","d"]
thi=[""]*len(fir)
a=0
for i in fir:
    if a % 2 == 0:
        thi[a]=[i,sec[a]]
    else:
        thi[a]=[sec[a],i]
    a+=1
print(thi)
---------------------------
"""
a = input().split(' ')
b = input().split(' ')

c = []
count = 0

for i, j in zip(a, b):
	if count % 2 == 0:
		c.append([i, j])
	else:
		c.append([j, i])
	count += 1

print(c)

# [[1,'a'],['b',2],[3,'c'],['d',4]]
