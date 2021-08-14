package Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class King extends Piece {
    Color color;

    public King(String color) {
        this.color = new Color(color);
    }

    public List<int[]> findMoves(int i, int j) {
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{i - 1, j});
        result.add(new int[]{i + 1, j});
        result.add(new int[]{i, j - 1});
        result.add(new int[]{i, j + 1});
        for (int k = 0; k < result.size(); k++) {
            if (result.get(k)[0] < 0 || result.get(k)[0] > 7 || result.get(k)[1] < 0 || result.get(k)[1] > 7) {
                result.remove(k);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "K";
    }
}
