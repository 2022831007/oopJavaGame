package gamebe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    private JButton[][] buttons = new JButton[3][3];
    private JLabel turnLabel;
    private boolean isXTurn = true;

    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setSize(480, 640);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // showing  "X's Turn" or "O's Turn"
        turnLabel = new JLabel("X's Turn", SwingConstants.CENTER);
        turnLabel.setFont(new Font("Arial", Font.BOLD, 24));
        turnLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(turnLabel, BorderLayout.NORTH);

        //grid panel for Tic Tac Toe board
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        add(gridPanel, BorderLayout.CENTER);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setFont(new Font("Arial", Font.BOLD, 60));
                buttons[row][col].setFocusPainted(false);
                buttons[row][col].addActionListener(this);
                gridPanel.add(buttons[row][col]);
            }
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (!clickedButton.getText().equals("")) return;

        clickedButton.setText(isXTurn ? "X" : "O");
        clickedButton.setForeground(isXTurn ? Color.BLUE : Color.RED);

        int[] winPositions = checkWinner();
        if (winPositions != null) {
            highlightWinningCells(winPositions);
            showWinnerPopup((isXTurn ? "X" : "O") + " Wins!",true);
        } else if (isBoardFull()) {
            showWinnerPopup("It's a Draw!",false);
        } else {
            isXTurn = !isXTurn;
            turnLabel.setText((isXTurn ? "X" : "O") + "'s Turn");
        }
    }

    private int[] checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][1].getText().equals(buttons[i][2].getText()) &&
                    !buttons[i][0].getText().equals("")) {
                // Row win
                return new int[]{i, 0, i, 1, i, 2};
            }

            if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                    buttons[1][i].getText().equals(buttons[2][i].getText()) &&
                    !buttons[0][i].getText().equals("")) {
                // Column win
                return new int[]{0, i, 1, i, 2, i};
            }
        }

        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][2].getText()) &&
                !buttons[0][0].getText().equals("")) {
            // Main diagonal win
            return new int[]{0, 0, 1, 1, 2, 2};
        }

        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[1][1].getText().equals(buttons[2][0].getText()) &&
                !buttons[0][2].getText().equals("")) {
            // Anti-diagonal win
            return new int[]{0, 2, 1, 1, 2, 0};
        }

        return null;
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().equals("")) return false;
            }
        }
        return true;
    }

    private void highlightWinningCells(int[] winPositions) {
        // Light green color highlighting  for the winner
        Color highlightColor = new Color(144, 238, 144);
        for (int i = 0; i < winPositions.length; i += 2) {
            buttons[winPositions[i]][winPositions[i + 1]].setBackground(highlightColor);
        }
    }

    private void resetGame() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
                buttons[row][col].setBackground(null);
            }
        }
        isXTurn = true;
        // Reseting turn indicator
        turnLabel.setText("X's Turn");
    }

    private void showWinnerPopup(String message,boolean isWin) {
        JFrame popup = new JFrame("Game Over");
        popup.setSize(350, 400);
        popup.setLayout(new BorderLayout());
        popup.setLocationRelativeTo(this);

        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        popup.add(label, BorderLayout.NORTH);

        // load exited gif for winner
        if (isWin) {
            java.net.URL gifUrl = getClass().getResource("/gamebe/cute.gif");
            if (gifUrl != null) {
                ImageIcon gifIcon = new ImageIcon(gifUrl);
                JLabel gifLabel = new JLabel(gifIcon);
                popup.add(gifLabel, BorderLayout.CENTER);
            } else {
                JLabel errorLabel = new JLabel("Winner GIF not found!", SwingConstants.CENTER);
                popup.add(errorLabel, BorderLayout.CENTER);
            }

        } //load sadcat gif for draw
        else {
            
            java.net.URL gifUrl = getClass().getResource("/gamebe/catSad.gif");
            if (gifUrl != null) {
                ImageIcon gifIcon = new ImageIcon(gifUrl);
                JLabel gifLabel = new JLabel(gifIcon);
                popup.add(gifLabel, BorderLayout.CENTER);
            } else {
                JLabel errorLabel = new JLabel("Draw GIF not found!", SwingConstants.CENTER);
                popup.add(errorLabel, BorderLayout.CENTER);
            }
        }

        // Buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 10, 10));

        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.setFocusPainted(false);
        playAgainButton.addActionListener(e -> {
            popup.dispose();
            resetGame();
        });

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> System.exit(0));

        panel.add(playAgainButton);
        panel.add(quitButton);
        popup.add(panel, BorderLayout.SOUTH);

        popup.setVisible(true);
    }
}
