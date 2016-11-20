// STAR-CCM+ macro: update_HB.java
// Written by STAR-CCM+ 10.06.009
package macro;

import java.util.*;

import star.turbulence.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;
import star.surfacewrapper.*;
import star.prismmesher.*;
import star.meshing.*;

public class update_HB extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();
      
      Units units_0 =
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
      
      PartImportManager partImportManager_0 =
      simulation_0.get(PartImportManager.class);
      
      Units units_1 =
      ((Units) simulation_0.getUnitsManager().getObject("mm"));
      
      partImportManager_0.importStlPart(resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\Outlet_final.stl"), "OneSurfacePerPatch", units_1, true, 1.0E-5);
      
      
      partImportManager_0.importStlPart(resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\Outlet_final_Rear_V2.stl"), "OneSurfacePerPatch", units_1, true, 1.0E-5);
      
      MeshPart meshPart_0 =
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Outlet_final"));
      
      PartSurface partSurface_0 =
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface"));
      
      meshPart_0.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_0}), 89.0);
      
      MeshPart meshPart_5 =
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Outlet_final_Rear_V2"));
      
      PartSurface partSurface_30 =
      ((PartSurface) meshPart_5.getPartSurfaceManager().getPartSurface("Surface"));
      
      meshPart_5.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_30}), 89.0);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    FeatureCurve featureCurve_0 = 
      region_0.getFeatureCurveManager().createEmptyFeatureCurveWithName("Feature Curve");

    MeshPart meshPart_1 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Body_QJ"));

    MeshPart meshPart_2 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Outlet_final"));

    MeshPart meshPart_3 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Outlet_final_Rear_V2"));

    MeshPart meshPart_4 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Tubes"));

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {meshPart_1, meshPart_2, meshPart_3, meshPart_4}), "OneRegion", region_0, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", featureCurve_0, true);

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final.Surface 2");

    boundary_0.setBoundaryType(InletBoundary.class);

    VelocityMagnitudeProfile velocityMagnitudeProfile_0 = 
      boundary_0.getValues().get(VelocityMagnitudeProfile.class);

    velocityMagnitudeProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(10.0);

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface");

    boundary_1.setBoundaryType(InletBoundary.class);

    VelocityMagnitudeProfile velocityMagnitudeProfile_1 = 
      boundary_1.getValues().get(VelocityMagnitudeProfile.class);

    velocityMagnitudeProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(10.0);

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface");

    boundary_2.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 2");

    boundary_3.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 3");

    boundary_4.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 4");

    boundary_5.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 5");

    boundary_6.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 6");

    boundary_7.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    boundary_0.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);
      
    Boundary boundary_8 =
    region_0.getBoundaryManager().getBoundary("Outlet_final.Surface");
      
    boundary_8.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    boundary_0.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_9 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final.Surface 3");

    boundary_9.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_10 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface 3");

    boundary_10.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_11 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface 2");

    boundary_11.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    boundary_1.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_12 = 
      region_0.getBoundaryManager().getBoundary("Body_QJ.Surface");

    boundary_12.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_13 = 
      region_0.getBoundaryManager().getBoundary("Tubes.Surface");

    boundary_13.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_0 = 
      ((OneGroupContactPreventionSet) region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).getObject("Contact Prevention 1"));

    oneGroupContactPreventionSet_0.getFloor().setValue(0.001);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_1 = 
      ((OneGroupContactPreventionSet) region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).getObject("Contact Prevention 3"));

    oneGroupContactPreventionSet_1.getFloor().setValue(0.005);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_2 = 
      ((OneGroupContactPreventionSet) region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).getObject("Contact Prevention 7"));

    Boundary boundary_14 = 
      region_0.getBoundaryManager().getBoundary("Airduct.Surface");

    Boundary boundary_15 = 
      region_0.getBoundaryManager().getBoundary("UB_Diffusor.Surface");

    oneGroupContactPreventionSet_2.getBoundaryGroup().setObjects(boundary_14, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_15);

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 15");

    HighlightDisplayer highlightDisplayer_0 = 
      scene_0.getHighlightDisplayer();

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_14, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_15);

    oneGroupContactPreventionSet_2.getFloor().setValue(0.001);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_3 = 
      ((OneGroupContactPreventionSet) region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).getObject("Contact Prevention 8"));

    Boundary boundary_16 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface");

    Boundary boundary_17 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 2");

    Boundary boundary_18 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 3");

    Boundary boundary_19 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 4");

    Boundary boundary_20 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 5");

    Boundary boundary_21 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 6");

    oneGroupContactPreventionSet_3.getBoundaryGroup().setObjects(boundary_14, boundary_12, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_14, boundary_12, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_4 = 
      ((OneGroupContactPreventionSet) region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).getObject("Contact Prevention 10"));

    oneGroupContactPreventionSet_4.getFloor().setValue(0.001);

    Boundary boundary_22 = 
      region_0.getBoundaryManager().getBoundary("FW_Endplates.Surface");

    Boundary boundary_23 = 
      region_0.getBoundaryManager().getBoundary("FW_Flap1.Surface");

    Boundary boundary_24 = 
      region_0.getBoundaryManager().getBoundary("FW_Main.Surface");

    Boundary boundary_25 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Floor");

    Boundary boundary_26 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Symmetry");

    Boundary boundary_27 = 
      region_0.getBoundaryManager().getBoundary("UB_hor.Surface");

    Boundary boundary_28 = 
      region_0.getBoundaryManager().getBoundary("UB_MC.Surface");

    Boundary boundary_29 = 
      region_0.getBoundaryManager().getBoundary("UB_ver.Surface");

    oneGroupContactPreventionSet_4.getBoundaryGroup().setObjects(boundary_22, boundary_23, boundary_24, boundary_25, boundary_26, boundary_15, boundary_27, boundary_28, boundary_29);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_22, boundary_23, boundary_24, boundary_25, boundary_26, boundary_15, boundary_27, boundary_28, boundary_29);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_5 = 
      ((OneGroupContactPreventionSet) region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).getObject("Contact Prevention 11"));

    oneGroupContactPreventionSet_5.getBoundaryGroup().setObjects(boundary_14, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_14, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21);

    oneGroupContactPreventionSet_3.getBoundaryGroup().setObjects(boundary_14, boundary_12, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_15);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_14, boundary_12, boundary_16, boundary_17, boundary_18, boundary_19, boundary_20, boundary_21, boundary_15);

    region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).remove(oneGroupContactPreventionSet_5);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_6 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_6.getFloor().setValue(0.001);

    Boundary boundary_30 = 
      region_0.getBoundaryManager().getBoundary("UB_F1.Surface");

    Boundary boundary_31 = 
      region_0.getBoundaryManager().getBoundary("UB_F2.Surface");

    oneGroupContactPreventionSet_6.getBoundaryGroup().setObjects(boundary_30, boundary_31);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_30, boundary_31);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_7 = 
      ((OneGroupContactPreventionSet) region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).getObject("Contact Prevention 5"));

    oneGroupContactPreventionSet_7.getBoundaryGroup().setObjects(boundary_22, boundary_23, boundary_24);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_22, boundary_23, boundary_24);

    Boundary boundary_32 = 
      region_0.getBoundaryManager().getBoundary("ContactP_FT_HB.Surface");

    Boundary boundary_33 = 
      region_0.getBoundaryManager().getBoundary("ContactP_RT_HB.Surface");

    Boundary boundary_34 = 
      region_0.getBoundaryManager().getBoundary("Tire_Front.Surface");

    Boundary boundary_35 = 
      region_0.getBoundaryManager().getBoundary("Tire_Rear.Surface");

    oneGroupContactPreventionSet_0.getBoundaryGroup().setObjects(boundary_32, boundary_33, boundary_25, boundary_34, boundary_35);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_32, boundary_33, boundary_25, boundary_34, boundary_35);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_8 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_8.getFloor().setValue(0.001);

    Boundary boundary_36 = 
      region_0.getBoundaryManager().getBoundary("Drivetrain.Surface");

    Boundary boundary_37 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Front.Surface");

    Boundary boundary_38 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Rear.Surface");

    oneGroupContactPreventionSet_8.getBoundaryGroup().setObjects(boundary_36, boundary_37, boundary_38);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_36, boundary_37, boundary_38);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_9 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    Boundary boundary_39 = 
      region_0.getBoundaryManager().getBoundary("Body_MC.Surface");

    oneGroupContactPreventionSet_9.getBoundaryGroup().setObjects(boundary_14, boundary_39);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_14, boundary_39);

    oneGroupContactPreventionSet_9.getFloor().setValue(0.001);
      
      
      OneGroupContactPreventionSet oneGroupContactPreventionSet_14 =
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();
      
      
      oneGroupContactPreventionSet_14.getBoundaryGroup().setObjects(boundary_29, boundary_39);
      
      highlightDisplayer_0.getVisibleParts().setObjects(boundary_29, boundary_39);
      
      oneGroupContactPreventionSet_14.getFloor().setValue(0.001);

    BoundaryInterface boundaryInterface_0 = 
      ((BoundaryInterface) simulation_0.getInterfaceManager().getInterface("Interface 1"));

    BoundaryInterface boundaryInterface_1 = 
      ((BoundaryInterface) simulation_0.getInterfaceManager().getInterface("Interface 2"));

    simulation_0.getInterfaceManager().deleteInterfaces(boundaryInterface_0, boundaryInterface_1);

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {-1.8607210083007812, 0.18296415710449218, 0.2744295425415039}), new DoubleVector(new double[] {-1.8607210083007812, 0.18296415710449218, 1.0526170699867718}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.2031477095811354, 0);

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("RegionRadiator");

    Boundary boundary_40 = 
      region_1.getBoundaryManager().getBoundary("Radiator.Surface 2");

    BoundaryInterface boundaryInterface_2 = 
      simulation_0.getInterfaceManager().createBoundaryInterface(boundary_17, boundary_40, "Interface");

    Boundary boundary_41 = 
      region_1.getBoundaryManager().getBoundary("Radiator.Surface 4");

    BoundaryInterface boundaryInterface_3 = 
      simulation_0.getInterfaceManager().createBoundaryInterface(boundary_19, boundary_41, "Interface");

    currentView_0.setInput(new DoubleVector(new double[] {-0.9255397379321919, 0.6275350503689365, 0.7174363211086138}), new DoubleVector(new double[] {-0.6035310390096321, 7.033683301400994, 0.5046925765803927}), new DoubleVector(new double[] {0.026645380886190968, 0.03184132559035939, 0.999137705054753}), 1.675372394794921, 0);

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    CartesianCoordinateSystem cartesianCoordinateSystem_0 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("frtwe_coord"));

    Coordinate coordinate_0 = 
      cartesianCoordinateSystem_0.getOrigin();

    Units units_2 =
      ((Units) simulation_0.getUnitsManager().getObject("m"));

    coordinate_0.setCoordinate(units_2, units_2, units_2, new DoubleVector(new double[] {0.0, 0.697221, 0.4353352}));

    coordinate_0.setCoordinate(units_2, units_2, units_2, new DoubleVector(new double[] {0.0, 0.697221, 0.2553352}));

    CartesianCoordinateSystem cartesianCoordinateSystem_1 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("rewe_coord"));

    Coordinate coordinate_1 = 
      cartesianCoordinateSystem_1.getOrigin();

    coordinate_1.setCoordinate(units_2, units_2, units_2, new DoubleVector(new double[] {-1.5301, 0.6890185, 0.2303102}));

    WallRelativeRotationProfile wallRelativeRotationProfile_0 = 
      boundary_34.getValues().get(WallRelativeRotationProfile.class);

    wallRelativeRotationProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.2672);

    WallRelativeRotationProfile wallRelativeRotationProfile_1 = 
      boundary_35.getValues().get(WallRelativeRotationProfile.class);

    wallRelativeRotationProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.2672);

    WallRelativeRotationProfile wallRelativeRotationProfile_2 = 
      boundary_37.getValues().get(WallRelativeRotationProfile.class);

    wallRelativeRotationProfile_2.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.2672);

    WallRelativeRotationProfile wallRelativeRotationProfile_3 = 
      boundary_38.getValues().get(WallRelativeRotationProfile.class);

    wallRelativeRotationProfile_3.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.2672);

    MeshContinuum meshContinuum_0 = 
      ((MeshContinuum) simulation_0.getContinuumManager().getContinuum("Mesh 1"));

    meshContinuum_0.setMeshInParallel(true);

    MeshContinuum meshContinuum_1 = 
      ((MeshContinuum) simulation_0.getContinuumManager().getContinuum("MeshRadiator 2"));

    meshContinuum_1.setMeshInParallel(true);

    MeshContinuum meshContinuum_2 = 
      ((MeshContinuum) simulation_0.getContinuumManager().getContinuum("MeshRadiator"));

    meshContinuum_2.setMeshInParallel(true);

    simulation_0.getContinuumManager().remove(meshContinuum_2);

    PhysicsContinuum physicsContinuum_0 = 
      ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 1"));

    TurbulentViscosityRatioProfile turbulentViscosityRatioProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(TurbulentViscosityRatioProfile.class);

    turbulentViscosityRatioProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(10.0);

    TurbulenceIntensityProfile turbulenceIntensityProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(TurbulenceIntensityProfile.class);

    turbulenceIntensityProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.01);

    SimpleBlockPart simpleBlockPart_0 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block"));

    Coordinate coordinate_2 = 
      simpleBlockPart_0.getCorner2();

    coordinate_2.setCoordinate(units_2, units_2, units_2, new DoubleVector(new double[] {1.1, 1.2, 0.93}));

    SimpleBlockPart simpleBlockPart_1 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block_4Verf"));

    Coordinate coordinate_3 = 
      simpleBlockPart_1.getCorner2();

    coordinate_3.setCoordinate(units_2, units_2, units_2, new DoubleVector(new double[] {1.4, 1.4, 1.6}));

    SimpleBlockPart simpleBlockPart_2 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block 3"));

    Coordinate coordinate_4 = 
      simpleBlockPart_2.getCorner2();

    coordinate_4.setCoordinate(units_2, units_2, units_2, new DoubleVector(new double[] {-0.23252013325691223, 1.2, 1.4}));
  }
}
