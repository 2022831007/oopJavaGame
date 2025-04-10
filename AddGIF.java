private void showWinnerPopup(String message) {
    JFrame popup = new JFrame("Game Over");
    popup.setSize(350, 400);
    popup.setLayout(new BorderLayout());
    popup.setLocationRelativeTo(this);

    JLabel label = new JLabel(message, SwingConstants.CENTER);
    label.setFont(new Font("Arial", Font.BOLD, 18));
    popup.add(label, BorderLayout.NORTH);

    // load GIF from resources
    java.net.URL gifUrl = getClass().getResource("/gamebe/cute.gif");
    if (gifUrl != null) {
        ImageIcon gifIcon = new ImageIcon(gifUrl);
        JLabel gifLabel = new JLabel(gifIcon);
        popup.add(gifLabel, BorderLayout.CENTER);
    } else {
        JLabel errorLabel = new JLabel("GIF not found!", SwingConstants.CENTER);
        popup.add(errorLabel, BorderLayout.CENTER);
    }

    JPanel panel = new JPanel();
    JButton playAgainButton = new JButton("Play Again");
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
