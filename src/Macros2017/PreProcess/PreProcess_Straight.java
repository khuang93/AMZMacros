// STAR-CCM+ macro: PreProcess_FW2Elements.java
// Written by STAR-CCM+ 9.02.007
package macro;

import java.util.*;

import star.common.*;

public class PreProcess_Straight extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {
      
  
      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2017\\Macro\\PreProcess\\10.06.009\\Straight\\importfan.java"))).play();
      

    new StarScript(getActiveSimulation(),

                   new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2017\\Macro\\PreProcess\\10.06.009\\Straight\\Preprocessing_1Teil_fluela_Bootcamp_2Elements_Straight.java"))).play();
      
      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2017\\Macro\\PreProcess\\10.06.009\\Straight\\Aktive_Kuehlung.java"))).play();
      
      
    new StarScript(getActiveSimulation(),

                   new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2017\\Macro\\PreProcess\\10.06.009\\Straight\\Preprocessing_2Teil_FW2Elements.java"))).play();

      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2017\\Macro\\PreProcess\\10.06.009\\Straight\\update_s.java"))).play();
      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2017\\Macro\\PreProcess\\10.06.009\\Straight\\repo.java"))).play();
      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2017\\Macro\\PreProcess\\10.06.009\\Straight\\repo_4.java"))).play();
      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2017\\Macro\\PreProcess\\10.06.009\\Straight\\repo5.java"))).play();
      
  }
}
