package oops;

public class StudentUse extends student {
	
	public static<T extends CompareInterface<T>> void sort(T input[]){
		
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input.length-i-1;j++){
				if(input[j].compareTo(input[j+1])==1){
					T tmp=input[j];
					input[j]=input[j+1];
					input[j+1]=tmp;
				}
			}
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student[] stu=new student[10];
		
		for(int i=0;i<stu.length;i++){
			stu[i]=new student();
			stu[i].marks=100-i*10;
		}
		
		sort(stu);
		for(int i=0;i<stu.length;i++){
			System.out.println(stu[i].marks);
		}
		

	}

}
