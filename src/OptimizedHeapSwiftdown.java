
public class OptimizedHeapSwiftdown extends Algorithm implements Heap {

	//  private int[] array;
	//
	//  public void setArray(int[] array){
	//    this.array = array;
	//  }

	public int[] optimizdHeapSort(int[] array, int length) {
		return super.heapSort(array, length, this);
	}

	public int[] buildOptimizedHeap(int[] array, int length, int i) {
		int leftIndx = leftChildIndex(i, length);
		int rightIndx = rightChildIndex(i, length);
		int maxIndx = i;
		if (leftIndx == -1 && rightIndx != -1) {
			maxIndx = rightIndx;
			bubbleUp(array, length, i);
		} else if (leftIndx != -1 && rightIndx == -1) {
			maxIndx = leftIndx;
			bubbleUp(array, length, i);
		} else if (leftIndx != -1 && rightIndx != -1) {
			if (array[leftIndx] > array[rightIndx]) {
				maxIndx = leftIndx;
				bubbleUp(array, length, i);
			} else {
				maxIndx = rightIndx;
				bubbleUp(array, length, i);
			}
			bubbleUp(array, length, i);
		} else {
			return bubbleUp(array, length, i);
		}
		swap(array, i, maxIndx);
		bubbleUp(array, length, maxIndx );
		return buildOptimizedHeap(array, length, maxIndx);
	}
	private int[] bubbleUp(int[] array, int length, int i) {
		int p = parentIndex(i);
		if (p == -1) {
			return array;
		}
		if (array[i] > array[p]) {
			swap(array, i, p);
			return bubbleUp(array, length, p);
		}
		return array;
	}

	@Override
	public int[] buildHeap(int[] array, int length, int i) {
		return buildOptimizedHeap(array, length, i);
	}
}
