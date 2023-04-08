package implement;

import main.java.interfaces.Calculator;

public class CalculatorImp implements Calculator {

    private String order(String a, String b) {
        String add = "";
        for (int i = 0; i < Math.abs(a.length() - b.length()); i++) {
            add += "0";
        }
        return add + b;
    }
    @Override
    public String sum(String a, String b) {
        //vamos a tener q sumar el carry a el resto de la suma en i posicion para el else
        if (a.length() < b.length()){
            a = order(a, b);
        }else b = order(b, a);
        String carry = "";
        String result = "";
        for (int i = 0; i < a.length() ; i--) {
            if(a.charAt(i) > b.charAt(i) || a.charAt(i) < b.charAt(i)){
                result += "1";


            }
            a[i] + b[i];
        }
    }

    @Override
    public String sub(String a, String b) {
        //hacemos lo mismo q para la suma pero cuando hay dif entre el restando y el restado, lo de pedirle uno
        //al de al lado, usamos el complemente de ese numero [base ^ canti de digitos] (hacer otra func para simplificarlo.
        return null;
    }

    @Override
    public String mult(String a, String b) {
        return null;
    }

    @Override
    public String div(String a, String b) {
        return null;
    }

    @Override
    public String toHex(String binary) {
        return null;
    }

    @Override
    public String fromHex(String hex) {
        return null;
    }
}
