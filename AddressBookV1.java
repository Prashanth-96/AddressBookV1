import java.util.*;

public class AddressBookV1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Address Book..!\n");
		int runloop=1;  // for breaking infinite loop
		Process process= new Process();
		HashMap book= process.bookCreate();
		while(runloop==1) {
			System.out.println("Address Book modes: "
					+ "\n1 to Create new contact."
					+ "\n2 to Read an existing contact."
					+ "\n3 to Delete a contact."
					+ "\n4 to Edit a contact.");
			System.out.println("Enter the mode: ");   // Get Mode
			int mode =sc.nextInt();
			switch(mode) { 
			case 1:  // Create contact Mode
				List contact=process.create();
				book=process.insertBook(contact, book);
				System.out.println("Contact Created Successfully!");
				break;
			case 2: // Read contact Mode
				System.out.println("Please enter the first name of the contact to Read: ");
				String qname =sc.next();
				process.readBook(qname, book);
				
				break;
			case 3: // Delete contact Mode
				System.out.println("Please enter the first name of the contact to Delete: ");
				String dname =sc.next();
				process.deleteBook(dname, book);
				
				break;
			case 4: // Edit contact Mode
				System.out.println("Please enter the first name of the contact to Edit: ");
				String ename =sc.next();
				process.editBook(ename, book);
				
				break;
			}			
			System.out.println("Do you wish to continue?"
					+ "\n 1 to continue "
					+ "\n 0 to Exit");
			System.out.println("Please enter your choice: ");   // continue loop?
			runloop =sc.nextInt();
			if (runloop==0) System.out.println("Thanks for using Address Book..!");
		}
	}
}