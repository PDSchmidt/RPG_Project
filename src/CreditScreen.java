import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditScreen extends Screen{
    JButton exit;
    ExitHandler eHandler = new ExitHandler();
    public CreditScreen(String type, Container container, GameManager game){
        super(type, container, game);
        mainTextBoxPanel.setBounds(540, 100, 400,400);
        mainText.setText("Created by:" +
                "\n\nDavid Francis" +
                "\nPaul Schmidt" +
                "\nSimon That" +
                "\nDevinn Wilson");
        mainButtonPanel.setBounds(540,550, 200, 50);
        exit = new JButton("EXIT");
        exit.setFocusPainted(false);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setFont(buttonFont);
        exit.addActionListener(eHandler);
        mainButtonPanel.add(exit);

    }

    @Override
    public void updateVisibility(boolean newValue) {
        visibility = newValue;
        mainTextBoxPanel.setVisible(visibility);
        mainButtonPanel.setVisible(visibility);
    }
    public class ExitHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
