import pile.PileSChainee;
import physique.*;

public class Sandbox {

    public static void main(String[] args) {
        // TestPosition();

        TestPile();
    }

    public static void TestPosition(){
        Position m_pos = new Position(1, 2);
        Position m_pos2 = new Position(m_pos);
        m_pos2.additionnerPos(m_pos);
        System.out.println(m_pos);
        System.out.println(m_pos2);

    }

    public static void TestPile(){
        PileSChainee pile = new PileSChainee();

        pile.empiler(2);
        pile.empiler(3);
        pile.empiler(4);

        System.out.println(pile.depiler());
    }
}
