
private static class Node{
    int data;
    ArrayList<Node> children;

    Node(){
        this.data = 0;
        this.children = new ArrayList<>();
    }
    Node(int data){
        this.data = data;
        this.children = new ArrayList<>();
    }
}