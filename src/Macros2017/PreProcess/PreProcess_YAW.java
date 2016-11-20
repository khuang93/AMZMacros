// STAR-CCM+ macro: PreProcess_FW2Elements.java
// Written by STAR-CCM+ 9.02.007
package macro;

import java.util.*;

import star.common.*;

public class PreProcess_YAW extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {
      
  
      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PreProcess\\10.06.009\\YAW\\Teil_1.java"))).play();
      

    new StarScript(getActiveSimulation(),

                   new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PreProcess\\10.06.009\\YAW\\Teil_2.java"))).play();
      
      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PreProcess\\10.06.009\\YAW\\Teil_3.java"))).play();
     
      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PreProcess\\10.06.009\\YAW\\Teil_4.java"))).play();
      
      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PreProcess\\10.06.009\\YAW\\Teil_5.java"))).play();
  }
}
