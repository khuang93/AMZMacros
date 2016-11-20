// STAR-CCM+ macro: Teil_1.java
// Written by STAR-CCM+ 10.06.009
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.resurfacer.*;
import star.vis.*;
import star.trimmer.*;
import star.meshing.*;

public class Teil_1 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    MeshPart meshPart_0 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("export_Tessellation (E0000-0000-rfmt-frt-whl-tyre-contactpatch).1_6"));

    MeshPart meshPart_1 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("export_Tessellation (E0000-0000-rfmt-frt-whl-tyre-contactpatch).1_6 2"));

    MeshPart meshPart_2 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("export_Tessellation (E0000-0000-rfmt-rr-whl-tyre-contactpatch).1_6"));

    MeshPart meshPart_3 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("export_Tessellation (E0000-0000-rfmt-rr-whl-tyre-contactpatch).1_6 2"));

    simulation_0.get(SimulationPartManager.class).removeParts(new NeoObjectVector(new Object[] {meshPart_0, meshPart_1, meshPart_2, meshPart_3}));

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    PartImportManager partImportManager_0 = 
      simulation_0.get(PartImportManager.class);

    Units units_1 = 
      ((Units) simulation_0.getUnitsManager().getObject("mm"));

    partImportManager_0.importStlParts(new StringVector(new String[] {resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\ContactP_FT_YAW_Final.stl"), resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\ContactP_RT_YAW.stl"), resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\Outlet_Rear_Yaw.stl"), resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\Outlet_Yaw.stl")}), "OneSurfacePerPatch", "OnePartPerFile", units_1, true, 1.0E-5);

    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Geometry", 1);

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 13");

    scene_0.initializeAndWait();

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_0.initialize();

    PartDisplayer partDisplayer_1 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Geometry 1"));

    partDisplayer_1.initialize();

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    scene_1.initializeAndWait();

    Scene scene_2 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 2");

    scene_2.initializeAndWait();

    Scene scene_3 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 3");

    scene_3.initializeAndWait();

    Scene scene_4 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 4");

    scene_4.initializeAndWait();

    Scene scene_5 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 5");

    scene_5.initializeAndWait();

    Scene scene_6 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 6");

    scene_6.initializeAndWait();

    Scene scene_7 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 7");

    scene_7.initializeAndWait();

    Scene scene_8 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 8");

    scene_8.initializeAndWait();

    Scene scene_9 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 9");

    scene_9.initializeAndWait();

    Scene scene_10 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 10");

    scene_10.initializeAndWait();

    Scene scene_11 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 11");

    scene_11.initializeAndWait();

    Scene scene_12 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 12");

    scene_12.initializeAndWait();

    Scene scene_13 = 
      simulation_0.getSceneManager().getScene("Mesh Scene 1");

    scene_13.initializeAndWait();

    Scene scene_14 = 
      simulation_0.getSceneManager().getScene("Mesh Scene 2");

    scene_14.initializeAndWait();

    Scene scene_15 = 
      simulation_0.getSceneManager().getScene("Mesh Scene 3");

    scene_15.initializeAndWait();

    scene_0.open(true);

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {-10.0, 0.0, 7.492500000167638}), new DoubleVector(new double[] {-10.0, 0.0, 140.29167292040916}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 34.667540742502624, 0);

    SimpleBlockPart simpleBlockPart_0 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block"));

    Coordinate coordinate_0 = 
      simpleBlockPart_0.getCorner2();

    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.1, 1.2, 0.93}));

    SimpleBlockPart simpleBlockPart_1 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block 3"));

    Coordinate coordinate_1 = 
      simpleBlockPart_1.getCorner2();

    coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-0.23252013325691223, 1.2, 1.4}));

    MeshContinuum meshContinuum_0 = 
      simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

    meshContinuum_0.setPresentationName("Mesh Radiator");

    meshContinuum_0.enable(TrimmerMeshingModel.class);

    meshContinuum_0.enable(ResurfacerMeshingModel.class);

    MaximumCellSize maximumCellSize_0 = 
      meshContinuum_0.getReferenceValues().get(MaximumCellSize.class);

    GenericRelativeSize genericRelativeSize_0 = 
      ((GenericRelativeSize) maximumCellSize_0.getRelativeSize());

    genericRelativeSize_0.setPercentage(0.5);

    SurfaceSize surfaceSize_0 = 
      meshContinuum_0.getReferenceValues().get(SurfaceSize.class);

    RelativeMinimumSize relativeMinimumSize_0 = 
      surfaceSize_0.getRelativeMinimumSize();

    relativeMinimumSize_0.setPercentage(0.08);

    partImportManager_0.importStlParts(new StringVector(new String[] {resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\FC6_inner_YAW.stl"), resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\Fan_Yaw.stl")}), "OneSurfacePerPatch", "OnePartPerFile", units_1, true, 1.0E-5);

    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Geometry", 1);

    Scene scene_16 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 14");

    scene_16.initializeAndWait();

    PartDisplayer partDisplayer_2 = 
      ((PartDisplayer) scene_16.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_2.initialize();

    PartDisplayer partDisplayer_3 = 
      ((PartDisplayer) scene_16.getDisplayerManager().getDisplayer("Geometry 1"));

    partDisplayer_3.initialize();

    scene_16.open(true);

    CurrentView currentView_1 = 
      scene_16.getCurrentView();

    currentView_1.setInput(new DoubleVector(new double[] {-10.0, 0.0, 7.492500000167638}), new DoubleVector(new double[] {-10.0, 0.0, 140.29167292040916}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 34.667540742502624, 0);

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    CartesianCoordinateSystem cartesianCoordinateSystem_0 = 
      labCoordinateSystem_0.getLocalCoordinateSystemManager().createLocalCoordinateSystem(CartesianCoordinateSystem.class, "Cartesian");

    Coordinate coordinate_2 = 
      cartesianCoordinateSystem_0.getOrigin();

    coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    coordinate_2.setValue(new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    cartesianCoordinateSystem_0.setBasis0(new DoubleVector(new double[] {1.0, -0.1051042, 0.0}));

    cartesianCoordinateSystem_0.setBasis1(new DoubleVector(new double[] {1.1051042, 1.0, 0.0}));

    cartesianCoordinateSystem_0.setPresentationName("YAW");

    simpleBlockPart_0.setCoordinateSystem(cartesianCoordinateSystem_0);

    simpleBlockPart_1.setCoordinateSystem(cartesianCoordinateSystem_0);

    SimpleBlockPart simpleBlockPart_2 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block_1Verf"));

    simpleBlockPart_2.setCoordinateSystem(cartesianCoordinateSystem_0);

    SimpleBlockPart simpleBlockPart_3 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block_2Verf"));

    simpleBlockPart_3.setCoordinateSystem(cartesianCoordinateSystem_0);

    SimpleBlockPart simpleBlockPart_4 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block_4Verf"));

    simpleBlockPart_4.setCoordinateSystem(cartesianCoordinateSystem_0);

    SimpleBlockPart simpleBlockPart_5 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block_vorFahrzeug"));

    simpleBlockPart_5.setCoordinateSystem(cartesianCoordinateSystem_0);

    SimpleBlockPart simpleBlockPart_6 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("BlockKanal"));

    simpleBlockPart_6.setCoordinateSystem(cartesianCoordinateSystem_0);

    SimpleBlockPart simpleBlockPart_7 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Boden"));

    simpleBlockPart_7.setCoordinateSystem(cartesianCoordinateSystem_0);

    scene_16.close(true);

    MeshContinuum meshContinuum_1 = 
      ((MeshContinuum) simulation_0.getContinuumManager().getContinuum("Mesh 1"));

    TrimmerMeshingModel trimmerMeshingModel_0 = 
      meshContinuum_1.getModelManager().getModel(TrimmerMeshingModel.class);

    trimmerMeshingModel_0.setCoordinateSystem(cartesianCoordinateSystem_0);

    TrimmerMeshingModel trimmerMeshingModel_1 = 
      meshContinuum_0.getModelManager().getModel(TrimmerMeshingModel.class);

    trimmerMeshingModel_1.setCoordinateSystem(cartesianCoordinateSystem_0);

    MeshPart meshPart_4 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Fan_Yaw"));

    PartSurface partSurface_0 = 
      ((PartSurface) meshPart_4.getPartSurfaceManager().getPartSurface("Surface"));

    meshPart_4.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_0}), 89.0);

    MeshPart meshPart_5 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Radiator"));

    PartSurface partSurface_1 = 
      ((PartSurface) meshPart_5.getPartSurfaceManager().getPartSurface("Surface"));

    meshPart_5.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_1}), 89.0);

    MeshPart meshPart_6 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("FW_FLap2"));

    simulation_0.get(SimulationPartManager.class).removeParts(new NeoObjectVector(new Object[] {meshPart_6}));

    MeshActionManager meshActionManager_0 = 
      simulation_0.get(MeshActionManager.class);

    MeshPart meshPart_7 = 
      meshActionManager_0.subtractParts(new NeoObjectVector(new Object[] {simpleBlockPart_6, meshPart_5}), simpleBlockPart_6, "Discrete");

    Region region_0 = 
      simulation_0.getRegionManager().createEmptyRegion();

    region_0.setPresentationName("Region");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Default");

    region_0.getBoundaryManager().removeBoundaries(new NeoObjectVector(new Object[] {boundary_0}));

    FeatureCurve featureCurve_0 = 
      ((FeatureCurve) region_0.getFeatureCurveManager().getObject("Default"));

    region_0.getFeatureCurveManager().removeObjects(featureCurve_0);

    FeatureCurve featureCurve_1 = 
      region_0.getFeatureCurveManager().createEmptyFeatureCurveWithName("Feature Curve");

    MeshPart meshPart_8 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Airduct"));

    MeshPart meshPart_9 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Body_Driver"));

    MeshPart meshPart_10 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Body_MC"));

    MeshPart meshPart_11 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Body_QJ"));

    MeshPart meshPart_12 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("ContactP_FT_YAW_Final"));

    MeshPart meshPart_13 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("ContactP_RT_YAW"));

    MeshPart meshPart_14 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Drivetrain"));

    MeshPart meshPart_15 =
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("FC6_inner_YAW"));

    MeshPart meshPart_16 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("FW_Endplates"));

    MeshPart meshPart_17 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("FW_Flap1"));

    MeshPart meshPart_18 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("FW_Main"));

    MeshPart meshPart_19 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Headrest"));

    MeshPart meshPart_20 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("MRH"));

    MeshPart meshPart_21 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Outlet_Rear_Yaw"));

    MeshPart meshPart_22 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Outlet_Yaw"));

    MeshPart meshPart_23 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("RW_Endplates"));

    MeshPart meshPart_24 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("RW_Flap1"));

    MeshPart meshPart_25 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("RW_Flap2"));

    MeshPart meshPart_26 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("RW_Main"));

    MeshPart meshPart_27 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("RW_Support"));

    MeshPart meshPart_28 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Sidepod"));

    MeshPart meshPart_29 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Susp_Brackets"));

    MeshPart meshPart_30 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Susp_Legs"));

    MeshPart meshPart_31 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Tire_Front"));

    MeshPart meshPart_32 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Tire_Front_Right"));

    MeshPart meshPart_33 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Tire_Rear"));

    MeshPart meshPart_34 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Tire_Rear_Right"));

    MeshPart meshPart_35 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("TSAL"));

    MeshPart meshPart_36 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Tubes"));

    MeshPart meshPart_37 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("UB_Diffusor"));

    MeshPart meshPart_38 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("UB_F1"));

    MeshPart meshPart_39 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("UB_F2"));

    MeshPart meshPart_40 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("UB_hor"));

    MeshPart meshPart_41 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("UB_MC"));

    MeshPart meshPart_42 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("UB_ver"));

    MeshPart meshPart_43 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Wheel_Front"));

    MeshPart meshPart_44 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Wheel_Front_Right"));

    MeshPart meshPart_45 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Wheel_Rear"));

    MeshPart meshPart_46 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Wheel_Rear_Right"));

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {meshPart_8, meshPart_9, meshPart_10, meshPart_11, meshPart_12, meshPart_13, meshPart_14, meshPart_4, meshPart_15, meshPart_16, meshPart_17, meshPart_18, meshPart_19, meshPart_20, meshPart_21, meshPart_22, meshPart_23, meshPart_24, meshPart_25, meshPart_26, meshPart_27, meshPart_28, meshPart_7, meshPart_29, meshPart_30, meshPart_31, meshPart_32, meshPart_33, meshPart_34, meshPart_35, meshPart_36, meshPart_37, meshPart_38, meshPart_39, meshPart_40, meshPart_41, meshPart_42, meshPart_43, meshPart_44, meshPart_45, meshPart_46}), "OneRegion", region_0, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", featureCurve_1, true);

    Region region_1 = 
      simulation_0.getRegionManager().createEmptyRegion();

    region_1.setPresentationName("RegionRadiator");

    Boundary boundary_1 = 
      region_1.getBoundaryManager().getBoundary("Default");

    region_1.getBoundaryManager().removeBoundaries(new NeoObjectVector(new Object[] {boundary_1}));

    FeatureCurve featureCurve_2 = 
      ((FeatureCurve) region_1.getFeatureCurveManager().getObject("Default"));

    region_1.getFeatureCurveManager().removeObjects(featureCurve_2);

    FeatureCurve featureCurve_3 = 
      region_1.getFeatureCurveManager().createEmptyFeatureCurveWithName("Feature Curve");

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {meshPart_5}), "OneRegion", region_1, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", featureCurve_3, true);

    CartesianCoordinateSystem cartesianCoordinateSystem_1 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("frtwe_coord"));

    labCoordinateSystem_0.getLocalCoordinateSystemManager().remove(cartesianCoordinateSystem_1);

    CartesianCoordinateSystem cartesianCoordinateSystem_2 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("rewe_coord"));

    labCoordinateSystem_0.getLocalCoordinateSystemManager().remove(cartesianCoordinateSystem_2);

    CartesianCoordinateSystem cartesianCoordinateSystem_3 = 
      labCoordinateSystem_0.getLocalCoordinateSystemManager().createLocalCoordinateSystem(CartesianCoordinateSystem.class, "Cartesian");

    Coordinate coordinate_3 = 
      cartesianCoordinateSystem_3.getOrigin();

    coordinate_3.setCoordinate(units_1, units_1, units_1, new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    coordinate_3.setValue(new DoubleVector(new double[] {14.6804, -695.023, 234.1699}));

    cartesianCoordinateSystem_3.setBasis0(new DoubleVector(new double[] {-19.5351, -185.6831, 9.6687}));

    cartesianCoordinateSystem_3.setBasis1(new DoubleVector(new double[] {185.6831, -19.5351, 9.6687}));

    cartesianCoordinateSystem_3.setPresentationName("FR");

    CartesianCoordinateSystem cartesianCoordinateSystem_4 = 
      labCoordinateSystem_0.getLocalCoordinateSystemManager().createLocalCoordinateSystem(CartesianCoordinateSystem.class, "Cartesian");

    Coordinate coordinate_4 = 
      cartesianCoordinateSystem_4.getOrigin();

    coordinate_4.setCoordinate(units_1, units_1, units_1, new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    coordinate_4.setValue(new DoubleVector(new double[] {-33.8755, 691.6337, 235.7473}));

    cartesianCoordinateSystem_4.setBasis0(new DoubleVector(new double[] {174.5489, -20.6593, 0.0}));

    cartesianCoordinateSystem_4.setBasis1(new DoubleVector(new double[] {20.6593, 174.5489, 13.0288}));

    cartesianCoordinateSystem_4.setPresentationName("FL");

    CartesianCoordinateSystem cartesianCoordinateSystem_5 = 
      labCoordinateSystem_0.getLocalCoordinateSystemManager().createLocalCoordinateSystem(CartesianCoordinateSystem.class, "Cartesian");

    Coordinate coordinate_5 = 
      cartesianCoordinateSystem_5.getOrigin();

    coordinate_5.setCoordinate(units_1, units_1, units_1, new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    coordinate_5.setValue(new DoubleVector(new double[] {-1530.0, -691.5863, 234.763}));

    cartesianCoordinateSystem_5.setBasis0(new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    cartesianCoordinateSystem_5.setBasis1(new DoubleVector(new double[] {0.0, -165.1282, 11.5465}));

    cartesianCoordinateSystem_5.setPresentationName("RR");

    CartesianCoordinateSystem cartesianCoordinateSystem_6 = 
      labCoordinateSystem_0.getLocalCoordinateSystemManager().createLocalCoordinateSystem(CartesianCoordinateSystem.class, "Cartesian");

    Coordinate coordinate_6 = 
      cartesianCoordinateSystem_6.getOrigin();

    coordinate_6.setCoordinate(units_1, units_1, units_1, new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    coordinate_6.setValue(new DoubleVector(new double[] {-1530.0, 684.9387, 234.2982}));

    cartesianCoordinateSystem_6.setBasis0(new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    cartesianCoordinateSystem_6.setBasis1(new DoubleVector(new double[] {0.0, 171.7757, 12.0117}));

    cartesianCoordinateSystem_6.setPresentationName("RL");

    Units units_2 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    labCoordinateSystem_0.getLocalCoordinateSystemManager().remove(cartesianCoordinateSystem_3);

    CartesianCoordinateSystem cartesianCoordinateSystem_7 = 
      labCoordinateSystem_0.getLocalCoordinateSystemManager().createLocalCoordinateSystem(CartesianCoordinateSystem.class, "Cartesian");

    Coordinate coordinate_7 = 
      cartesianCoordinateSystem_7.getOrigin();

    coordinate_7.setCoordinate(units_1, units_1, units_1, new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    coordinate_7.setValue(new DoubleVector(new double[] {14.6804, -695.023, 234.1699}));

    cartesianCoordinateSystem_7.setBasis0(new DoubleVector(new double[] {185.6831, -19.5351, 9.6687}));

    cartesianCoordinateSystem_7.setBasis1(new DoubleVector(new double[] {-19.5351, -185.6831, 9.6687}));

    cartesianCoordinateSystem_7.setPresentationName("FR");
  }
}
