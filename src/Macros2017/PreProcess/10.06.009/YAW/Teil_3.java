// STAR-CCM+ macro: Teil_3.java
// Written by STAR-CCM+ 10.06.009
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;
import star.flow.*;
import star.surfacewrapper.*;
import star.meshing.*;

public class Teil_3 extends StarMacro {

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
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_0.getFloor().setValue(0.001);

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("ContactP_FT_YAW_Final.Surface");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("ContactP_RT_YAW.Surface");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Floor");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Tire_Front.Surface");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Tire_Front_Right.Surface");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Tire_Rear.Surface");

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("Tire_Rear_Right.Surface");

    oneGroupContactPreventionSet_0.getBoundaryGroup().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6);

    Scene scene_16 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 14");

    HighlightDisplayer highlightDisplayer_0 = 
      scene_16.getHighlightDisplayer();

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_1 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_1.getFloor().setValue(0.005);

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap1.Surface");

    Boundary boundary_8 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap2.Surface");

    Boundary boundary_9 = 
      region_0.getBoundaryManager().getBoundary("RW_Main.Surface");

    oneGroupContactPreventionSet_1.getBoundaryGroup().setObjects(boundary_7, boundary_8, boundary_9);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_7, boundary_8, boundary_9);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_2 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_2.getFloor().setValue(0.005);

    Boundary boundary_10 = 
      region_0.getBoundaryManager().getBoundary("RW_Endplates.Surface");

    oneGroupContactPreventionSet_2.getBoundaryGroup().setObjects(boundary_10, boundary_8);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_10, boundary_8);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_3 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_3.getFloor().setValue(0.001);

    Boundary boundary_11 = 
      region_0.getBoundaryManager().getBoundary("Body_MC.Surface");

    Boundary boundary_12 = 
      region_0.getBoundaryManager().getBoundary("FW_Endplates.Surface");

    oneGroupContactPreventionSet_3.getBoundaryGroup().setObjects(boundary_11, boundary_12);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_11, boundary_12);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_4 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_4.getFloor().setValue(0.005);

    Boundary boundary_13 = 
      region_0.getBoundaryManager().getBoundary("FW_Flap1.Surface");

    Boundary boundary_14 = 
      region_0.getBoundaryManager().getBoundary("FW_Main.Surface");

    oneGroupContactPreventionSet_4.getBoundaryGroup().setObjects(boundary_12, boundary_13, boundary_14);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_12, boundary_13, boundary_14);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_5 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_5.getFloor().setValue(0.005);

    Boundary boundary_15 = 
      region_0.getBoundaryManager().getBoundary("Body_Driver.Surface");

    oneGroupContactPreventionSet_5.getBoundaryGroup().setObjects(boundary_15, boundary_11);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_15, boundary_11);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_6 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_6.getFloor().setValue(0.001);

    Boundary boundary_16 = 
      region_0.getBoundaryManager().getBoundary("Airduct.Surface");

    Boundary boundary_17 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface");

    Boundary boundary_18 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 2");

    Boundary boundary_19 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 3");

    Boundary boundary_20 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 4");

    Boundary boundary_21 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 5");

    Boundary boundary_22 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 6");

    Boundary boundary_23 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 7");

    Boundary boundary_24 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 8");

    Boundary boundary_25 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 9");

    Boundary boundary_26 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 10");

    Boundary boundary_27 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 11");

    Boundary boundary_28 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 12");

    Boundary boundary_29 = 
      region_0.getBoundaryManager().getBoundary("UB_Diffusor.Surface");

    oneGroupContactPreventionSet_6.getBoundaryGroup().setObjects(boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_22, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_28, boundary_29);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_22, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_28, boundary_29);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_7 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_7.getFloor().setValue(0.001);

    Boundary boundary_30 = 
      region_0.getBoundaryManager().getBoundary("Body_QJ.Surface");

    Boundary boundary_31 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface");

    Boundary boundary_32 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 2");

    Boundary boundary_33 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 3");

    Boundary boundary_34 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 4");

    Boundary boundary_35 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 5");

    Boundary boundary_36 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 6");

    Boundary boundary_37 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 7");

    Boundary boundary_38 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 8");

    Boundary boundary_39 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 9");

    Boundary boundary_40 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 10");

    Boundary boundary_41 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 11");

    Boundary boundary_42 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 12");

    oneGroupContactPreventionSet_7.getBoundaryGroup().setObjects(boundary_16, boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_29);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_16, boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_29);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_8 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_8.getFloor().setValue(0.005);

    Boundary boundary_43 = 
      region_0.getBoundaryManager().getBoundary("MRH.Surface");

    Boundary boundary_44 = 
      region_0.getBoundaryManager().getBoundary("RW_Support.Surface");

    oneGroupContactPreventionSet_8.getBoundaryGroup().setObjects(boundary_43, boundary_9, boundary_44);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_43, boundary_9, boundary_44);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_9 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_9.getFloor().setValue(0.001);

    Boundary boundary_45 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Symmetry");

    Boundary boundary_46 = 
      region_0.getBoundaryManager().getBoundary("UB_hor.Surface");

    Boundary boundary_47 = 
      region_0.getBoundaryManager().getBoundary("UB_MC.Surface");

    Boundary boundary_48 = 
      region_0.getBoundaryManager().getBoundary("UB_ver.Surface");

    oneGroupContactPreventionSet_9.getBoundaryGroup().setObjects(boundary_12, boundary_13, boundary_14, boundary_2, boundary_45, boundary_29, boundary_46, boundary_47, boundary_48);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_12, boundary_13, boundary_14, boundary_2, boundary_45, boundary_29, boundary_46, boundary_47, boundary_48);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_10 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_10.getFloor().setValue(0.001);

    Boundary boundary_49 = 
      region_0.getBoundaryManager().getBoundary("UB_F1.Surface");

    Boundary boundary_50 = 
      region_0.getBoundaryManager().getBoundary("UB_F2.Surface");

    oneGroupContactPreventionSet_10.getBoundaryGroup().setObjects(boundary_49, boundary_50);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_49, boundary_50);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_11 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_11.getFloor().setValue(0.001);

    Boundary boundary_51 = 
      region_0.getBoundaryManager().getBoundary("Drivetrain.Surface");

    Boundary boundary_52 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Front.Surface");

    Boundary boundary_53 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Front_Right.Surface");

    Boundary boundary_54 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Rear.Surface");

    Boundary boundary_55 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Rear_Right.Surface");

    oneGroupContactPreventionSet_11.getBoundaryGroup().setObjects(boundary_51, boundary_52, boundary_53, boundary_54, boundary_55);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_51, boundary_52, boundary_53, boundary_54, boundary_55);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_12 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_12.getFloor().setValue(0.001);

    oneGroupContactPreventionSet_12.getBoundaryGroup().setObjects(boundary_16, boundary_11);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_16, boundary_11);

    ForceReport forceReport_0 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift"));

    Boundary boundary_56 = 
      region_0.getBoundaryManager().getBoundary("FC6_inner_YAW.Surface");

    Boundary boundary_57 = 
      region_0.getBoundaryManager().getBoundary("Headrest.Surface");

    Boundary boundary_58 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface");

    Boundary boundary_59 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 2");

    Boundary boundary_60 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 3");

    Boundary boundary_61 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 4");

    Boundary boundary_62 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 5");

    Boundary boundary_63 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 6");

    Boundary boundary_64 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface");

    Boundary boundary_65 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 2");

    Boundary boundary_66 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 3");

    Boundary boundary_67 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 4");

    Boundary boundary_68 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 5");

    Boundary boundary_69 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 6");

    Boundary boundary_70 = 
      region_0.getBoundaryManager().getBoundary("Sidepod.Surface");

    Boundary boundary_71 = 
      region_0.getBoundaryManager().getBoundary("Susp_Brackets.Surface");

    Boundary boundary_72 = 
      region_0.getBoundaryManager().getBoundary("Susp_Legs.Surface");

    Boundary boundary_73 = 
      region_0.getBoundaryManager().getBoundary("TSAL.Surface");

    Boundary boundary_74 = 
      region_0.getBoundaryManager().getBoundary("Tubes.Surface");

    forceReport_0.getParts().setObjects(boundary_16, boundary_15, boundary_11, boundary_30, boundary_0, boundary_1, boundary_51, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_22, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_28, boundary_56, boundary_12, boundary_13, boundary_14, boundary_57, boundary_43, boundary_58, boundary_59, boundary_60, boundary_61, boundary_62, boundary_63, boundary_64, boundary_65, boundary_66, boundary_67, boundary_68, boundary_69, boundary_10, boundary_7, boundary_8, boundary_9, boundary_44, boundary_70, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_71, boundary_72, boundary_3, boundary_4, boundary_5, boundary_6, boundary_73, boundary_74, boundary_29, boundary_49, boundary_50, boundary_46, boundary_47, boundary_48, boundary_52, boundary_53, boundary_54, boundary_55);

    boundary_45.setBoundaryType(SymmetryBoundary.class);

    ForceReport forceReport_1 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag"));

    forceReport_1.getParts().setObjects(boundary_16, boundary_15, boundary_11, boundary_30, boundary_51, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_22, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_28, boundary_56, boundary_12, boundary_13, boundary_14, boundary_57, boundary_43, boundary_58, boundary_59, boundary_60, boundary_61, boundary_62, boundary_63, boundary_64, boundary_65, boundary_66, boundary_67, boundary_68, boundary_69, boundary_10, boundary_7, boundary_8, boundary_9, boundary_44, boundary_70, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_71, boundary_72, boundary_3, boundary_4, boundary_5, boundary_6, boundary_73, boundary_74, boundary_29, boundary_49, boundary_50, boundary_46, boundary_47, boundary_48, boundary_52, boundary_53, boundary_54, boundary_55);

    ForceReport forceReport_2 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag FW"));

    forceReport_2.getParts().setObjects(boundary_12, boundary_13, boundary_14);

    ForceReport forceReport_3 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag RW"));

    forceReport_3.getParts().setObjects(boundary_10, boundary_7, boundary_8, boundary_9);

    ForceReport forceReport_4 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag UB"));

    forceReport_4.getParts().setObjects(boundary_29, boundary_49, boundary_50, boundary_46, boundary_47, boundary_48);

    forceReport_0.getParts().setObjects(boundary_16, boundary_15, boundary_11, boundary_30, boundary_51, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_22, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_28, boundary_56, boundary_12, boundary_13, boundary_14, boundary_57, boundary_43, boundary_58, boundary_59, boundary_60, boundary_61, boundary_62, boundary_63, boundary_64, boundary_65, boundary_66, boundary_67, boundary_68, boundary_69, boundary_10, boundary_7, boundary_8, boundary_9, boundary_44, boundary_70, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_71, boundary_72, boundary_3, boundary_4, boundary_5, boundary_6, boundary_73, boundary_74, boundary_29, boundary_49, boundary_50, boundary_46, boundary_47, boundary_48, boundary_52, boundary_53, boundary_54, boundary_55);

    ForceReport forceReport_5 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift FW"));

    forceReport_5.getParts().setObjects(boundary_12, boundary_13, boundary_14);

    ForceReport forceReport_6 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift RW"));

    forceReport_6.getParts().setObjects(boundary_10, boundary_7, boundary_8, boundary_9);

    ForceReport forceReport_7 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift UB"));

    forceReport_7.getParts().setObjects(boundary_29, boundary_49, boundary_50, boundary_46, boundary_47, boundary_48);

    MomentReport momentReport_0 = 
      ((MomentReport) simulation_0.getReportManager().getReport("Moment pitch"));

    momentReport_0.getParts().setObjects(boundary_16, boundary_15, boundary_11, boundary_30, boundary_51, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_22, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_28, boundary_56, boundary_12, boundary_13, boundary_14, boundary_57, boundary_43, boundary_58, boundary_59, boundary_60, boundary_61, boundary_62, boundary_63, boundary_64, boundary_65, boundary_66, boundary_67, boundary_68, boundary_69, boundary_10, boundary_7, boundary_8, boundary_9, boundary_44, boundary_70, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_71, boundary_72, boundary_3, boundary_4, boundary_5, boundary_6, boundary_73, boundary_74, boundary_29, boundary_49, boundary_50, boundary_46, boundary_47, boundary_48, boundary_52, boundary_53, boundary_54, boundary_55);

    ForceReport forceReport_8 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    forceReport_8.getDirection().setComponents(0.0, 0.0, 1.0);

    forceReport_8.getParts().setObjects(boundary_56);

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {forceReport_8}), true, "%1$s Plot");

    ReportMonitor reportMonitor_0 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 1 Monitor"));

    MonitorPlot monitorPlot_0 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_0}), "Force 1 Monitor Plot");

    monitorPlot_0.open();

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {forceReport_1, forceReport_2, forceReport_3, forceReport_4, forceReport_8, forceReport_0, forceReport_5, forceReport_6, forceReport_7, momentReport_0}), false, "%1$s Plot");

    ReportMonitor reportMonitor_1 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag Monitor"));

    MonitorPlot monitorPlot_1 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_1}), "Drag Monitor Plot");

    ReportMonitor reportMonitor_2 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag FW Monitor"));

    MonitorPlot monitorPlot_2 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_2}), "Drag FW Monitor Plot");

    ReportMonitor reportMonitor_3 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag RW Monitor"));

    MonitorPlot monitorPlot_3 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_3}), "Drag RW Monitor Plot");

    ReportMonitor reportMonitor_4 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag UB Monitor"));

    MonitorPlot monitorPlot_4 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_4}), "Drag UB Monitor Plot");

    ReportMonitor reportMonitor_5 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 1 Monitor 2"));

    MonitorPlot monitorPlot_5 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_5}), "Force 1 Monitor 2 Plot");

    ReportMonitor reportMonitor_6 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift Monitor"));

    MonitorPlot monitorPlot_6 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_6}), "Lift Monitor Plot");

    ReportMonitor reportMonitor_7 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift FW Monitor"));

    MonitorPlot monitorPlot_7 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_7}), "Lift FW Monitor Plot");

    ReportMonitor reportMonitor_8 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift RW Monitor"));

    MonitorPlot monitorPlot_8 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_8}), "Lift RW Monitor Plot");

    ReportMonitor reportMonitor_9 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift UB Monitor"));

    MonitorPlot monitorPlot_9 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_9}), "Lift UB Monitor Plot");

    ReportMonitor reportMonitor_10 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Moment pitch Monitor"));

    MonitorPlot monitorPlot_10 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_10}), "Moment pitch Monitor Plot");

    monitorPlot_1.open();

    monitorPlot_2.open();

    monitorPlot_3.open();

    monitorPlot_4.open();

    monitorPlot_5.open();

    monitorPlot_6.open();

    monitorPlot_7.open();

    monitorPlot_8.open();

    monitorPlot_9.open();

    monitorPlot_10.open();

  }

  private void execute1() {

    Simulation simulation_0 = 
      getActiveSimulation();

    MonitorPlot monitorPlot_3 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag RW Monitor Plot"));

    monitorPlot_3.close();

    MonitorPlot monitorPlot_8 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift RW Monitor Plot"));

    monitorPlot_8.close();

    MonitorPlot monitorPlot_10 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Moment pitch Monitor Plot"));

    monitorPlot_10.close();

    MonitorPlot monitorPlot_0 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 1 Monitor Plot"));

    monitorPlot_0.close();

    MonitorPlot monitorPlot_4 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag UB Monitor Plot"));

    monitorPlot_4.close();

    Scene scene_15 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 13");

    scene_15.close(true);

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 12");

    scene_0.close(true);

    MonitorPlot monitorPlot_2 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag FW Monitor Plot"));

    monitorPlot_2.close();

    MonitorPlot monitorPlot_7 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift FW Monitor Plot"));

    monitorPlot_7.close();

    Scene scene_16 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 14");

    scene_16.close(true);

    MonitorPlot monitorPlot_1 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag Monitor Plot"));

    monitorPlot_1.close();

    MonitorPlot monitorPlot_9 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift UB Monitor Plot"));

    monitorPlot_9.close();

    MonitorPlot monitorPlot_5 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 1 Monitor 2 Plot"));

    monitorPlot_5.close();

    MonitorPlot monitorPlot_6 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift Monitor Plot"));

    monitorPlot_6.close();
  }
}
