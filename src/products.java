import java.util.*;

public  final class products {
	int price;
	int quantity;
	String path;
	String name;
	LinkedList<products> plist = new LinkedList<products>();
	LinkedList<String> pnames = new LinkedList<String>();
	products parent;

	products(String name, String pth, products parent) {
		this.name = name;
		
		Database.pmain_list.add(this);
		Database.pmain_list_name.add(this.name);
		this.parent=parent;
		this.path=pth;

	}

	void add(String nam, String pth , int k , String[] lst) throws AllreadyExists{
		
		if((pnames.contains(nam))  &  (k==lst.length-1)){
			System.out.println(k-lst.length-1);
			throw new AllreadyExists() ;
			
			
		}
		else {
		products adding = new products(nam, pth , this);

	
		plist.add(adding);
		pnames.add(nam);
		
		}
	}

	void modify_price(int pr) {
		this.price = pr;

	}

	void modify_quantity(int qnty) {
		this.quantity = qnty;
	}

	boolean if_exist(String name) {
		return pnames.contains(name);

	}

	void delete() {
		parent.plist.remove(this);
		parent.pnames.remove(this.name);
	}

	void when_found() {

		
		System.out.println(this.path);
		System.out.println(this.name);
		System.out.println(this.price);
		System.out.println(this.quantity);
		

	}

}
