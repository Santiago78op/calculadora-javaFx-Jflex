package com.calculadora.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;


public class FXMLDocument implements Initializable {

    @FXML
    private Label result;
    @FXML
    private Label prevnum;

    @FXML
    private Button clear;
    private double num_1 = 0,
        total = 0;

    private String operator = "";
    private boolean check = true;

    public  Double create(double num_1, double num_2, String operator){
        switch (operator){
            case "+":
                return (num_1 + num_2);
            case "-":
                return (num_1 - num_2);
            case "*":
                return (num_1 * num_2);
            case "/":
                if (num_2 == 0){
                    return 0.0;
                }
                return (num_1 / num_2);
            default:
                break;
        }
        return 0.0;
    }

    public void number(String number){
        result.setText(result.getText() + number);
    }

    public void prevNumber(String number){
        prevnum.setText(prevnum.getText() + number);
    }

    public void prevOperator(String operator){
        prevnum.setText(prevnum.getText() + " " + operator + " ");
    }

    public void computeProcess(ActionEvent event){
        if (check){
            result.setText("");
            prevnum.setText("");
            check = false;
        }

        Button button = (Button)event.getSource();

        String value = button.getText();

        number(value);
        prevNumber(value);
    }

    public void operatorProcess(ActionEvent event){
        Button button = (Button)event.getSource();
        String value = button.getText();

        if(!value.equals("Ans")){
            if(!operator.isEmpty())
                return;

            operator = value;
            prevOperator(operator);
            num_1 = Double.parseDouble(result.getText());
            result.setText("");
        }else{
            if(operator.isEmpty())
                return;
            double num_2 = Double.parseDouble(result.getText());

            total = create(num_1, num_2, operator);

            result.setText(String.valueOf(total));

            operator = "";
            check = true;
        }
    }

    public void clear(ActionEvent event){
        if(event.getSource() == clear){
            result.setText("0");
            prevnum.setText("");
        }
    }

    public void exit(){
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Todo
    }
}