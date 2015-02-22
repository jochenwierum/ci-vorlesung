package de.hbrs.se.learning.operations;

import de.hbrs.se.learning.collections.ArrayBackedStack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
abstract class AbstractOperationTest {

    @Mock
    protected ArrayBackedStack<Double> stack;

    protected void testOperation(int size, double lhs, double rhs, double result) {
        Mockito.when(stack.size()).thenReturn(size);
        Mockito.when(stack.pop()).thenReturn(lhs, rhs);

        createOperationObject().execute(stack);

        Mockito.verify(stack).push(result);
    }

    @Test(expected = IllegalStateException.class)
    public void emptyStackThrowException1() {
        Mockito.when(stack.size()).thenReturn(1);
        createOperationObject().execute(stack);
    }

    @Test(expected = IllegalStateException.class)
    public void emptyStackThrowException2() {
        Mockito.when(stack.size()).thenReturn(0);
        createOperationObject().execute(stack);
    }

    protected abstract RpnOperation createOperationObject();

}
