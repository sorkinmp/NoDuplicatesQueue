/**
   A driver that demonstrates the class NoDuplicatesQueueArray.
   
   @author Matthew Sorkin
   @version 1.0
*/
public class NoDuplicatesQueueArrayDriver {

	public static void main(String[] args) {
		testNoDupQueueOperations();
		System.out.println("\n\nDone.");
	}

	public static void testNoDupQueueOperations() {
		System.out.println("Create a queue:");
		NoDuplicatesQueueInterface<String> myNoDupQueue = new NoDuplicatesQueueArray<>(1);
		System.out.println("\n\nisEmpty() returns " + myNoDupQueue.isEmpty() + "\n");
		
		System.out.println("Add to queue to get:\n" +
				           "Joe Jess Jim\n");
		myNoDupQueue.enqueue("Joe");
		System.out.println("The front of the queue is: " + myNoDupQueue.getFront());
		myNoDupQueue.enqueue("Jess");
		myNoDupQueue.enqueue("Jim");
		System.out.println("Lets move Joe to the back so Jess is now the front");
		myNoDupQueue.moveToBack("Joe");
		System.out.println("The front of the queue is: " + myNoDupQueue.getFront());
		
		System.out.println("\nisEmpty() returns " + myNoDupQueue.isEmpty() + "\n");
		
		System.out.println("\nNow let's remove the current entries: " + "\n");
		System.out.println("\nThere should be four entries: " + "\n");
		System.out.println("Jess Jim null Joe\n");
		System.out.println(myNoDupQueue.dequeue());
		System.out.println(myNoDupQueue.dequeue());
		System.out.println(myNoDupQueue.dequeue());
		System.out.println(myNoDupQueue.dequeue());
		
		System.out.println("\nisEmpty() returns " + myNoDupQueue.isEmpty() + "\n");
		
		System.out.println("Let's test the isDuplicate method by trying to add two of the same items to the queue");
		myNoDupQueue.enqueue("Rob");
		System.out.println("The front of the queue is: " + myNoDupQueue.getFront());
		myNoDupQueue.enqueue("Joe");
		myNoDupQueue.enqueue("Rob");
		
		System.out.println("Now let's remove two entries and test if isEmpty() returns true");
		System.out.println(myNoDupQueue.dequeue());
		System.out.println(myNoDupQueue.dequeue());
		
		System.out.println("\nisEmpty() returns " + myNoDupQueue.isEmpty() + "\n");
		
		System.out.println("\nLet's finally test the clear() method and our exceptions\n");
		myNoDupQueue.enqueue("John");
		System.out.println("The front of the queue is: " + myNoDupQueue.getFront());
		myNoDupQueue.enqueue("Jermaine");
		
		System.out.println("\nisEmpty() returns " + myNoDupQueue.isEmpty() + "\n");
		
		System.out.println("Let's test the clear() method");
		myNoDupQueue.clear();
		System.out.println("\nisEmpty() returns " + myNoDupQueue.isEmpty() + "\n");
		
		System.out.println("The next two calls should throw exceptions");
		myNoDupQueue.getFront();
		myNoDupQueue.dequeue();
	}
	
}
