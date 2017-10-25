/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 25 18:11:32 GMT 2017
 */

package br.com.petdelivery.jdbc.dao;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import br.com.petdelivery.jdbc.dao.PrestadorDAO;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class PrestadorDAO_ESTest extends PrestadorDAO_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      PrestadorDAO prestadorDAO0 = null;
      try {
        prestadorDAO0 = new PrestadorDAO();
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // java.sql.SQLException: No suitable driver found for jdbc:mysql://null/null?useSSL=null
         //
         verifyException("br.com.petdelivery.jdbc.ConnectionFactory", e);
      }
  }
}
