package oops;

public class student implements CompareInterface<student> {
	
	int Roll_no=0;
	double marks=0;
	@Override
	public int compareTo(student stu) {
		if(this.marks>stu.marks){
			return 1;
		}
		if(this.marks<stu.marks){
			return -1;
		}
		// TODO Auto-generated method stub
		return 0;
	}
		

}
