import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CombatViewer extends JFrame {
    
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    
    JCheckBox testBox = new JCheckBox("Test", true);
    
    public CombatViewer() {
        super("Combat Tracker");
        setLookAndFeel();
        setSize(500,400);
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
        setLayout(layout);
        
        String[] columnNames = {"First Name",
                        "Last Name",
                        "Sport",
                        "# of Years",
                        "Vegetarian"};
        
        Object[][] data = {
            {"Kathy", "Smith",
            "Snowboarding", new Integer(5), new Boolean(false)},
            {"John", "Doe",
            "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black",
            "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White",
             "Speed reading", new Integer(20), new Boolean(true)},
            {"Joe", "Brown",
            "Pool", new Integer(10), new Boolean(false)}
        };
        
        JTable table = new JTable(data, columnNames);
        
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        panel1.setLayout(new BorderLayout());
        panel1.add(table.getTableHeader(), BorderLayout.PAGE_START);
        panel1.add(table, BorderLayout.CENTER);
        add(panel1);
        
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 
                10, 10));
        panel2.add(testBox);
        add(panel2);
        
        setVisible(true);
    }
    
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
                    );
        } catch (Exception exc) {
            // ignore error
        }
    }
    
    public static void main(String[] arguments) {
        CombatViewer frame = new CombatViewer();
    }
} 