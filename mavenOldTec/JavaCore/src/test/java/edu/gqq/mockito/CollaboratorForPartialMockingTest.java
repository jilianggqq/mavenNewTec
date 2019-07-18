package edu.gqq.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CollaboratorForPartialMocking.class})
public class CollaboratorForPartialMockingTest {

    @Test
    public void testStatic() {
        // We must use mockStatic or spy. Must be a mocked object or static method.
        spy(CollaboratorForPartialMocking.class);
        when(CollaboratorForPartialMocking.staticMethod()).thenReturn("I am a static mock method.");

        String returnVal = CollaboratorForPartialMocking.staticMethod();

        //The mocking behavior is verified as follows:
        verifyStatic();
        CollaboratorForPartialMocking.staticMethod();

        assertEquals("I am a static mock method.", returnVal);
    }

    /**
     * In order to illustrate the partial mocking of these methods,
     * we need to instantiate the class and tell the PowerMockito API to spy it:
     */
    @Test
    public void testFinalMethod() {
        CollaboratorForPartialMocking mocking = new CollaboratorForPartialMocking();

        // if you don't spy that. mocking can not be directly used in when.
        CollaboratorForPartialMocking collaborator = spy(mocking);
        when(collaborator.finalMethod()).thenReturn("I am a final mock method.");
        String returnValue = collaborator.finalMethod();

        // A test verifies that calling the finalMethod method will return a value that matches the expectation:
        Mockito.verify(collaborator).finalMethod();

        assertEquals("I am a final mock method.", returnValue);
    }

    /**
     * The main difference is that we cannot directly invoke this method from the test case.
     * Basically, a private method is to be called by other ones from the same class.
     * In the CollaboratorForPartialMocking class, the privateMethod method is to be invoked by the privateMethodCaller method
     * and we will use the latter as a delegate.
     */
    @Test
    public void testPrivateMethod() throws Exception {
        CollaboratorForPartialMocking collaborator = new CollaboratorForPartialMocking();

        // if you don't spy that. mocking can not be directly used in when.
        CollaboratorForPartialMocking mock = spy(collaborator);

        // when(collaborator, "privateTestMethod").thenReturn("I am a private mock method.");

        // Object privateTestMethod = Whitebox.invokeMethod(mock, "privateTestMethod");
        // verifyPrivate(mock).invoke("privateMethod");
        // assertEquals("I am a private mock method. Welcome to the Java world.", returnValue);

        PowerMockito.doReturn("mock value").when(mock, "privateTestMethod");
        String val = mock.privateMethodCaller();
        Assert.assertEquals("mock value Welcome to the Java world.", val);
    }

    @Test
    public void testPrivateField() {
        CollaboratorForPartialMocking collaborator = spy(new CollaboratorForPartialMocking());
        Whitebox.setInternalState(collaborator, "_value", "gqq_testvalue");
        String pStr = collaborator.privateFieldCaller();
        Assert.assertEquals(pStr, "gqq_testvalue");
    }
}
