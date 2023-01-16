#!/usr/local/bin/python3

def fifo(m,p):
    page=[]
    t=0
    for i in p:
        if len(page)!=m and i not in page:
            page.append(i)
            t+=6
        elif len(page)==m and i not in page:
            page.pop(0)
            page.append(i)
            t+=6
        else:
            t+=1
    return t

memory=int(input())
page=str(input())
print(fifo(memory,page))
