/*
 * Dipta Das CUET CSE 11
 */

package calculatorproject;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorProject extends JFrame implements ActionListener
{

    double ans = 0, num = 0, memory = 0;
    int reset_textfield = 1, equal_pressed = 0;
    String operator = null, temp_str;
    Color light_green = Color.getHSBColor(0.3f, 0.2f, 1f);
    Color teal = Color.getHSBColor(0.5f, 0.2f, 0.8f);
    Color violet = Color.getHSBColor(0.7f, 0.2f, 0.8f);
    Color light_blue = Color.getHSBColor(0.6f, 0.1f, 1f);
    JMenuBar menubar = new JMenuBar();
    JMenu menu_customize = new JMenu("Customize");
    JMenu menu_help = new JMenu("Help");
    JMenu menu_theme = new JMenu("Theme");
    JMenu menu_color = new JMenu("Text Color");
    JMenu menu_size = new JMenu("Text Size");
    JMenuItem menuitem_about = new JMenuItem("About");
    JMenuItem menuitem_reset = new JMenuItem("Reset");
    JMenuItem menuitem_colorful = new JMenuItem("Colorfull");
    JMenuItem menuitem_default = new JMenuItem("Default");
    JMenuItem menuitem_blue = new JMenuItem("BLUE");
    JMenuItem menuitem_red = new JMenuItem("RED");
    JMenuItem menuitem_black = new JMenuItem("BLACK");
    JMenuItem menuitem_size12 = new JMenuItem("12");
    JMenuItem menuitem_size15 = new JMenuItem("15");
    JMenuItem menuitem_size20 = new JMenuItem("20");
    JTextField textfield_result = new JTextField("0");
    JTextField textfield_process = new JTextField();
    JButton button[] = new JButton[33];
    String button_names[] =
    {
        "MC", "MR", "MS", "M+", "M-",
        "←", "CE", "±", "√", "x^2",
        "log", "sin", "cos", "tan", "x^y",
        "7", "8", "9", "/", "%",
        "4", "5", "6", "*", "1/x",
        "1", "2", "3", "-", "=",
        "0", ".", "+"
    };

    public CalculatorProject()
    {
        setTitle("Calculator");
        setBounds(200, 100, 340, 430);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//------------------------------------------------------------------------------
        for (int i = 0; i < 33; i++)
        {
            button[i] = new JButton(button_names[i]);
            button[i].addActionListener(this);
        }
//------------------------------------------------------------------------------
        setJMenuBar(menubar);
        menubar.add(menu_customize);
        menubar.add(menu_help);
        menu_help.add(menuitem_about);
        menu_customize.add(menu_theme);
        menu_customize.add(menu_color);
        menu_customize.add(menu_size);
        menu_customize.add(menuitem_reset);
        menu_theme.add(menuitem_default);
        menu_theme.add(menuitem_colorful);
        menu_color.add(menuitem_black);
        menu_color.add(menuitem_blue);
        menu_color.add(menuitem_red);
        menu_size.add(menuitem_size12);
        menu_size.add(menuitem_size15);
        menu_size.add(menuitem_size20);
//------------------------------------------------------------------------------
        setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.fill = GridBagConstraints.BOTH;
        constraint.insets.set(5, 5, 5, 5);
        constraint.weightx = 1;
        constraint.weighty = 1;
//------------------------------------------------------------------------------
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.gridwidth = 5;
        constraint.gridheight = 1;
        add(textfield_process, constraint);
        textfield_process.setFont(new Font(null, Font.PLAIN, 15));
        textfield_process.setHorizontalAlignment(JTextField.RIGHT);
        textfield_process.setEditable(false);
//------------------------------------------------------------------------------
        constraint.gridy = 1;
        add(textfield_result, constraint);
        constraint.gridwidth = 1;
        textfield_result.setPreferredSize(new Dimension(0, 50));
        textfield_result.setFont(new Font(null, Font.PLAIN, 15));
        textfield_result.setEditable(false);
        textfield_result.setHorizontalAlignment(JTextField.RIGHT);
//------------------------------------------------------------------------------
        for (int i = 0, y = 2; i < 33; y++)
        {
            constraint.gridy = y;
            for (int x = 0; x < 5 && i < 33; x++, i++)
            {
                constraint.gridx = x;
                if (i == 29)
                {
                    constraint.gridheight = 2;
                    add(button[i], constraint);
                    constraint.gridheight = 1;
                }
                else if (i == 30)
                {
                    constraint.gridwidth = 2;
                    add(button[i], constraint);
                    constraint.gridwidth = 1;
                    x++;
                }
                else
                {
                    add(button[i], constraint);
                }
            }
        }
//------------------------------------------------------------------------------
        menuitem_reset.addActionListener(this);
        menuitem_default.addActionListener(this);
        menuitem_colorful.addActionListener(this);
        menuitem_blue.addActionListener(this);
        menuitem_red.addActionListener(this);
        menuitem_black.addActionListener(this);
        menuitem_size12.addActionListener(this);
        menuitem_size15.addActionListener(this);
        menuitem_size20.addActionListener(this);
        menuitem_about.addActionListener(this);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String action_command = e.getActionCommand();
        if (action_command.equals("Reset"))
        {
            getContentPane().setBackground(null);
            menubar.setBackground(null);
            textfield_result.setFont(new Font(null, Font.PLAIN, 15));
            textfield_result.setBackground(null);
            textfield_result.setForeground(Color.BLACK);
            textfield_process.setFont(new Font(null, Font.PLAIN, 15));
            textfield_process.setBackground(null);
            textfield_process.setForeground(Color.BLACK);
            for (int i = 0; i < 33; i++)
            {
                button[i].setBackground(null);
            }
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("BLUE"))
        {
            textfield_result.setForeground(Color.BLUE);
            textfield_process.setForeground(Color.BLUE);
        }
        else if (action_command.equals("RED"))
        {
            textfield_result.setForeground(Color.RED);
            textfield_process.setForeground(Color.RED);
        }
        else if (action_command.equals("BLACK"))
        {
            textfield_result.setForeground(Color.BLACK);
            textfield_process.setForeground(Color.BLACK);
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("12"))
        {
            textfield_result.setFont(new Font(null, Font.PLAIN, 12));
            textfield_process.setFont(new Font(null, Font.PLAIN, 12));
        }
        else if (action_command.equals("15"))
        {
            textfield_result.setFont(new Font(null, Font.PLAIN, 15));
            textfield_process.setFont(new Font(null, Font.PLAIN, 15));
        }
        else if (action_command.equals("20"))
        {
            textfield_result.setFont(new Font(null, Font.PLAIN, 20));
            textfield_process.setFont(new Font(null, Font.PLAIN, 20));
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("Default"))
        {
            getContentPane().setBackground(null);
            textfield_result.setBackground(null);
            textfield_process.setBackground(null);
            menubar.setBackground(null);
            for (int i = 0; i < 33; i++)
            {
                button[i].setBackground(null);
            }
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("Colorfull"))
        {
            getContentPane().setBackground(violet);
            textfield_result.setBackground(light_blue);
            textfield_process.setBackground(light_blue);
            menubar.setBackground(teal);
            for (int i = 0; i <= 4; i++)
            {
                button[i].setBackground(Color.PINK);
            }
            for (int i = 5; i <= 14; i++)
            {
                button[i].setBackground(light_green);
            }
            for (int i = 15; i <= 32; i++)
            {
                if (i == 18 || i == 19 || i == 23 || i == 24 || i == 28 || i == 29 || i == 32)
                {
                    button[i].setBackground(light_green);
                }
                else
                {
                    button[i].setBackground(Color.CYAN);
                }
            }
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("About"))
        {
            String msg = "DIPTA DAS\nID : 1104051\nDepartment of CSE\nCUET";
            JOptionPane.showMessageDialog(null, msg, "About", -1);
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("MC"))
        {
            memory = 0;
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("MR"))
        {
            textfield_result.setText(Double.toString(memory));
            operator = null;
            reset_textfield = 0;
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("MS"))
        {
            memory = Double.parseDouble(textfield_result.getText());
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("M+"))
        {
            memory += Double.parseDouble(textfield_result.getText());
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("M-"))
        {
            memory -= Double.parseDouble(textfield_result.getText());
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("←"))
        {
            temp_str = textfield_result.getText();
            if (temp_str.length() == 1)
            {
                textfield_result.setText("0");
                reset_textfield = 1;
            }
            else if (reset_textfield == 0 && equal_pressed == 0)
            {
                textfield_result.setText(temp_str.substring(0, temp_str.length() - 1));
            }
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("CE"))
        {
            textfield_result.setText("0");
            textfield_process.setText(null);
            ans = 0;
            num = 0;
            reset_textfield = 1;
            equal_pressed = 0;
            operator = null;
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("±"))
        {
            temp_str = textfield_result.getText();
            if (!temp_str.equals("0"))
            {
                if (temp_str.startsWith("-"))
                {
                    textfield_result.setText(temp_str.substring(1));
                }
                else
                {
                    textfield_result.setText("-" + temp_str);
                }
            }
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("log"))
        {
            if (operator != null && equal_pressed == 0)
            {
                textfield_process.setText(textfield_process.getText() + " log(" + textfield_result.getText() + ")");
                num = Math.log10(Double.parseDouble(textfield_result.getText()));
                calculation();
            }
            else
            {
                textfield_process.setText("log(" + textfield_result.getText() + ")");
                ans = Math.log10(Double.parseDouble(textfield_result.getText()));
                textfield_result.setText(Double.toString(ans));
            }
            reset_textfield = 1;
            operator = null;
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("sin"))
        {
            if (operator != null && equal_pressed == 0)
            {
                textfield_process.setText(textfield_process.getText() + "sin(" + textfield_result.getText() + ")");
                num = Math.sin(Math.toRadians(Double.parseDouble(textfield_result.getText())));
                num = Math.round(num * 1000);
                num = num / 1000;
                calculation();
            }
            else
            {
                textfield_process.setText("sin(" + textfield_result.getText() + ")");
                ans = Math.sin(Math.toRadians(Double.parseDouble(textfield_result.getText())));
                ans = Math.round(ans * 1000);
                ans = ans / 1000;
                textfield_result.setText(Double.toString(ans));
            }
            reset_textfield = 1;
            operator = null;
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("cos"))
        {
            if (operator != null && equal_pressed == 0)
            {
                textfield_process.setText(textfield_process.getText() + "cos(" + textfield_result.getText() + ")");
                num = Math.cos(Math.toRadians(Double.parseDouble(textfield_result.getText())));
                num = Math.round(num * 1000);
                num = num / 1000;
                calculation();
            }
            else
            {
                textfield_process.setText("cos(" + textfield_result.getText() + ")");
                ans = Math.cos(Math.toRadians(Double.parseDouble(textfield_result.getText())));
                ans = Math.round(ans * 1000);
                ans = ans / 1000;
                textfield_result.setText(Double.toString(ans));
            }
            reset_textfield = 1;
            operator = null;
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("tan"))
        {
            if (operator != null && equal_pressed == 0)
            {
                textfield_process.setText(textfield_process.getText() + "tan(" + textfield_result.getText() + ")");
                num = Math.tan(Math.toRadians(Double.parseDouble(textfield_result.getText())));
                num = Math.round(num * 1000);
                num = num / 1000;
                calculation();
            }
            else
            {
                textfield_process.setText("tan(" + textfield_result.getText() + ")");
                ans = Math.tan(Math.toRadians(Double.parseDouble(textfield_result.getText())));
                ans = Math.round(ans * 1000);
                ans = ans / 1000;
                textfield_result.setText(Double.toString(ans));
            }
            reset_textfield = 1;
            operator = null;
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("x^2"))
        {
            if (operator != null && equal_pressed == 0)
            {
                textfield_process.setText(textfield_process.getText() + "(" + textfield_result.getText() + "^2)");
                num = Math.pow(Double.parseDouble(textfield_result.getText()), 2);
                calculation();
            }
            else
            {
                textfield_process.setText(textfield_result.getText() + "^2");
                ans = Math.pow(Double.parseDouble(textfield_result.getText()), 2);
                textfield_result.setText(Double.toString(ans));
            }
            reset_textfield = 1;
            operator = null;
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("√"))
        {
            if (operator != null && equal_pressed == 0)
            {
                textfield_process.setText(textfield_process.getText() + "√" + textfield_result.getText());
                num = Math.sqrt(Double.parseDouble(textfield_result.getText()));
                calculation();
            }
            else
            {
                textfield_process.setText("√" + textfield_result.getText());
                ans = Math.sqrt(Double.parseDouble(textfield_result.getText()));
                textfield_result.setText(Double.toString(ans));
            }
            reset_textfield = 1;
            operator = null;
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("%"))
        {
            if (operator != null && equal_pressed == 0)
            {
                num = ans * Double.parseDouble(textfield_result.getText()) / 100;
                textfield_process.setText(textfield_process.getText() + num);
                calculation();
            }
            else
            {
                ans = ans * Double.parseDouble(textfield_result.getText()) / 100;
                textfield_result.setText(Double.toString(ans));
            }
            reset_textfield = 1;
            operator = null;
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("1/x"))
        {
            if (operator != null && equal_pressed == 0)
            {
                textfield_process.setText(textfield_process.getText() + "reciproc(" + textfield_result.getText() + ")");
                num = 1 / Double.parseDouble(textfield_result.getText());
                calculation();
            }
            else
            {
                textfield_process.setText("reciproc(" + textfield_result.getText() + ")");
                ans = 1 / Double.parseDouble(textfield_result.getText());
                textfield_result.setText(Double.toString(ans));
            }
            reset_textfield = 1;
            operator = null;
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("+") || action_command.equals("-") || action_command.equals("*") || action_command.equals("/") || action_command.equals("x^y"))
        {
            if (action_command.equals("x^y"))
            {
                action_command = "^";
            }
            if ((operator == null || equal_pressed == 1) && reset_textfield == 0)
            {
                textfield_process.setText(textfield_process.getText() + textfield_result.getText());
                ans = Double.parseDouble(textfield_result.getText());
                reset_textfield = 1;
            }
            else
            {
                if (reset_textfield == 0)
                {
                    textfield_process.setText(textfield_process.getText() + textfield_result.getText());
                    num = Double.parseDouble(textfield_result.getText());
                    calculation();
                    reset_textfield = 1;
                }
                else if (textfield_process.getText().equals(""))
                {
                    textfield_process.setText(textfield_result.getText());
                }
                else
                {
                    temp_str = textfield_process.getText();
                    char ch = temp_str.charAt(temp_str.length() - 1);
                    if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')
                    {
                        textfield_process.setText(temp_str.substring(0, temp_str.length() - 1));
                    }
                }
            }
            operator = action_command;
            equal_pressed = 0;
            textfield_process.setText(textfield_process.getText() + operator);
        }
//------------------------------------------------------------------------------
        else if (action_command.equals("="))
        {
            if (operator != null && equal_pressed == 0)
            {
                num = Double.parseDouble(textfield_result.getText());
                calculation();
            }
            else
            {
                calculation();
            }
            equal_pressed = 1;
            reset_textfield = 1;
            textfield_process.setText(null);
        }
//------------------------------------------------------------------------------
        else
        {
            if (operator == null)
            {
                textfield_process.setText(null);
            }
            if (reset_textfield == 1)
            {
                if (action_command.equals("."))
                {
                    textfield_result.setText("0.");
                }
                else
                {
                    textfield_result.setText(action_command);
                }
                reset_textfield = 0;
            }
            else
            {
                temp_str = textfield_result.getText();
                if (action_command.equals("."))
                {
                    if (!temp_str.contains("."))
                    {
                        textfield_result.setText(temp_str + action_command);
                    }
                }
                else
                {
                    textfield_result.setText(temp_str + action_command);
                }
            }
        }
    }

    public void calculation()
    {
        if (operator == null)
        {
            ans = Double.parseDouble(textfield_result.getText());
        }
        else if (operator.equals("+"))
        {
            ans += num;
        }
        else if (operator.equals("-"))
        {
            ans -= num;
        }
        else if (operator.equals("*"))
        {
            ans *= num;
        }
        else if (operator.equals("/"))
        {
            ans /= num;
        }
        else if (operator.equals("^"))
        {
            ans = Math.pow(ans, num);
        }
        textfield_result.setText(Double.toString(ans));
        reset_textfield = 1;
    }

    public static void main(String[] args)
    {
        new CalculatorProject();
    }
}

