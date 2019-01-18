import java.util.*;
// insert("shashwat" > "jain" > "family" )

public class administrater {
	Database db;

	administrater(Database db) throws AllreadyExists{
		System.out.println("Insert product/category");
		System.out.println(" Delete product/category");
		System.out.println("Search product");
		System.out.println("Modify product");
		System.out.println("Exit as administrator");
		this.db = db;
		input();
	}

	public void input() throws AllreadyExists {
		boolean admin = true;
		Scanner sc = new Scanner(System.in);
		while (admin) {
			try {
				String[] oplist = Amacon_System.simplify_data();
				String choice = oplist[0];

				if (choice.equals("insert")) {

					db.add(oplist);

				} else if (choice.equals("delete")) {
					db.delete(oplist[1]);
				} else if (choice.equals("search")) {

					products myfind = db.search(oplist[1]);
					myfind.when_found();

				} else if (choice.equals("modify")) {
					db.modify(oplist[1]);

				} else if (choice.equals("exit")) {
					admin = false;
				} else {
				}

			} catch (NullPointerException e) {
				System.out.print("Invalid Input");
			}
		}
	}
}