/*
 * This file was automatically generated by EvoSuite
 * Thu Oct 26 21:33:48 GMT 2017
 */

package br.com.petdelivery.jdbc.modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.petdelivery.jdbc.modelo.Raca_Animal;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Raca_Animal_ESTest extends Raca_Animal_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Raca_Animal raca_Animal0 = new Raca_Animal();
      raca_Animal0.setNome("");
      String string0 = raca_Animal0.getNome();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Raca_Animal raca_Animal0 = new Raca_Animal();
      Long long0 = new Long(0L);
      raca_Animal0.setId_tipo(long0);
      Long long1 = raca_Animal0.getId_tipo();
      assertEquals(0L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Raca_Animal raca_Animal0 = new Raca_Animal();
      Long long0 = new Long(3377L);
      raca_Animal0.setId_tipo(long0);
      Long long1 = raca_Animal0.getId_tipo();
      assertEquals(3377L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Raca_Animal raca_Animal0 = new Raca_Animal();
      Long long0 = new Long(0L);
      raca_Animal0.setId_raca(long0);
      Long long1 = raca_Animal0.getId_raca();
      assertEquals(0L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Raca_Animal raca_Animal0 = new Raca_Animal();
      Long long0 = new Long((-1551L));
      raca_Animal0.setId_raca(long0);
      Long long1 = raca_Animal0.getId_raca();
      assertEquals((-1551L), (long)long1);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Raca_Animal raca_Animal0 = new Raca_Animal();
      Long long0 = new Long(3377L);
      raca_Animal0.setId_raca(long0);
      Long long1 = raca_Animal0.getId_raca();
      assertEquals(3377L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Raca_Animal raca_Animal0 = new Raca_Animal();
      Long long0 = raca_Animal0.getId_raca();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Raca_Animal raca_Animal0 = new Raca_Animal();
      String string0 = raca_Animal0.getNome();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Raca_Animal raca_Animal0 = new Raca_Animal();
      Long long0 = new Long((-1585L));
      raca_Animal0.setId_tipo(long0);
      Long long1 = raca_Animal0.getId_tipo();
      assertEquals((-1585L), (long)long1);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Raca_Animal raca_Animal0 = new Raca_Animal();
      raca_Animal0.setNome("f'Ftp7");
      String string0 = raca_Animal0.getNome();
      assertEquals("f'Ftp7", string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Raca_Animal raca_Animal0 = new Raca_Animal();
      Long long0 = raca_Animal0.getId_tipo();
      assertNull(long0);
  }
}
