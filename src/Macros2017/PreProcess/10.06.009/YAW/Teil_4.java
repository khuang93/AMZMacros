// STAR-CCM+ macro: Teil_4.java
// Written by STAR-CCM+ 10.06.009
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;
import star.flow.*;
import star.prismmesher.*;
import star.meshing.*;

public class Teil_4 extends StarMacro {

  public void execute() {
    execute0();
    execute1();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    BoundaryInterface boundaryInterface_0 = 
      ((BoundaryInterface) simulation_0.getInterfaceManager().getInterface("Interface 1"));

    BoundaryInterface boundaryInterface_1 = 
      ((BoundaryInterface) simulation_0.getInterfaceManager().getInterface("Interface 2"));

    simulation_0.getInterfaceManager().deleteInterfaces(boundaryInterface_0, boundaryInterface_1);

    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Geometry", 1);

    Scene scene_17 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 15");

    scene_17.initializeAndWait();

    PartDisplayer partDisplayer_2 = 
      ((PartDisplayer) scene_17.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_2.initialize();

    PartDisplayer partDisplayer_3 = 
      ((PartDisplayer) scene_17.getDisplayerManager().getDisplayer("Geometry 1"));

    partDisplayer_3.initialize();

    scene_17.open(true);

    CurrentView currentView_1 = 
      scene_17.getCurrentView();

    currentView_1.setInput(new DoubleVector(new double[] {-9.901968002319336, -1.3967914581298828, 7.492500000167638}), new DoubleVector(new double[] {-9.901968002319336, -1.3967914581298828, 153.61612105039472}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 38.14591969818383, 0);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 2");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 3");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 4");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 5");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 6");

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 7");

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 8");

    Boundary boundary_8 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 9");

    Boundary boundary_9 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 10");

    Boundary boundary_10 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 11");

    Boundary boundary_11 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 12");

    Boundary boundary_12 = 
      region_0.getBoundaryManager().getBoundary("FC6_inner_YAW.Surface");

    region_0.getBoundaryManager().removeBoundaries(new NeoObjectVector(new Object[] {boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12}));

    Boundary boundary_13 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface");

    Boundary boundary_14 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 2");

    Boundary boundary_15 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 3");

    Boundary boundary_16 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 4");

    Boundary boundary_17 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 5");

    Boundary boundary_18 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 6");

    Boundary boundary_19 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface");

    Boundary boundary_20 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 2");

    Boundary boundary_21 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 3");

    Boundary boundary_22 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 4");

    Boundary boundary_23 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 5");

    Boundary boundary_24 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 6");

    region_0.getBoundaryManager().removeBoundaries(new NeoObjectVector(new Object[] {boundary_13, boundary_14, boundary_15, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_22, boundary_23, boundary_24}));

    MeshPart meshPart_0 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Fan_Yaw"));

    MeshPart meshPart_1 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("FC6_inner_YAW"));

    MeshPart meshPart_2 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Outlet_Rear_Yaw"));

    MeshPart meshPart_3 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Outlet_Yaw"));

    simulation_0.get(SimulationPartManager.class).removeParts(new NeoObjectVector(new Object[] {meshPart_0, meshPart_1, meshPart_2, meshPart_3}));

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    PartImportManager partImportManager_0 = 
      simulation_0.get(PartImportManager.class);

    Units units_1 = 
      ((Units) simulation_0.getUnitsManager().getObject("mm"));

