/*
 * This file was automatically generated by EvoSuite
 * Thu Oct 26 21:36:53 GMT 2017
 */

package br.com.petdelivery.jdbc.modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.petdelivery.jdbc.modelo.Servico_Petshop;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Servico_Petshop_ESTest extends Servico_Petshop_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      servico_Petshop0.setPreco(2591.1894308560345);
      double double0 = servico_Petshop0.getPreco();
      assertEquals(2591.1894308560345, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = new Long((-3806L));
      servico_Petshop0.setId_unidade(long0);
      Long long1 = servico_Petshop0.getId_unidade();
      assertEquals((-3806L), (long)long1);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = new Long(0L);
      servico_Petshop0.setId_unidade(long0);
      Long long1 = servico_Petshop0.getId_unidade();
      assertEquals(0L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = new Long(4453L);
      servico_Petshop0.setId_unidade(long0);
      Long long1 = servico_Petshop0.getId_unidade();
      assertEquals(4453L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = new Long(1254L);
      servico_Petshop0.setId_unidade(long0);
      Long long1 = servico_Petshop0.getId_unidade();
      assertEquals(1254L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = new Long((-1503L));
      servico_Petshop0.setId_servicoPetshop(long0);
      Long long1 = servico_Petshop0.getId_servicoPetshop();
      assertEquals((-1503L), (long)long1);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = new Long(0L);
      servico_Petshop0.setId_servicoPetshop(long0);
      Long long1 = servico_Petshop0.getId_servicoPetshop();
      assertEquals(0L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = new Long(1292L);
      servico_Petshop0.setId_servicoPetshop(long0);
      Long long1 = servico_Petshop0.getId_servicoPetshop();
      assertEquals(1292L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = new Long(648L);
      servico_Petshop0.setId_servicoPetshop(long0);
      Long long1 = servico_Petshop0.getId_servicoPetshop();
      assertEquals(648L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = new Long(2889L);
      servico_Petshop0.setId_servico(long0);
      Long long1 = servico_Petshop0.getId_servico();
      assertEquals(2889L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = new Long((-1L));
      servico_Petshop0.setId_servico(long0);
      Long long1 = servico_Petshop0.getId_servico();
      assertEquals((-1L), (long)long1);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Boolean boolean0 = new Boolean(true);
      servico_Petshop0.setDelivery(boolean0);
      Boolean boolean1 = servico_Petshop0.getDelivery();
      assertTrue(boolean1);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      servico_Petshop0.setCondicoes("VBi1VN");
      String string0 = servico_Petshop0.getCondicoes();
      assertEquals("VBi1VN", string0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      servico_Petshop0.setCondicoes("");
      String string0 = servico_Petshop0.getCondicoes();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = new Long(0L);
      servico_Petshop0.setCnpj(long0);
      Long long1 = servico_Petshop0.getCnpj();
      assertEquals(0L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = new Long(1L);
      servico_Petshop0.setCnpj(long0);
      Long long1 = servico_Petshop0.getCnpj();
      assertEquals(1L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = new Long((-1L));
      servico_Petshop0.setCnpj(long0);
      Long long1 = servico_Petshop0.getCnpj();
      assertEquals((-1L), (long)long1);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      String string0 = servico_Petshop0.getCondicoes();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = servico_Petshop0.getId_servico();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = servico_Petshop0.getCnpj();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = servico_Petshop0.getId_unidade();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = new Long(0L);
      servico_Petshop0.setId_servico(long0);
      Long long1 = servico_Petshop0.getId_servico();
      assertEquals(0L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Long long0 = servico_Petshop0.getId_servicoPetshop();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      double double0 = servico_Petshop0.getPreco();
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Boolean boolean0 = servico_Petshop0.getDelivery();
      assertNull(boolean0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      servico_Petshop0.setPreco((-1649.59896881));
      double double0 = servico_Petshop0.getPreco();
      assertEquals((-1649.59896881), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Servico_Petshop servico_Petshop0 = new Servico_Petshop();
      Boolean boolean0 = new Boolean(";l1W6*$.K?");
      servico_Petshop0.setDelivery(boolean0);
      Boolean boolean1 = servico_Petshop0.getDelivery();
      assertFalse(boolean1);
  }
}
