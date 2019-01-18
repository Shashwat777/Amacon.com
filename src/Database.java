import java.util.*;

public final  class Database {
	 int myrev;
	Scanner sc = new Scanner(System.in);
	static List<products> pmain_list = new LinkedList<products>();
	static LinkedList<String> pmain_list_name = new LinkedList<String>();
	private LinkedList<products> plist = new LinkedList<products>();
	private LinkedList<String> pnames = new LinkedList<String>();
	

	Database() {
	}

	void add(String[] path) throws AllreadyExists {
		try {
			LinkedList<products> templist = plist;
			LinkedList<String> tempnames = new LinkedList<String>();
			String pth = "";
			products current = null;

			for (int k = 1; k < path.length; k++) {
				System.out.println(path[k] + k+ path.length);
				if (path[k].equals(" ")) {
				} else {
					if (k != 1) {
						pth = pth + ">" + path[k];
					} else {
						pth = path[k];
					}

					if (tempnames.contains(path[k])) {
						int inde = tempnames.indexOf(path[k]);
						current = templist.get(inde);
						templist = current.plist;
						tempnames = current.pnames;

					} else {
						if (current != null) {
							current.add(path[k], pth, k ,path);

							int inde = current.pnames.indexOf(path[k]);
							current = current.plist.get(inde);
							templist = current.plist;
							tempnames = current.pnames;
						}

						else {
						if (pmain_list_name.contains(path[k])  & (k==path.length-1)) {
								throw new AllreadyExists();

							}
							products main = new products("", "", null);
							main.add(path[k], pth,k,path);
							int inde = main.pnames.indexOf(path[k]);
							current = main.plist.get(inde);
							templist = current.plist;
							tempnames = current.pnames;

						}
					}
				}

			}
			System.out.println(current.name);
			if(current.pnames.contains(path[path.length-1])) {
				throw new AllreadyExists();
			}
			else {}
			
		} catch (AllreadyExists e) {
			

		}
	}

	products search(String to_be_searched) {
		products found = null;

		if (pmain_list_name.contains(to_be_searched)) {
			int inde = pmain_list_name.indexOf(to_be_searched);

			found = pmain_list.get(inde);

			return (found);
		}
		return found;

	}

	void modify(String to_be_modified) {

		System.out.println("type price to change price ");
		System.out.println("type qnty to change quantity ");

		String inp = sc.next();

		
		int val = sc.nextInt();
		if (inp.equals("price")) {
			System.out.println("Enter  price ");
			products tmp = search(to_be_modified);
			tmp.modify_price(val);
			System.out.print("Price modified");
		} else if (inp.equals("qnty")) {
			System.out.println("Enter new qnty ");
			products tmp = search(to_be_modified);
			tmp.modify_quantity(val);
			System.out.print("Quantity modified");
		}

	}

	void delete(String to_be_deleted) {
		products dlt = search(to_be_deleted);
		pmain_list.remove(dlt);
		pmain_list_name.remove(dlt.name);
		dlt.delete();

	}

	void sale(ArrayList<products> pr, int funds, int bill) throws NotEnoughFunds {
		try {
			if (funds < bill) {
				throw new NotEnoughFunds(bill - funds);

			} else {
				System.out.print("Transection completed !! Thanks for shopping");
				myrev = myrev + bill;
			}

		} catch (NotEnoughFunds e) {
			System.out.println("Not enough funds to process");
		}

	}
}
