private void showWinnerPopup(String message) {
    JFrame popup = createGameOverPopup(message);

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
