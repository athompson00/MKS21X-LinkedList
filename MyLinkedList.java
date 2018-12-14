class Node{
 private int data;
 private Node next,prev;
 public Node(Integer n, Node a, Node b){
   data = n;
   next = a;
   prev = b;
 }
 public int getNode(){
   return data;
 }
 public Node getNext(){
   return next;
 }
 public Node getPrev(){
   return prev;
 }
 public Node setNext(Integer n){
   Integer o = next.data;
   next = Node(n);
   return o;
 }
 public Node setPrev(Integer n){
   Integer o = prev.data;
   prev = Node(n);
   return o;
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
 public boolean add(Integer value){
  Node a = Node(value, null, end);
  this.end.setNext(a);
  this.end = a;
  size += 1;
  return true;
 }
 
 public String toString();
}
