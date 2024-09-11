import java.util.Random;

public class MinHeap{
    int[] heap;
    int heapSize;
    int size;
    MinHeap(){}
    MinHeap(int[] heap){
        this.heap=heap;
        this.heapSize=heap.length;
        this.size=this.heapSize;
    }
    public void minHeapify(int i){
        int highest = i;
        int left = 2*i;
        int right = 2*i+1;
        if(left<heapSize&&heap[left]<heap[highest]){
            highest=left;
        }
        if(right<heapSize&&heap[right]<heap[highest]){
            highest=right;
        }
        if(highest!=i){
            swap(highest, i);
            minHeapify(highest);
        }
    }
    public void swap(int i,int j){
        int temp = heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }
    public void buildMinHeap(){
        for(int i=heapSize/2-1;i>=0;i--){
            minHeapify(i);
        }
    }
    public void print(){
        for(int i =0;i<size;i++){
            System.out.print(heap[i]);
            if(i!=size-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    public void heapSort(){
        int counter =0;
        while(heapSize>0){
            swap(0, size-counter-1);
            heapSize--;
            counter++;
            minHeapify(0);
        }
    }
    public void increaseKey(int index,int key){
        if(index<size && index<heapSize && heap[index]<key){

        }
    }
    public void decreaseKey(int index,int key){
        if(index<size && index<heapSize && heap[index]>key){
            
        }
    }
    public static void main(String[] args){
        MinHeap heap = new MinHeap(random(15));
        heap.print();
        heap.buildMinHeap();
        heap.print();
        heap.heapSort();
        heap.print();
    }
    public static int[] random(int n){
        Random rand = new Random();
        int[] numbers = new int[n];
        for(int i=0;i<n;i++){
            numbers[i]=rand.nextInt(n);
        }
        return numbers;
    }
}