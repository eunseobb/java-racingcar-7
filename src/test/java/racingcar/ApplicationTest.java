package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기타_문자표_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi.seob", "1")).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_공백_예외_테스트() {
        assertSimpleTest(
            () -> assertThatThrownBy(() -> runException(" ", "1")).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("a,b", "q")).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 개별_이름_공백_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,,seob", "1")).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1")).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
