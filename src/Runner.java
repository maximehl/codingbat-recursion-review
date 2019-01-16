public class Runner {
    public static void main(String args[]){
        System.out.println(triangle(0)==0);
        System.out.println(triangle(7)==28);
        System.out.println(triangle(4)==10);

        System.out.println(fibonacci(7)==13);
        System.out.println(fibonacci(2)==1);
        System.out.println(fibonacci(18)==2584);

        System.out.println(countHi("hiAAhi12hi")==3);
        System.out.println(countHi("xhixhxihihhhih")==3);
        System.out.println(countHi("h")==0);

        System.out.println(sumDigits(1111)==4);
        System.out.println(sumDigits(49)==13);
        System.out.println(sumDigits(730)==10);

        System.out.println(!nestParen("((y)))"));
        System.out.println(nestParen("((()))"));
        System.out.println(nestParen("((yy))")); //this should return true, even though codingbat says it's false

        System.out.println(allStar("hello").equals("h*e*l*l*o"));
        System.out.println(allStar("Chocolate").equals("C*h*o*c*o*l*a*t*e"));
        System.out.println(allStar("3.14").equals("3*.*1*4"));

        System.out.println(parenBit("xyz(abc)123").equals("(abc)"));
        System.out.println(parenBit("(x)").equals("(x)"));
        System.out.println(parenBit("not really (possible)").equals("(possible)"));

        System.out.println(changeXY("codex").equals("codey"));
        System.out.println(changeXY("xxhixx").equals("yyhiyy"));
        System.out.println(changeXY("yyhxyi").equals("yyhyyi"));
    }

    public static int triangle(int rows){
        if(rows==0){ return 0; }
        return rows + triangle(rows-1);
    }

    public static int fibonacci(int n){
        if(n==0){ return 0; }
        if(n==1){ return 1; }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int countHi(String str) {
        if(str.length()<=1){ return 0; }
        if(str.substring(0, 2).equals("hi")){ return 1 + countHi(str.substring(2)); }
        return countHi(str.substring(1));
    }

    public static int sumDigits(int n) {
        if(n<10){ return n; }
        return (n%10) + sumDigits(n/10);
    }

    public static boolean nestParen(String str) {
        if(str.length()==0){ return true; } //the only way for this to happen is if there hasn't been an unmatched parenthesis left over
        if(str.substring(0,1).equals("(")||str.substring(str.length()-1).equals(")")){ //either one or both are parentheses...
            if(str.length()==1){ return false; } //but there's only one character——it's an unmatched parenthesis! :(
            if(str.substring(0,1).equals("(")&&str.substring(str.length()-1).equals(")")){ return nestParen(str.substring(1,str.length()-1)); }//we have a pair! let's chop both off and continue to check the rest of the string
            //it's not both, so only one of the two is a parenthesis...
            if(str.substring(0,1).equals("(")){ return nestParen(str.substring(0,str.length()-1)); }//it's the first one, so chop off the last character and keep looking for parentheses
            return nestParen(str.substring(1,str.length())); //it's the last one, so chop off the first character and keep looking for parentheses
        }
        return nestParen(str.substring(1));//neither of the characters are parentheses, so chop off characters from the front until you find an open parenthesis
    }

    public static String allStar(String str) {
        if(str.length()<=1){ return str; }
        return str.substring(0,1) + "*" + allStar(str.substring(1));
    }

    public static String parenBit(String str) {
        if(str.substring(0,1).equals("(")&&str.substring(str.length()-1).equals(")")){ return str; }
        if(str.substring(0,1).equals("(")){ return parenBit(str.substring(0,str.length()-1)); }
        return parenBit(str.substring(1));
    }

    public static String changeXY(String str) {
        if(str.length()==0){ return ""; }
        if(str.substring(0,1).equals("x")){ return "y" + changeXY(str.substring(1)); }
        return str.substring(0,1) + changeXY(str.substring(1));
    }
}