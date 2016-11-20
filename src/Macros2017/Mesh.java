// STAR-CCM+ macro: MeshAndSave.java
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

public class Mesh extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {


    Simulation simulation_0 = 
      getActiveSimulation();



    MeshPipelineController meshPipelineController_0 = 
      simulation_0.get(MeshPipelineController.class);

    meshPipelineController_0.generateSurfaceMesh();

  //  String Path = "E:\\Prepared\\";
   // File dir = new File(Path+getSimulation().getPresentationName());

//    simulation_0.saveState(resolvePath(Path+"\\"+getSimulation().getPresentationName())+".sim");

 

    meshPipelineController_0.generateVolumeMesh();

 

    
    

    

  //  simulation_0.saveState(resolvePath(Path+"\\"+getSimulation().getPresentationName())+".sim");

 
simulation_0.kill();
 

  }
  
}