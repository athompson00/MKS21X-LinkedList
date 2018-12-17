public class MyLinkedList{
 private int size;
 private Node start,end;

 public MyLinkedList(){
   size = 0;
   start = null;
   end = null;
 }
 public int size(){
   return size;
 }
 public boolean add(Integer value){
  Node a = new Node(value);
  if (size == 0){
    start = a;
    end = a;
  } else {
    a.setPrev(end);
    this.end.setNext(a);
    this.end = a;
  }
  size += 1;
  return true;
 }

 public String toString(){
   Node c = start;
   String result = "[";
   while (!(c == null)){
     result = result + c.getData();
     if (!(c.next() == null)){
       result = result + ", ";
     }
     c = c.next();
   }
   return result;
 }

}
