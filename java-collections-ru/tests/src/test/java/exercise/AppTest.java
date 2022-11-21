package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        // given
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        // when:
        List<Integer> result1 = App.take(numbers1, 2);
        List<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 2));
        // then
        assertThat(result1).isEqualTo(expected1);


        // given
        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 2));
        // when:
        List<Integer> result2 = App.take(numbers2, 5);
        List<Integer> expected2 = new ArrayList<>(Arrays.asList(1, 2));
        // then
        assertThat(result2).isEqualTo(expected2);


        // given
        List<Integer> numbers3 = new ArrayList<>();
        // when:
        List<Integer> result3 = App.take(numbers3, 5);
        // then
        assertThat(result3).hasSize(0);

        // given
        List<Integer> numbers4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        // when:
        List<Integer> result4 = App.take(numbers4, 0);
        // then
        assertThat(result4).hasSize(0);
        // END
    }
}
