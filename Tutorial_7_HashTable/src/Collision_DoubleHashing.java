
public class Collision_DoubleHashing {

static String [] myTable = new String [5];
	
	
	public static void main(String[] args) {
		
		insert(9, "Zairul"); //9%5 = 4
		insert(5, "Mazwan"); //5%5 = 0
		insert(12, "Jilani"); //12%5 = 2
		insert(15, "Rania");//iter 0 : 15%5 = 0, iter 1 :  (1*3)%5 = 3
		insert(23, "Mehmet"); //iter 0 : 23%5 = 3, iter 1: (4*1)%5 = 4, iter 2 : (5*1)%5 = 0, iter 3 : (6*1)%5 = 1, iter 4: (7*1)%5 = 2
		
		printData();	
		
	}
	
	public static void insert (int key, String name) {
		
		int i = 0;
		int index = hashFunction(key, i); 
		
		while (collision(index)==true) {
			i++;//increment the i for the next interation if there is collision
			index = hashFunction(key, i); //get the first hash with i incremented
			index *= doubleHash (key); //get the second hash and product with the first hash
			index %= myTable.length; 
			System.out.println(i);
		}
		myTable[index] = name;
	}
	
	public static int hashFunction (int key, int i) {
		int index = (key%myTable.length)+i;
		return index;
	}
	
	public static int doubleHash (int key) {
		 int index = 3 - (key%3);
		 return index;
	}
	
	public static boolean collision (int index) {
		boolean col = false;
		if (myTable[index]!=null) {
			col = true;
		}
		return col;
	}
	
	public static void printData () {
		for (int i = 0; i<myTable.length; i++) {
			System.out.print(myTable[i]);
			System.out.println();
		}
	}

}
