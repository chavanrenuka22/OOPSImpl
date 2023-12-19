import java.util.ArrayList;

abstract class Employee
{
	private String name;
	private int id;
	      public Employee(String name,int id)
	          {
	               this.name=name;
		           this.id=id;
	          }
           public String getName()
           {
	         return name;
           }
            public int getId()
           {
	          return id;
           }
            
public abstract double calculateSalary();

@Override
public String toString() {
	return "Employee [name=" + name + ", id=" + id + "]";
}	
}
class FullTimeEmployee extends Employee
{
	private double monthlysalary;
	public FullTimeEmployee(String name,int id,double monthlysalary)
	{
		super(name,id);
		this.monthlysalary=monthlysalary;
	}
	@Override
	public double calculateSalary()
	{
		return monthlysalary;
	}
}
class PartTimeEmployee extends Employee
{
	private int hoursWorked;
	private double hourlyRate;
	
	 public PartTimeEmployee(String name,int id, int hoursWorked,double hourlyRate)
	 {
		 super(name,hoursWorked);
		 this.hoursWorked=hoursWorked;
		 this.hourlyRate=hourlyRate;
	 }
	 
	@Override
	public double calculateSalary()
	{
		return hoursWorked*hourlyRate;
	}
}
class PayRollSystem
{
	private static ArrayList<Employee> employeeList;
	
	public PayRollSystem()
	{
		employeeList=new ArrayList<>();
	}
	public static void addEmployee(Employee employee)
	{
		employeeList.add(employee);
	}
	public static void removeEmployee(int id)
	{
		Employee employeeToRemove=null;
		for(Employee employee:employeeList)
		{
			if(employee.getId()==id)
			{
				employeeToRemove=employee;
				break;
			}
		}
		if(employeeToRemove !=null)
		{
			employeeList.remove(employeeToRemove);
		}
	}
	public static void displayEmployees()
	{
		for(Employee employee:employeeList)
		{
			System.out.println(employee);
		}
	}
}

public class Main
{
	public static void main(String[] args) 
	{	
		PayRollSystem ps=new PayRollSystem();
		String name;
		int id;
		double monthlysalary;
		float hoursWorked;
		int hourRate;
		FullTimeEmployee emp1=new FullTimeEmployee("Renuka", 1,17000.0);
		PartTimeEmployee emp2=new PartTimeEmployee("Alexander",2,3,40100.0);
		
		System.out.println(emp1);
		System.out.println(emp2);
		PayRollSystem.addEmployee(emp1);
		PayRollSystem.addEmployee(emp2);

		System.out.println("initial employee Details:");
		PayRollSystem.displayEmployees();
		System.out.println("removing employes");
		PayRollSystem.removeEmployee(1);
		PayRollSystem.removeEmployee(40);
		System.out.println("Remaining Employees Details:");
		PayRollSystem.displayEmployees();
		
		System.out.println("calculating salary");
		double s1=emp1.calculateSalary();
		System.out.println(s1);
		double s2=emp2.calculateSalary();
		System.out.println(s2);
	}
}
