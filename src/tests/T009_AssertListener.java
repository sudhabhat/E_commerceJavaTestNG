package tests;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.webLoading;

public class T009_AssertListener {

	webLoading e_User;
	LoginPage lPage = new LoginPage();

	@BeforeTest
	public void before_Run() throws InterruptedException, IOException {
		e_User = new webLoading();
		e_User.start("asos_Home");
		e_User.assertTest(false);
	}

	@AfterTest
	public void after_Run() throws InterruptedException, IOException {
		e_User.assertTest(false);
		e_User.quit();
		
	}

	/**
	 * Test to assert the sign up functionality for a new user 1) user navigates
	 * to the sign in page (selects email option) 2) sign up as a new user with
	 * valid values
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Parameters({ "email-id", "pass-word" })
	@Test
	public void new_User_Login_Email(String Emailid, String Password) throws IOException, InterruptedException {
		e_User.webElementClicknWait("home_Signin");
		lPage.LoginByEmail(Emailid, Password, e_User);
		e_User.assertTest(e_User.webElementIsText("asos_FirstName","user_FirstName"));
		Actions action = new Actions(e_User.a_Driver);
		action.moveToElement(e_User.webFindElementByXpath("home_Women")).perform();
		e_User.assertTest(e_User.webElementDisplayed("home_W_ShopByProd"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_NewInClothing"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_NewInShoesAccs"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_NewInBackinStock"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Outlet70Off"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_BeAVIPJoin"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Accessories"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_BagsNPurses"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Beauty"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Balzers"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Coords"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_CoatsNJackets"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_CurveNPlusSize"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Denim"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Designer"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Dresses"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Gifts"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_HoodieNSweatshirt"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Jeans"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_JewelleryNWatch"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_JumpersNCardigans"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_JumpSuitNPlaysuit"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Kimonos"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_LingerieNNightware"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Maternity"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_MultiPacks"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Petite"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_ShirtNBlouse"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Shoes"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Shorts"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Skirts"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_SocksNTights"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_SuitsNSeparates"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Sunglasses"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_SwimwearNBeachwear"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_TshirtsNVests"));
		e_User.assertTest(false);
		e_User.assertTest(e_User.webElementDisplayed("home_W_Tall"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Tops"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_TrouserNLeggin"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_GiftVouchers"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_ShopByEdit"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_NewMeetStylist"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_NewStylistsDailyEdit"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_AsSeenOnMe"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_DailyNewsFeed"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_AsosMagazine"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_AsosJeansCollection"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Flares"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_That70sShow"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_OccasionWear"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Student"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_GoingOut"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Work"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Holiday"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Festival"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_SS15HotPieces"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_AsosWhite"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_ReclaimedVintage"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_ExclusiveToAsos"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_GreenRoomEcoEdit"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_A2ZBrand"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Boutiques"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_NewInVintage"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_NewInIndependentLabel"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Explore750Boutique"));
		e_User.assertTest(false);
		e_User.assertTest(e_User.webElementDisplayed("home_W_MarketPlaceEdit"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_NailThe90s"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Adidas"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_ChiChiLondon"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_FrockNFrill"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Lipsy"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Monki"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_NewBalance"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Nike"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_RiverIsland"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_VirgosLounge"));
		e_User.assertTest(e_User.webElementDisplayed("home_W_Weekday"));
		e_User.assertTest(false);
	}
}