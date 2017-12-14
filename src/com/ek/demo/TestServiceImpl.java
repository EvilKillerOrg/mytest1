package com.ek.demo;

public class TestServiceImpl implements ITestService{

  @Override
  public TestVO getVO(ITestOne testOne, ITestTwo testTwo) {
    testOne.showHA1("n", 1);
    
    testTwo.showVO2(2);
    
    
    
    return null;
  }

}
