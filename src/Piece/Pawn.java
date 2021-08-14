package Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Pawn extends Piece {
    public Color color;
    public Boolean firstMoveDone;

    public Pawn(String color) {
        this.color = new Color(color);
        this.firstMoveDone = false;
    }

    public List<List<int[]>> findMoves(int i, int j) {
        List<List<int[]>> result = new ArrayList<>();
        result.add(this.findMovesAhead(i, j));
        result.add(this.findMovesToKill(i, j));
        return result;
    }

    private List<int[]> findMovesAhead(int i, int j) {
        List<int[]> result = new ArrayList<>();
        if (this.color.color == "White") {
            result.add(new int[]{i + 1, j});
            if (!this.firstMoveDone) {
                result.add(new int[]{i + 2, j});
            }
        }
        if (this.color.color == "Black") {
            result.add(new int[]{i - 1, j});
            if (!this.firstMoveDone) {
                result.add(new int[]{i - 2, j});
            }
        }
        for (int k = 0; k < result.size(); k++) {
            if (result.get(k)[0] < 0 || result.get(k)[0] > 7 || result.get(k)[1] < 0 || result.get(k)[1] > 7) {
                result.remove(k);
            }
        }
        return result;
    }

    private List<int[]> findMovesToKill(int i, int j) {
        List<int[]> result = new ArrayList<>();
        if (this.color.color == "White") {
            result.add(new int[]{i + 1, j - 1});
            result.add(new int[]{i + 1, j + 1});
        }
        if (this.color.color == "Black") {
            result.add(new int[]{i - 1, j - 1});
            result.add(new int[]{i - 1, j + 1});
        }
        for (int k = 0; k < result.size(); k++) {
            if (result.get(k)[0] < 0 || result.get(k)[0] > 7 || result.get(k)[1] < 0 || result.get(k)[1] > 7) {
                result.remove(k);
            }
        }
        return result;
    }


    @Override
    public String toString() {
        return "P";
    }
}
