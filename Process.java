import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Process 
{
	public HashMap<String, String[]> bookCreate() 
	{
		
		HashMap<String, String[]> book  = new HashMap<String, String[]>();
		return book;	
	}
	public List create() 
	{       // Getting input from user
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your First Name: ");
		String namef = sc.nextLine();
		System.out.println("Enter your Last Name: ");
		String namel = sc.nextLine();  
		System.out.println("Enter your Address: ");
		String address = sc.nextLine();
		System.out.println("Enter your city: ");
		String city = sc.nextLine();
		System.out.println("Enter your state: ");
		String state = sc.nextLine();
		System.out.println("Enter your Zip: ");
		String zip =sc.nextLine();
		System.out.println("Enter your Phone: ");
		String phone =sc.nextLine();
		System.out.println("Enter your E-mail: ");
		String email =sc.next();
		
		return Arrays.asList(namef,namel, address, city, state, zip, phone, email);
	}
	
	public HashMap<String,String[]> insertBook(List contact, HashMap book) 
	{
		List temp= Arrays.asList(contact.get(1),
				contact.get(2),
				contact.get(3),
				contact.get(4),
				contact.get(5),
				contact.get(6),
				contact.get(7));
		
		book.put(contact.get(0), temp);
				
		return book;
	}
	public void readBook(String name, HashMap book) 
	{
		if (book.containsKey(name)) 
		{	
			List temp=(List) book.get(name);
			
			System.out.println("First Name: "+name);
			System.out.println("Last Name: "+temp.get(0));
			System.out.println("Address : "+temp.get(1));
			System.out.println("City: "+temp.get(2));
			System.out.println("State: "+temp.get(3));
			System.out.println("Zip: "+temp.get(4));
			System.out.println("Phone: "+temp.get(5));
			System.out.println("E-Mail: "+temp.get(6));
		}
		else
		{
			System.out.println("Contact Not found!");
			
		}
		
	}
	public void deleteBook(String name, HashMap book) 
	{
		if (book.containsKey(name)) 
		{
			book.remove(name);
			System.out.println("Contact Deleted Successfully!");
		}
		else
		{
			System.out.println("Contact Not found!");
			
		}
		
	}
	public void editBook(String name, HashMap book)
	{
		Scanner sci= new Scanner(System.in);
		Process temp = new Process();
		System.out.println("Contact to Edit: \n");
		temp.readBook(name,book);
		if (book.containsKey(name)) 
		{
			System.out.println("\nSelect the field to Edit: ");
			System.out.println("0 for First Name\n1 for Last Name\n2 for Address\n3 for City\n4 for State\n5 for Zip"
								+ "\n6 for Phone\n7 for E-Mail\nPlease enter your choice: ");
			int ef=sci.nextInt();
			System.out.println("Enter the new field value : \n");
			sci.nextLine();
			String efield =sci.nextLine();
			
			if (ef==0) 
			{
				book.put(efield, book.get(name));
				book.remove(name);
			}
			else 
			{
				List value= (List) book.get(name);
				value.set(ef-1, efield);
				book.put(name, value);
			}
			System.out.println("Contact Edited Successfully!");
		}
	}
}