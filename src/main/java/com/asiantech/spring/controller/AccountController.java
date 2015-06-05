package com.asiantech.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asiantech.spring.dao.AccountDao;
import com.asiantech.spring.etity.Account;
import com.asiantech.spring.service.AccountService;
@Controller
@RequestMapping("/admin")
public class AccountController {
	    @Autowired
	    private AccountDao accountDao;
	    private Account account = new Account();
	    private List<Account>  listAccount= new ArrayList<Account>();
	    private List<Account>  listAccount2= new ArrayList<Account>();;
	    private List<Account>  listAccountAcc;
	    public List<Account> getAccounts() {
	        return listAccount;
	    }
	    @RequestMapping("")
		public String getIndex(){
			return "redirect:admin/";
		}
	    @RequestMapping("/")
	    public String listthymleaf( ModelMap model) {
	    	int page=1;
	    	int limit = 5;
	    	int end =0;
	    	int dem=0;
	        int  totalrecord = accountDao.getAllTotal();
	        for(int i=1;i<=totalrecord;i=i+limit){
	        	end=end+limit;
	        	dem++;
	        	
	        }
	    	List<Account> listAccountAcc = accountDao.getLimitAccount(limit,(page*limit-limit));
	    	listAccount=listAccountAcc;
	        model.put("page", page);
	        model.put("limit", limit);
		    model.put("totalrecord", totalrecord);
		    model.put("iend", dem);
	        model.put("listAccount", listAccount);
	        Account newAccount = new Account();
	        model.put("account", newAccount);
	        return "listthymleaf";
	    }
	    @RequestMapping(value = "thymeleafpage", method = RequestMethod.GET)
	    public ModelAndView getAccountThymeleaf(@RequestParam(value="page",required=false) Integer page,HttpServletRequest request,@RequestParam(value="limit",required=false) Integer limit) {
	        if(page==null)
	        	page=1;
	        //page = Integer.parseInt(request.getParameter("page"));
	        if(limit==null)
	        	limit=5;
	        //limit = Integer.parseInt(request.getParameter("limit"));
	    	int end =0;
	    	int dem=0;
	        int  totalrecord = accountDao.getAllTotal();
	        for(int i=1;i<=totalrecord;i=i+limit){
	        	end=end+limit;
	        	dem++;
	        	
	        }
	    	List<Account> listAccountAcc = accountDao.getLimitAccount(limit,(page*limit-limit));
	    	
	    	listAccount=listAccountAcc;
	    	
	    	ModelAndView model = new ModelAndView("listthymleaf");
	        model.addObject("page", page);
	        model.addObject("limit", limit);
		    model.addObject("totalrecord", totalrecord);
		    model.addObject("iend", dem);
	        model.addObject("listAccount", listAccount);
	        model.addObject("msg", accountDao.getMsg());
	        Account newAccount = new Account();
	        model.addObject("account", newAccount);
	        accountDao.setMsg("");
	        return model;
	    }

	    public List<Account> copyAccount(List<Account> listAccount,List<Account> listAccount2){
	    	//listAccount.removeAll(listAccount);
	    	listAccount.addAll(listAccount2);
	    	return listAccount;
	    }
	    
	    @RequestMapping(value = "/list", method = RequestMethod.GET)
	    public ModelAndView getAccount(@RequestParam(value="page",required=false) Integer page,HttpServletRequest request) {
	        if(page==null)
	        	page=1;
	        page = Integer.parseInt(request.getParameter("page"));
	    	int limit = 5;
	    	int end =0;
	    	int dem=0;
	        int  totalrecord = accountDao.getAllTotal();
	        for(int i=1;i<=totalrecord;i=i+limit){
	        	end=end+limit;
	        	dem++;
	        	
	        }
	    	List<Account> listAccountAcc = accountDao.getLimitAccount(limit,(page*limit-limit));
	    	
	    	listAccount=listAccountAcc;
	    	
	    	ModelAndView model = new ModelAndView("list");
	        model.addObject("page", page);
	        model.addObject("limit", limit);
		    model.addObject("totalrecord", totalrecord);
		    model.addObject("iend", dem);
	        model.addObject("listAccount", listAccount);
	        Account newAccount = new Account();
	        model.addObject("account", newAccount);
	       
	        return model;
	    }
	   /* @RequestMapping(value="/")
	    public String listAccount(ModelMap model) throws IOException{
	    	int page=1;
	    	int limit = 5;
	    	int end =0;
	    	int dem=0;
	        int  totalrecord = accountDao.getAllTotal();
	        for(int i=1;i<=totalrecord;i=i+limit){
	        	end=end+limit;
	        	dem++;
	        	
	        }
	    	List<Account> listAccountAcc = accountDao.getLimitAccount(limit,(page*limit-limit));
	    	//listAccount.addAll(listAccountAcc);
	    	//copyAccount(listAccount,listAccountAcc);
	    	// Account account=new  Account(01,"333","33333","333333");
	    	 //copyAccount(listAccountAcc,listAccount);
	    	// listAccount.add(account);
	    	/*for(int i=0;i<listAccount.size();i++){
	    		System.out.println("sdvdgfsfgsg"+listAccount.size());
	    	System.out.println(listAccount.get(i).getId());
	    	System.out.println(listAccount.get(i).getName());
	    	System.out.println(listAccount.get(i).getFirstname());
	    	System.out.println(listAccount.get(i).getLastname());
	    		//System.out.println("fdgdggg");
	       }
	    	listAccount=listAccountAcc;
	        model.put("page", page);
	        model.put("limit", limit);
		    model.put("totalrecord", totalrecord);
		    model.put("iend", dem);
	        model.put("listAccount", listAccount);
	        Account newAccount = new Account();
	        model.put("account", newAccount);
	       
	        //model.setViewName("list");
	        
	     
	        return "/list";
	    }*/
	    
