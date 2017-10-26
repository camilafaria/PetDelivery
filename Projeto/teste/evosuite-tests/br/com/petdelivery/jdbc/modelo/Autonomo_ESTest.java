/*
 * This file was automatically generated by EvoSuite
 * Thu Oct 26 21:29:21 GMT 2017
 */

package br.com.petdelivery.jdbc.modelo;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.petdelivery.jdbc.modelo.Autonomo;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Autonomo_ESTest extends Autonomo_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      Long long0 = new Long(0L);
      autonomo0.setTelefone(long0);
      Long long1 = autonomo0.getTelefone();
      assertEquals(0L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      Long long0 = new Long((-1489L));
      autonomo0.setTelefone(long0);
      Long long1 = autonomo0.getTelefone();
      assertEquals((-1489L), (long)long1);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setRua("");
      String string0 = autonomo0.getRua();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setNumero(440);
      int int0 = autonomo0.getNumero();
      assertEquals(440, int0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setNumero((-1));
      int int0 = autonomo0.getNumero();
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setNome("-EHpQUF/qmXx5+D![;");
      String string0 = autonomo0.getNome();
      assertEquals("-EHpQUF/qmXx5+D![;", string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setNome("");
      String string0 = autonomo0.getNome();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      byte[] byteArray0 = new byte[2];
      autonomo0.setFoto(byteArray0);
      byte[] byteArray1 = autonomo0.getFoto();
      assertArrayEquals(new byte[] {(byte)0, (byte)0}, byteArray1);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      byte[] byteArray0 = new byte[0];
      autonomo0.setFoto(byteArray0);
      byte[] byteArray1 = autonomo0.getFoto();
      assertArrayEquals(new byte[] {}, byteArray1);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setExperiencia("-EHpQUF/qmXx5+D![;");
      String string0 = autonomo0.getExperiencia();
      assertEquals("-EHpQUF/qmXx5+D![;", string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setExperiencia("");
      String string0 = autonomo0.getExperiencia();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setDdd(1358);
      int int0 = autonomo0.getDdd();
      assertEquals(1358, int0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setDdd((-3126));
      int int0 = autonomo0.getDdd();
      assertEquals((-3126), int0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      Long long0 = new Long(0L);
      autonomo0.setCpf(long0);
      Long long1 = autonomo0.getCpf();
      assertEquals(0L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      Long long0 = new Long(71L);
      autonomo0.setCpf(long0);
      Long long1 = autonomo0.getCpf();
      assertEquals(71L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      Long long0 = new Long((-1L));
      autonomo0.setCpf(long0);
      Long long1 = autonomo0.getCpf();
      assertEquals((-1L), (long)long1);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setComplemento("osK");
      String string0 = autonomo0.getComplemento();
      assertEquals("osK", string0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setCep("8GsO,I");
      String string0 = autonomo0.getCep();
      assertEquals("8GsO,I", string0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setCep("");
      String string0 = autonomo0.getCep();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setBairro("");
      String string0 = autonomo0.getBairro();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      String string0 = autonomo0.getRua();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      byte[] byteArray0 = autonomo0.getFoto();
      assertNull(byteArray0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setRua("(|~-U0(quOn");
      String string0 = autonomo0.getRua();
      assertEquals("(|~-U0(quOn", string0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      String string0 = autonomo0.getBairro();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      Long long0 = autonomo0.getCpf();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setBairro("osK");
      String string0 = autonomo0.getBairro();
      assertEquals("osK", string0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      String string0 = autonomo0.getNome();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      Long long0 = new Long(499L);
      autonomo0.setTelefone(long0);
      Long long1 = autonomo0.getTelefone();
      assertEquals(499L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      Long long0 = autonomo0.getTelefone();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      autonomo0.setComplemento("");
      String string0 = autonomo0.getComplemento();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      String string0 = autonomo0.getExperiencia();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      String string0 = autonomo0.getCep();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      String string0 = autonomo0.getComplemento();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      int int0 = autonomo0.getNumero();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Autonomo autonomo0 = new Autonomo();
      int int0 = autonomo0.getDdd();
      assertEquals(0, int0);
  }
}
