// STAR-CCM+ macro: Teil_5.java
// Written by STAR-CCM+ 10.06.009
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.surfacewrapper.*;
import star.meshing.*;
import star.base.report.*;
import star.flow.*;

public class Teil_5 extends StarMacro {

  public void execute() {
    execute0();
    execute1();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    OneGroupContactPreventionSet oneGroupContactPreventionSet_0 = 
      ((OneGroupContactPreventionSet) region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).getObject("Contact Prevention 7"));

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Airduct.Surface");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 2");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 3");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 4");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 5");

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 6");

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 7");

    Boundary boundary_8 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 8");

    Boundary boundary_9 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 9");

    Boundary boundary_10 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 10");

    Boundary boundary_11 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 11");

    Boundary boundary_12 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 12");

    Boundary boundary_13 = 
      region_0.getBoundaryManager().getBoundary("UB_Diffusor.Surface");

    oneGroupContactPreventionSet_0.getBoundaryGroup().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, boundary_13);
  }
    private void execute1() {
        
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
        
        Boundary boundary_4 =
        region_0.getBoundaryManager().getBoundary("Drivetrain.Surface");
        
        Boundary boundary_5 =
        region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface");
        
        Boundary boundary_6 =
        region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 2");
        
        Boundary boundary_7 =
        region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 3");
        
        Boundary boundary_8 =
        region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 4");
        
        Boundary boundary_9 =
        region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 5");
        
        Boundary boundary_10 =
        region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 6");
        
        Boundary boundary_11 =
        region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 7");
        
        Boundary boundary_12 =
        region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 8");
        
        Boundary boundary_13 =
        region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 9");
        
        Boundary boundary_14 =
        region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 10");
        
        Boundary boundary_15 =
        region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 11");
        
        Boundary boundary_16 =
        region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 12");
        
        Boundary boundary_17 =
        region_0.getBoundaryManager().getBoundary("FC6_inner_YAW.Surface");
        
        Boundary boundary_18 =
        region_0.getBoundaryManager().getBoundary("FW_Endplates.Surface");
        
        Boundary boundary_19 =
        region_0.getBoundaryManager().getBoundary("FW_Flap1.Surface");
        
        Boundary boundary_20 =
        region_0.getBoundaryManager().getBoundary("FW_Main.Surface");
        
        Boundary boundary_21 =
        region_0.getBoundaryManager().getBoundary("Headrest.Surface");
        
        Boundary boundary_22 =
        region_0.getBoundaryManager().getBoundary("MRH.Surface");
        
        Boundary boundary_23 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface");
        
        Boundary boundary_24 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface 2");
        
        Boundary boundary_25 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface 3");
        
        Boundary boundary_26 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface 4");
        
        Boundary boundary_27 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface 5");
        
        Boundary boundary_28 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface 6");
        
        Boundary boundary_29 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface");
        
        Boundary boundary_30 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface 2");
        
        Boundary boundary_31 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface 3");
        
        Boundary boundary_32 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface 4");
        
        Boundary boundary_33 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface 5");
        
        Boundary boundary_34 =
        region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface 6");
        
        Boundary boundary_35 =
        region_0.getBoundaryManager().getBoundary("RW_Endplates.Surface");
        
        Boundary boundary_36 =
        region_0.getBoundaryManager().getBoundary("RW_Flap1.Surface");
        
        Boundary boundary_37 =
        region_0.getBoundaryManager().getBoundary("RW_Flap2.Surface");
        
        Boundary boundary_38 =
        region_0.getBoundaryManager().getBoundary("RW_Main.Surface");
        
        Boundary boundary_39 =
        region_0.getBoundaryManager().getBoundary("RW_Support.Surface");
        
        Boundary boundary_40 =
        region_0.getBoundaryManager().getBoundary("Sidepod.Surface");
        
        Boundary boundary_41 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface");
        
        Boundary boundary_42 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 2");
        
        Boundary boundary_43 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 3");
        
        Boundary boundary_44 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 4");
        
        Boundary boundary_45 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 5");
        
        Boundary boundary_46 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 6");
        
        Boundary boundary_47 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 7");
        
        Boundary boundary_48 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 8");
        
        Boundary boundary_49 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 9");
        
        Boundary boundary_50 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 10");
        
        Boundary boundary_51 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 11");
        
        Boundary boundary_52 =
        region_0.getBoundaryManager().getBoundary("Subtract.Surface 12");
        
        Boundary boundary_53 =
        region_0.getBoundaryManager().getBoundary("Susp_Brackets.Surface");
        
        Boundary boundary_54 =
        region_0.getBoundaryManager().getBoundary("Susp_Legs.Surface");
        
        Boundary boundary_55 =
        region_0.getBoundaryManager().getBoundary("Tire_Front.Surface");
        
        Boundary boundary_56 =
        region_0.getBoundaryManager().getBoundary("Tire_Front_Right.Surface");
        
        Boundary boundary_57 =
        region_0.getBoundaryManager().getBoundary("Tire_Rear.Surface");
        
        Boundary boundary_58 =
        region_0.getBoundaryManager().getBoundary("Tire_Rear_Right.Surface");
        
        Boundary boundary_59 =
        region_0.getBoundaryManager().getBoundary("TSAL.Surface");
        
        Boundary boundary_60 =
        region_0.getBoundaryManager().getBoundary("Tubes.Surface");
        
        Boundary boundary_61 =
        region_0.getBoundaryManager().getBoundary("UB_Diffusor.Surface");
        
        Boundary boundary_62 =
        region_0.getBoundaryManager().getBoundary("UB_F1.Surface");
        
        Boundary boundary_63 =
        region_0.getBoundaryManager().getBoundary("UB_F2.Surface");
        
        Boundary boundary_64 =
        region_0.getBoundaryManager().getBoundary("UB_hor.Surface");
        
        Boundary boundary_65 =
        region_0.getBoundaryManager().getBoundary("UB_MC.Surface");
        
        Boundary boundary_66 =
        region_0.getBoundaryManager().getBoundary("UB_ver.Surface");
        
        Boundary boundary_67 =
        region_0.getBoundaryManager().getBoundary("Wheel_Front.Surface");
        
        Boundary boundary_68 =
        region_0.getBoundaryManager().getBoundary("Wheel_Front_Right.Surface");
        
        Boundary boundary_69 =
        region_0.getBoundaryManager().getBoundary("Wheel_Rear.Surface");
        
        Boundary boundary_70 =
        region_0.getBoundaryManager().getBoundary("Wheel_Rear_Right.Surface");
        
        momentReport_0.getParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, boundary_13, boundary_14, boundary_15, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_22, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_28, boundary_29, boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_43, boundary_44, boundary_45, boundary_46, boundary_47, boundary_48, boundary_49, boundary_50, boundary_51, boundary_52, boundary_53, boundary_54, boundary_55, boundary_56, boundary_57, boundary_58, boundary_59, boundary_60, boundary_61, boundary_62, boundary_63, boundary_64, boundary_65, boundary_66, boundary_67, boundary_68, boundary_69, boundary_70);
    }
}
