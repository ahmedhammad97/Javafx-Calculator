
package calculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Button nine;

    @FXML
    private Button minus;

    @FXML
    private Button six;

    @FXML
    private Button mul;

    @FXML
    private Button one;

    @FXML
    private Label display;

    @FXML
    private Button dot;

    @FXML
    private Button clear;

    @FXML
    private Button seven;

    @FXML
    private Button three;

    @FXML
    private Button two;

    @FXML
    private Button plus;

    @FXML
    private Button eight;

    @FXML
    private Button div;

    @FXML
    private Button zero;

    @FXML
    private Button equal;

    @FXML
    private Label result;

    @FXML
    private Button four;

    @FXML
    private AnchorPane window;

    @FXML
    private Button five;
    
    private boolean start = false;
    ArrayList<String> history = new ArrayList<>();
     
    
    
    

    @FXML
    void handleButtonAction(ActionEvent event) {
            if(!start && event.getSource()!=equal){display.setText("");start=true;}
            ActionEvent last = event;
            if(event.getSource()==one){
                display.setText(display.getText() + '1');
            }
            else if(event.getSource()==two){
                display.setText(display.getText() + '2');
            }
            else if(event.getSource()==three){
                display.setText(display.getText() + '3');
            }
            else if(event.getSource()==four){
                display.setText(display.getText() + '4');
            }
            else if(event.getSource()==five){
                display.setText(display.getText() + '5');
            }
            else if(event.getSource()==six){
                display.setText(display.getText() + '6');
            }
            else if(event.getSource()==seven){
                display.setText(display.getText() + '7');
            }
            else if(event.getSource()==eight){
                display.setText(display.getText() + '8');
            }
            else if(event.getSource()==nine){
                display.setText(display.getText() + '9');
            }
            else if(event.getSource()==zero){
                display.setText(display.getText() + '0');
            }
            else if(event.getSource()==plus){
                display.setText(display.getText() + " + ");
            }
            else if(event.getSource()==minus){
                display.setText(display.getText() + " - ");
            }
            else if(event.getSource()==mul){
                display.setText(display.getText() + " x ");
            }
            else if(event.getSource()==div){
                display.setText(display.getText() + " / ");
            }
            else if(event.getSource()==dot){
                display.setText(display.getText() + '.');
            }
            else if(event.getSource()==clear){
                display.setText("");
            }
            else if(event.getSource()==equal){
                String s = display.getText();
                Calculations c = new Calculations(s);
                String msg = c.validate();
                if(!msg.equals("OK")){display.setText(msg);start=false;}
                else{
                    double ans = c.getResult();
                    if(ans==Double.POSITIVE_INFINITY){
                        display.setText("Welcome to Infinity, sir.");
                        start=false;
                    }
                    else{
                        result.setText(String.format("%.4f", ans));
                        start=false;
                        history.add(0, s);
                        if(history.size()>5){history.remove(5);}
                    }
                    
                }
                
            }
            
    }
    
    public void KeyboardFunction(KeyEvent event) {
        //System.out.println(event.getCode());
        switch(event.getCode()){
            case NUMPAD0: case DIGIT0: zero.fire();break;
            case NUMPAD1: case DIGIT1: one.fire();break;
            case NUMPAD2: case DIGIT2: two.fire();break;
            case NUMPAD3: case DIGIT3: three.fire();break;
            case NUMPAD4: case DIGIT4: four.fire();break;
            case NUMPAD5: case DIGIT5: five.fire();break;
            case NUMPAD6: case DIGIT6: six.fire();break;
            case NUMPAD7: case DIGIT7: seven.fire();break;
            case NUMPAD8: case DIGIT8: eight.fire();break;
            case NUMPAD9: case DIGIT9: nine.fire();break;
            case DECIMAL: dot.fire();break;
            
            case ADD: plus.fire();break;
            case SUBTRACT: minus.fire();break;
            case DIVIDE: div.fire();break;
            case MULTIPLY: mul.fire();break;
            
            case EQUALS: equal.fire();break;
            case ENTER: equal.fire();break;
            case BACK_SPACE: clear.fire();break;
            
            case UP:
                start = true;
                String temp1 = history.get(history.size()-1);
                history.remove(history.size()-1);
                history.add(0, temp1);
                display.setText(history.get(0));
                break;
            
            case DOWN :  
                start=true;
                String temp2 = history.get(0);
                history.remove(0);
                history.add(temp2);
                display.setText(history.get(0));
                break;
                
            default:
        }
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
}
