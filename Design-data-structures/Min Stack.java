class MinStack {
    // every node stores two values current value and so far minimum value
    class Node {
        int val;
        int mini;
        Node next;
        public Node(int val,int mini) {
            this.val = val;
            this.mini = mini;
        }
    }
    Node head = null;
    public void push(int val) {
        if(head == null) {
            Node newNode = new Node(val,val);
            head  = newNode;
        }else {
            Node newNode = new Node(val,Math.min(head.mini,val));
            // head stores the last element and also min element so far
            newNode.next = head;
            head = newNode;
        }
        
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
        
    }
    
    public int getMin() {
        return head.mini;
        
    }
}