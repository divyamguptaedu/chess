package Chess;
import Chess.Piece.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GamePlayTest {

    @Test
    public void PawnDefaultPositionOne() {
        Pawn pawn = new Pawn("White");
        List<List<int[]>> result = pawn.findMoves(1, 0);
        assertEquals(2, result.get(0).size());
        assertEquals(1, result.get(1).size());
    }

    @Test
    public void PawnDefaultPositionTwo() {
        Pawn pawn = new Pawn("White");
        List<List<int[]>> result = pawn.findMoves(1, 1);
        assertEquals(2, result.get(0).size());
        assertEquals(2, result.get(1).size());
    }

    @Test
    public void PawnDefaultGamePlayPosition() {
        Pawn pawn = new Pawn("Black");
        pawn.firstMoveDone = true;
        List<List<int[]>> result = pawn.findMoves(4, 4);
        assertEquals(1, result.get(0).size());
        assertEquals(2, result.get(1).size());
    }

    @Test
    public void PawnEndPosition() {
        Pawn pawn = new Pawn("Black");
        List<List<int[]>> result = pawn.findMoves(0, 0);
        assertEquals(0, result.get(0).size());
        assertEquals(0, result.get(1).size());
    }
}