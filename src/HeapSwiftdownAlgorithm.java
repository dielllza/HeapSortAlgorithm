
public class HeapSwiftdownAlgorithm extends Algorithm{
	private int[] array;
	public void setArray(int[] array){
		this.array = array;
	}
	
	public int[] heapSort(int[] array, int length){
		//build the array:
		int elementIndex = length/2;
		for(int i = elementIndex; i >= 0; i--) {
			array = buildHeap(array,length, i);
		}
		
		// sort the array
		while(length > 0 ) {
			swap(array, 0, length-1); // -i-1 i->0 to (length?)
			buildHeap(array, length-1, 0);
			
			length = length - 1;
		}
		return array;
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
//			System.out.print(i + " : ");
//			print(array);
//			System.out.println();
			return array;
	}
}
