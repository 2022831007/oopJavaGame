package gamebe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
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

        // adding gameBoard
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        add(gridPanel, BorderLayout.CENTER);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setFont(new Font("Arial", Font.BOLD, 60));
                gridPanel.add(buttons[row][col]);
            }
        }

        setVisible(true);
    }
}
