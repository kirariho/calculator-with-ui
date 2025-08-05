package com.calc;

import java.awt.*;
import java.awt.event.*;

class CalcAWT extends WindowAdapter implements ActionListener {

    Frame calcFrame;
    Label calcLabel;
    Button bnum_0, bnum_1, bnum_2, bnum_3, bnum_4, bnum_5, bnum_6, bnum_7, bnum_8, bnum_9;
    Button addButton, subButton, multButton, divButton, modButton, calcButton, clrButton, pointButton, negButton, backButton;
    double xd;
    double number1, number2, check;

    CalcAWT(){
        calcFrame = new Frame("Calc");
        calcLabel = new Label();
        calcLabel.setBackground(Color.LIGHT_GRAY);
        calcLabel.setBounds(50,50,260,60);
        
        // параметры числовых кнопок
        bnum_1 = new Button("1");
        bnum_1.setBounds(50, 340, 50, 50);

        bnum_2 = new Button("2");
        bnum_2.setBounds(120, 340, 50, 50);

        bnum_3 = new Button("3");
        bnum_3.setBounds(190, 340, 50, 50);

        bnum_4 = new Button("4");
        bnum_4.setBounds(50, 270, 50, 50);

        bnum_5 = new Button("5");
        bnum_5.setBounds(120, 270, 50, 50);

        bnum_6 = new Button("6");
        bnum_6.setBounds(190, 270, 50, 50);

        bnum_7 = new Button("7");
        bnum_7.setBounds(50, 200, 50 ,50);

        bnum_8 = new Button("8");
        bnum_8.setBounds(120, 200, 50, 50);

        bnum_9 = new Button("9");
        bnum_9.setBounds(190, 200, 50, 50);

        bnum_0 = new Button("0");
        bnum_0.setBounds(120, 410, 50, 50);

        // Параметры навигационных кнопок
        negButton = new Button("+/-");
        negButton.setBounds(50, 410, 50, 50);

        pointButton = new Button(".");
        pointButton.setBounds(190, 410, 50, 50);

        backButton = new Button("back");
        backButton.setName("BackBtn");
        backButton.setBounds(120, 130, 50, 50);

        // Параметры кнопоко операнд
        addButton = new Button("+");
        addButton.setName("AddBtn");
        addButton.setBounds(260, 340, 50, 50);

        subButton = new Button("-");
        subButton.setName("SubBtn");
        subButton.setBounds(260, 270, 50, 50);

        multButton = new Button("*");
        multButton.setName("MultBtn");
        multButton.setBounds(260, 200, 50, 50);

        divButton = new Button("/");
        divButton.setName("DivBtn");
        divButton.setBounds(260, 130, 50, 50);

        modButton = new Button("%");
        modButton.setName("ModBtn");
        modButton.setBounds(190, 130, 50, 50);
        
        calcButton = new Button("=");
        calcButton.setName("CalcBtn");
        calcButton.setBounds(245, 410, 65, 50);

        clrButton = new Button("CE");
        clrButton.setName("ClrBtn");
        clrButton.setBounds(50, 130, 65, 50);

        // Добавление слушателей событий
        bnum_1.addActionListener(this);
        bnum_2.addActionListener(this);
        bnum_3.addActionListener(this);
        bnum_4.addActionListener(this);
        bnum_5.addActionListener(this);
        bnum_6.addActionListener(this);
        bnum_7.addActionListener(this);
        bnum_8.addActionListener(this);
        bnum_9.addActionListener(this);
        bnum_0.addActionListener(this);

        pointButton.addActionListener(this);
        negButton.addActionListener(this);
        backButton.addActionListener(this);

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        multButton.addActionListener(this);
        divButton.addActionListener(this);
        modButton.addActionListener(this);
        calcButton.addActionListener(this);
        clrButton.addActionListener(this);
        
        //Добавляем компоненты интерфейса на фрейм
        calcFrame.addWindowListener(this);
        calcFrame.add(calcLabel);
        
        calcFrame.add(bnum_1); calcFrame.add(bnum_2); calcFrame.add(bnum_3); calcFrame.add(bnum_4); calcFrame.add(bnum_5); calcFrame.add(bnum_6); calcFrame.add(bnum_7); calcFrame.add(bnum_8); calcFrame.add(bnum_9); calcFrame.add(bnum_0);
        calcFrame.add(addButton); calcFrame.add(subButton); calcFrame.add(multButton); calcFrame.add(divButton); calcFrame.add(modButton); calcFrame.add(calcButton);
        calcFrame.add(clrButton); calcFrame.add(pointButton); calcFrame.add(negButton); calcFrame.add(backButton);
        
        calcFrame.setSize(360, 500);
        calcFrame.setLayout(null);
        calcFrame.setVisible(true);
   }

//    Когда окно закрывается - ресурсы, занимаемые им, освобождаются
        public void closingWindow(WindowEvent e){
            calcFrame.dispose();
        }

        public void actionPerformed(ActionEvent e){
            setTextForButton(bnum_1, e, '1');
            setTextForButton(bnum_2, e, '2');
            setTextForButton(bnum_3, e, '3');
            setTextForButton(bnum_4, e, '4');
            setTextForButton(bnum_5, e, '5');
            setTextForButton(bnum_6, e, '6');
            setTextForButton(bnum_7, e, '7');
            setTextForButton(bnum_8, e, '8');
            setTextForButton(bnum_9, e, '9');
            setTextForButton(bnum_0, e, '0');

            setTextForButton(pointButton, e, '.');
            setTextForButton(negButton, e, '-');
            
            //Для пробела
            setTextForButton(backButton, e, ' '); // надо отделить часть кода, которая отвечает за работу кнопок действий и арифметических операций


        }

        public void setTextForButton(Button buttonName, ActionEvent e, char charNumber){
             String input, output;  // Переменные для getText - setText
            if((e.getSource() == buttonName) && (buttonName != backButton) && (buttonName != addButton) && (buttonName != subButton) && (buttonName != multButton) && (buttonName != divButton) &&(buttonName != modButton) && (buttonName != calcButton) && (buttonName != clrButton)){
                input = calcLabel.getText();
                output = input + charNumber;
                calcLabel.setText(output);
            }
            else if((e.getSource() == buttonName) && (buttonName == backButton) && (buttonName != addButton) && (buttonName != subButton) && (buttonName != multButton) && (buttonName != divButton) &&(buttonName != modButton)){
                input = calcLabel.getText();
                try{
                    output = input.substring(0, input.length()-1);
                }catch(StringIndexOutOfBoundsException f){
                    return;
                }
                calcLabel.setText(output);
            }
            else if ((e.getSource() == buttonName) && ((buttonName == addButton) || (buttonName == subButton) || (buttonName == multButton) || (buttonName == divButton) || (buttonName == modButton))){
                try{
                    number1 = Double.parseDouble(calcLabel.getText());
                }catch(NumberFormatException f){
                    calcLabel.setText("Invalid format");
                    return;
                }
                output = "";
                calcLabel.setText(output);

                String checkValue = buttonName.getName();
                switch(checkValue){
                    case "AddBtn":
                        check = 1;
                        break;
                    case "SubBtn":
                        check = 2;
                        break;
                    case "MultBtn":
                        check = 3;
                        break;
                    case "DivBtn":
                        check = 4;
                        break;
                    case "ModBtn":
                        check = 5;
                        break;
                    default:
                        throw new IllegalArgumentException("Uncnown button " + buttonName);
                }
            }
        }
    public static void main(String[] args) {
        
    }
}

