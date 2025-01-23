package wrapperspractice;

public interface WrappersPractice {
	
	public void invokeApp(String browser, String url); 
	// String locator, String data
	public void enterById(String IdVal,String data);
	public void enterByName(String NameVal,String data);
	public void enterByXPath(String XPathVal,String data);
	public void ClickById(String IdVal);
	public void ClickByName(String NameVal);
	public void ClickByXpath(String XPathVal);
	public void ClickByCssselVal(String CssselVal);
	public void SelectVisibleTextById(String IdVal,String data);
	public void SelectValueById(String IdVal, String data);
	public void SelectindexById(String IdVal, int index);
	public void SelectVisibleTextByName(String NameVal,String data);
	public void SelectValueByName(String NameVal, String data);
	public void SelectIndexByName(String NameVal,int index);
	public void SelectVisibleTextByXPath(String XPathVal,String data);
	public void SelectValueByXPath(String XPathval, String data);
	public void SelectIndexByXPath(String  XPathVal,int index);
	public void WaitDriver(Long time);
	public void CloseDriver();

}
