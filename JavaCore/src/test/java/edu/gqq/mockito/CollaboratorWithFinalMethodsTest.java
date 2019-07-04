package edu.gqq.mockito;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

//@RunWith(PowerMockRunner.class)
public class CollaboratorWithFinalMethodsTest extends TestCase {
    public void testFinalMethod() throws Exception {
//        CollaboratorWithFinalMethods mock = mock(CollaboratorWithFinalMethods.class);
//        // could not use this way to mock final method.
////        when(mock.helloMethod()).thenReturn("Hello Baeldung!");
//
//        // mock construction.
//        whenNew(CollaboratorWithFinalMethods.class).withNoArguments().thenReturn(mock);
//
//        CollaboratorWithFinalMethods collaborator = new CollaboratorWithFinalMethods();
//        verifyNew(CollaboratorWithFinalMethods.class).withNoArguments();
//
//        when(collaborator.helloMethod()).thenReturn("Hello Baeldung!");
//
//        String welcome = collaborator.helloMethod();
//
//        Mockito.verify(collaborator).helloMethod();
//        Assert.assertEquals("Hello Baeldung!", welcome);
    }
}
