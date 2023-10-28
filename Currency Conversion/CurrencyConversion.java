import java.util.HashMap;
import java.util.Map;
import java.awt.event.*;  
import javax.swing.*;  
import java.awt.*;


public class CurrencyConversion extends JFrame implements ActionListener{

    private static Map<String, Double> exchangeRates;

    static {
        // Initialize exchange rates
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.73);
        exchangeRates.put("CAD", 1.26);
        exchangeRates.put("INR",83.28);
        exchangeRates.put("JPY", 149.56);
        
    }

    
    
    JLabel mainTitle,amount,from,to,result;
    JTextField amnt;  
    String str[]={"USD", "EUR", "GBP","CAD","INR","JPY"};
    JComboBox<String> fromcurr,tocurr;
    JButton b;

    
    public CurrencyConversion() {
        
        super("Currency Conversion"); 
        
        

        // Create components
        mainTitle = new JLabel("Currency Converter");
        Font font= new Font("Papyrus", Font.PLAIN, 20); 
        mainTitle.setFont(font);
        mainTitle.setBounds(150,0,200,50);

        
        
        amount = new JLabel("Amount");
        amount.setBounds(80, 75, 100, 30);
        

        from = new JLabel("From Currency:");
        from.setBounds(80, 150, 100, 30);
        

        to = new JLabel("To Currency:");
        to.setBounds(300, 150, 100, 30);
        

        amnt= new JTextField();
        amnt.setBounds(300, 70, 100, 30);

        fromcurr=new JComboBox<>(str);
        fromcurr.setBounds(80, 200, 100, 30);

        tocurr=new JComboBox<>(str);
        tocurr.setBounds(300, 200, 100, 30);

        b=new JButton("Convert");
        b.setBounds(180,300,100,30);

        result = new JLabel("Result:");
        result.setBounds(200, 350, 100, 30);

        b.addActionListener(this); 
         
        add(mainTitle);
        add(amount);
        add(amnt);
        add(from);
        add(to);
        add(fromcurr);
        add(tocurr);
        add(b);
        add(result);
        
        setSize(500,500); 
        setLayout(null);  
        setVisible(true); 
    }
                
        public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }


    

   private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amnt.getText());
            String fromCurrency = (String) fromcurr.getSelectedItem();
            String toCurrency = (String) tocurr.getSelectedItem();

            double res = convert(amount, fromCurrency, toCurrency);

            result.setText("Result: " + res);
           
        } 
        catch (NumberFormatException ex) {
            result.setText("Invalid input");
            
        }
    }
    private double convert(double amount, String fromCurrency, String toCurrency) {
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);

        
        double amountInUSD = amount / fromRate;
        return amountInUSD * toRate;
    }
    
    public static void main(String[] args) {
              
        new CurrencyConversion();
           
    }
}





