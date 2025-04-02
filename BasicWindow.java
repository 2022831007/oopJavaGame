package gamebe;
import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    private JLabel turnLabel;
    private boolean isXTurn = true;

    public TicTacToe() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Tic Tac Toe");
        setSize(480, 840);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        turnLabel = new JLabel("X's Turn", SwingConstants.CENTER);
        turnLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(turnLabel, BorderLayout.NORTH);

        setVisible(true);
    }
}
