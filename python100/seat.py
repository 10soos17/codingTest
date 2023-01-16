#!/usr/bin/python3i

import random

times = 4
nameTag = {}
nameNum=[]
num = 24
newTag={}

while times !=0:
    name = list(map(str,input("name?").split()))
    while len(name) > num:
        name = list(map(str,input("name?").split()))

    for i in name:
        fix = random.randint(1,num)
        while nameNum.count(fix) != 0:
            fix = random.randint(1,num)
        nameNum.append(fix)
        nameTag[i]=fix
        
    for i in nameTag:
        newTag[nameTag[i]] = i
    for i in sorted(newTag):
        print("{}:{},".format(i,newTag[i]), end='')

    times-=1
    nameTag.clear()
    nameNum.clear()
    newTag.clear()
