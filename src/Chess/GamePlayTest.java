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
        assertTrue(GamePlay.contains(2, 0, result));
        assertTrue(GamePlay.contains(3, 0, result));
        assertTrue(GamePlay.contains(2, 1, result));
    }

    @Test
    public void PawnDefaultPositionTwo() {
        Pawn pawn = new Pawn("White");
        List<List<int[]>> result = pawn.findMoves(1, 1);
        assertEquals(2, result.get(0).size());
        assertEquals(2, result.get(1).size());
        assertTrue(GamePlay.contains(2, 1, result));
        assertTrue(GamePlay.contains(3, 1, result));
        assertTrue(GamePlay.contains(2, 0, result));
        assertTrue(GamePlay.contains(2, 2, result));
    }

    @Test
    public void PawnGamePlayPosition() {
        Pawn pawn = new Pawn("Black");
        pawn.firstMoveDone = true;
        List<List<int[]>> result = pawn.findMoves(4, 4);
        assertEquals(1, result.get(0).size());
        assertEquals(2, result.get(1).size());
        assertTrue(GamePlay.contains(3, 4, result));
        assertTrue(GamePlay.contains(3, 3, result));
        assertTrue(GamePlay.contains(3, 5, result));
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
        assertTrue(GamePlay.contains(0, 0, result));
        assertTrue(GamePlay.contains(7, 7, result));
    }

    @Test
    public void RookGamePlayPosition() {
        Rook rook = new Rook("White");
        List<List<int[]>> result = rook.findMoves(4, 4);
        assertEquals(4, result.get(0).size());
        assertEquals(3, result.get(1).size());
        assertEquals(3, result.get(2).size());
        assertEquals(4, result.get(3).size());
        assertTrue(GamePlay.contains(7, 4, result));
        assertTrue(GamePlay.contains(0, 4, result));
        assertTrue(GamePlay.contains(4, 7, result));
        assertTrue(GamePlay.contains(4, 0, result));
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
        assertTrue(GamePlay.contains(5, 0, result));
        assertTrue(GamePlay.contains(5, 2, result));
        assertTrue(GamePlay.contains(6, 3, result));
    }

    @Test
    public void KnightGamePlayPosition() {
        Knight knight = new Knight("White");
        List<List<int[]>> result = knight.findMoves(4, 4);
        assertEquals(8, result.get(0).size());
        assertTrue(GamePlay.contains(2, 3, result));
        assertTrue(GamePlay.contains(2, 5, result));
        assertTrue(GamePlay.contains(3, 2, result));
        assertTrue(GamePlay.contains(3, 6, result));
        assertTrue(GamePlay.contains(5, 2, result));
        assertTrue(GamePlay.contains(5, 6, result));
        assertTrue(GamePlay.contains(6, 3, result));
        assertTrue(GamePlay.contains(6, 5, result));
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
        assertTrue(GamePlay.contains(5, 0, result));
        assertTrue(GamePlay.contains(6, 1, result));
        assertTrue(GamePlay.contains(2, 7, result));
    }

    @Test
    public void BishopGamePlayPosition() {
        Bishop bishop = new Bishop("White");
        List<List<int[]>> result = bishop.findMoves(4, 4);
        assertEquals(3, result.get(0).size());
        assertEquals(4, result.get(1).size());
        assertEquals(3, result.get(2).size());
        assertEquals(3, result.get(3).size());
        assertTrue(GamePlay.contains(1, 7, result));
        assertTrue(GamePlay.contains(0, 0, result));
        assertTrue(GamePlay.contains(7, 1, result));
        assertTrue(GamePlay.contains(7, 7, result));
    }

    @Test
    public void BishopColor() {
        Bishop bishop = new Bishop("White");
        assertEquals("White", bishop.getColor());
    }

    @Test
    public void QueenDefaultPosition() {
        Queen queen = new Queen("Black");
        List<List<int[]>> result = queen.findMoves(7, 3);
        assertEquals(7, result.get(0).size());
        assertEquals(0, result.get(1).size());
        assertEquals(4, result.get(2).size());
        assertEquals(3, result.get(3).size());
        assertEquals(4, result.get(4).size());
        assertEquals(3, result.get(5).size());
        assertEquals(0, result.get(6).size());
        assertEquals(0, result.get(7).size());
        assertTrue(GamePlay.contains(0, 3, result));
        assertTrue(GamePlay.contains(7, 7, result));
        assertTrue(GamePlay.contains(7, 0, result));
        assertTrue(GamePlay.contains(3, 7, result));
        assertTrue(GamePlay.contains(4, 0, result));
    }

    @Test
    public void QueenGamePlayPosition() {
        Queen queen = new Queen("White");
        List<List<int[]>> result = queen.findMoves(4, 4);
        assertEquals(4, result.get(0).size());
        assertEquals(3, result.get(1).size());
        assertEquals(3, result.get(2).size());
        assertEquals(4, result.get(3).size());
        assertEquals(3, result.get(4).size());
        assertEquals(4, result.get(5).size());
        assertEquals(3, result.get(6).size());
        assertEquals(3, result.get(7).size());
        assertTrue(GamePlay.contains(0, 4, result));
        assertTrue(GamePlay.contains(7, 4, result));
        assertTrue(GamePlay.contains(4, 0, result));
        assertTrue(GamePlay.contains(4, 7, result));
        assertTrue(GamePlay.contains(1, 7, result));
        assertTrue(GamePlay.contains(0, 0, result));
        assertTrue(GamePlay.contains(7, 1, result));
        assertTrue(GamePlay.contains(7, 7, result));
    }

    @Test
    public void QueenColor() {
        Queen queen = new Queen("White");
        assertEquals("White", queen.getColor());
    }

    @Test
    public void KingDefaultPosition() {
        King king = new King("Black");
        List<List<int[]>> result = king.findMoves(7, 4);
        assertEquals(5, result.get(0).size());
        assertTrue(GamePlay.contains(7, 3, result));
        assertTrue(GamePlay.contains(7, 5, result));
        assertTrue(GamePlay.contains(6, 4, result));
        assertTrue(GamePlay.contains(6, 5, result));
        assertTrue(GamePlay.contains(6, 4, result));
    }

    @Test
    public void KingGamePlayPosition() {
        King king = new King("White");
        List<List<int[]>> result = king.findMoves(4, 4);
        assertEquals(8, result.get(0).size());
        assertTrue(GamePlay.contains(4, 3, result));
        assertTrue(GamePlay.contains(4, 5, result));
        assertTrue(GamePlay.contains(5, 4, result));
        assertTrue(GamePlay.contains(3, 4, result));
        assertTrue(GamePlay.contains(3, 3, result));
        assertTrue(GamePlay.contains(3, 5, result));
        assertTrue(GamePlay.contains(5, 3, result));
        assertTrue(GamePlay.contains(5, 5, result));
    }

    @Test
    public void KingColor() {
        King king = new King("White");
        assertEquals("White", king.getColor());
    }

    @Test
    public void EmptyTest() {
        Empty empty = new Empty();
        assertNull(empty.getColor());
        assertNull(empty.findMoves(4, 4));
    }

    @Test
    public void RemoveFriendsTest() {
        Grid grid = new Grid();
        List<List<int[]>> result = GamePlay.removeFriends(7, 4, grid.grid[7][4].findMoves(7, 4), grid);
        assertEquals(0, result.get(0).size());
    }

    @Test
    public void LimitEnemyTest() {
        Grid grid = new Grid();
        List<List<int[]>> result = GamePlay.limitTillEnemy(7, 0, grid.grid[7][0].findMoves(7, 0), grid);
        assertEquals(0, result.get(0).size());
    }

    @Test
    public void FilterPawnMovesTestOne() {
        Grid grid = new Grid();
        List<List<int[]>> result = GamePlay.filterPawnMoves(6, 0, grid.grid[6][0].findMoves(6, 0), grid);
        assertEquals(2, result.get(0).size());
        assertEquals(0, result.get(1).size());
        assertTrue(GamePlay.contains(5, 0, result));
        assertTrue(GamePlay.contains(4, 0, result));
    }


    @Test
    public void FilterPawnMovesTestTwo() {
        Grid grid = new Grid();
        Pawn pawn = new Pawn("Black");
        pawn.firstMoveDone = true;
        List<List<int[]>> result = pawn.findMoves(6, 4);
        List<List<int[]>> finalResult = GamePlay.filterPawnMoves(6, 4, pawn.findMoves(6, 4), grid);
        assertEquals(1, finalResult.get(0).size());
        assertEquals(0, finalResult.get(1).size());
        assertTrue(GamePlay.contains(5, 4, finalResult));
    }


    @Test
    public void SwapTest() {
        Grid grid = new Grid();
        grid.swap(6, 0, 5, 0);
        assertEquals("P", grid.grid[5][0].toString());
        assertEquals("_", grid.grid[6][0].toString());
    }

    @Test
    public void StringTests() {
        Pawn pawn = new Pawn("Black");
        Rook rook = new Rook("Black");
        Bishop bishop = new Bishop("Black");
        Queen queen = new Queen("Black");
        King king = new King("Black");
        Knight knight = new Knight("Black");
        assertEquals("P", pawn.toString());
        assertEquals("R", rook.toString());
        assertEquals("B", bishop.toString());
        assertEquals("Q", queen.toString());
        assertEquals("K", king.toString());
        assertEquals("N", knight.toString());
    }
}
