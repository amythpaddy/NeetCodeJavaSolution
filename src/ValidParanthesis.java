import java.util.ArrayList;
import java.util.List;

public class ValidParanthesis {
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) {
List<String> finalAns = generateParenthesis(1);
for(String ans : finalAns){
    System.out.println(ans);
}
    }
    static void addOpen(String result, int openCount,int closeCount, int size){
        if(openCount>= size){
            return;
        }
        result = result.concat("(");
        addOpen(result,++openCount,closeCount,size);
        addClose(result,openCount,closeCount,size);
    }
    static void addClose(String result, int openCount, int closeCount, int size){
        if(closeCount>=openCount){
            return;
        }
        result = result.concat(")");
        if(result.length()==size*2){
            answer.add(result);
        }
        addOpen(result,openCount,++closeCount,size);
        addClose(result,openCount,closeCount,size);
    }

    static public List<String> generateParenthesis(int n) {
        addOpen("",0,0,n);
        return answer;
    }
}
