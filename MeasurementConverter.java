import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class MeasurementConverter extends Frame implements ItemListener, ActionListener
{
  
    JComboBox From, To;
    JTextField From1, To1;
    JButton solve, exit;
    JLabel amountfrom, amountto;
    JLabel From2, To2;
    JPanel Panel = new JPanel();

    double input = 0;
    double result = 0;

    public MeasurementConverter() {
       //GUI BOX
        super("Measurement Converter");
        setSize(420,300);
        setLayout(null);
        setBackground(Color.lightGray);

        
        //From Measurement dropdown box
        From = new JComboBox();
        From.setBounds(30,70,150,30);
        From.addItem("Inches");
        From.addItem("Feet");
        From.addItem("Yards");
        From.addItem("Meters");
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
        To.addItem("Inches");
        To.addItem("Feet");
        To.addItem("Yards");
        To.addItem("Meters");
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

         

        
        //exit button
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
    
    
    
    

    public void ConvertFromInches() {
        if(To.getSelectedItem()=="Inches")
        {
            result = (input);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Feet")
        {
            result = (input / 12);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()== "Yards")
        {
            result = (input / 36);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Meters")
        {
            result = (input / 39.3701);
            To1.setText(""+result);
        }
        
    }

    public void ConvertFromFeet() {
        if(To.getSelectedItem()=="Inches")
        {
            result = (input * 12);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Feet")
        {
            result = (input);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Yards")
        {
            result = (input / 3);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Meters")
        {
            result = (input / 3.28084);
            To1.setText(""+result);
        }
       
    }

    public void ConvertFromYards() {
        if(To.getSelectedItem()=="Inches")
        {
            result = (input * 36);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Feet")
        {
            result = (input * 3);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Yards")
        {
            result = (input);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Meters")
        {
            result = (input / 1.09361);
            To1.setText(""+result);
        }
    }

    public void ConvertFromMeters() {
        if(To.getSelectedItem()=="Inches")
        {
            result = (input * 39.3701);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Feet")
        {
            result = (input * 3.28084);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Yards")
        {
            result = (input * 1.09361);
            To1.setText(""+result);
        }
        else if(To.getSelectedItem()=="Meters")
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
            if(From.getSelectedItem()=="Inches")
            {
                ConvertFromInches();                
            }
            else if(From.getSelectedItem()=="Feet")
            {
                ConvertFromFeet();
            }
            else if(From.getSelectedItem()=="Yards")
            {
                ConvertFromYards();
            }
            else if(From.getSelectedItem()=="Meters")
            {
                ConvertFromMeters();
            }
            

        }
        else
        {
            //this will display a confirm dialog box
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
    public void itemStateChanged(ItemEvent e)
    {

    }
}
