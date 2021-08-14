package Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Knight extends Piece {
    Color color;

    public Knight(String color) {
        this.color = new Color(color);
    }

    @Override
    public List<int[]> findMoves(int i, int j) {
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{i - 2, j - 1});
        result.add(new int[]{i - 2, j + 1});
        result.add(new int[]{i - 1, j - 2});
        result.add(new int[]{i - 1, j + 2});
        result.add(new int[]{i + 2, j - 1});
        result.add(new int[]{i + 2, j + 1});
        result.add(new int[]{i + 1, j - 2});
        result.add(new int[]{i + 1, j + 2});
        for (int k = 0; k < result.size(); k++) {
            if (result.get(k)[0] < 0 || result.get(k)[0] > 7 || result.get(k)[1] < 0 || result.get(k)[1] > 7) {
                result.remove(k);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "N";
    }
}
