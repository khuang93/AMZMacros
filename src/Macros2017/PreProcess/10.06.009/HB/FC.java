// STAR-CCM+ macro: FC.java
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

public class FC extends StarMacro {

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

    partImportManager_0.importStlPart(resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\FC6_inner.stl"), "OneSurfacePerPatch", units_1, true, 1.0E-5);

    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Geometry", 1);

    Scene scene_18 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 16");

    scene_18.initializeAndWait();

    PartDisplayer partDisplayer_2 = 
      ((PartDisplayer) scene_18.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_2.initialize();

    PartDisplayer partDisplayer_3 = 
      ((PartDisplayer) scene_18.getDisplayerManager().getDisplayer("Geometry 1"));

    partDisplayer_3.initialize();

    scene_18.open(true);

    CurrentView currentView_1 = 
      scene_18.getCurrentView();

    currentView_1.setInput(new DoubleVector(new double[] {-10.145353317260742, 7.499947779484501, 7.315015733242035}), new DoubleVector(new double[] {-10.145353317260742, 7.499947779484501, 131.31065776735122}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 32.36935801318568, 0);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    FeatureCurve featureCurve_0 = 
      region_0.getFeatureCurveManager().createEmptyFeatureCurveWithName("Feature Curve");

    MeshPart meshPart_0 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("FC6_inner"));

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {meshPart_0}), "OneRegion", region_0, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", featureCurve_0, true);

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("FC6_inner.Surface");

    boundary_0.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    ForceReport forceReport_0 = 
      simulation_0.getReportManager().createReport(ForceReport.class);

    ForceReport forceReport_1 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Force 34"));

    forceReport_1.getDirection().setComponents(-0.016337688416039733, 0.0, 0.9998665310616315);

    forceReport_0.getDirection().setComponents(-0.016337688416039733, 0.0, 0.9998665310616315);

    forceReport_0.getParts().setObjects(boundary_0);
      
   
  }
}
