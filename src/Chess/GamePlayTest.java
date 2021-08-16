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
        assertEquals(true, GamePlay.contains(2, 0, result));
        assertEquals(true, GamePlay.contains(3, 0, result));
        assertEquals(true, GamePlay.contains(2, 1, result));
    }

    @Test
    public void PawnDefaultPositionTwo() {
        Pawn pawn = new Pawn("White");
        List<List<int[]>> result = pawn.findMoves(1, 1);
        assertEquals(2, result.get(0).size());
        assertEquals(2, result.get(1).size());
        assertEquals(true, GamePlay.contains(2, 1, result));
        assertEquals(true, GamePlay.contains(3, 1, result));
        assertEquals(true, GamePlay.contains(2, 0, result));
        assertEquals(true, GamePlay.contains(2, 2, result));
    }

    @Test
    public void PawnGamePlayPosition() {
        Pawn pawn = new Pawn("Black");
        pawn.firstMoveDone = true;
        List<List<int[]>> result = pawn.findMoves(4, 4);
        assertEquals(1, result.get(0).size());
        assertEquals(2, result.get(1).size());
        assertEquals(true, GamePlay.contains(3, 4, result));
        assertEquals(true, GamePlay.contains(3, 3, result));
        assertEquals(true, GamePlay.contains(3, 5, result));
    }

    @Test
    public void PawnEndPosition() {
        Pawn pawn = new Pawn("Black");
        List<List<int[]>> result = pawn.findMoves(0, 0);
        assertEquals(0, result.get(0).size());
        assertEquals(0, result.get(1).size());
    }

    @Test
    public void PawnColor() {
        Pawn pawn = new Pawn("Black");
        assertEquals("Black", pawn.getColor());
    }

    @Test
    public void RookDefaultPosition() {
        Rook rook = new Rook("Black");
        List<List<int[]>> result = rook.findMoves(7, 0);
        assertEquals(7, result.get(0).size());
        assertEquals(0, result.get(1).size());
        assertEquals(7, result.get(2).size());
        assertEquals(0, result.get(3).size());
        assertEquals(true, GamePlay.contains(0, 0, result));
        assertEquals(true, GamePlay.contains(7, 7, result));
    }

    @Test
    public void RookGamePlayPosition() {
        Rook rook = new Rook("White");
        List<List<int[]>> result = rook.findMoves(4, 4);
        assertEquals(4, result.get(0).size());
        assertEquals(3, result.get(1).size());
        assertEquals(3, result.get(2).size());
        assertEquals(4, result.get(3).size());
        assertEquals(true, GamePlay.contains(7, 4, result));
        assertEquals(true, GamePlay.contains(0, 4, result));
        assertEquals(true, GamePlay.contains(4, 7, result));
        assertEquals(true, GamePlay.contains(4, 0, result));
    }

    @Test
    public void RookColor() {
        Rook rook = new Rook("White");
        assertEquals("White", rook.getColor());
    }

    @Test
    public void KnightDefaultPosition() {
        Knight knight = new Knight("Black");
        List<List<int[]>> result = knight.findMoves(7, 1);
        assertEquals(3, result.get(0).size());
        assertEquals(true, GamePlay.contains(5, 0, result));
        assertEquals(true, GamePlay.contains(5, 2, result));
        assertEquals(true, GamePlay.contains(6, 3, result));
    }

    @Test
    public void KnightGamePlayPosition() {
        Knight knight = new Knight("White");
        List<List<int[]>> result = knight.findMoves(4, 4);
        assertEquals(8, result.get(0).size());
        assertEquals(true, GamePlay.contains(2, 3, result));
        assertEquals(true, GamePlay.contains(2, 5, result));
        assertEquals(true, GamePlay.contains(3, 2, result));
        assertEquals(true, GamePlay.contains(3, 6, result));
        assertEquals(true, GamePlay.contains(5, 2, result));
        assertEquals(true, GamePlay.contains(5, 6, result));
        assertEquals(true, GamePlay.contains(6, 3, result));
        assertEquals(true, GamePlay.contains(6, 5, result));
    }

    @Test
    public void KnightColor() {
        Knight knight = new Knight("Black");
        assertEquals("Black", knight.getColor());
    }

    @Test
    public void BishopDefaultPosition() {
        Bishop bishop = new Bishop("Black");
        List<List<int[]>> result = bishop.findMoves(7, 2);
        assertEquals(5, result.get(0).size());
        assertEquals(2, result.get(1).size());
        assertEquals(0, result.get(2).size());
        assertEquals(0, result.get(3).size());
        assertEquals(true, GamePlay.contains(5, 0, result));
        assertEquals(true, GamePlay.contains(6, 1, result));
        assertEquals(true, GamePlay.contains(2, 7, result));
    }

    @Test
    public void BishopGamePlayPosition() {
        Bishop bishop = new Bishop("White");
        List<List<int[]>> result = bishop.findMoves(4, 4);
        assertEquals(3, result.get(0).size());
        assertEquals(4, result.get(1).size());
        assertEquals(3, result.get(2).size());
        assertEquals(3, result.get(3).size());
        assertEquals(true, GamePlay.contains(1, 7, result));
        assertEquals(true, GamePlay.contains(0, 0, result));
        assertEquals(true, GamePlay.contains(7, 1, result));
        assertEquals(true, GamePlay.contains(7, 7, result));
    }

    @Test
    public void BishopColor() {
        Bishop bishop = new Bishop("White");
        assertEquals("White", bishop.getColor());
    }
}