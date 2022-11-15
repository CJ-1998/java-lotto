package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatingLottoTest {
    CalculatingLotto calculatingLotto = new CalculatingLotto();
    List<Integer> winningLotto=List.of(1, 2, 3, 4, 5, 6);
    List<List<Integer>> allLotto=new ArrayList<>();

    @BeforeEach
    void setUp() {
        allLotto.add(List.of(1, 2, 3, 4, 5, 6));
        allLotto.add(List.of(1, 2, 3, 4, 5, 7));
        allLotto.add(List.of(1, 2, 3, 4, 5, 8));
        allLotto.add(List.of(1, 2, 3, 4, 8, 9));
        allLotto.add(List.of(1, 2, 3, 8, 9, 10));
        allLotto.add(List.of(1, 2, 8, 9, 10, 11));
        allLotto.add(List.of(8, 9, 10, 11, 12, 13));
    }

    @Test
    void findSameNumberTest() {
        assertThat(calculatingLotto.findSameNumber(6,6)).isEqualTo(1);

        assertThat(calculatingLotto.findSameNumber(5,6)).isEqualTo(0);
    }

    @Test
    void checkBonusTest() {
        assertThat(calculatingLotto.checkBonus(6, List.of(1, 2, 3, 4, 5, 6))).isEqualTo(true);

        assertThat(calculatingLotto.checkBonus(6, List.of(1, 2, 3, 4, 5, 8))).isEqualTo(false);
    }

    @Test
    void getLottoRankTest() {
        assertThat(calculatingLotto.getLottoRank(6, false)).isEqualTo(1);
        assertThat(calculatingLotto.getLottoRank(6, true)).isEqualTo(1);
        assertThat(calculatingLotto.getLottoRank(5, true)).isEqualTo(2);
        assertThat(calculatingLotto.getLottoRank(5, false)).isEqualTo(3);
        assertThat(calculatingLotto.getLottoRank(4, true)).isEqualTo(4);
        assertThat(calculatingLotto.getLottoRank(4, false)).isEqualTo(4);
        assertThat(calculatingLotto.getLottoRank(3, true)).isEqualTo(5);
        assertThat(calculatingLotto.getLottoRank(3, false)).isEqualTo(5);
        assertThat(calculatingLotto.getLottoRank(2, true)).isEqualTo(0);
        assertThat(calculatingLotto.getLottoRank(1, false)).isEqualTo(0);
    }

    @Test
    void calculateLottoRankTest() {
        assertThat(calculatingLotto.calculateLottoRank(winningLotto, 7, allLotto.get(0))).isEqualTo(1);
        assertThat(calculatingLotto.calculateLottoRank(winningLotto, 7, allLotto.get(1))).isEqualTo(2);
        assertThat(calculatingLotto.calculateLottoRank(winningLotto, 7, allLotto.get(2))).isEqualTo(3);
        assertThat(calculatingLotto.calculateLottoRank(winningLotto, 7, allLotto.get(3))).isEqualTo(4);
        assertThat(calculatingLotto.calculateLottoRank(winningLotto, 7, allLotto.get(4))).isEqualTo(5);
        assertThat(calculatingLotto.calculateLottoRank(winningLotto, 7, allLotto.get(5))).isEqualTo(0);
        assertThat(calculatingLotto.calculateLottoRank(winningLotto, 7, allLotto.get(6))).isEqualTo(0);
    }

    @Test
    void calculateAllLottoTest() {
        assertThat(calculatingLotto.calculateAllLotto(winningLotto, 7, allLotto)).isEqualTo(List.of(1,2,3,4,5,0,0));
    }
}