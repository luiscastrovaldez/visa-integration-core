package com.visa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/visa/resources/applicationContext-hibernate.xml" })
@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class })
@TransactionConfiguration(defaultRollback = false)
public class VisaCoreTest extends
    AbstractTransactionalJUnit4SpringContextTests {

  @Test
  public void testApp() {
    assert (true);
  }

  /*@BeforeClass
  public static void inicializacionClass() {
    System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
        "org.apache.naming.java.javaURLContextFactory");
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() {

  }*/

}