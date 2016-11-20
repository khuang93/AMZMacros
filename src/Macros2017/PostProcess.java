// STAR-CCM+ macro: PostProcess.java
// Written by STAR-CCM+ 9.02.007
package macro;

import java.util.*;

import star.common.*;

public class PostProcess extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {
/*
   new StarScript(getActiveSimulation(),

                   new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PostProcess\\Plots.java"))).play();

	new StarScript(getActiveSimulation(),

                 new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PostProcess\\Cp_Plot.java"))).play();

*/
		  
    new StarScript(getActiveSimulation(),

                  new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PostProcess\\TotPressCoeffx.java"))).play();


    new StarScript(getActiveSimulation(),

                   new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PostProcess\\TotPressCoeffy.java"))).play();
 
/*
     new StarScript(getActiveSimulation(),

                   new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PostProcess\\TotPressCoeffz.java"))).play();

 */
	new StarScript(getActiveSimulation(),

                   new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PostProcess\\Velocity_i_neu.java"))).play();


	new StarScript(getActiveSimulation(),

                  new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PostProcess\\Velocity_j_neu.java"))).play();
     

	new StarScript(getActiveSimulation(),

		new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PostProcess\\Surface_Pressure.java"))).play();
      
      new StarScript(getActiveSimulation(),
                     
                     new java.io.File(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Macro\\2016\\PostProcess\\Plots.java"))).play();

        
  }
}
