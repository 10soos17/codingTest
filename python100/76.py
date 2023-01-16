import random

def mine(width,high):
    land=[[0]*int(width)for i in range(int(high))]
    for i in range(len(land)):
        for j in range(len(land[0])):
            land[i][j] = random.randint(0,1)
    count=[]
    n=len(land)
    m=len(land[0])
    for i in range(n-1):
        for j in range(m-1):
            if i == 0:
                if j == 0:
                    count.append(land[i][j+1]+land[i+1][j+1]+land[i+1][j])
                elif j == n-1:
                    count.append(land[i][j-1]+land[i+1][j]+land[i+1][j-1])
                else:
                    count.append(land[i][j-1]+land[i][j+1]+land[i+1][j+1]+land[i+1][j]+land[i+1][j-1])
                
            elif i == n-1:
                if j == 0:
                    count.append(land[i-1][j]+land[i-1][j+1]+land[i][j+1])
                                
                elif j == m-1:
                    count.append(land[i][j-1]+land[i-1][j-1]+land[i-1][j])
                    
                else:
                    count.append(land[i][j-1]+land[i-1][j-1]+land[i-1][j]+land[i-1][j+1]+land[i][j+1])
            else:
                count.append(land[i][j-1]+land[i-1][j-1]+land[i-1][j]+
                land[i-1][j+1]+land[i][j+1]+land[i+1][j+1]+
                land[i+1][j]+land[i+1][j-1])
    return max(count)

a, b = input().split()
print(mine(a,b))
