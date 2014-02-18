import java.util.*;

public class HeapSortEmployee 
{
	List<Employee> coll;
	
	public HeapSortEmployee()
	{
		List<Employee> col = new ArrayList<Employee>();
		
		col.add(new Employee(5, "Mark", 26, 3234.55));
		col.add(new Employee(1, "Chris", 22, 3321.55));
		col.add(new Employee(6, "Lance", 28, 4314.55));
		col.add(new Employee(3, "Michael", 24, 4342.55));
		col.add(new Employee(7, "Chelsea", 25, 2124.55));
		col.add(new Employee(4, "Nicole",20, 923.55));
		col.add(new Employee(8, "Steve", 50, 8412.55));
		col.add(new Employee(2, "Donna", 49, 9341.55));
		
	}
	
	public void runSort()
	{
		printList("Employees sorted by Name",
			HeapSort.heapSort(coll, new employeeSortByName()));
		
		printList("Employees sorted by Age",
			HeapSort.heapSort(coll, new employeeSortByAge()));
			
		printList("Employees sorted by Salary",
			HeapSort.heapSort(coll, new employeeSortBySalary()));
		
	}//end sort
	
	public void printList(String header, List<Employee> list)
	{
		System.out.println(header);
		for(Employee e : list)
		{
			System.out.println(e);
			System.out.println();
		}
	}
}