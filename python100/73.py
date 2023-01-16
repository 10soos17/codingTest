#!/usr/local/bin/python3
"""
최단경로찾기
노드의 연결 관계가 그래프 형태로 주어집니다. 그 다음 경로를 구할 두 정점이 공백으로 구분
두 정점 사이를 이동할 수 있는 최단거리를 출력하는 프로그램을 작성해 주세요. 
최단 거리란, 중복 없이 한 정점에서 다른 정점까지 갈 수 있는 가장 적은 간선의 수

데이터
graph = {'A': set(['B', 'C']),
         'B': set(['A', 'D', 'E']),
         'C': set(['A', 'F']),
         'D': set(['B']),
         'E': set(['B', 'F']),
         'F': set(['C', 'E'])}
입출력
입력 : A F
출력 : 2
------------------
graph = {'A': set(['B', 'C']),
         'B': set(['A', 'D', 'E']),
         'C': set(['A', 'F']),
         'D': set(['B']),
         'E': set(['B', 'F']),
         'F': set(['C', 'E'])}
def bfs(graph,a):
    visited=[]
    count = 0
    b = a[1]
    c = [a[0]]
    
    while c:
        n = c.pop(0)

        if b not in graph[n]:
            count+=1
            visited.append(n)
            c += graph[n] - set(visited)
        
        if a[1] in graph[n]:
            count+=1
            if b not in graph[n]:
               visited.append(n)
            break
        
    b = a[1]
    c = [a[0]]
    secount = 0
    revisited = []
    while c:
        n = c.pop()

        if b not in graph[n]:
            secount+=1
            revisited.append(n)
            c += graph[n] - set(revisited)
        
        if a[1] in graph[n]:
            secount+=1
            if b not in graph[n]:
               revisited.append(n)
            break  
    return count, secount, min(count, secount)
    
a = list(map(str,input("?").split()))
print(bfs(graph, a))
--------------------
"""
graph = {'A': set(['B', 'C']),
         'B': set(['A', 'D', 'E']),
         'C': set(['A', 'F']),
         'D': set(['B']),
         'E': set(['B', 'F']),
         'F': set(['C', 'E'])}

start, end = [i for i in input().split()]
    
queue = [start]
visited = [start]
    
def solution():
    count = -1

    while len(queue)!=0:
        count += 1
        size = len(queue)

        for i in range(size):
            node = queue.pop(0)
            if node == end:
                return count

            for next_node in graph[node]:
                if next_node not in visited:
                    visited.append(next_node)
                    queue.append(next_node)

print(solution())
