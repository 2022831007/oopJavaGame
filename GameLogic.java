import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {

    public TicTacToe() {
        initComponents();
    }

    private void initComponents() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (!clickedButton.getText().equals("")) return;

        clickedButton.setText(isXTurn ? "X" : "O");
        clickedButton.setForeground(isXTurn ? Color.BLUE : Color.RED);

        isXTurn = !isXTurn;
        turnLabel.setText((isXTurn ? "X" : "O") + "'s Turn");
    }
}
