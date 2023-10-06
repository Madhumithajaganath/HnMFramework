package Assignment;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import GenericUtilities.BaseClass;

public class HnMExecute extends BaseClass{
 public String lpstr = "India/English";
	@Test
	public void demo1() throws InterruptedException {
		
		lp.loginSetup(gutil, lpstr);
		sp.searchSetup(gutil, "tops");
		pp.productSetup();
		cp.cartSetup();
	}
	
	@Test
	public void demo2() {
		lp.loginSetup(gutil, lpstr);
		mp.magazineSetup(gutil, "MAGAZINE");
	}
	
	@Test
	public void demo3() throws InterruptedException {
		lp.loginSetup(gutil, lpstr);
		wp.whishlistSetup(gutil, "The most loved styles 🤍");
	}
	
	@Test
	public void demo4() {
		lp.loginSetup(gutil, lpstr);
		ip.inboxSetup();
	}
	
	@Test
	public void demo5() {
		lp.loginSetup(gutil, lpstr);
		fp.filterSetup(gutil, "Popular categories", dutil);
	}
	
	@Test
	public void demo6() throws InterruptedException {
		lp.loginSetup(gutil, lpstr);
		slp.storeLocatorSetup(gutil);
	}
}