    partImportManager_0.importStlParts(new StringVector(new String[] {resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\FC6_inner_YAW.stl"), resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\Fan_Yaw_final.stl"), resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\Outlet_final_Rear_Yaw_V2.stl"), resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\Outlet_final_Yaw.stl")}), "OneSurfacePerPatch", "OnePartPerFile", units_1, true, 1.0E-5);

    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Geometry", 1);

    Scene scene_18 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 16");

    scene_18.initializeAndWait();

    PartDisplayer partDisplayer_4 = 
      ((PartDisplayer) scene_18.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_4.initialize();

    PartDisplayer partDisplayer_5 = 
      ((PartDisplayer) scene_18.getDisplayerManager().getDisplayer("Geometry 1"));

    partDisplayer_5.initialize();

    scene_18.open(true);

    CurrentView currentView_2 = 
      scene_18.getCurrentView();

    currentView_2.setInput(new DoubleVector(new double[] {-9.901968002319336, -1.3967914581298828, 7.492500000167638}), new DoubleVector(new double[] {-9.901968002319336, -1.3967914581298828, 153.61612105039472}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 38.14591969818383, 0);

    MeshPart meshPart_4 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Outlet_final_Rear_Yaw_V2"));

    PartSurface partSurface_0 = 
      ((PartSurface) meshPart_4.getPartSurfaceManager().getPartSurface("Surface"));

    meshPart_4.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_0}), 89.0);

    MeshPart meshPart_5 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Outlet_final_Yaw"));

    PartSurface partSurface_1 = 
      ((PartSurface) meshPart_5.getPartSurfaceManager().getPartSurface("Surface"));

    meshPart_5.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_1}), 89.0);

    MeshPart meshPart_6 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Fan_Yaw_final"));

    PartSurface partSurface_2 = 
      ((PartSurface) meshPart_6.getPartSurfaceManager().getPartSurface("Surface"));

    meshPart_6.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_2}), 89.0);

    FeatureCurve featureCurve_0 = 
      region_0.getFeatureCurveManager().createEmptyFeatureCurveWithName("Feature Curve");

    MeshPart meshPart_7 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("FC6_inner_YAW"));

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {meshPart_6, meshPart_7, meshPart_4, meshPart_5}), "OneRegion", region_0, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", featureCurve_0, true);

    Boundary boundary_25 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface");

    boundary_25.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_26 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 2");

    boundary_26.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_27 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 3");

    boundary_27.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_28 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 4");

    boundary_28.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_29 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 5");

    boundary_29.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_30 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 6");

    boundary_30.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_31 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 7");

    boundary_31.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_32 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 8");

    boundary_32.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.CUSTOM_VALUES);

    boundary_32.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_33 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 9");

    boundary_33.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_34 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 10");

    boundary_34.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_35 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 11");

    boundary_35.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_36 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 12");

    boundary_36.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_37 = 
      region_0.getBoundaryManager().getBoundary("FC6_inner_YAW.Surface");

    boundary_37.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_38 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface");

    boundary_38.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_39 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface 2");

    boundary_39.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_40 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface 3");

    boundary_40.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_41 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface 4");

    boundary_41.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_42 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface 5");

    boundary_42.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_43 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface 6");

    boundary_43.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_44 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface");

    boundary_44.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_45 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface 2");

    boundary_45.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_46 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface 3");

    boundary_46.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_47 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface 4");

    boundary_47.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_48 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface 5");

    boundary_48.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_49 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface 6");

    boundary_49.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    partDisplayer_4.setVisibilityOverrideMode(2);

    partDisplayer_5.getInputParts().setQuery(null);

    Boundary boundary_50 = 
      region_0.getBoundaryManager().getBoundary("Airduct.Surface");

    Boundary boundary_51 = 
      region_0.getBoundaryManager().getBoundary("Body_Driver.Surface");

    Boundary boundary_52 = 
      region_0.getBoundaryManager().getBoundary("Body_MC.Surface");

    Boundary boundary_53 = 
      region_0.getBoundaryManager().getBoundary("Body_QJ.Surface");

    Boundary boundary_54 = 
      region_0.getBoundaryManager().getBoundary("ContactP_FT_YAW_Final.Surface");

    Boundary boundary_55 = 
      region_0.getBoundaryManager().getBoundary("ContactP_RT_YAW.Surface");

    Boundary boundary_56 = 
      region_0.getBoundaryManager().getBoundary("Drivetrain.Surface");

    Boundary boundary_57 = 
      region_0.getBoundaryManager().getBoundary("FW_Endplates.Surface");

    Boundary boundary_58 = 
      region_0.getBoundaryManager().getBoundary("FW_Flap1.Surface");

    Boundary boundary_59 = 
      region_0.getBoundaryManager().getBoundary("FW_Main.Surface");

    Boundary boundary_60 = 
      region_0.getBoundaryManager().getBoundary("Headrest.Surface");

    Boundary boundary_61 = 
      region_0.getBoundaryManager().getBoundary("MRH.Surface");

    Boundary boundary_62 = 
      region_0.getBoundaryManager().getBoundary("RW_Endplates.Surface");

    Boundary boundary_63 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap1.Surface");

    Boundary boundary_64 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap2.Surface");

    Boundary boundary_65 = 
      region_0.getBoundaryManager().getBoundary("RW_Main.Surface");

    Boundary boundary_66 = 
      region_0.getBoundaryManager().getBoundary("RW_Support.Surface");

    Boundary boundary_67 = 
      region_0.getBoundaryManager().getBoundary("Sidepod.Surface");

    Boundary boundary_68 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface");

    Boundary boundary_69 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 2");

    InterfaceBoundary interfaceBoundary_0 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Subtract.Surface 2 [Interface 3]"));

    Boundary boundary_70 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 3");

    Boundary boundary_71 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 4");

    InterfaceBoundary interfaceBoundary_1 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Subtract.Surface 4 [Interface 4]"));

    Boundary boundary_72 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 5");

    Boundary boundary_73 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 6");

    Boundary boundary_74 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 7");

    Boundary boundary_75 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 8");

    InterfaceBoundary interfaceBoundary_2 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Subtract.Surface 8 [Interface 5]"));

    Boundary boundary_76 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 9");

    Boundary boundary_77 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 10");

    InterfaceBoundary interfaceBoundary_3 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Subtract.Surface 10 [Interface 6]"));

    Boundary boundary_78 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 11");

    Boundary boundary_79 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 12");

    Boundary boundary_80 = 
      region_0.getBoundaryManager().getBoundary("Susp_Brackets.Surface");

    Boundary boundary_81 = 
      region_0.getBoundaryManager().getBoundary("Susp_Legs.Surface");

    Boundary boundary_82 = 
      region_0.getBoundaryManager().getBoundary("Tire_Front.Surface");

    Boundary boundary_83 = 
      region_0.getBoundaryManager().getBoundary("Tire_Front_Right.Surface");

    Boundary boundary_84 = 
      region_0.getBoundaryManager().getBoundary("Tire_Rear.Surface");

    Boundary boundary_85 = 
      region_0.getBoundaryManager().getBoundary("Tire_Rear_Right.Surface");

    Boundary boundary_86 = 
      region_0.getBoundaryManager().getBoundary("TSAL.Surface");

    Boundary boundary_87 = 
      region_0.getBoundaryManager().getBoundary("Tubes.Surface");

    Boundary boundary_88 = 
      region_0.getBoundaryManager().getBoundary("UB_Diffusor.Surface");

    Boundary boundary_89 = 
      region_0.getBoundaryManager().getBoundary("UB_F1.Surface");

    Boundary boundary_90 = 
      region_0.getBoundaryManager().getBoundary("UB_F2.Surface");

    Boundary boundary_91 = 
      region_0.getBoundaryManager().getBoundary("UB_hor.Surface");

    Boundary boundary_92 = 
      region_0.getBoundaryManager().getBoundary("UB_MC.Surface");

    Boundary boundary_93 = 
      region_0.getBoundaryManager().getBoundary("UB_ver.Surface");

    Boundary boundary_94 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Front.Surface");

    Boundary boundary_95 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Front_Right.Surface");

    Boundary boundary_96 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Rear.Surface");

    Boundary boundary_97 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Rear_Right.Surface");

    partDisplayer_5.getInputParts().setObjects(boundary_50, boundary_51, boundary_52, boundary_53, boundary_54, boundary_55, boundary_56, boundary_25, boundary_26, boundary_27, boundary_28, boundary_29, boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_57, boundary_58, boundary_59, boundary_60, boundary_61, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_43, boundary_44, boundary_45, boundary_46, boundary_47, boundary_48, boundary_49, boundary_62, boundary_63, boundary_64, boundary_65, boundary_66, boundary_67, boundary_68, boundary_69, interfaceBoundary_0, boundary_70, boundary_71, interfaceBoundary_1, boundary_72, boundary_73, boundary_74, boundary_75, interfaceBoundary_2, boundary_76, boundary_77, interfaceBoundary_3, boundary_78, boundary_79, boundary_80, boundary_81, boundary_82, boundary_83, boundary_84, boundary_85, boundary_86, boundary_87, boundary_88, boundary_89, boundary_90, boundary_91, boundary_92, boundary_93, boundary_94, boundary_95, boundary_96, boundary_97);

    currentView_2.setInput(new DoubleVector(new double[] {-0.5232498049736023, 5.876719951629639E-4, 0.5722341467626393}), new DoubleVector(new double[] {-0.5232498049736023, 5.876719951629639E-4, 7.235317393589664}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 1.7394137693070992, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.5433661230891736, -0.47314027468541703, 0.6205156581654893}), new DoubleVector(new double[] {-0.8462529938841138, -7.605955263683204, 1.5619583972138151}), new DoubleVector(new double[] {-0.03684582898490848, 0.1323015072398623, 0.9905244550582664}), 1.879850973026656, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.6192674451510554, -0.5104286916376609, 0.8186625594518531}), new DoubleVector(new double[] {-1.9176077117875148, -7.536173716838282, 1.745973396839686}), new DoubleVector(new double[] {-0.03684582898490848, 0.1323015072398623, 0.9905244550582664}), 1.8516327203541145, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.9702812352196741, -1.0207298768215294, 0.8755045246389161}), new DoubleVector(new double[] {-8.688051310085266, -3.4157501536344026, 0.9804576603370223}), new DoubleVector(new double[] {-0.03337099166965438, 0.13698563906731567, 0.9900107633780063}), 1.8620113212400202, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.3268624965491105, -0.7002589103700179, 0.8108439030794187}), new DoubleVector(new double[] {-7.984808302230949, -3.073950630810192, 0.9148623916294817}), new DoubleVector(new double[] {-0.03337099166965438, 0.13698563906731567, 0.9900107633780063}), 1.8454294100903912, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.3439735936285988, -0.6207279954298057, 0.7603831616174527}), new DoubleVector(new double[] {-7.351834246983735, -2.76265127126322, 0.8542452330161244}), new DoubleVector(new double[] {-0.03337099166965438, 0.13698563906731567, 0.9900107633780063}), 1.665240761191659, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.3683791971150034, -0.5523608554336179, 0.7151091909375633}), new DoubleVector(new double[] {-6.782157597261242, -2.482481847670945, 0.7996897902641029}), new DoubleVector(new double[] {-0.03337099166965438, 0.13698563906731567, 0.9900107633780063}), 1.5005748275715838, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.4167194853364302, -0.42745448975278477, 0.6323298447521924}), new DoubleVector(new double[] {-5.756673585762444, -1.9747355004333187, 0.7001338610476858}), new DoubleVector(new double[] {-0.03337099166965438, 0.13698563906731567, 0.9900107633780063}), 1.2029354352109125, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.434713338214248, -0.377013399907997, 0.5991971358299092}), new DoubleVector(new double[] {-5.346479981162925, -1.7716369615382683, 0.660311489361119}), new DoubleVector(new double[] {-0.03337099166965438, 0.13698563906731567, 0.9900107633780063}), 1.0842517225279158, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.5215054050586487, -0.35282965498188434, 0.5696989544328777}), new DoubleVector(new double[] {-4.98431877427905, -1.5873923360018212, 0.6237992164821525}), new DoubleVector(new double[] {-0.03337099166965438, 0.13698563906731567, 0.9900107633780063}), 0.9598122033015088, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.6211388443625743, -0.3350598223202823, 0.5394582362842222}), new DoubleVector(new double[] {-4.66825909581708, -1.421419537938668, 0.5870640372680779}), new DoubleVector(new double[] {-0.03337099166965438, 0.13698563906731567, 0.9900107633780063}), 0.8445916341519842, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.63624390056628, -0.2924830352843939, 0.5110766446505618}), new DoubleVector(new double[] {-4.383805385201308, -1.2720440196818301, 0.5540023759754107}), new DoubleVector(new double[] {-0.03337099166965438, 0.13698563906731567, 0.9900107633780063}), 0.7615608353931078, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.6498393044347397, -0.2541642311654202, 0.48553322551132055}), new DoubleVector(new double[] {-4.127797045647113, -1.137606053250676, 0.5242468808120102}), new DoubleVector(new double[] {-0.03337099166965438, 0.13698563906731567, 0.9900107633780063}), 0.6868328799991124, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.66207577419789, -0.21967752360991755, 0.46254415775806745}), new DoubleVector(new double[] {-3.8973895400483376, -1.0166118834626374, 0.49746693516494983}), new DoubleVector(new double[] {-0.03337099166965438, 0.13698563906731567, 0.9900107633780063}), 0.6195775520972223, 0);

    BoundaryInterface boundaryInterface_2 = 
      simulation_0.getInterfaceManager().createBoundaryInterface(boundary_25, boundary_27, "Interface");

    BoundaryInterface boundaryInterface_3 = 
      simulation_0.getInterfaceManager().createBoundaryInterface(boundary_31, boundary_33, "Interface");

    boundaryInterface_2.setInterfaceType(FanInterface.class);

    boundaryInterface_2.getTopology().setSelected(InterfaceConfigurationOption.Type.REPEATING);

    boundaryInterface_2.getTopology().setSelected(InterfaceConfigurationOption.Type.PERIODIC);

    FanCurveTable fanCurveTable_0 = 
      boundaryInterface_2.getValues().get(FanCurveTable.class);

    FileTable fileTable_0 = 
      ((FileTable) simulation_0.getTableManager().getTable("Fan-curve-kuehlung"));

    fanCurveTable_0.setActiveTable(fileTable_0);

    fanCurveTable_0.setActiveTableX("column1");

    fanCurveTable_0.setActiveTableP("column0");

    Units units_2 = 
      ((Units) simulation_0.getUnitsManager().getObject("rpm"));

    fanCurveTable_0.getOperatingRotationRate().setUnits(units_2);

    fanCurveTable_0.getOperatingRotationRate().setValue(11000.0);

    fanCurveTable_0.getDataRotationRate().setUnits(units_2);

    fanCurveTable_0.getDataRotationRate().setValue(11000.0);

    boundaryInterface_3.setInterfaceType(FanInterface.class);

    boundaryInterface_3.getTopology().setSelected(InterfaceConfigurationOption.Type.PERIODIC);

    FanCurveTable fanCurveTable_1 = 
      boundaryInterface_3.getValues().get(FanCurveTable.class);

    fanCurveTable_1.setActiveTable(fileTable_0);

    fanCurveTable_1.setActiveTableX("column1");

    fanCurveTable_1.setActiveTableP("column0");

    fanCurveTable_1.getOperatingRotationRate().setUnits(units_2);

    fanCurveTable_1.getOperatingRotationRate().setValue(11000.0);

    fanCurveTable_1.getDataRotationRate().setUnits(units_2);

    fanCurveTable_1.getDataRotationRate().setValue(11000.0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.2070310190569062, -0.39032446599569154, 0.4327922985379526}), new DoubleVector(new double[] {-3.7924315040266885, -1.3120717893153808, 0.47318455443670954}), new DoubleVector(new double[] {-0.03337099166965438, 0.13698563906731567, 0.9900107633780063}), 0.7166135368289592, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.181781580002064, -0.418883551284725, 0.4074616943989252}), new DoubleVector(new double[] {-1.3809250452202038, -2.826002747454647, -1.1403382767890313}), new DoubleVector(new double[] {-0.5217652157473059, -0.43043423966751776, 0.7365374565886063}), 0.7488867084692904, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.181781580002064, -0.418883551284725, 0.4074616943989252}), new DoubleVector(new double[] {-1.3809250452202038, -2.826002747454647, -1.1403382767890313}), new DoubleVector(new double[] {-0.5217652157473059, -0.43043423966751776, 0.7365374565886063}), 0.7488867084692904, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.20660967018993515, -0.3104850508087689, 0.5586725663686719}), new DoubleVector(new double[] {-0.011202032219812308, -2.9432539917661917, -1.1342222838084055}), new DoubleVector(new double[] {-0.5217652157473059, -0.43043423966751776, 0.7365374565886063}), 0.81908933695139, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.6388233762851115, -0.20363063811214663, 0.3144593085652015}), new DoubleVector(new double[] {0.4218515913717887, -2.8262471920624033, -1.3719074625943584}), new DoubleVector(new double[] {-0.5217652157473059, -0.43043423966751776, 0.7365374565886063}), 0.8159307946984758, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.6408287359069244, -0.1308333029266563, 0.3370482912524998}), new DoubleVector(new double[] {0.6443863466299867, -3.2221553522295663, -0.08731707175880116}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.8145658772316515, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.5927003833822081, -0.16869414694373663, 0.3089323561828381}), new DoubleVector(new double[] {0.5958652270452054, -2.9187283017762806, -0.06858225529937563}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.72463623913054, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.5493419863302111, -0.1655092907842559, 0.28874287813865646}), new DoubleVector(new double[] {0.5521962194189022, -2.6456439563683234, -0.05172092048589266}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.6535175039364387, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.510319430016374, -0.1626438178129268, 0.27057222468347}), new DoubleVector(new double[] {0.5128941125552293, -2.399868045501162, -0.03654571915375799}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.5895104057507411, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.47516409212678035, -0.17559054663982243, 0.25223586747478616}), new DoubleVector(new double[] {0.4774695276214932, -2.178857382960998, -0.02276526299482529}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.5278624426157736, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.4428359917907012, -0.18057360829151126, 0.2352409078632395}), new DoubleVector(new double[] {0.44490725331593606, -1.9803591726096752, -0.011827059227606133}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.47424496174970804, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.41380062549421387, -0.18185454673165236, 0.2202752160715498}), new DoubleVector(new double[] {0.4156647946827786, -1.8016909382975104, -0.0020899879940602037}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.42682820819821526, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.33873552820537334, -0.17654987431207347, 0.1786706162623637}), new DoubleVector(new double[] {0.34004997095131717, -1.318711330241337, 0.02187887695709272}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.30096047369085893, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.3045316697386631, -0.1831037906804165, 0.15719636582434815}), new DoubleVector(new double[] {0.3055788574225698, -1.0930387523765068, 0.03228382867089599}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.23976860336012715, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.29084567644118986, -0.18185868703514452, 0.1491374679640614}), new DoubleVector(new double[] {0.2917904120110708, -1.0027697212305748, 0.0364458093564173}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.21631072597218748, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.26671345310329364, -0.18548139744202585, 0.1334504087295789}), new DoubleVector(new double[] {0.26746701275738644, -0.8402735474266227, 0.043562941816248625}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.17253826471327272, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.25718695978186984, -0.1877595892767565, 0.12702918848997005}), new DoubleVector(new double[] {0.2578630876555767, -0.7752687820585796, 0.04637807938810346}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.15480915070233495, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.24819130936174438, -0.19416916800034945, 0.12419874480180912}), new DoubleVector(new double[] {0.24879376291557925, -0.7176603815211884, 0.05233578930382332}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.13794036103770577, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.24008824135648435, -0.1938703601916869, 0.12248425985525913}), new DoubleVector(new double[] {0.24063137064958154, -0.6658128210375363, 0.057697728227971194}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.12435722273208376, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.23279548029446193, -0.1936015571705766, 0.1209412063801807}), new DoubleVector(new double[] {0.2332852176101836, -0.6191500166022493, 0.06252347325970428}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.11213236558116119, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.22623199549154704, -0.1933597673158839, 0.11955244001348499}), new DoubleVector(new double[] {0.22667367987472545, -0.5771534926104911, 0.06686664378826405}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.10112995913547793, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.22032485929464576, -0.19314226569064574, 0.11830253528684485}), new DoubleVector(new double[] {0.22072329591281312, -0.5393566210179087, 0.07077549726396785}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.09122776454848391, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.21500843682276938, -0.19294660575667572, 0.11717760846813811}), new DoubleVector(new double[] {0.21536795034709202, -0.5053394365845845, 0.07429346539210127}), new DoubleVector(new double[] {-0.5100900983218944, -0.11755334091578103, 0.8520500593471596}), 0.0823157653022906, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.21343201607690543, 0.21224537216863373, 0.17056066145750765}), new DoubleVector(new double[] {0.25884449688878614, -0.49661719410647676, 0.163247293067694}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.18543944220339115, 0);

    boundary_45.setBoundaryType(MassFlowBoundary.class);

    MassFlowRateProfile massFlowRateProfile_0 = 
      boundary_45.getValues().get(MassFlowRateProfile.class);

    massFlowRateProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.01685);

    boundary_48.setBoundaryType(MassFlowBoundary.class);

    MassFlowRateProfile massFlowRateProfile_1 = 
      boundary_48.getValues().get(MassFlowRateProfile.class);

    massFlowRateProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.01685);

    currentView_2.setInput(new DoubleVector(new double[] {0.22162222876332846, -0.14220710764355354, 0.15736918318651133}), new DoubleVector(new double[] {0.2423963104233984, -0.4664785100046706, 0.1540236598981114}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.0848298539621563, 0);
  }

  private void execute1() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_18 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 16");

    CurrentView currentView_2 = 
      scene_18.getCurrentView();

    currentView_2.setInput(new DoubleVector(new double[] {0.2089102680585425, -0.14744472078481408, 0.14869862595187994}), new DoubleVector(new double[] {0.22761068459742642, -0.4393474096751064, 0.14568705220063835}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.07636215308973981, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.17396742216990085, -0.14999760998953884, 0.12541842651486806}), new DoubleVector(new double[] {0.1878112209063357, -0.36609130326202743, 0.1231889777319798}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.05653041344063424, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.1597577136502866, -0.1685950923595679, 0.11483861841511177}), new DoubleVector(new double[] {0.17032839249650505, -0.3335972767863674, 0.11313628312862857}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.04316480302131187, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.16678703329197966, -0.1652382303278578, 0.1197978243687857}), new DoubleVector(new double[] {0.17855901499512242, -0.34899205771291186, 0.11790202750118306}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.048070259136519286, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.15310477967625938, -0.1694602345821004, 0.1101420756907212}), new DoubleVector(new double[] {0.162730745522415, -0.319715995346381, 0.10859187994976792}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.0393071178950654, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.1470765990053878, -0.16960605515298413, 0.10592171594274019}), new DoubleVector(new double[] {0.15589286324573398, -0.30722284205039324, 0.10450191708879333}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.036000744593098336, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.15267898809760028, -0.17482306333347195, 0.10955553000488538}), new DoubleVector(new double[] {0.16188085968750024, -0.3184589579847945, 0.10807363173353852}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.03757535162914632, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.15833157511227358, -0.17303044334420703, 0.11360333685914971}), new DoubleVector(new double[] {0.16844001955017027, -0.33081741593836167, 0.1119754412520249}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.04127729347957413, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.16464164136694273, -0.17249807063707376, 0.11804107291397754}), new DoubleVector(new double[] {0.17565509539910729, -0.34441171968728557, 0.1162674317223599}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.044972851866814934, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.19229739068446283, -0.16846134969965113, 0.1375845915321419}), new DoubleVector(new double[] {0.20740142913443022, -0.40422665618255066, 0.1351521897918339}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.06167653506495444, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.23101210993186502, -0.1627579641795368, 0.1649460538385482}), new DoubleVector(new double[] {0.25184629636388234, -0.4879675672759218, 0.16159085108909754}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.08507528859123695, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.256260958099818, -0.14493909519573855, 0.18341112386633343}), new DoubleVector(new double[] {0.28198835733245164, -0.5465289206707177, 0.17926790277520926}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.10505646196266372, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.2716383167538275, -0.13736194636649907, 0.19429570911625105}), new DoubleVector(new double[] {0.30010096227925054, -0.5816473848500053, 0.18971199538040864}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.11622569424761463, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.2887834267413939, -0.12633360124176213, 0.2072319626016673}), new DoubleVector(new double[] {0.3204341362932729, -0.6203828757201455, 0.20213483303257923}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.12924398358581843, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.30831466744602576, -0.12468601705166049, 0.22135368168900835}), new DoubleVector(new double[] {0.34280062770869746, -0.6629919156772998, 0.21579995444996689}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.14082157857548971, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.32979869289694147, -0.12286837778832005, 0.23688762733091395}), new DoubleVector(new double[] {0.36740376826566445, -0.7098618596301695, 0.2308315880090933}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.15355831867630806, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.3534307855697846, -0.12086374039794812, 0.25397502153850454}), new DoubleVector(new double[] {0.39446722287832814, -0.7614187979783261, 0.24736638492413238}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.16757010206145673, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.3794257422794724, -0.1186532504210025, 0.27277121076384736}), new DoubleVector(new double[] {0.42423702295225824, -0.8181314301612984, 0.26555466153067536}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.1829844735151989, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.4058032311608319, -0.078209682828003, 0.29520241447473267}), new DoubleVector(new double[] {0.45721523781775136, -0.8807213783934836, 0.2869228636195582}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.20993818585929416, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.43749587235833187, -0.07551447781185028, 0.31944556110841293}), new DoubleVector(new double[] {0.4934912741697938, -0.9495703214488874, 0.31042788591732934}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.22865423540472507, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.4723571893358482, -0.07254056865103997, 0.3461131171535378}), new DoubleVector(new double[] {0.5333949141570405, -1.0253041588098315, 0.3362834104448776}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.24924429235860782, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.5107040489092844, -0.06926007303519599, 0.3754475236739825}), new DoubleVector(new double[] {0.5772889181430119, -1.10861137990687, 0.36472448742518065}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.27189576057377457, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.5905542292177816, -0.02589719359877063, 0.43950223030334906}), new DoubleVector(new double[] {0.671660717717448, -1.2919225802672605, 0.4264405869269524}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.33119401797840514, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.6398633010715628, -0.02171647987183367, 0.4777097607825709}), new DoubleVector(new double[] {0.7282837974621096, -1.4019093004834948, 0.4634702466280155}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.36106037892826187, 0);

    currentView_2.setInput(new DoubleVector(new double[] {0.7440019281377843, 0.019204546979406878, 0.5602911217645327}), new DoubleVector(new double[] {0.8505433416715343, -1.6438453120442418, 0.5431333582595727}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.43505617715759753, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.26100607292789646, -0.16043508684068153, -0.04654302685582609}), new DoubleVector(new double[] {-0.1622167822410879, -1.7024787907915322, -0.062452364175534875}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.40340079716230515, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.733522891649494, -0.10761332083316309, 0.13378735549102855}), new DoubleVector(new double[] {-0.6293139708043393, -1.7342543177225282, 0.11700522392674367}), new DoubleVector(new double[] {-0.5125725762387433, -0.04168560769843999, 0.8576314267788868}), 0.42553156772460143, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.727741041278221, -0.2008547915173945, 0.10713588278164016}), new DoubleVector(new double[] {-0.6494906056118703, -1.5322948887177668, -0.8516151323544445}), new DoubleVector(new double[] {-0.4824261189398718, -0.5303487501958885, 0.6971335904475352}), 0.4287986560815803, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.6834865561097185, -0.14262316687157228, 0.14317056251160298}), new DoubleVector(new double[] {-0.5942725006440758, -1.6606105067413495, -0.9499104601525735}), new DoubleVector(new double[] {-0.4824261189398718, -0.5303487501958885, 0.6971335904475352}), 0.48887736868800036, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.6314416758340251, -0.1304712134806998, 0.14544484259941326}), new DoubleVector(new double[] {-0.533213683060574, -1.8018317258199466, -1.058078013016123}), new DoubleVector(new double[] {-0.4824261189398718, -0.5303487501958885, 0.6971335904475352}), 0.5382721633709636, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.5737720094476114, -0.1242554846235917, 0.1427969152920705}), new DoubleVector(new double[] {-0.46604898371872217, -1.9571750668064034, -1.1770623211660272}), new DoubleVector(new double[] {-0.4824261189398718, -0.5303487501958885, 0.6971335904475352}), 0.5903032777803753, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.5103354911381566, -0.11741623098173593, 0.13988560078863732}), new DoubleVector(new double[] {-0.39216781444268506, -2.128052741891506, -1.307945060130922}), new DoubleVector(new double[] {-0.4824261189398718, -0.5303487501958885, 0.6971335904475352}), 0.6475381322520876, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.4405554152689922, -0.10989144793985073, 0.13668430987818292}), new DoubleVector(new double[] {-0.31089852823904424, -2.3160181844851184, -1.4519160729923062}), new DoubleVector(new double[] {-0.4824261189398718, -0.5303487501958885, 0.6971335904475352}), 0.7104969887608014, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.3637974522075019, -0.10161213806607483, 0.13316436499225048}), new DoubleVector(new double[] {-0.22150231341503934, -2.522780171338092, -1.6102841871398288}), new DoubleVector(new double[] {-0.4824261189398718, -0.5303487501958885, 0.6971335904475352}), 0.7797523906616153, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.4235644730018069, -0.20699211160750508, 0.07439615595588389}), new DoubleVector(new double[] {-0.3001293285306165, -2.307255188140587, -1.4379733159512638}), new DoubleVector(new double[] {-0.4824261189398718, -0.5303487501958885, 0.6971335904475352}), 0.6764029313288874, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.48268761153043577, -0.21629800992704218, 0.08254827061883785}), new DoubleVector(new double[] {-0.3712507079937296, -2.112409647046315, -1.2828146628859847}), new DoubleVector(new double[] {-0.4824261189398718, -0.5303487501958885, 0.6971335904475352}), 0.6106546764567141, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.5926357182903899, -0.21118088333538565, 0.10894978314677406}), new DoubleVector(new double[] {-0.5018867056234141, -1.7552856952414266, -1.0029380584499314}), new DoubleVector(new double[] {-0.4824261189398718, -0.5303487501958885, 0.6971335904475352}), 0.4972886647973384, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.8634433318347376, -0.20373545754297318, 0.1617754646269401}), new DoubleVector(new double[] {-0.823354857895656, -0.8858454187660786, -0.32940218514656616}), new DoubleVector(new double[] {-0.4824261189398718, -0.5303487501958885, 0.6971335904475352}), 0.2196778024691779, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.8962320554972767, -0.26710090425800537, 0.1221375500039803}), new DoubleVector(new double[] {-0.8667194058384639, -0.7692620078449051, -0.23946149514881276}), new DoubleVector(new double[] {-0.4824261189398718, -0.5303487501958885, 0.6971335904475352}), 0.16172414125672885, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.925283584941904, -0.2698012725844382, 0.12498556480021822}), new DoubleVector(new double[] {-0.9014110441927101, -0.6759952791079662, -0.16750894315061005}), new DoubleVector(new double[] {-0.4824261189398718, -0.5303487501958885, 0.6971335904475352}), 0.13081733415714406, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.9369875401664971, -0.2750896799773348, 0.1228552310333551}), new DoubleVector(new double[] {-0.9156441064307708, -0.638250641902884, -0.1386517955584079}), new DoubleVector(new double[] {-0.4824261189398718, -0.5303487501958885, 0.6971335904475352}), 0.11695827153050974, 0);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");


    currentView_2.setInput(new DoubleVector(new double[] {-1.0713830168383331, 0.08935954577029281, 0.09674424134699251}), new DoubleVector(new double[] {-1.0363873902474057, -0.5060950363420119, -0.33203410644952125}), new DoubleVector(new double[] {-0.4824261189398718, -0.5303487501958885, 0.6971335904475352}), 0.19176989269307687, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.279973565009528, 0.10846716659905002, -0.1775740405831328}), new DoubleVector(new double[] {-1.8767778937224415, 0.7168701913724704, -0.5185099443897303}), new DoubleVector(new double[] {-0.7581558545459879, -0.5979705601123391, 0.26005943446946594}), 0.23962375592854165, 0);

    Boundary boundary_41 =
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface 4");

    boundary_41.setBoundaryType(MassFlowBoundary.class);
      
      MassFlowRateProfile massFlowRateProfile_2 =
      boundary_41.getValues().get(MassFlowRateProfile.class);

    massFlowRateProfile_2.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.05);
      
      Boundary boundary_38 =
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface");
      
      boundary_38.setBoundaryType(MassFlowBoundary.class);

    MassFlowRateProfile massFlowRateProfile_3 = 
      boundary_38.getValues().get(MassFlowRateProfile.class);

    massFlowRateProfile_3.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.05);

    currentView_2.setInput(new DoubleVector(new double[] {-1.0664377580051325, -0.10897098639276392, -0.06963164341510253}), new DoubleVector(new double[] {-1.9535176040139912, 0.7953489649910802, -0.5763929963360729}), new DoubleVector(new double[] {-0.7581558545459879, -0.5979705601123391, 0.26005943446946594}), 0.35617269225841597, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.0625455290476542, -0.11266644204560661, -0.08285655792204949}), new DoubleVector(new double[] {-2.037931285334696, 0.881675615971551, -0.6400643534770497}), new DoubleVector(new double[] {-0.7581558545459879, -0.5979705601123391, 0.26005943446946594}), 0.3916285240503566, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.0582640849451088, -0.11673143536242081, -0.09740396830741604}), new DoubleVector(new double[] {-2.130786334787471, 0.9766349320500688, -0.7101028463321243}), new DoubleVector(new double[] {-0.7581558545459879, -0.5979705601123391, 0.26005943446946594}), 0.43062993590950427, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.0580968244834084, -0.11701016375272899, -0.11645030691438463}), new DoubleVector(new double[] {-2.2323870647635453, 1.080102021557872, -0.7872860987133463}), new DoubleVector(new double[] {-0.7581558545459879, -0.5979705601123391, 0.26005943446946594}), 0.4714909466776251, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.0556555222194586, -0.12011748903047748, -0.1362275281804204}), new DoubleVector(new double[] {-2.344011758331623, 1.1932775272670635, -0.8722257048877851}), new DoubleVector(new double[] {-0.7581558545459879, -0.5979705601123391, 0.26005943446946594}), 0.5172897471051401, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.0502536310850241, -0.1263047989614008, -0.15643064254230643}), new DoubleVector(new double[] {-2.4667989212565082, 1.317770583547174, -0.9656592716796677}), new DoubleVector(new double[] {-0.7581558545459879, -0.5979705601123391, 0.26005943446946594}), 0.5687591167540946, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.0482176759796644, -0.12895117424830538, -0.1815512290437291}), new DoubleVector(new double[] {-2.601032027548626, 1.4540416140975545, -1.0686261695652934}), new DoubleVector(new double[] {-0.7581558545459879, -0.5979705601123391, 0.26005943446946594}), 0.6234727016561039, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.0414158885658944, -0.13651308943511076, -0.2065776090406537}), new DoubleVector(new double[] {-2.7486884444699555, 1.6039397477029729, -1.1818897572394818}), new DoubleVector(new double[] {-0.7581558545459879, -0.5979705601123391, 0.26005943446946594}), 0.6854894352420944, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.1299937778116895, -0.06644649184231821, -0.2886165830422518}), new DoubleVector(new double[] {-2.9099511341610436, 1.7481037509585868, -1.3054513156805414}), new DoubleVector(new double[] {-0.7581558545459879, -0.5979705601123391, 0.26005943446946594}), 0.7146732129790617, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.1310514905643325, -0.08762427400283457, -0.32380169570154305}), new DoubleVector(new double[] {-3.0873400928212402, 1.9066841545397621, -1.441369029965707}), new DoubleVector(new double[] {-0.7581558545459879, -0.5979705601123391, 0.26005943446946594}), 0.7854722226361326, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.1322148350799845, -0.11091997660303266, -0.36250523992771533}), new DoubleVector(new double[] {-3.2824679473474565, 2.081122598479055, -1.590878515679389}), new DoubleVector(new double[] {-0.7581558545459879, -0.5979705601123391, 0.26005943446946594}), 0.8633511892746751, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.133494576052648, -0.1365451862527487, -0.40507917399830373}), new DoubleVector(new double[] {-3.4971085873262946, 2.273004886812277, -1.7553389499644392}), new DoubleVector(new double[] {-0.7581558545459879, -0.5979705601123391, 0.26005943446946594}), 0.9490180276811765, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.1349019965967044, -0.16473321711732414, -0.45191033322240437}), new DoubleVector(new double[] {-3.7332132913030165, 2.4840754039788218, -1.9362454276779946}), new DoubleVector(new double[] {-0.7581558545459879, -0.5979705601123391, 0.26005943446946594}), 1.0432516681838313, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-1.063603584043123, -0.08315467947618757, -0.40411193022130437}), new DoubleVector(new double[] {-2.583144667327451, -3.63757173224062, -1.5060045970973304}), new DoubleVector(new double[] {0.2465427762280895, -0.3815696379236679, 0.8908542366204176}), 1.0493219098864937, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.2494596928496088, 0.2010330011037864, -0.22826773015301294}), new DoubleVector(new double[] {-1.9985730876579657, -3.8903854844615733, -1.496634373526832}), new DoubleVector(new double[] {0.2465427762280895, -0.3815696379236679, 0.8908542366204176}), 1.20785349487318, 0);

    currentView_2.setInput(new DoubleVector(new double[] {-0.19349719923219597, -0.19715338936131005, -0.23528695152059462}), new DoubleVector(new double[] {3.7468835701972765, -1.115957701835414, 1.7101836303882287}), new DoubleVector(new double[] {-0.21899636294010463, 0.6330151792487142, 0.7425175929631057}), 1.1719960611681213, 0);

    ForceReport forceReport_0 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 1"));

    Boundary boundary_37 = 
      region_0.getBoundaryManager().getBoundary("FC6_inner_YAW.Surface");

    forceReport_0.getParts().setObjects(boundary_37);

    ForceReport forceReport_1 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag"));

    Boundary boundary_50 = 
      region_0.getBoundaryManager().getBoundary("Airduct.Surface");

    Boundary boundary_51 = 
      region_0.getBoundaryManager().getBoundary("Body_Driver.Surface");

    Boundary boundary_52 = 
      region_0.getBoundaryManager().getBoundary("Body_MC.Surface");

    Boundary boundary_53 = 
      region_0.getBoundaryManager().getBoundary("Body_QJ.Surface");

    Boundary boundary_56 = 
      region_0.getBoundaryManager().getBoundary("Drivetrain.Surface");

    Boundary boundary_25 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface");

    Boundary boundary_26 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 2");

    Boundary boundary_27 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 3");

    Boundary boundary_28 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 4");

    Boundary boundary_29 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 5");

    Boundary boundary_30 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 6");

    Boundary boundary_31 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 7");

    Boundary boundary_32 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 8");

    Boundary boundary_33 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 9");

    Boundary boundary_34 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 10");

    Boundary boundary_35 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 11");

    Boundary boundary_36 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw_final.Surface 12");

    Boundary boundary_57 = 
      region_0.getBoundaryManager().getBoundary("FW_Endplates.Surface");

    Boundary boundary_58 = 
      region_0.getBoundaryManager().getBoundary("FW_Flap1.Surface");

    Boundary boundary_59 = 
      region_0.getBoundaryManager().getBoundary("FW_Main.Surface");

    Boundary boundary_60 = 
      region_0.getBoundaryManager().getBoundary("Headrest.Surface");

    Boundary boundary_61 = 
      region_0.getBoundaryManager().getBoundary("MRH.Surface");

    Boundary boundary_39 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface 2");
      
    Boundary boundary_40 =
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface 3");

    Boundary boundary_42 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface 5");
      
    Boundary boundary_43 =
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_Yaw_V2.Surface 6");

    Boundary boundary_44 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface");

    Boundary boundary_45 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface 2");

    Boundary boundary_46 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface 3");

    Boundary boundary_47 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface 4");

    Boundary boundary_48 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface 5");

    Boundary boundary_49 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Yaw.Surface 6");

    Boundary boundary_62 = 
      region_0.getBoundaryManager().getBoundary("RW_Endplates.Surface");

    Boundary boundary_63 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap1.Surface");

    Boundary boundary_64 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap2.Surface");

    Boundary boundary_65 = 
      region_0.getBoundaryManager().getBoundary("RW_Main.Surface");

    Boundary boundary_66 = 
      region_0.getBoundaryManager().getBoundary("RW_Support.Surface");

    Boundary boundary_67 = 
      region_0.getBoundaryManager().getBoundary("Sidepod.Surface");

    Boundary boundary_68 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface");

    Boundary boundary_69 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 2");

    Boundary boundary_70 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 3");

    Boundary boundary_71 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 4");

    Boundary boundary_72 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 5");

    Boundary boundary_73 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 6");

    Boundary boundary_74 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 7");

    Boundary boundary_75 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 8");

    Boundary boundary_76 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 9");

    Boundary boundary_77 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 10");

    Boundary boundary_78 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 11");

    Boundary boundary_79 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 12");

    Boundary boundary_80 = 
      region_0.getBoundaryManager().getBoundary("Susp_Brackets.Surface");

    Boundary boundary_81 = 
      region_0.getBoundaryManager().getBoundary("Susp_Legs.Surface");

    Boundary boundary_82 = 
      region_0.getBoundaryManager().getBoundary("Tire_Front.Surface");

    Boundary boundary_83 = 
      region_0.getBoundaryManager().getBoundary("Tire_Front_Right.Surface");

    Boundary boundary_84 = 
      region_0.getBoundaryManager().getBoundary("Tire_Rear.Surface");

    Boundary boundary_85 = 
      region_0.getBoundaryManager().getBoundary("Tire_Rear_Right.Surface");

    Boundary boundary_86 = 
      region_0.getBoundaryManager().getBoundary("TSAL.Surface");

    Boundary boundary_87 = 
      region_0.getBoundaryManager().getBoundary("Tubes.Surface");

    Boundary boundary_88 = 
      region_0.getBoundaryManager().getBoundary("UB_Diffusor.Surface");

    Boundary boundary_89 = 
      region_0.getBoundaryManager().getBoundary("UB_F1.Surface");

    Boundary boundary_90 = 
      region_0.getBoundaryManager().getBoundary("UB_F2.Surface");

    Boundary boundary_91 = 
      region_0.getBoundaryManager().getBoundary("UB_hor.Surface");

    Boundary boundary_92 = 
      region_0.getBoundaryManager().getBoundary("UB_MC.Surface");

    Boundary boundary_93 = 
      region_0.getBoundaryManager().getBoundary("UB_ver.Surface");

    Boundary boundary_94 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Front.Surface");

    Boundary boundary_95 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Front_Right.Surface");

    Boundary boundary_96 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Rear.Surface");

    Boundary boundary_97 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Rear_Right.Surface");

    forceReport_1.getParts().setObjects(boundary_50, boundary_51, boundary_52, boundary_53, boundary_56, boundary_25, boundary_26, boundary_27, boundary_28, boundary_29, boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_57, boundary_58, boundary_59, boundary_60, boundary_61, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_43, boundary_44, boundary_45, boundary_46, boundary_47, boundary_48, boundary_49, boundary_62, boundary_63, boundary_64, boundary_65, boundary_66, boundary_67, boundary_68, boundary_69, boundary_70, boundary_71, boundary_72, boundary_73, boundary_74, boundary_75, boundary_76, boundary_77, boundary_78, boundary_79, boundary_80, boundary_81, boundary_82, boundary_83, boundary_84, boundary_85, boundary_86, boundary_87, boundary_88, boundary_89, boundary_90, boundary_91, boundary_92, boundary_93, boundary_94, boundary_95, boundary_96, boundary_97);

    ForceReport forceReport_2 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift"));

    forceReport_2.getParts().setObjects(boundary_50, boundary_51, boundary_52, boundary_53, boundary_56, boundary_25, boundary_26, boundary_27, boundary_28, boundary_29, boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_57, boundary_58, boundary_59, boundary_60, boundary_61, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_43, boundary_44, boundary_45, boundary_46, boundary_47, boundary_48, boundary_49, boundary_62, boundary_63, boundary_64, boundary_65, boundary_66, boundary_67, boundary_68, boundary_69, boundary_70, boundary_71, boundary_72, boundary_73, boundary_74, boundary_75, boundary_76, boundary_77, boundary_78, boundary_79, boundary_80, boundary_81, boundary_82, boundary_83, boundary_84, boundary_85, boundary_86, boundary_87, boundary_88, boundary_89, boundary_90, boundary_91, boundary_92, boundary_93, boundary_94, boundary_95, boundary_96, boundary_97);
      
      StepStoppingCriterion stepStoppingCriterion_0 =
      ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps"));
      
      stepStoppingCriterion_0.setMaximumNumberSteps(2000);
  }
}
