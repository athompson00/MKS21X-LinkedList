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
   result = result + "]";
   return result;
 }
 private Node getNthNode(int index){
   Node c = start;
   for (int i = 0; i < this.size; i++){
     if (i == index){
       return c;
     }
     c = c.next();
   }
   return c; //should never happen
 }
 public Integer get(int index){
   if ((size < index + 1) || (index < 0)){
     throw new IndexOutOfBoundsException("index must be less than size and nonnegative");
   }
   return getNthNode(index).getData();
 }
 public Integer set(int index, Integer value){
   if ((index >= size) || (index < 0)){
     throw new IndexOutOfBoundsException("index must be less than size and nonnegative");
   }
   Node c = getNthNode(index);
   int n = c.getData();
   c.setData(value);
   return n;
 }
 public boolean contains(Integer value){
   Node c = start;
   for (int i = 0; i < size; i++){
     if (c.getData() == value){
       return true;
     }
     c = c.next();
   }
   return false;
 }

}
