// STAR-CCM+ macro: MeshAndSaveRun.java
// Written by STAR-CCM+ 8.06.005


package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;
import star.flow.*;
import star.surfacewrapper.*;
import star.prismmesher.*;
import star.meshing.*;
import star.base.report.*;

import java.io.File;

public class MeshAndRun extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {


    Simulation simulation_0 = 
      getActiveSimulation();

 

    simulation_0.getSimulationIterator().run();

    }
  
}