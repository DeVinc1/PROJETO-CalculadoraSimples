import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculatorMain implements ActionListener{

    JFrame frame;
    JTextField textField;
    JPanel panel;
    Font myFont = new Font("Monospaced", Font.BOLD, 18);

    JButton[] numberButtons = new JButton[10];
    JButton[] functionsButtons = new JButton[9];

    /* Botões de Operações Matemáticas */
    JButton addButton, subButton, multiButton, dividButton, equalsButton;

    /* Botões de Operações da Calculadora */
    JButton decButton, deletButton, clearButton, negButton;

    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char mathOperator;

    calculatorMain(){

        /* Configs da Janela */
        frame = new JFrame("Calculadora Java");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        /* Configs do texto mostrador */
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        /* Configs dos Botões */
        addButton = new JButton("+");
        subButton = new JButton("-");
        multiButton = new JButton("*");
        dividButton = new JButton("/");
        equalsButton = new JButton("=");

        decButton = new JButton(".");
        deletButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        negButton = new JButton("(-)");

        /* Povoando Array de Botões com Função */
        functionsButtons[0] = addButton;
        functionsButtons[1] = subButton;
        functionsButtons[2] = multiButton;
        functionsButtons[3] = dividButton;
        functionsButtons[4] = equalsButton;
        functionsButtons[5] = decButton;
        functionsButtons[6] = deletButton;
        functionsButtons[7] = clearButton;
        functionsButtons[8] = negButton;

        for (int i = 0; i < 9; i++){
            functionsButtons[i].addActionListener(this);
            functionsButtons[i].setFont(myFont);
            functionsButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430, 100,50);
        deletButton.setBounds(150,430,100,50);
        clearButton.setBounds(250, 430, 100, 50);

        /* Povoando Array de Botões dos Números */
        for (int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        /* Configs do Painel */
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        /* Adicionando botões no painel */
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiButton);

        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(dividButton);

        /* Adicionando componentes ao Frame */
        frame.add(panel);
        frame.add(negButton);
        frame.add(deletButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /* Funcionalidade para os Botões de Número */
        for (int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        /* Funcionalidade para o Botão de Decimal */
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }

        /* Funcionalidade para botões de operações matemáticas */
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            mathOperator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            mathOperator = '-';
            textField.setText("");
        }
        if(e.getSource() == multiButton){
            num1 = Double.parseDouble(textField.getText());
            mathOperator = '*';
            textField.setText("");
        }
        if(e.getSource() == dividButton){
            num1 = Double.parseDouble(textField.getText());
            mathOperator = '/';
            textField.setText("");
        }

        /* Funcionalidade para Botão de Resultado */
        if(e.getSource() == equalsButton){
            num2 = Double.parseDouble(textField.getText());
            switch (mathOperator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        /* Funcionalidade para Botão de Limpar Tudo */
        if(e.getSource()==clearButton){
            textField.setText("");
        }

        /* Funcionalidade para Botão de Limpar um Número */
        if(e.getSource()==deletButton){

            String stringTemporaria = textField.getText();
            textField.setText("");

            for (int i=0; i < stringTemporaria.length() - 1; i++){
                textField.setText(textField.getText() + stringTemporaria.charAt(i));
            }

        }

        /* Funcionalidade para o Botão de Negativo */
        if(e.getSource() == negButton){
            double tempNumber = Double.parseDouble(textField.getText());
            tempNumber *= -1;
            textField.setText(String.valueOf(tempNumber));

        }
    }
}
