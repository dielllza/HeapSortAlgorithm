
public class HeapSwiftdownAlgorithm extends Algorithm implements Heap {
//	private int[] array;
//	public void setArray(int[] array){
//		this.array = array;
//	}
	
	public int[] basicHeapSort(int[] array, int length){		
		return super.heapSort(array, length, this);
	}
	public int[] buildHeap(int[] array, int length, int i){
			int leftIndx = leftChildIndex(i, length);
			int rightIndx = rightChildIndex(i, length);
			
			int maxIndx = i;
			
			if(leftIndx != -1 && array[maxIndx] < array[leftIndx]) {
				maxIndx = leftIndx;
			}
			if(rightIndx != -1 && array[maxIndx] < array[rightIndx]) {
				maxIndx = rightIndx;
			}
			if(maxIndx != i) {
				array = swap(array, i, maxIndx);
				return buildHeap(array, length, maxIndx);
			}
			return array;
	}
}
