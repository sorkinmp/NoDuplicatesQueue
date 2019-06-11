/**
   An interface for the ADT queue without duplicates.   
   @author Matthew Sorkin
   @version 1.0
 */
public interface NoDuplicatesQueueInterface<T> extends QueueInterface<T> 
{
	/** Checks to see if the new entry is already in queue.
	@param newEntry The object to be checked.
	@return True if newEntry is already in queue.
	 * False otherwise. */
	public boolean isDuplicate(T newEntry);
	
	/** Doubles size of array. */
	public void doubleSize();
	
	/** Adds a new entry to the back of this queue if
	 * the entry is not already in queue.
    @param newEntry  An object to be added. */
	public void enqueue(T newEntry);

	/** Takes an object in the queue and moves it to the back.
	 * If the object is not in queue, add it to the back.
	@param anEntry An object in the queue. */
	public void moveToBack(T anEntry);
	
	/** Removes and returns the entry at the front of this queue.
    @return  The object at the front of the queue. 
    @throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue();

	/**  Retrieves the entry at the front of this queue.
    @return  The object at the front of the queue.
    @throws  EmptyQueueException if the queue is empty. */
	public T getFront();

	/** Detects whether this queue is empty.
    @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty();

	/** Removes all entries from this queue. */
	public void clear();
}  // end NoDuplicatesQueueInterface
