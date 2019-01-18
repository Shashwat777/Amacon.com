import java.util.*;

public class Amacon_System {
	public static  String[] simplify_data() {
		Scanner sc= new Scanner(System.in);
		String option = sc.nextLine();

		String bchoice = "";
		String prev = "";
		String lastadded="k";
		for (int ch = 0; ch < option.length(); ch++) {
			char tem = option.charAt(ch);
			
			if (((int) tem > 95 & (int) tem < 123) || ((int) tem > 64 & (int) tem < 91) ||((int) tem > 48  & (int) tem < 59)  ) {
				bchoice = bchoice + tem;
				lastadded=Character.toString(tem);

			} else {
			
				if(lastadded.equals("1")) {
		
				}
				else {
					bchoice = bchoice + " ";
					
					lastadded="1";}
				
			}
	
		}
		String[] oplist = bchoice.split(" ");
		
		return (oplist);
		
	}

	public static void main(String[] args)throws  AllreadyExists , NotEnoughFunds {
		// TODO Auto-generated method stub
		Database db = new Database();
		boolean y = true;
		while (y) {
		
			System.out.println("Type admin to continue as administrator");
			System.out.println("Type customer to continue as Customer");
			System.out.println("Type exit to Exit the program");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			if (input.equals("admin")) {
				administrater adm = new administrater(db);

			} else if (input.equals("customer")) {
				customer cs = new customer(db);
				
			}
			
			else if(input.equals("exit")) {
				System.out.println("Total Revenue");
				System.out.print(db.myrev);
				
				System.exit(0);
			}
		}
	}

}
