
package calculator;


public class Calculations {
    private String expression;

    Calculations(String s) {
        this.expression = s;
    }
    
    public String validate(){
        if(expression.isEmpty()){return "Come on! I cannot read magic ink!";}
        if(expression.charAt(0)==' '){
            return "We usually put numbers first!";
        }
        if(expression.charAt(expression.length()-1)==' '){
            return "I am still expecting a number!";
        }
        if(expression.charAt(expression.length()-1)=='.'){
            return "I feel useless, just as a floating point at the end.";
        }
        for(int i=1;i<expression.length()-2;i++){
            if(expression.charAt(i)==' ' && expression.charAt(i+1)==' '){
                return "Ohh, only one operation per time!";
            }
        }
        for(int i=0;i<expression.length()-2;i++){
            if(expression.charAt(i)=='.' && expression.charAt(i+1)==' '){
                return "How about some numbers after the floating point?!";
            }
        }
        boolean flag = false;
        for(int i=1;i<expression.length()-2;i++){
            if(expression.charAt(i)==' '){flag=false;}
            if(expression.charAt(i)=='.'){
                if(flag){return "Seems like you are in love with floating points!";}
                else{flag=true;}
            }
        }
        
        return "OK";
    }
    
    private String[] parse(){
        return expression.split("\\s");
    }
    
    public double getResult(){
        String[] values = parse();
        double answer = Double.parseDouble(values[0]);
        for(int i=1;i<values.length;i+=2){
            switch(values[i]){
                case "+":  answer+= Double.parseDouble(values[i+1]);break;
                case "-":  answer-= Double.parseDouble(values[i+1]);break;
                case "x":  answer*= Double.parseDouble(values[i+1]);break;
                case "/":
                    if(Float.parseFloat(values[i+1])!=0){answer/= Float.parseFloat(values[i+1]);}
                    else{return Double.POSITIVE_INFINITY;}
            }
        }
        return answer;
    }
    
    
    
    
}
