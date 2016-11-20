// STAR-CCM+ macro: repo_4.java
// Written by STAR-CCM+ 10.06.009
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.flow.*;

public class repo_4 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    ForceReport forceReport_2 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 1"));

    forceReport_2.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_3 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 2"));

    forceReport_3.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_4 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 3"));

    forceReport_4.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_5 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 4"));

    forceReport_5.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_6 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 5"));

    forceReport_6.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_7 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 6"));

    forceReport_7.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_8 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 7"));

    forceReport_8.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_9 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 8"));

    forceReport_9.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_10 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 9"));

    forceReport_10.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_11 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 10"));

    forceReport_11.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_12 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 11"));

    forceReport_12.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_13 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 12"));

    forceReport_13.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_42 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    forceReport_42.setPresentationName("Copy of Force 14");

    ForceReport forceReport_15 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 14"));

    forceReport_42.copyProperties(forceReport_15);

    ForceReport forceReport_14 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 13"));

    forceReport_14.getDirection().setComponents(0.0, 0.0, 1.0);

    forceReport_15.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_16 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 15"));

    forceReport_16.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_17 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 16"));

    forceReport_17.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_18 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 17"));

    forceReport_18.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_19 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 18"));

    forceReport_19.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_20 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 19"));

    forceReport_20.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_21 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 20"));

    forceReport_21.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_22 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 21"));

    forceReport_22.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_23 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 22"));

    forceReport_23.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_24 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 23"));

    forceReport_24.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_25 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 24"));

    forceReport_25.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_26 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 25"));

    forceReport_26.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_27 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 26"));

    forceReport_27.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_28 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 27"));

    forceReport_28.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_29 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 28"));

    forceReport_29.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_30 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 29"));

    forceReport_30.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_31 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 30"));

    forceReport_31.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_32 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 31"));

    forceReport_32.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_33 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 32"));

    forceReport_33.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_34 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 33"));

    forceReport_34.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_43 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    forceReport_43.setPresentationName("Copy of Force 34");

    ForceReport forceReport_35 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 34"));

    forceReport_43.copyProperties(forceReport_35);

    forceReport_35.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_1 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift"));

    forceReport_1.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_39 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift FW"));

    forceReport_39.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_40 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift RW"));

    forceReport_40.getDirection().setComponents(0.0, 0.0, 1.0);

    ForceReport forceReport_41 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift UB"));

    forceReport_41.getDirection().setComponents(0.0, 0.0, 1.0);

    simulation_0.getReportManager().removeObjects(forceReport_42, forceReport_43);

    ForceReport forceReport_0 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag"));

    forceReport_0.getDirection().setComponents(1.0, 0.0, 0.0);

    ForceReport forceReport_36 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag FW"));

    forceReport_36.getDirection().setComponents(1.0, 0.0, 0.0);

    ForceReport forceReport_37 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag RW"));

    forceReport_37.getDirection().setComponents(1.0, 0.0, 0.0);

    ForceReport forceReport_38 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag UB"));

    forceReport_38.getDirection().setComponents(1.0, 0.0, 0.0);
  }
}
