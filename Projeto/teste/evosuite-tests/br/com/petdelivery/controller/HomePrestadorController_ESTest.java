/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 25 17:56:17 GMT 2017
 */

package br.com.petdelivery.controller;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.MockitoExtension.*;
import br.com.petdelivery.controller.HomePrestadorController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class HomePrestadorController_ESTest extends HomePrestadorController_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      HomePrestadorController homePrestadorController0 = new HomePrestadorController();
      String string0 = homePrestadorController0.unidadesPetshop((HttpSession) null);
      assertEquals("posLogin/prestador/petshop/minhasUnidades", string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      HomePrestadorController homePrestadorController0 = new HomePrestadorController();
      String string0 = homePrestadorController0.servicoAutonomo((HttpSession) null);
      assertEquals("posLogin/prestador/autonomo/meusServicos", string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      HomePrestadorController homePrestadorController0 = new HomePrestadorController();
      String string0 = homePrestadorController0.indexPetshop((HttpServletRequest) null, (HttpSession) null);
      assertEquals("posLogin/prestador/petshop/home", string0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      HomePrestadorController homePrestadorController0 = new HomePrestadorController();
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      HttpServletRequestWrapper httpServletRequestWrapper0 = new HttpServletRequestWrapper(httpServletRequest0);
      String string0 = homePrestadorController0.indexAutonomo(httpServletRequestWrapper0);
      assertEquals("posLogin/prestador/autonomo/home", string0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      HomePrestadorController homePrestadorController0 = new HomePrestadorController();
      String string0 = homePrestadorController0.configuraContaPetshop((HttpSession) null);
      assertEquals("posLogin/prestador/petshop/configConta", string0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      HomePrestadorController homePrestadorController0 = new HomePrestadorController();
      String string0 = homePrestadorController0.configuraContaAutonomo((HttpSession) null);
      assertEquals("posLogin/prestador/autonomo/configConta", string0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      HomePrestadorController homePrestadorController0 = new HomePrestadorController();
      String string0 = homePrestadorController0.cadastroUnidadePetshop((HttpSession) null);
      assertEquals("posLogin/prestador/petshop/cadastraUnidade", string0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      HomePrestadorController homePrestadorController0 = new HomePrestadorController();
      String string0 = homePrestadorController0.cadastroServicoPetshop((HttpSession) null);
      assertEquals("posLogin/prestador/petshop/cadastraServicoPetshop", string0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      HomePrestadorController homePrestadorController0 = new HomePrestadorController();
      String string0 = homePrestadorController0.cadastroServico((HttpSession) null);
      assertEquals("posLogin/prestador/petshop/meusServicos", string0);
  }

  @Test(timeout = 4000)
  public void test9()  throws Throwable  {
      HomePrestadorController homePrestadorController0 = new HomePrestadorController();
      String string0 = homePrestadorController0.cadastraServicoAutonomo((HttpSession) null);
      assertEquals("posLogin/prestador/autonomo/cadastraServicoAutonomo", string0);
  }
}
