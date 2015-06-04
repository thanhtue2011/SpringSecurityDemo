package com.asiantech.spring.dao.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.asiantech.spring.dao.AccountDao;
import com.asiantech.spring.etity.Account;
public class AccountDaoImple implements AccountDao{
	private String msg;
	private static AccountDaoImple accounttest;
	
	private JdbcTemplate jdbcTemplate;
	 public AccountDaoImple(){
		 msg="";
	 }
    public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public AccountDaoImple(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	@Override
	public void editAccount(Account account){
		if (account.getId() > 0) {
	        // update
	        String sql = "UPDATE accounts SET name=?, fname=?, lname=? WHERE id=?";
	        jdbcTemplate.update(sql,account.getName(), account.getFirstname(),
	                account.getLastname(),account.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO accounts (name,fname,lname)"
	                    + " VALUES (?, ?, ?)";
	        jdbcTemplate.update(sql, account.getName(), account.getFirstname(),
	                account.getLastname());
	    }
	 
		
		
		
	}
	@Override
	public List<Account> listAccount() {
		    String sql = "SELECT * FROM accounts";
		    List<Account> listAccount = jdbcTemplate.query(sql, new RowMapper<Account>() {
		    	@Override
		        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Account account1 = new Account();
		 
		            account1.setId(rs.getInt("id"));
		            account1.setName(rs.getString("name"));
		            account1.setFirstname(rs.getString("fname"));
		            account1.setLastname(rs.getString("lname"));
		           
		 
		            return account1;
		        }
		 
		    });
		 
		    return listAccount;
	}
    @Override	
	public List<Account> SearchlistAccount(String name){
		String sql = "SELECT * FROM accounts where name like '"+name+"%' ";
	    List<Account> listAccount = jdbcTemplate.query(sql, new RowMapper<Account>() {
	    	@Override
	        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Account account1 = new Account();
	 
	            account1.setId(rs.getInt("id"));
	            account1.setName(rs.getString("name"));
	            account1.setFirstname(rs.getString("fname"));
	            account1.setLastname(rs.getString("lname"));
	           
	 
	            return account1;
	        }
	 
	    });
	 
	    return listAccount;
		
	}
	@Override
	public void removeAccount(int id) {
		String sql = "DELETE FROM accounts WHERE id=?";
	    jdbcTemplate.update(sql, id);

	}
	@Override
	public Account get(int id) {
	    String sql = "SELECT * FROM accounts WHERE id=" + id;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Account>() {
	 
	        @Override
	        public Account extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Account account2 = new Account();
	                account2.setId(rs.getInt("id"));
	                account2.setName(rs.getString("name"));
	                account2.setFirstname(rs.getString("fname"));
	                account2.setLastname(rs.getString("lname"));
	               
	                return account2;
	            }
	 
	            return null;
	        }
	 
	    });
	}
	@Override
	public List<Account> getLimitAccount(int limit, int offset) {
	
		 String sql = "SELECT * FROM accounts LIMIT "+limit+" OFFSET "+offset;
		 List<Account> listAccount =jdbcTemplate.query(sql,new RowMapper<Account>() {
			 @Override
		        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account1 = new Account();
				 account1.setId(rs.getInt("id"));
	            account1.setName(rs.getString("name"));
	            account1.setFirstname(rs.getString("fname"));
	            account1.setLastname(rs.getString("lname"));
				 return account1;
			 
			 }
				 });
	        return  listAccount;
	}
	@Override
	public int getNumber(){
		return 0;
	}
	@SuppressWarnings("deprecation")
	@Override
	public int getAllTotal(){
		int counttotal=0;
		String sql = "SELECT COUNT(*) AS 'TOTAL' FROM accounts";
		counttotal = getJdbcTemplate().queryForInt(sql);
		return counttotal;
	}
   @Override
   public List<Account> getPage(int page){
	   String sql = "SELECT * FROM accounts LIMIT 5 OFFSET "+((page*5)-5);
		 List<Account> listAccount =jdbcTemplate.query(sql,new RowMapper<Account>() {
			 @Override
		        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account1 = new Account();
				 account1.setId(rs.getInt("id"));
	            account1.setName(rs.getString("name"));
	            account1.setFirstname(rs.getString("fname"));
	            account1.setLastname(rs.getString("lname"));
				 return account1;
			 
			 }
				 });
	        return  listAccount;
	   
   }
   @Override
   public int getAllTotalSearch(String name){
	   int counttotal=0;
		String sql = "SELECT COUNT(*) AS 'TOTAL' FROM accounts where name like '"+name+"%' ";
		counttotal = getJdbcTemplate().queryForInt(sql);
		return counttotal;   
   }
   @Override
   public List<Account>  getLimitAccountSearch(int limit, int offset,String name){
	   
	   String sql = "SELECT * FROM accounts where name like '"+name+"%' LIMIT "+limit+" OFFSET "+offset;
		 List<Account> listAccount =jdbcTemplate.query(sql,new RowMapper<Account>() {
			 @Override
		        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account1 = new Account();
				 account1.setId(rs.getInt("id"));
	            account1.setName(rs.getString("name"));
	            account1.setFirstname(rs.getString("fname"));
	            account1.setLastname(rs.getString("lname"));
				 return account1;
			 
			 }
				 });
	        return  listAccount; 
	   
   }
   public static AccountDaoImple getInstance(){
	   
	   return accounttest;
	   
   }
@Override
public void setMsg(String msg) {
	// TODO Auto-generated method stub
	this.msg=msg;
} 
@Override
public String getMsg() {
	// TODO Auto-generated method stub
	return msg;
} 
}
