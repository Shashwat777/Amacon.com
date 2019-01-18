import java.util.LinkedList;
import java.util.*;

public final class customer {
	private int funds;
	private ArrayList<products> cart = new ArrayList<products>();
	private Database db;
	private int bill;

	customer(Database db) throws NotEnoughFunds {
		System.out.println("add funds");
		System.out.println("add product to the cart");
		System.out.println("check-out cart");
		System.out.println("Exit as customer");
		this.db = db;
		input();

	}

	void add_funds(int fund_tobeadded) {
		this.funds = this.funds + fund_tobeadded;
	}

	void add_product(products pr) {
		cart.add(pr);

	}

	void input() throws NotEnoughFunds {
		Scanner sc = new Scanner(System.in);
		boolean cust = true;
	
			while (cust) {
				try {

				String oplist = sc.nextLine();				
				if (oplist.equals("add funds")) {
					System.out.println("enter amount");
					int amount = sc.nextInt();
					funds = funds + amount;

				} else if (oplist.equals("add product")) {
					System.out.println("Enter Product Name");

					String pro_name = sc.next();
					products pro = db.search(pro_name);
					if(pro!=null ) {
					cart.add(pro);
					bill = bill + pro.price;}
					else {
						System.out.println("Please enter a valid product");
					}
					
					

				} else if (oplist.equals("check-out")) {
					
						db.sale(cart, funds, bill);
					
					
				} else if (oplist.equals("exit")) {
					cust = false;
				} else {
				}

			}
				 catch (ArrayIndexOutOfBoundsException e) {
					}


		}
	}
}
