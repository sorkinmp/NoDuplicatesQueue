
public class NoDuplicatesQueueArray<T> implements NoDuplicatesQueueInterface<T> {

	// Variables
	private T [] noDupQueue;
	private int frontIndex;
	private int backIndex;
	private static final int DEFAULT_CAPACITY = 50;
	
	// Constructors
	
	// default constructor
	public NoDuplicatesQueueArray() {
		this(DEFAULT_CAPACITY);
	}

	// parameterized constructor
	public NoDuplicatesQueueArray(int capacity) {
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[capacity + 1];
		noDupQueue = tempQueue;
		frontIndex = 0;
		backIndex = capacity;
	}
	

	// Methods
	
	/** Checks to see if the new entry is already in queue.
	@param newEntry The object to be checked.
	@return True if newEntry is already in queue.
	 * False otherwise. */
	@Override
	public boolean isDuplicate(T newEntry) {
		// check if empty
		if (isEmpty()) {
			return false;
		}
		
		// loop through queue
		for (int i = 0; i < noDupQueue.length; i++) {
			// if the entry is already in queue, return true
			if (noDupQueue[i] != null && noDupQueue[i].equals(newEntry)) {
				return true;
			}
		}
		// if not in queue, return false
		return false;
	}
	
	/** Doubles size of array. */
	@Override
	public void doubleSize() {
		T[] currentQueue = noDupQueue;
		int prevSize = currentQueue.length;
		int newSize = 2 * prevSize;
		// create new doubled array
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[newSize];
		noDupQueue = tempQueue;
		// fill up new array with old entries
		for (int i = 0; i < prevSize - 1; i++) {
			noDupQueue[i] = currentQueue[frontIndex];
			frontIndex = (frontIndex + 1) % prevSize;
		}
		// finally update frontIndex and backIndex
		frontIndex = 0;
		backIndex = prevSize - 2;
	}

	/** Adds a new entry to the back of this queue if
	 * the entry is not already in queue.
    @param newEntry  An object to be added. */
	@Override
	public void enqueue(T newEntry) {
		// check if newEntry is in queue
		if (isDuplicate(newEntry)) {
			return;  // if it is in queue, queue unchanged
		}
		// if not in queue, add to back
		// first check size
		if (frontIndex == ( (backIndex + 2) % noDupQueue.length) ) {
			// double size of array since array is full
			doubleSize();
		}
		// if queue not full, add to back of queue and update backIndex
		// since array is circular, backIndex loops back to 0 once it reaches
		// its maximum value
		backIndex = (backIndex + 1) % noDupQueue.length;
		noDupQueue[backIndex] = newEntry;
	}

	/** Takes an object in the queue and moves it to the back.
	 * If the object is not in queue, add it to the back.
	@param anEntry An object in the queue. */
	@Override
	public void moveToBack(T anEntry) {
		// check if anEntry is in queue
		if (isDuplicate(anEntry)) {
			// if anEntry in queue
			// remove it so it can
			// be added to the back
			int anEntryIndex = 0;
			for (int i = 0; i < noDupQueue.length; i++) {
				if (noDupQueue[i] == anEntry) {
					noDupQueue[i] = null;
					anEntryIndex = i;
				}
			}
			// shift everything to ensure that everything in right place
			for (int i = anEntryIndex; i < noDupQueue.length - 1; i++) {
				noDupQueue[i] = noDupQueue[i + 1];
			}
			enqueue(anEntry);
			return;
		}
		// if anEntry not in queue
		// add it to the back
		enqueue(anEntry);
	}

	/** Removes and returns the entry at the front of this queue.
    @return  The object at the front of the queue. 
    @throws  EmptyQueueException if the queue is empty before the operation. */
	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			// retrieve front entry
			// update frontIndex
			T front = noDupQueue[frontIndex];
			noDupQueue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % noDupQueue.length;
			return front;
		}
	}

	/**  Retrieves the entry at the front of this queue.
    @return  The object at the front of the queue.
    @throws  EmptyQueueException if the queue is empty. */
	@Override
	public T getFront() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			return noDupQueue[frontIndex];
		}
	}

	/** Detects whether this queue is empty.
    @return  True if the queue is empty, or false otherwise. */
	@Override
	public boolean isEmpty() {
		// if frontIndex is equal to
		// backIndex plus 1 modulus the length of
		// the array, then backIndex is the last index
		// of the array and therefore has not moved,
		// indicating that the queue is empty
		return frontIndex == ( (backIndex + 1) % noDupQueue.length);
	}

	/** Removes all entries from this queue. */
	@Override
	public void clear() {
		// continue to remove entries until queue is empty
		while (!isEmpty()) {
			dequeue();
		}
	}
	
}
