package searching;

public class THashLinearProbing {
	public static void main(String []args) {
		HashLinearProbing<Integer,String> hslp = new HashLinearProbing<Integer,String>();
		hslp.put( 66,  "b");
		hslp.put( 114, "r");
		hslp.put( 117, "u");
		hslp.put( 110, "n");
		hslp.put( 111, "o");
		hslp.put(85, "U");
		hslp.put(78, "N");
		hslp.put(73, "I");
		hslp.put(81, "Q");
		hslp.put(69, "E");
		hslp.allkeys().forEach(System.out::println);

	
	}

}
