package StudentManagementSystem;

public class Student {
	
	private String name;
	private int rollnumber;
	private String grade;
	private String email;
	
	
	interface StudentManagement{
		
		void addStudent();
		void updateStudent();
		void removeStudent();
		void searchStudent();
		void displayStudent();
		
		
		
	}
	
	class ImplementationStudendentManagement implements StudentManagement{

		@Override
		public void addStudent() {
		     
			
		}

		@Override
		public void updateStudent() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeStudent() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void searchStudent() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void displayStudent() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
