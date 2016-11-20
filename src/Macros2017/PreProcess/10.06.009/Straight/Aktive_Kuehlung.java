// STAR-CCM+ macro: Aktive_Kuehlung.java
// Written by STAR-CCM+ 9.02.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.flow.*;
import star.meshing.*;

public class Aktive_Kuehlung extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    MeshPart meshPart_0 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Fan_final"));

    PartSurface partSurface_0 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface"));

    meshPart_0.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_0}), 89.0);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    FeatureCurve featureCurve_0 = 
      region_0.getFeatureCurveManager().createEmptyFeatureCurveWithName("Feature Curve");

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {meshPart_0}), "OneRegion", region_0, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", featureCurve_0, true);

    FileTable fileTable_0 = 
      (FileTable) simulation_0.getTableManager().createFromFile(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Fan-tables\\Fan-curve-kuehlung.csv"));

    SurfaceMeshProxy surfaceMeshProxy_0 = 
      simulation_0.get(SurfaceMeshProxy.class);

      Boundary boundary_0 =
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface");
      
      Boundary boundary_1 =
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 3");
      
      BoundaryInterface boundaryInterface_1 =
      simulation_0.getInterfaceManager().createBoundaryInterface(boundary_0, boundary_1, "Interface");
      
      boundaryInterface_1.setInterfaceType(FanInterface.class);
      
      boundaryInterface_1.getTopology().setSelected(InterfaceConfigurationOption.Type.PERIODIC);
      
      FanCurveTable fanCurveTable_0 =
      boundaryInterface_1.getValues().get(FanCurveTable.class);
      
      
      fanCurveTable_0.setActiveTable(fileTable_0);
      
      fanCurveTable_0.setActiveTableX("column1");
      
      fanCurveTable_0.setActiveTableP("column0");
      
      Units units_2 =
      ((Units) simulation_0.getUnitsManager().getObject("rpm"));
      
      fanCurveTable_0.getOperatingRotationRate().setUnits(units_2);
      
      fanCurveTable_0.getOperatingRotationRate().setValue(11000.0);
      
      fanCurveTable_0.getDataRotationRate().setUnits(units_2);
      
      fanCurveTable_0.getDataRotationRate().setValue(11000.0);
  }
}
