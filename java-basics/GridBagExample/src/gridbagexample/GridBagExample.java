/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridbagexample;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author dipta
 */
public class GridBagExample extends JFrame {
    
    String[] btnName={"7","8","9","+","4","5","6","1","2","3","=","0","."};

    public GridBagExample() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 400);

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets.set(4, 4, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;

        for (int i = 0,k=0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                
                if((i==1||i==3) && j==3) continue;
                if(i==3 && j==1) continue;
                
                if(i==3 && j==0)
                {
                    constraints.gridheight=1;
                    constraints.gridwidth=2;
                }
                else if((i==0||i==2) && j==3)
                {
                    constraints.gridheight=2;
                    constraints.gridwidth=1;
                }
                else
                {
                    constraints.gridheight=1;
                    constraints.gridwidth=1;
                }
                
                constraints.gridx = j;
                constraints.gridy = i;
                JButton btn = new JButton(btnName[k++]);
                add(btn, constraints);
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new GridBagExample();
    }

}
