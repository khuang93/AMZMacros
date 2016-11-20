// STAR-CCM+ macro: repo.java
// Written by STAR-CCM+ 10.06.009
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.flow.*;

public class repo extends StarMacro {

  public void execute() {
    execute0();
    execute1();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();
/*
    MonitorPlot monitorPlot_0 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("DRS_Moment_P1 Monitor Plot"));

    MonitorPlot monitorPlot_1 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("DRS_Moment_P1 Monitor Plot 2"));

    MonitorPlot monitorPlot_2 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("DRS_Moment_P2 Monitor Plot"));

    MonitorPlot monitorPlot_3 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("DRS_Moment_P2 Monitor Plot 2"));

    MonitorPlot monitorPlot_4 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("DRS_Moment_P3 Monitor Plot"));

    MonitorPlot monitorPlot_5 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("DRS_Moment_P3 Monitor Plot 2"));

    simulation_0.getPlotManager().deletePlots(new NeoObjectVector(new Object[] {monitorPlot_0, monitorPlot_1, monitorPlot_2, monitorPlot_3, monitorPlot_4, monitorPlot_5}));

    MonitorPlot monitorPlot_6 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Massflow_Radiator Monitor Plot"));

    MonitorPlot monitorPlot_7 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Massflow_Radiator Monitor Plot 2"));

    simulation_0.getPlotManager().deletePlots(new NeoObjectVector(new Object[] {monitorPlot_6, monitorPlot_7}));

    MonitorPlot monitorPlot_8 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag FW Monitor Plot"));

    MonitorPlot monitorPlot_9 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag FW Monitor Plot 2"));

    MonitorPlot monitorPlot_10 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag Monitor Plot"));

    MonitorPlot monitorPlot_11 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag Monitor Plot 2"));

    MonitorPlot monitorPlot_12 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag RW Monitor Plot"));

    MonitorPlot monitorPlot_13 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag RW Monitor Plot 2"));

    MonitorPlot monitorPlot_14 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag UB Monitor Plot"));

    MonitorPlot monitorPlot_15 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag UB Monitor Plot 2"));

    MonitorPlot monitorPlot_16 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift FW Monitor Plot"));

    MonitorPlot monitorPlot_17 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift FW Monitor Plot 2"));

    MonitorPlot monitorPlot_18 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift Monitor Plot"));

    MonitorPlot monitorPlot_19 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift Monitor Plot 2"));

    MonitorPlot monitorPlot_20 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift RW Monitor Plot"));

    MonitorPlot monitorPlot_21 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift RW Monitor Plot 2"));

    MonitorPlot monitorPlot_22 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift UB Monitor Plot"));

    MonitorPlot monitorPlot_23 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift UB Monitor Plot 2"));

    MonitorPlot monitorPlot_24 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Moment pitch Monitor Plot"));

    MonitorPlot monitorPlot_25 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Moment pitch Monitor Plot 2"));

    MonitorPlot monitorPlot_26 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Monitor Plot 1"));

    simulation_0.getPlotManager().deletePlots(new NeoObjectVector(new Object[] {monitorPlot_8, monitorPlot_9, monitorPlot_10, monitorPlot_11, monitorPlot_12, monitorPlot_13, monitorPlot_14, monitorPlot_15, monitorPlot_16, monitorPlot_17, monitorPlot_18, monitorPlot_19, monitorPlot_20, monitorPlot_21, monitorPlot_22, monitorPlot_23, monitorPlot_24, monitorPlot_25, monitorPlot_26}));

    ReportMonitor reportMonitor_0 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("DRS_Moment_P1 2 Monitor"));

    ReportMonitor reportMonitor_1 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("DRS_Moment_P1 Monitor"));

    ReportMonitor reportMonitor_2 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("DRS_Moment_P2 2 Monitor"));

    ReportMonitor reportMonitor_3 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("DRS_Moment_P2 Monitor"));

    ReportMonitor reportMonitor_4 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("DRS_Moment_P3 2 Monitor"));

    ReportMonitor reportMonitor_5 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("DRS_Moment_P3 Monitor"));

    ReportMonitor reportMonitor_6 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag FW Monitor"));

    ReportMonitor reportMonitor_7 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag FW Monitor 2"));

    ReportMonitor reportMonitor_8 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag Monitor"));

    ReportMonitor reportMonitor_9 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag Monitor 2"));

    ReportMonitor reportMonitor_10 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag RW Monitor"));

    ReportMonitor reportMonitor_11 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag RW Monitor 2"));

    ReportMonitor reportMonitor_12 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag UB Monitor"));

    ReportMonitor reportMonitor_13 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag UB Monitor 2"));

    simulation_0.getMonitorManager().removeObjects(reportMonitor_0, reportMonitor_1, reportMonitor_2, reportMonitor_3, reportMonitor_4, reportMonitor_5, reportMonitor_6, reportMonitor_7, reportMonitor_8, reportMonitor_9, reportMonitor_10, reportMonitor_11, reportMonitor_12, reportMonitor_13);

    ReportMonitor reportMonitor_14 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift FW Monitor"));

    ReportMonitor reportMonitor_15 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift FW Monitor 2"));

    ReportMonitor reportMonitor_16 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift Monitor"));

    ReportMonitor reportMonitor_17 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift Monitor 2"));

    ReportMonitor reportMonitor_18 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift RW Monitor"));

    ReportMonitor reportMonitor_19 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift RW Monitor 2"));

    ReportMonitor reportMonitor_20 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift UB Monitor"));

    ReportMonitor reportMonitor_21 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift UB Monitor 2"));

    ReportMonitor reportMonitor_22 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Massflow_Radiator 2 Monitor"));

    ReportMonitor reportMonitor_23 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Massflow_Radiator Monitor"));

    ReportMonitor reportMonitor_24 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Moment pitch Monitor"));

    ReportMonitor reportMonitor_25 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Moment pitch Monitor 2"));

    simulation_0.getMonitorManager().removeObjects(reportMonitor_14, reportMonitor_15, reportMonitor_16, reportMonitor_17, reportMonitor_18, reportMonitor_19, reportMonitor_20, reportMonitor_21, reportMonitor_22, reportMonitor_23, reportMonitor_24, reportMonitor_25);

    MomentReport momentReport_0 = 
      ((MomentReport) simulation_0.getReportManager().getReport("DRS_Moment_P1"));

    MomentReport momentReport_1 = 
      ((MomentReport) simulation_0.getReportManager().getReport("DRS_Moment_P1 2"));

    MomentReport momentReport_2 = 
      ((MomentReport) simulation_0.getReportManager().getReport("DRS_Moment_P2"));

    MomentReport momentReport_3 = 
      ((MomentReport) simulation_0.getReportManager().getReport("DRS_Moment_P2 2"));

    MomentReport momentReport_4 = 
      ((MomentReport) simulation_0.getReportManager().getReport("DRS_Moment_P3"));

    MomentReport momentReport_5 = 
      ((MomentReport) simulation_0.getReportManager().getReport("DRS_Moment_P3 2"));

    simulation_0.getReportManager().removeObjects(momentReport_0, momentReport_1, momentReport_2, momentReport_3, momentReport_4, momentReport_5);

    MassFlowReport massFlowReport_0 = 
      ((MassFlowReport) simulation_0.getReportManager().getReport("Massflow_Radiator"));

    MassFlowReport massFlowReport_1 = 
      ((MassFlowReport) simulation_0.getReportManager().getReport("Massflow_Radiator 2"));

    simulation_0.getReportManager().removeObjects(massFlowReport_0, massFlowReport_1);
*/
    ForceReport forceReport_0 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag"));

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Airduct.Surface");

    Boundary boundary_10 = 
      region_0.getBoundaryManager().getBoundary("Body_Driver.Surface");

    Boundary boundary_11 = 
      region_0.getBoundaryManager().getBoundary("Body_MC.Surface");

    Boundary boundary_12 = 
      region_0.getBoundaryManager().getBoundary("Body_QJ.Surface");

    Boundary boundary_13 = 
      region_0.getBoundaryManager().getBoundary("Drivetrain.Surface");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 2");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 3");

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 4");

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 5");

