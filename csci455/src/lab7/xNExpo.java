package lab7;

public class xNExpo {
	public int fastExpon(int x, int n) {
		  if(n == 0){
		    return 1;
		  }else if(n == 1){
		    return x;
		  }else{
		    if(n%2 == 0){
		      return fastExpon(x, n/2)*fastExpon(x, n/2);
		    }else{
		      return fastExpon(x, n/2)*fastExpon(x, n/2+1);
		    }
		  }
		}
}
