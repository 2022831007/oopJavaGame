private int[] checkWinner() {
    for (int i = 0; i < 3; i++) {
        if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                buttons[i][1].getText().equals(buttons[i][2].getText()) &&
                !buttons[i][0].getText().equals("")) {
            return new int[]{i, 0, i, 1, i, 2};
        }

        if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                buttons[1][i].getText().equals(buttons[2][i].getText()) &&
                !buttons[0][i].getText().equals("")) {
            return new int[]{0, i, 1, i, 2, i};
        }
    }

    if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][2].getText()) &&
            !buttons[0][0].getText().equals("")) {
        return new int[]{0, 0, 1, 1, 2, 2};
    }

    if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][0].getText()) &&
            !buttons[0][2].getText().equals("")) {
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
