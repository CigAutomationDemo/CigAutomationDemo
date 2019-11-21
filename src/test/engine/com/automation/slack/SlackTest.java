package com.automation.slack;

public class SlackTest {
	public String strScriptName;
	public String strStatus;
	public String strBuildNo;
	public String strCycle;
	public String strBuildDate;
	public String strBuildTime;



	public static void main(String[] args) {
		System.out.println("Test API");
		// TODO Auto-generated method stub
		// Send simple message
		SlackApi api = new SlackApi("https://hooks.slack.com/services/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");
		//api.call(new SlackMessage("Slack Automation Cigniti Demo123"));
		String strMessage="Script Name :- HOOQ_Web_SignUp_Mobile ";
		strMessage=strMessage + "\n" + "Status :- PASS ";
		strMessage=strMessage + "\n" +"Build No :- Version 1.9.15-3 ";
		strMessage=strMessage + "\n" +"Cycle No :- 17";
		strMessage=strMessage + "\n" +"Last Update Date :- 26-Sep-2017";
		strMessage=strMessage + "\n" +"Last Update Time :- 19:08:05";
		api.call(new SlackMessage("#autodemo", "automationcigniti",strMessage ));
	}

	public static void fnUpdateSanityChanel(SlackTest objData)
	{
		SlackApi api = new SlackApi("https://hooks.slack.com/services/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");
		String strMessage="****************************************";
		strMessage=strMessage + "\n"+"Script Name :- " + objData.strScriptName;
		strMessage=strMessage + "\n" + "Status :- " + objData.strStatus;
		strMessage=strMessage + "\n" +"Build No :- " + objData.strBuildNo;
		if(objData.strStatus.toLowerCase().equals("pass")==false)
		{
			strMessage=strMessage + "\n" +"Cycle No :- " + objData.strCycle;
			strMessage=strMessage + "\n" +"Last Update Date :- " + objData.strBuildDate;
			strMessage=strMessage + "\n" +"Last Update Time :- " + objData.strBuildTime;
		}
		strMessage=strMessage + "\n" +"************************************";
		api.call(new SlackMessage("#sanity_api_test", "automationcigniti",strMessage ));
	}

}
