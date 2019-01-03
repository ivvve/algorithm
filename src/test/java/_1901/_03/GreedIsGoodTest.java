package _1901._03;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class GreedIsGoodTest {
    @Test
    public void howManyNumberInArray_메서드_테스트() {
        assertThat(GreedIsGood.howManyNumberInArray(new int[] {5, 3, 3, 4, 4}, 3), is(2));
        assertThat(GreedIsGood.howManyNumberInArray(new int[] {5, 3, 3, 4, 4}, 4), is(2));
        assertThat(GreedIsGood.howManyNumberInArray(new int[] {5, 3, 3, 4, 4}, 5), is(1));
    }

    @Test
    public void testExample() {
        assertEquals("Score for [5,1,3,4,1] must be 250:", 250, GreedIsGood.greedy(new int[]{5,1,3,4,1}));
        assertEquals("Score for [1,1,1,3,1] must be 1100:", 1100, GreedIsGood.greedy(new int[]{1,1,1,3,1}));
        assertEquals("Score for [2,4,4,5,4] must be 450:", 450, GreedIsGood.greedy(new int[]{2,4,4,5,4}));
    }
}