## BFS(너비 우선 탐색)


>너비 우선 탐색
  
시작 노드의 인접 노드부터 탐색하는 방법  
시작 정점의 가까운 정점부터 탐색한 후 점점 먼 정점으로 탐색해 나가는 방법이다.   
보통 두 노드 사이 최단경로를 찾을때, 임의의 어떤 경로를 찾을때 사용한다.  
 
![너비 우선 탐색](bfs-example.png)
  
- 구현은 큐를 이용하여 한다. 
[Source](https://github.com/3jin-p/Algorithm-java/tree/master/src/main/java/BaekJoon/B_1260) 

>시간복잡도  
  
인접 리스트 그래프: O(N+E)  
인접 행렬 그래프: O(N^2)  
