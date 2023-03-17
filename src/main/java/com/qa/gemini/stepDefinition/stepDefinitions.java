package com.qa.gemini.stepDefinition;

import io.cucumber.java.en.Given;
import com.qa.gemini.commonUtils.Utils;
import io.cucumber.java.en.Then;

import java.util.HashMap;

public class stepDefinitions {
    int status;
    @Given("^Set endpoint and method and PayloadName \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void Login(String url, String method, String PayloadName) throws Exception {
        status = Utils.LoginUser(url, method, PayloadName, "Login User").getStatus();
    }

    @Then("Verify Status code {int}")
    public void check_status_code(int Expected) {
        Utils.VerifyStatusCode(Expected, status);
    }

    @Given("^Set invalid credential endpoint and method and PayloadName \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void LoginWrong(String url, String method, String PayloadName) throws Exception {
        HashMap<String,String> token=new HashMap<String,String>();
        status = Utils.LoginUser(url, method, PayloadName,"").getStatus();
    }

    @Given("^Set email endpoint and method and PayloadName (.+) and (.+) and (.+)")
    public void forgot_password(String url, String method, String PayloadName) throws Exception {
        HashMap<String,String> token=new HashMap<String,String>();
        token.put("Token", Utils.GetToken());
        status= Utils.APIwithPayloads(url,method,PayloadName,token,"").getStatus();
    }

    @Given("Authenticate endpoint and method and PayloadName (.+) and (.+) and (.+)")
    public void resetPassword(String url, String method, String PayloadName) throws Exception {
        HashMap<String,String> token=new HashMap<String,String>();
        token.put("Token", Utils.GetToken());
        status= Utils.APIwithPayloads(url,method,PayloadName,token,"").getStatus();
    }
}
