// STAR-CCM+ macro: PreProcess_FW2Elements.java
// Written by STAR-CCM+ 9.02.007
package macro;

import java.util.*;

import star.common.*;

public class PreProcess_HB extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {
      
  
    new StarScript(getActiveSimulation(),
                     
                   new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PreProcess\\10.06.009\\HB\\heavybraking_1.java"))).play();
      
      new StarScript(getActiveSimulation(),
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PreProcess\\10.06.009\\HB\\importfan.java"))).play();
      

    new StarScript(getActiveSimulation(),

                   new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PreProcess\\10.06.009\\HB\\Preprocessing_1Teil_fluela_Bootcamp_2Elements_HB.java"))).play();

      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PreProcess\\10.06.009\\HB\\Aktive_Kuehlung.java"))).play();
      

    new StarScript(getActiveSimulation(),

                   new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PreProcess\\10.06.009\\HB\\Preprocessing_2Teil_FW2Elements.java"))).play();
     
    
    new StarScript(getActiveSimulation(),
                     
                   new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PreProcess\\10.06.009\\HB\\heavybraking_2.java"))).play();
      
      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PreProcess\\10.06.009\\HB\\update_HB.java"))).play();
      
      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PreProcess\\10.06.009\\HB\\repo.java"))).play();
   
      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PreProcess\\10.06.009\\HB\\FC.java"))).play();
      
      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PreProcess\\10.06.009\\HB\\plo.java"))).play();
      
      
  }
}
