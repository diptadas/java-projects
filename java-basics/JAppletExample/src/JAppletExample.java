
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dipta
 */
public class JAppletExample extends JApplet implements ActionListener{
    
    @Override
    public void init()
    {
        setLayout(new FlowLayout());
        JButton btn=new JButton("Click");
        add(btn);
        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Click"))
        {
            JOptionPane.showMessageDialog(null, "JApplet Example", "About", 1);
        }
    }
    
}
