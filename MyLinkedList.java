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
   while (c != null){
     if (c.getData() == value){
       return true;
     }
     c = c.next();
   }
   return false;
 }
 public int indexOf(Integer value){
   Node c = start;
   for (int i = 0; i < this.size - 1; i++){
     if (c.getData() == value){
       return i;
     }
     c = c.next();
   }
   return -1;
 }
 public void add(int index, Integer value){
   if ((index >= size) || (index < 0)){
     throw new IndexOutOfBoundsException("index must be less than size and nonnegative");
   }
   Node n = new Node(value);
   if (index == size){
     add(value);
   } else if (index == 0){
     Node a = start;
     n.setNext(a);
     a.setPrev(n);
     start = n;
     size++;
   } else if (index > 0){
     Node a = getNthNode(index);
     a.prev().setNext(n);
     n.setPrev(a.prev());
     a.setPrev(n);
     n.setNext(a);
     size++;
   }
 }
   public Integer remove(int index){
     if ((index >= size) || (index < 0)){
       throw new IndexOutOfBoundsException("index must be less than size and nonnegative.");
     }
     if (index == 0){
       Node removed = getNthNode(index);
       start = removed.next();
       removed.next().setPrev(null);
       size--;
       return removed.getData();
     } else if (index == size - 1){
       Node removed = getNthNode(index);
       end = removed.prev();
       removed.setPrev(null);
       size--;
       return removed.getData();
     } else if (index == 1){
       Node removed = getNthNode(index);
       start = removed.next();
       removed.setNext(null);
       size--;
       return removed.getData();
     } else {
      Node removed = getNthNode(index);
      Node previous = removed.prev();
      Node nextNode = removed.next();
      previous.setNext(nextNode);
      nextNode.setPrev(previous);
      size--;
      return removed.getData();
    }
   }
   public boolean remove(Integer value){
     if (!(this.contains(value))){
       return false;
     }
     int n = this.indexOf(value);
     this.remove(n);
     return true;
/*
     Node c = start;
     if (!(this.contains(value))){
       return false;
     }
     for (int i = 0; i < size; i++){
       if (size == 1 && c.getData() == value){
         start = null;
         end = null;
         size--;
         return true;
       } else if (c.getData() == value){
           Node n = c;
           if (n.prev() == null){
             start = n.next();
             n.next().setPrev(null);
             size--;
             return true;
           } else if (n.next() == null){
             end = n.prev();
             n.prev().setNext(null);
             size--;
             return true;
           } else {
             n.prev().setNext(n.next());
             n.next().setPrev(n.prev());
             n.setPrev(null);
             n.setNext(null);
             size--;
             return true;
           }
         }
         c = c.next();
       }
     return false;
     */
   }
}
