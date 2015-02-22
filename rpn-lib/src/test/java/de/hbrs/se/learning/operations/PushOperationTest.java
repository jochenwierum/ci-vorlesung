package de.hbrs.se.learning.operations;

import de.hbrs.se.learning.collections.ArrayBackedStack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PushOperationTest {

    @Mock
    ArrayBackedStack<Double> stack;

    @Test
    public void operationPushesFive() {
        RpnOperation operation = new PushOperation(5.0);

        operation.execute(stack);

        Mockito.verify(stack).push(5.0);
    }

    @Test
    public void operationPushesSeven() {
        RpnOperation operation = new PushOperation(7.0);

        operation.execute(stack);

        Mockito.verify(stack).push(7.0);
    }
}
