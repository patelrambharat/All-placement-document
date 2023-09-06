// What is a graph data structure?
// There are two types of data structures

// Linear
// Non – linear

// We are aware of linear data structures such as arrays, stacks, queues, and linked lists. 
// They are called linear because data elements are arranged in a linear or sequential manner.

// The only non-linear data structure that we’ve seen so far is Tree. In fact, a tree is a special type of graph with some restrictions. 
// Graphs are data structures that have a wide-ranging application in real life. These include analysis of electrical circuits,
//  finding the shortest route between two places, building navigation systems like Google Maps, even social media using graphs 
// to store data about each user, etc. To understand and use the graph data structure, let’s get familiar with the definitions and 
// terms associated with graphs. 

// Definitions and Terminology
// A graph is a non-linear data structure consisting of nodes that have data and are connected to other nodes through edges.

// Nodes are circles represented by numbers. Nodes are also referred to as vertices. They store the data.
//  The numbering of the nodes can be done in any order, no specific order needs to be followed.

// Two nodes are connected by a horizontal line called Edge. Edge can be directed or undirected. Basically,
//  pairs of vertices are called edges.

// In the above example, the edge can go from 1 to 4 or from 4 to 1, i.e. a bidirectional edge can be in both directions,
//  hence called an undirected edge. Thus, the pairs (1,4) and (4,1) represent the same edge.



// An undirected graph is a graph where edges are bidirectional, with no direction associated with them, 
// i.e, there will be an undirected edge. In an undirected graph, the pair of vertices representing any edge is unordered. 
// Thus, the pairs (u, v) and (v, u) represent the same edge.

// A directed graph is a graph where all the edges are directed from one vertex to another, 
// i.e, there will be a directed edge. It contains an ordered pair of vertices. It implies each edge is represented by a directed
//  pair <u, v>. Therefore, <u, v> and <v, u> represent two different edges.
// There can be multi-directed edges, hence bidirectional edges, as shown in the example below.

// Structure of Graph 
// Does every graph have a cycle? 

// The answer is No! Let us consider the following examples to understand this. 

// Fig. 1 does not form a cycle but still, it is a graph. 

// Fig. 2 is an example of a binary tree. It can also be called a graph because it follows all the rules. We’ve nodes and edges, 
// and this is the minimal condition to be called a graph. 

// So a graph does not necessarily mean to be an enclosed structure, it can be an open structure as well. 
// A graph is said to have a cycle if it starts from a node and ends at the same node. There can be multiple cycles in a graph.

// If there is at least one cycle present in the graph then it is called an Undirected Cyclic Graph.

// In the following examples of directed graphs, the first directed graph is not cyclic as we can’t start from a node and end at the same node. 
// Hence it is called Directed Acyclic Graph, commonly called DAG.

// If we just add an edge to the directed graph, then at least one cycle is present in the graph, hence it becomes Directed

// If we just add an edge to the directed graph, then at least one cycle is present in the graph, hence it becomes Directed


// Degree of Graph

// It is the number of edges that go inside or outside that node.

// For undirected graphs, the degree is the number of edges attached to a node.

// Property: It states that the total degree of a graph is equal to twice the number of edges. 
// This is because every edge is associated/ connected to two nodes.

// For directed graphs, we’ve Indegree and Outdegree. The indegree of a node is the number of incoming edges. 
// The outdegree of a node is the number of outgoing edges.

// Edge Weight
// A graph may have weights assigned on its edges. It is often referred to as the cost of the edge.


