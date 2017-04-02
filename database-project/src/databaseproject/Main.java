package databaseproject;

public class Main
{
    public static String cur_user = "Admin";

    public static void main(String[] args)
    {
        new Operation().Check();
        new LoginForm().setVisible(true);
    }
}
