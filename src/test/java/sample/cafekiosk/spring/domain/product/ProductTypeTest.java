package sample.cafekiosk.spring.domain.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class ProductTypeTest {

    @Test
    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    void containsStockType() {
        // given
        ProductType givenType = ProductType.HANDMADE;

        // when
        boolean isStockType = ProductType.containsStockType(givenType);

        // then
        assertThat(isStockType).isFalse();
    }

    @Test
    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    void containsStockType2() {
        // given
        ProductType givenType1 = ProductType.BOTTLE;
        ProductType givenType2 = ProductType.BAKERY;

        // when
        boolean isStockType1 = ProductType.containsStockType(givenType1);
        boolean isStockType2 = ProductType.containsStockType(givenType2);

        // then
        assertThat(isStockType1).isTrue();
        assertThat(isStockType2).isTrue();
    }

    @Test
    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    void containsStockType3() {
        // given
        ProductType givenType0 = ProductType.HANDMADE;
        ProductType givenType1 = ProductType.BOTTLE;
        ProductType givenType2 = ProductType.BAKERY;

        // when
        boolean isStockType0 = ProductType.containsStockType(givenType0);
        boolean isStockType1 = ProductType.containsStockType(givenType1);
        boolean isStockType2 = ProductType.containsStockType(givenType2);

        // then
        assertThat(isStockType0).isFalse();
        assertThat(isStockType1).isTrue();
        assertThat(isStockType2).isTrue();
    }

    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    @CsvSource({"HANDMADE,false", "BOTTLE,true", "BAKERY,true"})
    @ParameterizedTest
    void containsStockType4(ProductType givenType, boolean expected) {
        // when
        boolean result = ProductType.containsStockType(givenType);

        // then
        assertThat(result).isEqualTo(expected);

    }

    private static Stream<Arguments> provideProductTypesForCheckingStockType() {
        return Stream.of(
                Arguments.of(ProductType.HANDMADE, false),
                Arguments.of(ProductType.BOTTLE, true),
                Arguments.of(ProductType.BAKERY, true)
        );
    }

    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다. - @MethodSource 활용")
    @MethodSource("provideProductTypesForCheckingStockType")
    @ParameterizedTest
    void containsStockType5(ProductType productType, boolean expected) {
        // when
        boolean result = ProductType.containsStockType(productType);

        // then
        assertThat(result).isEqualTo(expected);
    }
}