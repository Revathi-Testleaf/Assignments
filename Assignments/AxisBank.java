package week3.day1.Assignments;

public class AxisBank extends BankInfo{
	@Override
	public void deposit() {
		System.out.println("Im inside the AxisBank -deposit");
	}
	public static void main(String[] args) {
		
		AxisBank aab=new AxisBank();
		aab.deposit();
		aab.fixed();
		aab.saving();
		BankInfo  bi=new BankInfo();
		bi.deposit();
		
	}

}