    Boundary boundary_8 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 6");

    Boundary boundary_14 = 
      region_0.getBoundaryManager().getBoundary("FW_Endplates.Surface");

    Boundary boundary_15 = 
      region_0.getBoundaryManager().getBoundary("FW_Flap1.Surface");

    Boundary boundary_16 = 
      region_0.getBoundaryManager().getBoundary("FW_Main.Surface");

    Boundary boundary_17 = 
      region_0.getBoundaryManager().getBoundary("Headrest.Surface");

    Boundary boundary_18 = 
      region_0.getBoundaryManager().getBoundary("MRH.Surface");

    Boundary boundary_19 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final.Surface");

    Boundary boundary_20 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final.Surface 2");

    Boundary boundary_21 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final.Surface 3");

    Boundary boundary_22 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface");

    Boundary boundary_23 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface 2");

    Boundary boundary_24 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface 3");

    Boundary boundary_25 = 
      region_0.getBoundaryManager().getBoundary("RW_Endplates.Surface");

    Boundary boundary_26 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap1.Surface");

    Boundary boundary_27 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap2.Surface");

    Boundary boundary_28 = 
      region_0.getBoundaryManager().getBoundary("RW_Main.Surface");

    Boundary boundary_29 = 
      region_0.getBoundaryManager().getBoundary("RW_Support.Surface");

