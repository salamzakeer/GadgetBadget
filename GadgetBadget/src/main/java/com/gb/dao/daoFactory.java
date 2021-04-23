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

}
