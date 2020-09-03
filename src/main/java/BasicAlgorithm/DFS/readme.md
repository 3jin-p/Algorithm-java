## DFS(깊이 우선 탐색)


>깊이 우선 탐색

시작 노드에 다음 가지로 넘어가기 전에 해당 가지를 완벽하게 탐색하는 방법  

한 방향으로 갈 수 있을 때까지 계속 가다가 더 이상 갈 수 없게 되면 다시 가장 가까운 갈림길로 돌아와서   
이곳으로부터 다른 방향으로 다시 탐색을 진행하는 방법.  
  
넓게 탐색하기보다 깊게 탐색하는 방법이다.  
일반적으로 모든 노드를 방문하고자 할때 사용하는 방법이다.  
  
![깊이 우선 탐색](dfs-example.png)  

- 재귀 알고리즘을 이용하여 구현한다.
  
> 시간 복잡도  
  
인접 리스트 그래프: O(N+E)  
인접 행렬 그래프: O(N^2)
