package org.rixon.pi;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigInteger;
 
public class Pi {
  final BigInteger TWO = BigInteger.valueOf(2) ;
  final BigInteger THREE = BigInteger.valueOf(3) ;
  final BigInteger FOUR = BigInteger.valueOf(4) ;
  final BigInteger SEVEN = BigInteger.valueOf(7) ;
  final BigInteger BASE = BigInteger.valueOf(26) ;
 
  BigInteger q = BigInteger.ONE ;
  BigInteger r = BigInteger.ZERO ;
  BigInteger t = BigInteger.ONE ;
  BigInteger k = BigInteger.ONE ;
  BigInteger n = THREE;
  BigInteger l = THREE;
 
  public void calcPiDigits() throws FileNotFoundException{
    BigInteger nn, nr ;
    boolean first = true ;
    
    PrintStream ps = new PrintStream("pi26.txt");
    
    while(true){
        if(FOUR.multiply(q).add(r).subtract(t).compareTo(n.multiply(t)) == -1){
          char c = Character.forDigit(n.intValueExact() + 10, 36);
          ps.print(c);
          if(first){
        	  ps.print(".");
        	  first = false;
          }
          
          nr = BASE.multiply(r.subtract(n.multiply(t))) ;
          n = BASE.multiply(THREE.multiply(q).add(r)).divide(t).subtract(BASE.multiply(n)) ;
          q = q.multiply(BASE) ;
          r = nr ;
          System.out.flush() ;
        }else{
          nr = TWO.multiply(q).add(r).multiply(l) ;
          nn = q.multiply((SEVEN.multiply(k))).add(TWO).add(r.multiply(l)).divide(t.multiply(l)) ;
          q = q.multiply(k) ;
          t = t.multiply(l) ;
          l = l.add(TWO) ;
          k = k.add(BigInteger.ONE) ;
          n = nn ;
          r = nr ;
        }
    }
  }
 
  public static void main(String[] args) throws FileNotFoundException {
    Pi p = new Pi() ;
    p.calcPiDigits() ;
  }
}
