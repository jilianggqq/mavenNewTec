package edu.gqq.mockito;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "edu.gqq.mockito.*")
public class CollaboratorWithFinalMethodsTest extends TestCase {
    public void testFinalMethod() throws Exception {
        CollaboratorWithFinalMethods mock = mock(CollaboratorWithFinalMethods.class);
        // could not use this way to mock final method.
        // when(mock.helloMethod()).thenReturn("Hello Baeldung!");

        // mock construction.

        // whenever the no-arg constructor of that class is invoked,
        // a mock instance should be returned rather than a real one
        whenNew(CollaboratorWithFinalMethods.class).withNoArguments().thenReturn(mock);

        //verify the behaviors of PowerMock
        CollaboratorWithFinalMethods collaborator = new CollaboratorWithFinalMethods();
        // verifyNew(CollaboratorWithFinalMethods.class).withNoArguments();

        when(collaborator.helloMethod()).thenReturn("Hello Baeldung!");

        String welcome = collaborator.helloMethod();

        // confirm that the helloMethod method has been called on the collaborator object,
        // Mockito.verify(collaborator).helloMethod();
        Assert.assertEquals("Hello Baeldung!", welcome);
    }
}
