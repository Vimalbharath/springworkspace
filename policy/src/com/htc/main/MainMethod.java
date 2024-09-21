package com.htc.main;

import com.htc.dao.PolicyProvider;
import com.htc.entity.Policy;
import com.htc.exceptions.PolicyNotFoundException;

public class MainMethod {
	public static void main(String [] args) throws PolicyNotFoundException {
		  System.out.println("Hello");
		  Policy p1=new Policy("P01","PF",500.0,"Active");
		  Policy p3 = null;
		  PolicyProvider policies=new PolicyProvider();
		  policies.addPolicy(p1);
		  System.out.println(policies.addPolicy(new Policy("P02","Retirement",500.0,"Active")));
		  System.out.println(policies.updatePremiumAmount("P02", 100.0));
		  System.out.println(policies.removePolicy(p1));
		  policies.showAllPolicy();
		  
		  System.out.println( policies);
}
}