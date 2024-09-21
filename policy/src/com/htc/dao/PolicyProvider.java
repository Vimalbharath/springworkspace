package com.htc.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.htc.entity.Policy;

import com.htc.exceptions.PolicyNotFoundException;

public class PolicyProvider implements PolicyProviderInterface {
	
	@Override
	public String toString() {
		return "PolicyProvider [list=" + list + "]";
	}

	

	

	public PolicyProvider() {
		super();
	}



	ArrayList<Policy> list=new ArrayList<>();

	@Override
	public boolean addPolicy(Policy policy) {
		// TODO Auto-generated method stub
		list.add(policy);
		return true;
	}

	@Override
	public boolean removePolicy(Policy policy) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		Policy p=null;
		for (Policy temp : list) {
			if(temp==policy) {
				list.remove(policy);
			return true;
			}
		}
		if(p==null)
			throw new PolicyNotFoundException("Policy Not found");
		
		return false;
	}

	@Override
	public ArrayList<Policy> showAllPolicy() {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		System.out.println(list);
		return list;
	}

	@Override
	public boolean updatePremiumAmount(String policyId, double newCost) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		Policy p=null;
		for (Policy temp : list) {
			if(temp.getPolicyNo()==policyId) {
				temp.setPremiumAmount(newCost);
			return true;
			}
		}
		if(p==null)
			throw new PolicyNotFoundException("Policy Not found");
		
		return false;
	}

}
