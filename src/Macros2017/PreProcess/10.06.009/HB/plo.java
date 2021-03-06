// STAR-CCM+ macro: plo.java
// Written by STAR-CCM+ 10.06.009
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.flow.*;

public class plo extends StarMacro {

  public void execute() {
    execute0();
    execute1();
    execute2();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    ForceReport forceReport_0 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 35"));

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {forceReport_0}), true, "%1$s Plot");

    ReportMonitor reportMonitor_0 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 35 Monitor"));

    MonitorPlot monitorPlot_0 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_0}), "Force 35 Monitor Plot");

    monitorPlot_0.open();
      
      Region region_0 =
      simulation_0.getRegionManager().getRegion("Region");
      
      Boundary boundary_0 =
      region_0.getBoundaryManager().getBoundary("Outlet_final.Surface 2");
      
      boundary_0.setBoundaryType(MassFlowBoundary.class);
      
      MassFlowRateProfile massFlowRateProfile_0 =
      boundary_0.getValues().get(MassFlowRateProfile.class);
      
      massFlowRateProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.01685);
      
      Boundary boundary_1 =
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface");
      
      boundary_1.setBoundaryType(MassFlowBoundary.class);
      
      MassFlowRateProfile massFlowRateProfile_1 =
      boundary_1.getValues().get(MassFlowRateProfile.class);
      
      massFlowRateProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.05);
  }
    
    private void execute1() {
        
        Simulation simulation_0 =
        getActiveSimulation();
        
        ForceReport forceReport_0 =
        ((ForceReport) simulation_0.getReportManager().getReport("Drag"));
        
        Region region_0 =
        simulation_0.getRegionManager().getRegion("Region");
        
        Boundary boundary_0 =
        region_0.getBoundaryManager().getBoundary("Airduct.Surface");
        
        Boundary boundary_1 =
        region_0.getBoundaryManager().getBoundary("Body_Driver.Surface");
        
        Boundary boundary_2 =
        region_0.getBoundaryManager().getBoundary("Body_MC.Surface");
        
        Boundary boundary_3 =
        region_0.getBoundaryManager().getBoundary("Body_QJ.Surface");
        
        Boundary boundary_4 =
        region_0.getBoundaryManager().getBoundary("Drivetrain.Surface");
        
        Boundary boundary_5 =
        region_0.getBoundaryManager().getBoundary("Fan_final.Surface");
        
        Boundary boundary_6 =
        region_0.getBoundaryManager().getBoundary("Fan_final.Surface 2");
        
        Boundary boundary_7 =
        region_0.getBoundaryManager().getBoundary("Fan_final.Surface 3");
        
        Boundary boundary_8 =
        region_0.getBoundaryManager().getBoundary("Fan_final.Surface 4");
        
        Boundary boundary_9 =
        region_0.getBoundaryManager().getBoundary("Fan_final.Surface 5");
        
        Boundary boundary_10 =
        region_0.getBoundaryManager().getBoundary("Fan_final.Surface 6");
        
        Boundary boundary_11 =
        region_0.getBoundaryManager().getBoundary("FC6_inner.Surface");
        
        Boundary boundary_12 =
        region_0.getBoundaryManager().getBoundary("FW_Endplates.Surface");
        
        Boundary boundary_13 =
        region_0.getBoundaryManager().getBoundary("FW_Flap1.Surface");
        
        Boundary boundary_14 =
        region_0.getBoundaryManager().getBoundary("FW_Main.Surface");
        
        Boundary boundary_15 =
        region_0.getBoundaryManager().getBoundary("Headrest.Surface");
        
        Boundary boundary_16 =
        region_0.getBoundaryManager().getBoundary("MRH.Surface");
        
        Boundary boundary_17 =
        region_0.getBoundaryManager().getBoundary("Outlet_final.Surface");
        
        Boundary boundary_18 =
        region_0.getBoundaryManager().getBoundary("Outlet_final.Surface 2");
        
        Boundary boundary_19 =
        region_0.getBoundaryManager().getBoundary("Outlet_final.Surface 3");
        
        Boundary boundary_20 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface");
        
        Boundary boundary_21 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface 2");
        
        Boundary boundary_22 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface 3");
        
        Boundary boundary_23 =
        region_0.getBoundaryManager().getBoundary("RW_Endplates.Surface");
        
        Boundary boundary_24 =
        region_0.getBoundaryManager().getBoundary("RW_Flap1.Surface");
        
        Boundary boundary_25 =
        region_0.getBoundaryManager().getBoundary("RW_Flap2.Surface");
        
        Boundary boundary_26 =
        region_0.getBoundaryManager().getBoundary("RW_Main.Surface");
        
        Boundary boundary_27 =
        region_0.getBoundaryManager().getBoundary("RW_Support.Surface");
        
        Boundary boundary_28 =
        region_0.getBoundaryManager().getBoundary("Sidepod.Surface");
        
        Boundary boundary_29 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface");
        
        Boundary boundary_30 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 2");
        
        Boundary boundary_31 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 3");
        
        Boundary boundary_32 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 4");
        
        Boundary boundary_33 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 5");
        
        Boundary boundary_34 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 6");
        
        Boundary boundary_35 =
        region_0.getBoundaryManager().getBoundary("Susp_Brackets.Surface");
        
        Boundary boundary_36 =
        region_0.getBoundaryManager().getBoundary("Susp_Legs.Surface");
        
        Boundary boundary_37 =
        region_0.getBoundaryManager().getBoundary("Tire_Front.Surface");
        
        Boundary boundary_38 =
        region_0.getBoundaryManager().getBoundary("Tire_Rear.Surface");
        
        Boundary boundary_39 =
        region_0.getBoundaryManager().getBoundary("TSAL.Surface");
        
        Boundary boundary_40 =
        region_0.getBoundaryManager().getBoundary("Tubes.Surface");
        
        Boundary boundary_41 =
        region_0.getBoundaryManager().getBoundary("UB_Diffusor.Surface");
        
        Boundary boundary_42 =
        region_0.getBoundaryManager().getBoundary("UB_F1.Surface");
        
        Boundary boundary_43 =
        region_0.getBoundaryManager().getBoundary("UB_F2.Surface");
        
        Boundary boundary_44 =
        region_0.getBoundaryManager().getBoundary("UB_hor.Surface");
        
        Boundary boundary_45 =
        region_0.getBoundaryManager().getBoundary("UB_MC.Surface");
        
        Boundary boundary_46 =
        region_0.getBoundaryManager().getBoundary("UB_ver.Surface");
        
        Boundary boundary_47 =
        region_0.getBoundaryManager().getBoundary("Wheel_Front.Surface");
        
        Boundary boundary_48 =
        region_0.getBoundaryManager().getBoundary("Wheel_Rear.Surface");
        
        forceReport_0.getParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, boundary_13, boundary_14, boundary_15, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_22, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_28, boundary_29, boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_43, boundary_44, boundary_45, boundary_46, boundary_47, boundary_48);
        
        ForceReport forceReport_1 =
        ((ForceReport) simulation_0.getReportManager().getReport("Lift"));
        
        forceReport_1.getParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, boundary_13, boundary_14, boundary_15, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_22, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_28, boundary_29, boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_43, boundary_44, boundary_45, boundary_46, boundary_47, boundary_48);
    }
    
    private void execute2() {
        
        Simulation simulation_0 =
        getActiveSimulation();
        
        MomentReport momentReport_0 =
        ((MomentReport) simulation_0.getReportManager().getReport("Moment pitch"));
        
        Region region_0 =
        simulation_0.getRegionManager().getRegion("Region");
        
        Boundary boundary_0 =
        region_0.getBoundaryManager().getBoundary("Airduct.Surface");
        
        Boundary boundary_1 =
        region_0.getBoundaryManager().getBoundary("Body_Driver.Surface");
        
        Boundary boundary_2 =
        region_0.getBoundaryManager().getBoundary("Body_MC.Surface");
        
        Boundary boundary_3 =
        region_0.getBoundaryManager().getBoundary("Body_QJ.Surface");
        
        Boundary boundary_6 =
        region_0.getBoundaryManager().getBoundary("Drivetrain.Surface");
        
        Boundary boundary_7 =
        region_0.getBoundaryManager().getBoundary("Fan_final.Surface");
        
        Boundary boundary_8 =
        region_0.getBoundaryManager().getBoundary("Fan_final.Surface 2");
        
        Boundary boundary_9 =
        region_0.getBoundaryManager().getBoundary("Fan_final.Surface 3");
        
        Boundary boundary_10 =
        region_0.getBoundaryManager().getBoundary("Fan_final.Surface 4");
        
        Boundary boundary_11 =
        region_0.getBoundaryManager().getBoundary("Fan_final.Surface 5");
        
        Boundary boundary_12 =
        region_0.getBoundaryManager().getBoundary("Fan_final.Surface 6");
        
        Boundary boundary_50 =
        region_0.getBoundaryManager().getBoundary("FC6_inner.Surface");
        
        Boundary boundary_13 =
        region_0.getBoundaryManager().getBoundary("FW_Endplates.Surface");
        
        Boundary boundary_14 =
        region_0.getBoundaryManager().getBoundary("FW_Flap1.Surface");
        
        Boundary boundary_15 =
        region_0.getBoundaryManager().getBoundary("FW_Main.Surface");
        
        Boundary boundary_16 =
        region_0.getBoundaryManager().getBoundary("Headrest.Surface");
        
        Boundary boundary_17 =
        region_0.getBoundaryManager().getBoundary("MRH.Surface");
        
        Boundary boundary_18 =
        region_0.getBoundaryManager().getBoundary("Outlet_final.Surface");
        
        Boundary boundary_19 =
        region_0.getBoundaryManager().getBoundary("Outlet_final.Surface 2");
        
        Boundary boundary_20 =
        region_0.getBoundaryManager().getBoundary("Outlet_final.Surface 3");
        
        Boundary boundary_21 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface");
        
        Boundary boundary_22 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface 2");
        
        Boundary boundary_23 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface 3");
        
        Boundary boundary_24 =
        region_0.getBoundaryManager().getBoundary("RW_Endplates.Surface");
        
        Boundary boundary_25 =
        region_0.getBoundaryManager().getBoundary("RW_Flap1.Surface");
        
        Boundary boundary_26 =
        region_0.getBoundaryManager().getBoundary("RW_Flap2.Surface");
        
        Boundary boundary_27 =
        region_0.getBoundaryManager().getBoundary("RW_Main.Surface");
        
        Boundary boundary_28 =
        region_0.getBoundaryManager().getBoundary("RW_Support.Surface");
        
        Boundary boundary_29 =
        region_0.getBoundaryManager().getBoundary("Sidepod.Surface");
        
        Boundary boundary_30 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface");
        
        Boundary boundary_31 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 2");
        
        Boundary boundary_32 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 3");
        
        Boundary boundary_33 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 4");
        
        Boundary boundary_34 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 5");
        
        Boundary boundary_35 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 6");
        
        Boundary boundary_36 =
        region_0.getBoundaryManager().getBoundary("Susp_Brackets.Surface");
        
        Boundary boundary_37 =
        region_0.getBoundaryManager().getBoundary("Susp_Legs.Surface");
        
        Boundary boundary_38 =
        region_0.getBoundaryManager().getBoundary("Tire_Front.Surface");
        
        Boundary boundary_39 =
        region_0.getBoundaryManager().getBoundary("Tire_Rear.Surface");
        
        Boundary boundary_40 =
        region_0.getBoundaryManager().getBoundary("TSAL.Surface");
        
        Boundary boundary_41 =
        region_0.getBoundaryManager().getBoundary("Tubes.Surface");
        
        Boundary boundary_42 =
        region_0.getBoundaryManager().getBoundary("UB_Diffusor.Surface");
        
        Boundary boundary_43 =
        region_0.getBoundaryManager().getBoundary("UB_F1.Surface");
        
        Boundary boundary_44 =
        region_0.getBoundaryManager().getBoundary("UB_F2.Surface");
        
        Boundary boundary_45 =
        region_0.getBoundaryManager().getBoundary("UB_hor.Surface");
        
        Boundary boundary_46 =
        region_0.getBoundaryManager().getBoundary("UB_MC.Surface");
        
        Boundary boundary_47 =
        region_0.getBoundaryManager().getBoundary("UB_ver.Surface");
        
        Boundary boundary_48 =
        region_0.getBoundaryManager().getBoundary("Wheel_Front.Surface");
        
        Boundary boundary_49 =
        region_0.getBoundaryManager().getBoundary("Wheel_Rear.Surface");
        
        momentReport_0.getParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_6, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, boundary_50, boundary_13, boundary_14, boundary_15, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_22, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_28, boundary_29, boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_43, boundary_44, boundary_45, boundary_46, boundary_47, boundary_48, boundary_49);
    }
}
