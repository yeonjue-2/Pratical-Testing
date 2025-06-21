package sample.cafekiosk.learning;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.junit.jupiter.api.*;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GuavaLearningTest {

    @Test
    @DisplayName("주어진 개수만큼 List를 파티셔닝한다.")
    void partitionTest1() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);

        // when
        List<List<Integer>> partition = Lists.partition(integers, 3);

        // then
        assertThat(partition).hasSize(2)
                .isEqualTo(List.of(
                        List.of(1,2,3), List.of(4,5,6)
                ));
    }

    @Test
    @DisplayName("주어진 개수만큼 List를 파티셔닝한다.")
    void partitionTest2() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);

        // when
        List<List<Integer>> partition = Lists.partition(integers, 4);

        // then
        assertThat(partition).hasSize(2)
                .isEqualTo(List.of(
                        List.of(1,2,3,4), List.of(5,6)
                ));
    }

    @Test
    void multimapTest1() {
        // given
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("커피", "아메리카노");
        multimap.put("커피", "카페라떼");
        multimap.put("커피", "카푸치노");
        multimap.put("베이커리", "소금빵");

        // when
        Collection<String> strings = multimap.get("커피");

        // then
        assertThat(strings).hasSize(3)
                .isEqualTo(List.of("아메리카노", "카페라떼", "카푸치노"));
    }

    @TestFactory
    Collection<DynamicTest> multimapTest2() {
        // given
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("커피", "아메리카노");
        multimap.put("커피", "카페라떼");
        multimap.put("커피", "카푸치노");
        multimap.put("베이커리", "소금빵");

        return List.of(
                DynamicTest.dynamicTest("1개 value 삭제", () -> {
                    // when
                    multimap.remove("커피", "카푸치노");

                    // then
                    Collection<String> results = multimap.get("커피");
                    assertThat(results).hasSize(2)
                            .isEqualTo(List.of("아메리카노", "카페라떼"));
                }),
                DynamicTest.dynamicTest("1개 key 삭제", () -> {
                    // when
                    multimap.removeAll("커피");

                    // then
                    Collection<String> results = multimap.get("커피");
                    assertThat(results).isEmpty();
                })
        );
    }
}
