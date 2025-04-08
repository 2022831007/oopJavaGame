private JFrame createGameOverPopup(String message) {
    JFrame popup = new JFrame("Game Over");
    popup.setSize(350, 400);
    popup.setLayout(new BorderLayout());
    popup.setLocationRelativeTo(this);

    JLabel label = new JLabel(message, SwingConstants.CENTER);
    label.setFont(new Font("Arial", Font.BOLD, 18));
    popup.add(label, BorderLayout.NORTH);

    return popup;
}