    Boundary boundary_30 = 
      region_0.getBoundaryManager().getBoundary("Sidepod.Surface");

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
      region_0.getBoundaryManager().getBoundary("Susp_Brackets.Surface");

    Boundary boundary_38 = 
      region_0.getBoundaryManager().getBoundary("Susp_Legs.Surface");

    Boundary boundary_39 = 
      region_0.getBoundaryManager().getBoundary("Tire_Front.Surface");

    Boundary boundary_40 = 
      region_0.getBoundaryManager().getBoundary("Tire_Rear.Surface");

    Boundary boundary_41 = 
      region_0.getBoundaryManager().getBoundary("TSAL.Surface");

    Boundary boundary_42 = 
      region_0.getBoundaryManager().getBoundary("Tubes.Surface");

    Boundary boundary_9 = 
      region_0.getBoundaryManager().getBoundary("UB_Diffusor.Surface");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("UB_F1.Surface");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("UB_F2.Surface");

    Boundary boundary_43 = 
      region_0.getBoundaryManager().getBoundary("UB_hor.Surface");

    Boundary boundary_44 = 
      region_0.getBoundaryManager().getBoundary("UB_MC.Surface");

    Boundary boundary_45 = 
      region_0.getBoundaryManager().getBoundary("UB_ver.Surface");

    Boundary boundary_46 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Front.Surface");

    Boundary boundary_47 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Rear.Surface");
      
      Boundary boundary_48 =
      region_0.getBoundaryManager().getBoundary("FC6_inner.Surface");

    forceReport_0.getParts().setObjects(boundary_2, boundary_10, boundary_11, boundary_12, boundary_13, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_14, boundary_15, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_22, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_28, boundary_29, boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_9, boundary_0, boundary_1, boundary_43, boundary_44, boundary_45, boundary_46, boundary_47, boundary_48);

    ForceReport forceReport_1 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift"));

    forceReport_1.getParts().setObjects(boundary_2, boundary_10, boundary_11, boundary_12, boundary_13, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_14, boundary_15, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_22, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_28, boundary_29, boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_9, boundary_0, boundary_1, boundary_43, boundary_44, boundary_45, boundary_46, boundary_47);

    ForceReport forceReport_2 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceCoefficientReport forceCoefficientReport_0 = 
      simulation_0.getReportManager().createReport(ForceCoefficientReport.class);

