package week3.day1.Assignments;

public class Students {
	/*Methods: getStudentInfo()
	 * 

Description: 
Create multiple getStudentInfo() method 
by passing id argument alone, by id & name, by email & phoneNumber**/
	public void getStudentInfo(int id) {
		System.out.println("The Given Id  :"+id);
	}
	public void getStudentInfo(int id, String name) 
	{
		System.out.println("ID :"+id+" Name :"+name);

	}
	public void getStudentInfo(String email,long Phoneno) 
	{
		System.out.println("Email :"+email+ " Phone No :"+ Phoneno);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Students st=new Students();
		st.getStudentInfo(12);
		st.getStudentInfo(12, "Pranav");
		st.getStudentInfo("pranav@gmail.com", 9867543423l);

	}

}
