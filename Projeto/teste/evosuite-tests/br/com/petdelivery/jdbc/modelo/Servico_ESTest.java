/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 25 18:28:13 GMT 2017
 */

package br.com.petdelivery.jdbc.modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.petdelivery.jdbc.modelo.Servico;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Servico_ESTest extends Servico_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Servico servico0 = new Servico();
      servico0.setNome((String) null);
      assertNull(servico0.getNome());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Servico servico0 = new Servico();
      servico0.setId_servico((Long) null);
      assertNull(servico0.getNome());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Servico servico0 = new Servico();
      String string0 = servico0.getNome();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Servico servico0 = new Servico();
      Long long0 = servico0.getId_servico();
      assertNull(long0);
  }
}