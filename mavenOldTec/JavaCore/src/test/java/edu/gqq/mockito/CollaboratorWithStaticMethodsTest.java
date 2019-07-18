package edu.gqq.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
// @PrepareForTest(fullyQualifiedNames = "edu.gqq.mockito.*")
@PrepareForTest({CollaboratorWithStaticMethods.class})
public class CollaboratorWithStaticMethodsTest {

    @Before
    public void setUp() {
    }

    @Test
    public void testStaticMethod() {
        mockStatic(CollaboratorWithStaticMethods.class);
        when(CollaboratorWithStaticMethods.firstMethod(Mockito.anyString())).thenReturn("test first by gqq");
        when(CollaboratorWithStaticMethods.secondMethod()).thenReturn("test second by gqq");

        // an exception may be set to be thrown when calling the thirdMethod method:
        // doThrow(new RuntimeException()).when(CollaboratorWithStaticMethods.class);
        // CollaboratorWithStaticMethods.thirdMethod();

        String firstWelcome = CollaboratorWithStaticMethods.firstMethod("Whoever");
        String secondWelcome = CollaboratorWithStaticMethods.firstMethod("Whatever");
        Assert.assertEquals("test first by gqq", firstWelcome);
        Assert.assertEquals("test first by gqq", secondWelcome);

        verifyStatic(Mockito.times(2));
        CollaboratorWithStaticMethods.firstMethod(Mockito.anyString());

        verifyStatic(Mockito.never());
        CollaboratorWithStaticMethods.secondMethod();
    }
}