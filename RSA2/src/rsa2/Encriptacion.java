
package rsa2;

import java.util.ArrayList;

/**
 *
 * @author agarcia
 */
public class Encriptacion {
    //ozzze
    //viva la guitarrita y el flamenquito
    long p,q,e,n,d,fn,c;
    int priv[]=new int[2],pub[]=new int[2];
    char[] alfabeto={' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z',' ','0','1','2','3','4','5','6','7','8','9','.',',',':',';'};
    ArrayList<Character> mensaje2 = new ArrayList<Character>();
    
    
    
    public Encriptacion() {
        for(char w : alfabeto){
        mensaje2.add(w);
    }
        
    }
    public void iniciar(){
        p=42461;
        q=42683;
        n=p*q;
        fn=(p-1)*(q-1);
        e=mcd2(fn);
        d=((fn*calcularY())+1)/e;
    }
    
    public  long[] encriptar(String mensaje){
        String s=mensaje.toLowerCase();
        long encriptado[]= new long[s.length()];
        iniciar();
        for(int i=0;i<s.length();i++){
            c=((mensaje2.indexOf(s.charAt(i))^e))%n;
            encriptado[i]=c;
            
        }
        return encriptado;
        
    }
    public  String desencriptar(long[] mensaje){
        int m;
        String s="";
        iniciar();
        for (long i : mensaje) {
            m=(int) (i^d%n);
            s= s+ mensaje2.get(m);
        }
        
        return s;
    }
     public  long  MCD_Euclides(long a, long b){
    while(b != 0){
         long t = b;
         b = a % b;
         a = t;
    }
    return a;
    }
    public long mcd2(long b){
        long a=b-1;
        while(MCD_Euclides(a, b)!=1){
            a=a-1;
        }
        return a;
    }
    long calcularY(){
        long y=1;
        while((fn*y+1)%e!=0){
            y=y+1;
            
        }
        return y;
    }

    
}
