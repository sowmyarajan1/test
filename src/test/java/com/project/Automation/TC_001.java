package com.project.Automation;

import org.testng.annotations.Test;

public class TC_001 extends BaseTest{
  @Test
  public void f() throws Exception {
	  
	  openBrowser("chromebrowser");
	  navigate("amazonurl");
	  text("amazonsearchtext_id","sony");
	  clickElement("amazonsearchbutton_xpath");

  }

}