	    //new
	    @RequestMapping(value = "/addAccount", method = RequestMethod.GET)
	    public ModelAndView newAccount(ModelAndView model) {
	        Account newAccount = new Account();
	        model.addObject("account", newAccount);
	        model.setViewName("AccountForm");
	        return model;
	    }
	    //delete list method post
	    @RequestMapping(value="/deletelist",method=RequestMethod.GET)
	    public String detetelist(HttpServletRequest request){
	    	//copyAccount(listAccountAcc,listAccount);
	    	int id = Integer.parseInt(request.getParameter("id"));
	    	if(account.getId()==id){
	    	     listAccount.remove(account);
	    	     System.out.println("Da xoa"+id);
	    	}
		     return "redirect:/";
	    }
	    //new list method post
	    @RequestMapping(value="/addlist",method=RequestMethod.POST)
	    public String addlist(String name, String firstname,String lastname,ModelMap model){
	    	//System.out.println("id99999999999999id"+id);
	    	 Account account=new  Account(01,name,firstname,lastname);
	    	 listAccount.add(account);
	    	 for(int i=0;i<listAccount.size();i++){
		    		System.out.println("sdvdgfsfgsg"+listAccount.size());
		    	System.out.println(listAccount.get(i).getId());
		    	System.out.println(listAccount.get(i).getName());
		    	System.out.println(listAccount.get(i).getFirstname());
		    	System.out.println(listAccount.get(i).getLastname());
		    		//System.out.println("fdgdggg");
		       }
	    	 //copyAccount(listAccountAcc,listAccount);
	    	
	    	 model.put("listAccount",listAccount);
		     return "redirect:/";
	    }
	    //search
	    @RequestMapping(value = "/searchAccount", method = RequestMethod.POST)
	    public String searchAccount(ModelMap model,String name) {
	       
	     	int page=1;
	    	int limit = 5;
	    	int end =0;
	    	int dem=0;
	        int  totalrecord = accountDao.getAllTotalSearch(name);
	        for(int i=1;i<=totalrecord;i=i+limit){
	        	end=end+limit;
	        	dem++;
	        	
	        }
	    	List<Account> listAccountAcc = accountDao.getLimitAccountSearch(limit,(page*limit-limit),name);
	    	listAccount=listAccountAcc;
	    	
	        model.put("page", page);
	        model.put("limit", limit);
		    model.put("totalrecord", totalrecord);
		    model.put("iend", dem);
	        model.put("listAccount", listAccount);
	        Account newAccount = new Account();
	        model.put("account", newAccount);
	        return "/list";
	    }
	    
	    
	    //delete method post
	    @RequestMapping(value="/delete",method=RequestMethod.POST)
	    public String detete(@Valid Account account,BindingResult bidding, @RequestParam("id") Integer id,@RequestParam("page") Integer page){
	    	 accountDao.removeAccount(id);
	    	 accountDao.setMsg("Xoa thanh cong Account "+id+" !");
	    	 return "redirect:/admin/thymeleafpage?page="+page;
	    }
	    
	    //update or insert
	    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	    public String saveAccount(@Valid Account account,BindingResult bidding,
	    		@RequestParam("page") Integer page) {
	       accountDao.editAccount(account);
	       accountDao.setMsg("Them thanh cong!");
	        return "redirect:/admin/thymeleafpage?page="+page;
	    	
	    }
	    //delete method get
	    @RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	    public String deleteAccount(HttpServletRequest request) {
	        int id = Integer.parseInt(request.getParameter("id"));
	        int page = Integer.parseInt(request.getParameter("page"));
	        accountDao.removeAccount(id);
	        return "redirect:/list?page="+page;
	    }
	    //edit method get
	    @RequestMapping(value = "/editAccount", method = RequestMethod.GET)
	    public ModelAndView editAccount(HttpServletRequest request) {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Account account = accountDao.get(id);
	       
	        ModelAndView model = new ModelAndView("AccountForm");
	        //List<Account> listAccount = accountDao.listAccount();
	        //model.addObject("listAccount", listAccount);
	        model.addObject("account", account);
	        //model.setViewName("list");
	     
	        return model;
	    }
	    //edit method post
	    @RequestMapping(value = "/edit", method = RequestMethod.POST)
	    public ModelAndView edit(@RequestParam("id") Integer id,@RequestParam("page") Integer page) {
	        Account account = accountDao.get(id);
	       // ModelAndView model = new ModelAndView("AccountForm");
	        ModelAndView model = new ModelAndView("formedit");
	        //List<Account> listAccount = accountDao.listAccount();
	        //model.addObject("listAccount", listAccount);
	        model.addObject("account", account);
	        model.addObject("page", page);
	        //model.addObject("id",id);
	        //model.setViewName("list");
	     
	        return model;
	    }
	    //save edit
	    @RequestMapping(value = "/saveedit", method = RequestMethod.POST)
	    public String saveedit(@Valid Account account,BindingResult bidding,
	    		@RequestParam("page") Integer page,@RequestParam("id") Integer id) {
	       accountDao.editAccount(account);
	       accountDao.setMsg("Sua thanh cong Account "+id+" !");
	        return "redirect:/admin/thymeleafpage?page="+page;
	    	
	    }
}
