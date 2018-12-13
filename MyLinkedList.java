class Node{
 private int data;
 private Node next,prev;
 public Node(int n){
   data = n;
   next = null;
   prev = null;
 }
}


class MyLinkedList{
 private int size;
 private Node start,end;

 public MyLinkedList(){
   size = 0;
   start = null;
   end = null;
 }
 public int size();
 public boolean add(int value){
   Node current = this.start;
   if (start == null){
     start = new Node(value);
   } else {
     this.end.next = new Node(value);
     this.end = this.end.next;
     size++;
   }
 }
 public String toString();
}