    simulation_0.getReportManager().removeObjects(forceCoefficientReport_0);

    ForceReport forceReport_3 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_4 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_5 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_6 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_7 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_8 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_9 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_10 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_11 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_12 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_13 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_14 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_15 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_16 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_17 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_18 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_19 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_20 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_21 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    forceReport_2.getParts().setObjects(boundary_2);

    forceReport_3.getParts().setObjects(boundary_10);

    forceReport_4.getParts().setObjects(boundary_11);

    forceReport_5.getParts().setObjects(boundary_12);

    forceReport_6.getParts().setObjects(boundary_13);

    forceReport_7.getParts().setObjects(boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_8);

    forceReport_8.getParts().setObjects(boundary_14);

    forceReport_9.getParts().setObjects(boundary_15);

    forceReport_10.getParts().setObjects(boundary_16);

    forceReport_11.getParts().setObjects(boundary_17);

    forceReport_12.getParts().setObjects(boundary_18);

    forceReport_13.getParts().setObjects(boundary_19, boundary_20, boundary_21);

    forceReport_14.getParts().setObjects(boundary_22, boundary_23, boundary_24);

    forceReport_15.getParts().setObjects(boundary_25);

    forceReport_16.getParts().setObjects(boundary_26);

    forceReport_17.getParts().setObjects(boundary_27);

    forceReport_18.getParts().setObjects(boundary_28);

    forceReport_19.getParts().setObjects(boundary_30);

    forceReport_19.getParts().setObjects(boundary_29);

    forceReport_20.getParts().setObjects(boundary_30);

    forceReport_21.getParts().setObjects(boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36);

    ForceReport forceReport_22 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_23 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_24 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_25 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_26 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_27 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_28 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_29 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_30 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_31 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    forceReport_22.getParts().setObjects(boundary_37);

    forceReport_23.getParts().setObjects(boundary_38);

    forceReport_24.getParts().setObjects(boundary_39);

    forceReport_25.getParts().setObjects(boundary_40);

    forceReport_26.getParts().setObjects(boundary_41);

    forceReport_27.getParts().setObjects(boundary_42);

    forceReport_28.getParts().setObjects(boundary_9);

    forceReport_29.getParts().setObjects(boundary_0);

    forceReport_30.getParts().setObjects(boundary_1);

    forceReport_31.getParts().setObjects(boundary_43);

    ForceReport forceReport_32 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_33 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_34 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_35 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    forceReport_32.getParts().setObjects(boundary_44);

    forceReport_33.getParts().setObjects(boundary_45);

    forceReport_34.getParts().setObjects(boundary_46);

    forceReport_35.getParts().setObjects(boundary_47);

    ForceReport forceReport_36 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag FW"));

    ForceReport forceReport_37 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag RW"));

    ForceReport forceReport_38 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag UB"));

    ForceReport forceReport_39 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift FW"));

    ForceReport forceReport_40 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift RW"));

    ForceReport forceReport_41 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift UB"));

