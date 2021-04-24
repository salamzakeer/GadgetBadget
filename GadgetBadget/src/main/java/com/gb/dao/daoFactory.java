package com.gb.dao;

public final class daoFactory {

	private static final String IMPL_TYPE = "jdbc";
	private daoFactory() {	
	}

	public static productDao getProductDao() throws DaoException {
		
		switch(IMPL_TYPE) {
		case "jdbc":
			return new jdbcProductDao();
			default:
				throw new DaoException("no suitabale implemtation available");
				
			
		}
		
	}

	public static  SellerDao getSellerDao() throws DaoException {
		switch(IMPL_TYPE) {
		case"jdbc":		
			return new JdbcSellerDao();
			default:
				throw new DaoException("No suitable implementation available");
		}
		
	}
	public static BuyersDao getBuyersDao() throws DaoException {
switch (IMPL_TYPE) {
		
		case "jdbc" :
			return new JdbcBuyersDao();
		default:
			throw new DaoException("No suitable implementation available");			
		}
	}

}
