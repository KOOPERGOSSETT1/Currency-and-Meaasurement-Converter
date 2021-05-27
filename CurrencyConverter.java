import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class CurrencyConverter extends Frame implements ItemListener, ActionListener
{
  
    JComboBox From, To;
    JTextField From1, To1;
    JButton solve, exit;
    JLabel amountfrom, amountto;
    JLabel From2, To2;
    JPanel Panel = new JPanel();

    double input = 0;
    double result = 0;

    public CurrencyConverter() {
       //GUI BOX
        super("Currency Converter");
        setSize(420,300);
        setLayout(null);
        setBackground(Color.lightGray);

        
        //From currency dropdown box
        From = new JComboBox();
        From.setBounds(30,70,150,30);
        From.addItem("Dollar");
        From.addItem("Peso");
        From.addItem("Yen");
        From.addItem("Baht");
        // form dropdown's box
        From1 = new JTextField(15);
        From1.setBounds(50,140,300,30);
        //String on top of from dropdown box
        From2 = new JLabel("From");
        From2.setBounds(30,45,250,30);
        From2.setForeground(Color.BLACK);
        //The amount the user wants to convert box
        amountfrom = new JLabel("Type Amount to Convert");
        amountfrom.setBounds(50,110,300,30);

        add(amountfrom);
        add(From);
        add(From1);
        add(From2);
        //To dropdown box
        To = new JComboBox();
        To.setBounds(230,70,150,30);
        To.addItem("Dollar");
        To.addItem("Peso");
        To.addItem("Yen");
        To.addItem("Baht");
        //To Dropdown's box
        To1 = new JTextField(15);
        To1.setBounds(50,200,300,30);
        To1.setEditable(false);
        To1.setForeground(Color.BLACK);
        //String above To dropdown box
        To2 = new JLabel("To");
        To2.setBounds(230,45,250,30);
        To2.setForeground(Color.BLACK);
        //Amount converted box
        amountto = new JLabel("Amount Converted");
        amountto.setBounds(50,170,300,30);

        add(To);
        add(To1);
        add(To2);
        add(amountto);

        //solve button
        solve = new JButton("Solve");
        solve.setBounds(100,250,100,30);
        add(solve);

         

        
        //
        exit = new JButton("Exit");
        exit.setBounds(210,250,100,30);
        add(exit);
       
        //register all the GUI components who will listen or invoke the methods
        From.addItemListener(this);
        To.addItemListener(this);
        solve.addActionListener(this);
        From1.addActionListener(this);
        exit.addActionListener(this);
       
        //this will close the applet window if the user clicked the close or exit button
        addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    exit();
                }
            });
    }
    
    
    
    

    public void ConvertFromDollar() {
        if(To.getSelectedItem()=="Dollar")
        {
            result = (input);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Peso")
        {
            result = (input * 19.90);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()== "Yen")
        {
            result = (input * 108.99);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Baht")
        {
            result = (input * 31.35);
            To1.setText(""+result);
        }
        
    }

    public void ConvertFromPeso() {
        if(To.getSelectedItem()=="Dollar")
        {
            result = (input * 0.050);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Peso")
        {
            result = (input);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Yen")
        {
            result = (input * 2.26);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Baht")
        {
            result = (input * 0.65);
            To1.setText(""+result);
        }
       
    }

    public void ConvertFromYen() {
        if(To.getSelectedItem()=="Dollar")
        {
            result = (input * 0.0092);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Peso")
        {
            result = (input * 0.44);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Yen")
        {
            result = (input);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Baht")
        {
            result = (input * 0.29);
            To1.setText(""+result);
        }
    }

    public void ConvertFromBaht() {
        if(To.getSelectedItem()=="Dollar")
        {
            result = (input * 0.032);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Peso")
        {
            result = (input * 1.54);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Yen")
        {
            result = (input * 3.48);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Baht")
        {
            result = (input);
            To1.setText(""+result);
        }
    }

   
    public void actionPerformed(ActionEvent e) {

        input = Double.parseDouble(From1.getText());
        String msg = From1.getText();

        if(e.getSource()== solve)
        {
            if(From.getSelectedItem()=="Dollar")
            {
                ConvertFromDollar();                
            }
            else if(From.getSelectedItem()=="Peso")
            {
                ConvertFromPeso();
            }
            else if(From.getSelectedItem()=="Yen")
            {
                ConvertFromYen();
            }
            else if(From.getSelectedItem()=="Baht")
            {
                ConvertFromBaht();
            }
            

        }
        else
        {
            //this will display a confirm box
            int choice = JOptionPane.showConfirmDialog(null,"Do you really want to quit this application?","Exit",JOptionPane.YES_NO_OPTION);
            if(choice==0) {
                dispose();
                System.exit(0);
            }
        }
    }
      public void exit(){
        setVisible(false);
        dispose();
        System.exit(0);
      }
}
