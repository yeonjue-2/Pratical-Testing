package sample.cafekiosk.spring.domain.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void containsStockType_true() {
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

}