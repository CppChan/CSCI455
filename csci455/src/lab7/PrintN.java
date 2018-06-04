package lab7;

public class PrintN {
	public static String string1UpToN(int n) {
		  return RAppendUpTo("", 1, n);
		}

		public static String RAppendUpTo(String pre, int start, int end){
		  if(start == end){
		    return pre+String.valueOf(end);
		  }else{
		    pre = pre+String.valueOf(start)+" ";
		    start++;
		    return RAppendUpTo(pre, start, end);
		  }
		}
		
	public static void main(String args[]) {
		System.out.print(string1UpToN(5));
	}
}
