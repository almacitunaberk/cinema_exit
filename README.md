# Cinema Exit

##Problem Description:

Bad days have gone there is no pandemic anymore and you bought a movie ticket to celebrate. Everything has been going well so far, but when the movie has started, your house owner called and told you to come home as soon as possible. Now, you need to leave without disturbing any person in the theater!
The theater has HxW seats. Here are the possible steps you can take to go to the exit: U: move one cell Up,
D: move one cell Down,
L: move one cell Left,
R: move one cell Right, and M(i): go to the i-th step
For example, if your list includes the following steps-list: 1: U
2: R
3: M(6)
4: D
5: M(1)
6: L
7: M(4)
you move Up (line1), then Right (line2), then go to step 6 (line3), then move Left (line6), then go to step 4 (line7), then move Down (line4), then go to step 1 (line5), then move Up (line1), etc.
With a given map of theater, find the minimum number of steps that you need to include in your step-lists to reach the exit without disturbing anyone in the audience.

##Input Format:

2: Number of test cases
2 5: Number of rows and columns respectively

EX--- : E for exit, X for obstacles, - for non-occupied seats

---XY : Y for the starting point

2 5

E---X 

----Y

##Optimal Algorithm:

For each non-occupied square, randomly pick a displacement vector. The x and y direction of the displacement vector will restrict the K number, namely the number of times we can move in the map using that vector. After K is calculated, we should execute a part of the vector for K times (this part may be the entire vector itself), and the whole vector for K-1 times. We first check if this vector moves us to the exit point. If it does, the next step is to check if there is any obstacle that we hit when we use this vector. To do in linear time, we start with the original obstacles. For each obstacle, we augment the map by adding artifical obstacles in the reverse direction of the chosen vector starting from the original obstacles. This step is repeated until we augment the whole map. If there is an obstacle at the square that we are currently one, then this means that we would hit an obstacle along the path. If there is no such obstacle, we then keep track of the found vector and the total number of instructions together with the instructions themselves. After we do this step for every point, we pick the instruction set with the minimum number of instructions.

Time complexity: *O(N^4)*

Space complexity: *O(2xN^2) = O(N^2)*

##Included Algorithm:

The algorithm we implemented in this repository does not use the M operator. The algorithm either finds a path from the starting point to the exit or it informs the user that no such path exists. If there is a path, the algorithm picks the shortest path, hence the path that is described by the minimum set of instructions. To find the shortest path, we simply used the breadth first search algorithm.

Time complexity: *O(V + E) = O(N^2)*

Space complexity: *O(N^2)*
