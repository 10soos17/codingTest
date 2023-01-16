#!/usr/local/bin/python3
"""
지도의 크기와 장애물의 위치, 캐릭터의 위치만 입력하면 게임 지형을 완성해주는 프로그램
가로:n /세로:m 크기가 주어집니다.
지형의 테두리는 벽으로 이루어져 있습니다.
캐릭터가 있는 좌표가 배열형태로 주어집니다.
장애물이 있는 좌표가 2차원 배열 형태로 주어집니다.
지도는 n x m 크기의 배열이며 배열안의 값은
   -움직일수 있는 공간(0)
   -캐릭터(1)
   -벽(2)
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
n=4
m=5
char=[0,0]
obj=[[0,1],[1,1],[1,3],[2,3]]
make_map(n,m,char,obj)
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
    
    
res=game(4,5,[0,0],[[0,1],[1,1],[2,3],[1,3]])
for i in res:
    print(i,sep='\n')
