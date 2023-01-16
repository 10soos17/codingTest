#!/usr/local/bin/python3
"""
1. 지도는 88번 문제의 해답을 사용해주세요
2. 입력값은 지도,캐릭터의 움직임입니다.
3. 캐릭터의 움직임은 {상:1,하:2,좌:3,우:4} 로 정수로 이루어진 배열이 들어갑니다.
4. 벽과 장애물은 통과할 수 없습니다. 
5. 마지막 캐릭터의 위치를 반영한 지도를 보여주고 위치를 반환하는함수를 작성해주세요.
def make_map(n,m,char,obj):
    #지도 초기화하기
                #각 지도 가로/세로 두칸 외벽을 포함한 크기만큼 추가하기(각 끝 한칸씩)
    world_map = [[0]*(n+2) for i in range(m+2)]
    #지도 외벽 그리기
    for i in range(len(world_map)):
        for j in range(len(world_map[0])):
            if i==0 or j==len(world_map[0])-1 or j==0 or i ==len(world_map)-1:
                world_map[i][j]=2
#     print(wordl_map)
    #지도에 캐릭터 추가하기/ 외벽으로 인해 좌표에 +1을 해줍니다.
    world_map[char[0]+1][char[1]+1] = 1
    #지도에 장애물 추가하기
    for i in obj:
#         print(i)
        #장애물을 추가하려는 자리에 캐릭터가 있을 시 캐릭터는 그대로둔다
                                # 마찬가지 외벽으로 인한 좌표 조정을 해준다.
        world_map[i[0]+1][i[1]+1] = 2 if world_map[i[0]+1][i[1]+1] != 1 else 1
    for i in world_map:
        print(i)
def move(world_map, moving):
    x,y = 0,0
    for i,m in enumerate(world_map):
        if 1 in m:
            x,y = m.index(1),i
    world_map[y][x] = 0
    for i in moving:
        if i==1 and world_map[y-1][x]!=2:
            y-=1
            
        elif i==2 and world_map[y+1][x]!=2:
            y+=1
            
        elif i==3 and world_map[y][x-1]!=2:
            x-=1
            
        elif i==4 and world_map[y][x+1]!=2:
            x+=1
    world_map[y][x] = 1
    for i in world_map:
        print(i)
    return [x,y]
n=4
m=5
char=[0,0]
obj=[[0,1],[1,1],[1,3],[2,3]]
make_map(n,m,char,obj)
move=[2,2,2,4,4,4]
----------------------------------------------
x= int(input("x?")) #row count(1 dimention)
y=int(input("y?")) #column count(2 diemention)
shell=[[2]*(y+2) for i in range(x+2)]
a=1
b=1
for i in range(x):
    for j in range(y):
        shell[a][b]=0
        b+=1
    b=1
    a+=1
hero=list(map(int,input("Enter the hero's x and y coordinates separated by commas:").split(",")))
shell[hero[0]+1][hero[1]+1]=1
while y<hero[0]<0 or x<hero[1]<0:
    hero=list(map(int,input("Enter the hero's x and y coordinates separated by commas:").split(",")))
    shell[hero[0]+1][hero[1]+1]=1

enemyCount=int(input("How many enemies are on the map?"))
while enemyCount !=0:
    enemy=list(map(int,input("Enter the obstacle's x and y coordinates separated by commas: ").split(",")))
    shell[enemy[0]+1][enemy[1]+1]=2
    enemyCount-=1
a=0
b=0
for i in range(x+2):
    for j in range(y+2):
        print(shell[a][b], end = "")
        b+=1
    print("\n")
    b=0
    a+=1

move=list(map(int,input("Enter whatever you want to move the main character.").split(",")))

for i in move:
    if i==1:
        shell[hero[0]+1][hero[1]+1]=0
        hero[0]=hero[0]-1
        if shell[hero[0]+1][hero[1]+1]==2:
           hero[0]=hero[0]+1
           shell[hero[0]+1][hero[1]+1]=1
           print("enemy!")
           break
        else:
            shell[hero[0]+1][hero[1]+1]=1  
    if i==2:
        shell[hero[0]+1][hero[1]+1]=0
        hero[0]=hero[0]+1
        if shell[hero[0]+1][hero[1]+1]==2:
           hero[0]=hero[0]-1
           shell[hero[0]+1][hero[1]+1]=1
           print("enemy!")
           break
        else:
            shell[hero[0]+1][hero[1]+1]=1
    if i==3:
        shell[hero[0]+1][hero[1]+1]=0
        hero[1]=hero[1]-1
        if shell[hero[0]+1][hero[1]+1]==2:
           hero[1]=hero[1]+1
           shell[hero[0]+1][hero[1]+1]=1
           print("enemy!")
           break
        else:
            shell[hero[0]+1][hero[1]+1]=1
   if i==4:
        shell[hero[0]+1][hero[1]+1]=0
        hero[1]=hero[1]+1
        if shell[hero[0]+1][hero[1]+1]==2:
           hero[1]=hero[1]-1
           shell[hero[0]+1][hero[1]+1]=1
           print("enemy!")
           break
        else:
            shell[hero[0]+1][hero[1]+1]=1
    if 0>=(hero[0]+1) or (hero[0]+1)>=x or 0>=(hero[1]+1) or (hero[1]+1)>=y:
        print("wall!")
        break
a=0
b=0
for i in range(x+2):
    for j in range(y+2):
        print(shell[a][b], end = "")
        b+=1
    print("\n")
    b=0
    a+=1
-------------
"""
def game(n,m,one,two):
    mat=[[0]*(n+2) for i in range(m+2)]
    for i in range(len(mat)):
        for j in range(len(mat[0])):
            if i==0 or i ==len(mat)-1 or j == 0 or j == len(mat[0])-1:
                mat[i][j]=2
    mat[one[0]+1][one[1]+1]=1
    for i in range(len(two)):
        mat[two[i][0]+1][two[i][1]+1]=2
    return mat
def move(mat,one,go):
   # mat[one[0]+1][one[1]+1]
    a=one[0]+1
    b=one[1]+1
    for i in go:
        if i ==1 and mat[a-1][b] !=2:
            mat[a][b]=0
            a-=1
            mat[a][b]=1
        elif i ==2 and mat[a+1][b] !=2:
            mat[a][b]=0
            a+=1
            mat[a][b]=1
        elif i ==3 and mat[a][b-1] !=2:
            mat[a][b]=0
            b-=1
            mat[a][b]=1
        elif i ==4 and mat[a][b+1] !=2:
            mat[a][b]=0
            b+=1
            mat[a][b]=1
    return mat
        
