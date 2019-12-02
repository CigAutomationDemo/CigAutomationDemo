package com.automation.slack;

public class SlackTest {
	public String strScriptName;
	public String strStatus;
	public String strBuildNo;
	public String strBuildDate;
	public String strCountry;
	public String strEnv;
	public String strDefectID;



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
		try
		{
			SlackApi api = new SlackApi("https://hooks.slack.com/services/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");
			String strMessage="****************************************";
			strMessage=strMessage + "\n"+"Script Name :- " + objData.strScriptName;
			strMessage=strMessage + "\n" +"Country :- " + objData.strCountry.toUpperCase();
			strMessage=strMessage + "\n" +"Environment :- " + objData.strEnv.toUpperCase();
			strMessage=strMessage + "\n" +"Build No :- " + objData.strBuildNo;
			strMessage=strMessage + "\n" +"Date & Time :- " + objData.strBuildDate;
			strMessage=strMessage + "\n" +"Status :- " + objData.strStatus;
			if(objData.strStatus.toLowerCase().contains("fail"))
			{
				strMessage=strMessage + "\n" +"Defect ID :- " + objData.strDefectID;
			}
			strMessage=strMessage + "\n" +"************************************";
			api.call(new SlackMessage("#autodemo", "automationcigniti",strMessage ));
			System.out.println("\n**********************************************");
			System.out.println("Slack Details Updated \n" + strMessage);
			System.out.println("\n**********************************************");
		}
		catch(Exception e){e.printStackTrace();}
	}

}