    MomentReport momentReport_6 = 
      ((MomentReport) simulation_0.getReportManager().getReport("Moment pitch"));

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {forceReport_0, forceReport_36, forceReport_37, forceReport_38, forceReport_2, forceReport_3, forceReport_4, forceReport_5, forceReport_6, forceReport_7, forceReport_8, forceReport_9, forceReport_10, forceReport_11, forceReport_12, forceReport_13, forceReport_14, forceReport_15, forceReport_16, forceReport_17, forceReport_18, forceReport_19, forceReport_20, forceReport_21, forceReport_22, forceReport_23, forceReport_24, forceReport_25, forceReport_26, forceReport_27, forceReport_28, forceReport_29, forceReport_30, forceReport_31, forceReport_32, forceReport_33, forceReport_34, forceReport_35, forceReport_1, forceReport_39, forceReport_40, forceReport_41, momentReport_6}), false, "%1$s Plot");

    ReportMonitor reportMonitor_26 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag Monitor"));

    MonitorPlot monitorPlot_27 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_26}), "Drag Monitor Plot");

    ReportMonitor reportMonitor_27 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag FW Monitor"));

    MonitorPlot monitorPlot_28 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_27}), "Drag FW Monitor Plot");

    ReportMonitor reportMonitor_28 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag RW Monitor"));

    MonitorPlot monitorPlot_29 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_28}), "Drag RW Monitor Plot");

    ReportMonitor reportMonitor_29 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag UB Monitor"));

    MonitorPlot monitorPlot_30 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_29}), "Drag UB Monitor Plot");

    ReportMonitor reportMonitor_30 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 1 Monitor"));

    MonitorPlot monitorPlot_31 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_30}), "Force 1 Monitor Plot");

    ReportMonitor reportMonitor_31 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 2 Monitor"));

    MonitorPlot monitorPlot_32 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_31}), "Force 2 Monitor Plot");

    ReportMonitor reportMonitor_32 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 3 Monitor"));

    MonitorPlot monitorPlot_33 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_32}), "Force 3 Monitor Plot");

    ReportMonitor reportMonitor_33 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 4 Monitor"));

    MonitorPlot monitorPlot_34 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_33}), "Force 4 Monitor Plot");

    ReportMonitor reportMonitor_34 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 5 Monitor"));

    MonitorPlot monitorPlot_35 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_34}), "Force 5 Monitor Plot");

    ReportMonitor reportMonitor_35 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 6 Monitor"));

    MonitorPlot monitorPlot_36 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_35}), "Force 6 Monitor Plot");

    ReportMonitor reportMonitor_36 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 7 Monitor"));

    MonitorPlot monitorPlot_37 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_36}), "Force 7 Monitor Plot");

    ReportMonitor reportMonitor_37 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 8 Monitor"));

    MonitorPlot monitorPlot_38 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_37}), "Force 8 Monitor Plot");

    ReportMonitor reportMonitor_38 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 9 Monitor"));

    MonitorPlot monitorPlot_39 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_38}), "Force 9 Monitor Plot");

    ReportMonitor reportMonitor_39 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 10 Monitor"));

    MonitorPlot monitorPlot_40 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_39}), "Force 10 Monitor Plot");

    ReportMonitor reportMonitor_40 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 11 Monitor"));

    MonitorPlot monitorPlot_41 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_40}), "Force 11 Monitor Plot");

    ReportMonitor reportMonitor_41 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 12 Monitor"));

    MonitorPlot monitorPlot_42 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_41}), "Force 12 Monitor Plot");

    ReportMonitor reportMonitor_42 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 13 Monitor"));

    MonitorPlot monitorPlot_43 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_42}), "Force 13 Monitor Plot");

    ReportMonitor reportMonitor_43 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 14 Monitor"));

    MonitorPlot monitorPlot_44 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_43}), "Force 14 Monitor Plot");

    ReportMonitor reportMonitor_44 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 15 Monitor"));

    MonitorPlot monitorPlot_45 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_44}), "Force 15 Monitor Plot");

    ReportMonitor reportMonitor_45 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 16 Monitor"));

    MonitorPlot monitorPlot_46 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_45}), "Force 16 Monitor Plot");

    ReportMonitor reportMonitor_46 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 17 Monitor"));

    MonitorPlot monitorPlot_47 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_46}), "Force 17 Monitor Plot");

    ReportMonitor reportMonitor_47 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 18 Monitor"));

    MonitorPlot monitorPlot_48 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_47}), "Force 18 Monitor Plot");

    ReportMonitor reportMonitor_48 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 19 Monitor"));

    MonitorPlot monitorPlot_49 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_48}), "Force 19 Monitor Plot");

    ReportMonitor reportMonitor_49 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 20 Monitor"));

    MonitorPlot monitorPlot_50 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_49}), "Force 20 Monitor Plot");

    ReportMonitor reportMonitor_50 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 21 Monitor"));

    MonitorPlot monitorPlot_51 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_50}), "Force 21 Monitor Plot");
  }

  private void execute1() {

    Simulation simulation_0 = 
      getActiveSimulation();

    ReportMonitor reportMonitor_51 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 22 Monitor"));

    MonitorPlot monitorPlot_52 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_51}), "Force 22 Monitor Plot");

    ReportMonitor reportMonitor_52 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 23 Monitor"));

    MonitorPlot monitorPlot_53 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_52}), "Force 23 Monitor Plot");

    ReportMonitor reportMonitor_53 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 24 Monitor"));

    MonitorPlot monitorPlot_54 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_53}), "Force 24 Monitor Plot");

    ReportMonitor reportMonitor_54 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 25 Monitor"));

    MonitorPlot monitorPlot_55 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_54}), "Force 25 Monitor Plot");

    ReportMonitor reportMonitor_55 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 26 Monitor"));

    MonitorPlot monitorPlot_56 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_55}), "Force 26 Monitor Plot");

    ReportMonitor reportMonitor_56 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 27 Monitor"));

    MonitorPlot monitorPlot_57 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_56}), "Force 27 Monitor Plot");

    ReportMonitor reportMonitor_57 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 28 Monitor"));

    MonitorPlot monitorPlot_58 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_57}), "Force 28 Monitor Plot");

    ReportMonitor reportMonitor_58 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 29 Monitor"));

    MonitorPlot monitorPlot_59 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_58}), "Force 29 Monitor Plot");

    ReportMonitor reportMonitor_59 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 30 Monitor"));

    MonitorPlot monitorPlot_60 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_59}), "Force 30 Monitor Plot");

    ReportMonitor reportMonitor_60 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 31 Monitor"));

    MonitorPlot monitorPlot_61 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_60}), "Force 31 Monitor Plot");

    ReportMonitor reportMonitor_61 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 32 Monitor"));

    MonitorPlot monitorPlot_62 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_61}), "Force 32 Monitor Plot");

    ReportMonitor reportMonitor_62 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 33 Monitor"));

    MonitorPlot monitorPlot_63 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_62}), "Force 33 Monitor Plot");

    ReportMonitor reportMonitor_63 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 34 Monitor"));

    MonitorPlot monitorPlot_64 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_63}), "Force 34 Monitor Plot");

    ReportMonitor reportMonitor_64 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift Monitor"));

    MonitorPlot monitorPlot_65 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_64}), "Lift Monitor Plot");

    ReportMonitor reportMonitor_65 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift FW Monitor"));

    MonitorPlot monitorPlot_66 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_65}), "Lift FW Monitor Plot");

    ReportMonitor reportMonitor_66 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift RW Monitor"));

    MonitorPlot monitorPlot_67 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_66}), "Lift RW Monitor Plot");

    ReportMonitor reportMonitor_67 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift UB Monitor"));

    MonitorPlot monitorPlot_68 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_67}), "Lift UB Monitor Plot");

    ReportMonitor reportMonitor_68 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Moment pitch Monitor"));

    MonitorPlot monitorPlot_69 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_68}), "Moment pitch Monitor Plot");

    MonitorPlot monitorPlot_27 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag Monitor Plot"));

    monitorPlot_27.open();

    MonitorPlot monitorPlot_28 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag FW Monitor Plot"));

    monitorPlot_28.open();

    MonitorPlot monitorPlot_29 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag RW Monitor Plot"));

    monitorPlot_29.open();

    MonitorPlot monitorPlot_30 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag UB Monitor Plot"));

    monitorPlot_30.open();

    MonitorPlot monitorPlot_31 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 1 Monitor Plot"));

    monitorPlot_31.open();

    MonitorPlot monitorPlot_32 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 2 Monitor Plot"));

    monitorPlot_32.open();

    MonitorPlot monitorPlot_33 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 3 Monitor Plot"));

    monitorPlot_33.open();

    MonitorPlot monitorPlot_34 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 4 Monitor Plot"));

    monitorPlot_34.open();

    MonitorPlot monitorPlot_35 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 5 Monitor Plot"));

    monitorPlot_35.open();

    MonitorPlot monitorPlot_36 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 6 Monitor Plot"));

    monitorPlot_36.open();

    MonitorPlot monitorPlot_37 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 7 Monitor Plot"));

    monitorPlot_37.open();

    MonitorPlot monitorPlot_38 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 8 Monitor Plot"));

    monitorPlot_38.open();

    MonitorPlot monitorPlot_39 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 9 Monitor Plot"));

    monitorPlot_39.open();

    MonitorPlot monitorPlot_40 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 10 Monitor Plot"));

    monitorPlot_40.open();

    MonitorPlot monitorPlot_41 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 11 Monitor Plot"));

    monitorPlot_41.open();

    MonitorPlot monitorPlot_42 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 12 Monitor Plot"));

    monitorPlot_42.open();

    MonitorPlot monitorPlot_43 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 13 Monitor Plot"));

    monitorPlot_43.open();

    MonitorPlot monitorPlot_44 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 14 Monitor Plot"));

    monitorPlot_44.open();

    MonitorPlot monitorPlot_45 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 15 Monitor Plot"));

    monitorPlot_45.open();

    MonitorPlot monitorPlot_46 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 16 Monitor Plot"));

    monitorPlot_46.open();

    MonitorPlot monitorPlot_47 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 17 Monitor Plot"));

    monitorPlot_47.open();

    MonitorPlot monitorPlot_48 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 18 Monitor Plot"));

    monitorPlot_48.open();

    MonitorPlot monitorPlot_49 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 19 Monitor Plot"));

    monitorPlot_49.open();

    MonitorPlot monitorPlot_50 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 20 Monitor Plot"));

    monitorPlot_50.open();

    MonitorPlot monitorPlot_51 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Force 21 Monitor Plot"));

    monitorPlot_51.open();

    monitorPlot_52.open();

    monitorPlot_53.open();

    monitorPlot_54.open();

    monitorPlot_55.open();

    monitorPlot_56.open();

    monitorPlot_57.open();

    monitorPlot_58.open();

    monitorPlot_59.open();

    monitorPlot_60.open();

    monitorPlot_61.open();

    monitorPlot_62.open();

    monitorPlot_63.open();

    monitorPlot_64.open();

    monitorPlot_65.open();

    monitorPlot_66.open();

    monitorPlot_67.open();

    monitorPlot_68.open();

    monitorPlot_69.open();

    monitorPlot_56.close();

    monitorPlot_55.close();

    monitorPlot_54.close();

    monitorPlot_53.close();

    monitorPlot_52.close();

    monitorPlot_51.close();

    monitorPlot_50.close();

    monitorPlot_49.close();

    monitorPlot_48.close();

    monitorPlot_47.close();

    monitorPlot_46.close();

    monitorPlot_45.close();

    monitorPlot_44.close();

    monitorPlot_43.close();

    monitorPlot_42.close();

    monitorPlot_41.close();

    monitorPlot_40.close();

    monitorPlot_39.close();

    monitorPlot_38.close();

    monitorPlot_37.close();

    monitorPlot_36.close();

    monitorPlot_35.close();

    monitorPlot_34.close();

    monitorPlot_33.close();

    monitorPlot_32.close();

    monitorPlot_31.close();

    monitorPlot_30.close();

    monitorPlot_29.close();

    monitorPlot_28.close();

    monitorPlot_27.close();

    monitorPlot_69.close();

    monitorPlot_68.close();

    monitorPlot_67.close();

    monitorPlot_58.close();

    monitorPlot_59.close();

    monitorPlot_60.close();

    monitorPlot_61.close();

    monitorPlot_62.close();

    monitorPlot_63.close();

    monitorPlot_64.close();

    monitorPlot_66.close();

    monitorPlot_65.close();

    monitorPlot_57.close();
  }
}
