import java.util.Random;

public class MaxHeap{
    int[] heap;
    int heapSize;
    int size;
    MaxHeap(){}
    MaxHeap(int[] heap){
        this.heap=heap;
        this.heapSize=heap.length;
        this.size=this.heapSize;
    }
    public void maxHeapify(int i){
        int highest = i;
        int left = 2*i;
        int right = 2*i+1;
        if(left<heapSize&&heap[left]>heap[highest]){
            highest=left;
        }
        if(right<heapSize&&heap[right]>heap[highest]){
            highest=right;
        }
        if(highest!=i){
            swap(highest, i);
            maxHeapify(highest);
        }
    }
    public void swap(int i,int j){
        int temp = heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }
    public void buildMaxHeap(){
        for(int i=heapSize/2-1;i>=0;i--){
            maxHeapify(i);
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
            maxHeapify(0);
        }
    }
    public void increaseKey(int index,int key){
        if(index<size && index<heapSize && heap[index]<key){
            heap[index]=key;
            int parent = (int)Math.ceil(index/2) - 1;
            while(parent>=0 && heap[parent]<key){
                swap(parent, index);
                parent = (int)Math.ceil(parent/2) - 1;
            }
        }
    }
    public void decreaseKey(int index,int key){
        if(index<size && index<heapSize && heap[index]>key){
            heap[index]=key;
            maxHeapify(index);
        }
    }
    public static void main(String[] args){
        MaxHeap heap = new MaxHeap(random(15));
        heap.print();
        heap.buildMaxHeap();
        heap.print();
        
        heap.increaseKey(3, 500);
        heap.print();

        heap.decreaseKey(6, -5);
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