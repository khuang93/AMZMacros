// STAR-CCM+ macro: repo35.java
// Written by STAR-CCM+ 10.06.009
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;

public class repo35 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();
      
     	String Path = "Z:\\StarCCM\\Auto 2016\\Aero\\PostProcess\\";
      File dir = new File(Path+getSimulation().getPresentationName());
      dir.mkdir();

    ReportMonitor reportMonitor_0 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 35 Monitor"));

    simulation_0.getMonitorManager().export(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\PostProcess\\2016_HB_S2_02a_000_06e_FC4@02000\\LiftFC.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_0}));
  }
}
