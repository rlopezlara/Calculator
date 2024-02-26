package calculator.calculator;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class CalForm {
    @FXML
    private Label IbIAnswer;

    @FXML
    private Button btn0;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btnC;

    @FXML
    private Button btnCE;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnEq;

    @FXML
    private Button btnMulti;

    @FXML
    private Button btnOnOff;

    @FXML
    private Button btnPoint;

    @FXML
    private Button btnSub;

    @FXML
    private Button btnSum;

    @FXML
    private TextField txtShow;

    @FXML
    private Button btnQuater;
    private List<Button> btnList; // Creating a list to keep all the buttons
    private double answer;
    private String function;

    //initialize function
    public void initialize(){
        answer = 0;
        function = "empty";
        btnList = FXCollections.observableArrayList(btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnPoint,btnEq,btnSum,
                btnMulti, btnSub, btnDivide,btnC,btnCE,btnQuater);
        off();
        onOffFunction();
        setAnswer();
        functions();
    }

    private void functions(){
//        givining a function to each buttons
        btnC.setOnAction(event -> {
            txtShow.clear();
        });
        btnCE.setOnAction(event -> {
            function = "empty";
            answer = 0;
            IbIAnswer.setText("0");
        });

        btn0.setOnAction(event -> {
            txtShow.setText(txtShow.getText()!= null? txtShow.getText()+"0":"0");
        });

        btn1.setOnAction(event -> {

            txtShow.setText(txtShow.getText()!= null? txtShow.getText()+"1":"1");
        });

        btn2.setOnAction(event -> {

            txtShow.setText(txtShow.getText()!= null? txtShow.getText()+"2":"2");
        });

        btn3.setOnAction(event -> {

            txtShow.setText(txtShow.getText()!= null? txtShow.getText()+"3":"3");
        });

        btn4.setOnAction(event -> {

            txtShow.setText(txtShow.getText()!= null? txtShow.getText()+"4":"4");
        });

        btn5.setOnAction(event -> {

            txtShow.setText(txtShow.getText()!= null? txtShow.getText()+"5":"5");
        });

        btn6.setOnAction(event -> {

            txtShow.setText(txtShow.getText()!= null? txtShow.getText()+"6":"6");
        });

        btn7.setOnAction(event -> {

            txtShow.setText(txtShow.getText()!= null? txtShow.getText()+"7":"7");
        });

        btn8.setOnAction(event -> {

            txtShow.setText(txtShow.getText()!= null? txtShow.getText()+"8":"8");
        });

        btn9.setOnAction(event -> {

            txtShow.setText(txtShow.getText()!= null? txtShow.getText()+"9":"9");
        });

        btnPoint.setOnAction(event -> {
            txtShow.setText(txtShow.getText()!= null? txtShow.getText()+".":".0");
        });

        btnSum.setOnAction(event -> {
            action();
            function = "sum";

        });

        btnSub.setOnAction(event -> {
            action();
            function = "sub";

        });

        btnMulti.setOnAction(event -> {
            action();
            function = "multi";

        });

        btnDivide.setOnAction(event -> {
            action();
            function = "div";

        });

        btnEq.setOnAction(event -> {
            action();
            function = "equal";
        });

        btnQuater.setOnAction(event -> {
            function = "quater";
            action();

        });

    }
//    Setting result in correct format
    private void setAnswer(){
        String formattedAnswer = answer >= 1000000 ? formatWithCommas(answer) : String.valueOf(answer);
        IbIAnswer.setText(String.format("%.02f",answer));
        IbIAnswer.setText(formattedAnswer);
        txtShow.clear();
    }
    private String formatWithCommas(double number) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();
        formatter.applyPattern("#,###.##");
        return formatter.format(number);
    }
    private void action(){
//      function to catch the values and working out the option
        switch (function){
            case "empty": answer = Double.parseDouble(txtShow.getText());
                        setAnswer(); break;
            case "sum": answer += Double.parseDouble(txtShow.getText());
                    setAnswer(); break;
            case "sub": answer -= Double.parseDouble(txtShow.getText());
                    setAnswer();break;
            case "multi": answer *= Double.parseDouble(txtShow.getText());
                    setAnswer(); break;
            case "div":
//              Setting up the function to number divide by 0
                if(Double.parseDouble(txtShow.getText()) != 0) {
                    answer /= Double.parseDouble(txtShow.getText());
                    setAnswer();
                }else{
                    IbIAnswer.setText("Error: Division by Zero");
                    return;
                }
                break;

            case "quater": answer = Double.parseDouble(txtShow.getText()) * Double.parseDouble(txtShow.getText());
                setAnswer(); break;

            case "equal": setAnswer(); break;
        }

    }
    private void on(){

        for(Button btn: btnList){
            btn.setDisable(false);
        }
        txtShow.clear();
        answer = 0;
        setAnswer();
    }
    private void off(){

        for(Button btn: btnList){
            btn.setDisable(true);
        }
        txtShow.clear();
        answer = 0;
        setAnswer();
    }

    private void onOffFunction(){
        btnOnOff.setOnAction(event -> {
        if(btnOnOff.getText().equals("ON")){
            on();
            btnOnOff.setText("OFF");
        }else if(btnOnOff.getText().equals("OFF")){
            off();
            btnOnOff.setText("ON");
        }
        });
    }
}