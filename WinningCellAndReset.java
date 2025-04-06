private void highlightWinningCells(int[] winPositions) {
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
    turnLabel.setText("X's Turn");
}
